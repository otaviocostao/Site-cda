package com.cda.cda.controller;

import com.cda.cda.model.Noticia;
import com.cda.cda.model.Projeto;
import com.cda.cda.service.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class ProjetoAdminController {

    @Autowired
    ProjetoService projetoService;

    @GetMapping("/listaProjetos")
    public String listaProjetos(Model model){
        List<Projeto> projetos = projetoService.findAll();
        model.addAttribute("projetos", projetos);
        return "admin/lista_projetos";
    }

    @GetMapping("/novoProjeto")
    public String novoProjeto(Model model){
        model.addAttribute("projeto", new Projeto());
        return "admin/novo_projeto";
    }

    @PostMapping("/salvarProjeto")
    public String salvarProjeto(@ModelAttribute
    Projeto projeto,
    @RequestParam("imagem")
    MultipartFile imagem) throws IOException {
        if (!imagem.isEmpty()) {
            // Define o diretório onde as imagens serão salvas
            String diretorioImagens = "uploads/imagens/";
            Path caminhoDiretorio = Paths.get(diretorioImagens);

            // Cria o diretório se ele não existir
            if (!Files.exists(caminhoDiretorio)) {
                Files.createDirectories(caminhoDiretorio);
            }

            // Define o nome do arquivo e o caminho completo
            String nomeArquivo = LocalDateTime.now().toString().replace(":", "-") + "-" + imagem.getOriginalFilename();
            Path caminhoArquivo = caminhoDiretorio.resolve(nomeArquivo);

            // Salva o arquivo no diretório
            Files.copy(imagem.getInputStream(), caminhoArquivo);

            // Salva o caminho do arquivo na entidade Noticia
            projeto.setImagem_url(caminhoArquivo.toString());
        }

        // Salva a notícia no banco de dados
        projetoService.saveProjeto(projeto);

        return "redirect:/admin/listaProjetos";
    }


    @PostMapping("/deletarProjeto/{id}")
    public String deletarProjeto(@PathVariable("id") Long id){
        Projeto projeto = projetoService.getById(id).orElseThrow(() -> new RuntimeException("Projeto não encontrado com ID: " + id));;

        if(projeto != null){
            String imagem_url = projeto.getImagem_url();
            if(imagem_url!=null){
                Path caminhoImagem = Paths.get(imagem_url);
                try{
                    Files.deleteIfExists(caminhoImagem);
                } catch (IOException e) {
                    System.out.println("Erro ao deletar a imagem: " + e.getMessage());
                }
            }
        }

        projetoService.deleteProjeto(id);

        return "redirect:/admin/listaProjetos";
    }


    @GetMapping("/editarProjeto/{id}")
    public String editarProjeto(@PathVariable("id") Long id, Model model){
        Projeto projeto = projetoService.getById(id).orElseThrow(() -> new RuntimeException("Projeto não encontrado com ID: " + id));
        model.addAttribute("projeto", projeto);
        return "admin/editar_projeto";
    }

    @PostMapping("/salvarEdicaoProjeto")
    public String salvarEdicaoProjeto(@ModelAttribute("projeto") Projeto projeto){
        projetoService.saveProjeto(projeto);
        return "redirect:/admin/listaProjetos";
    }

}
