package com.cda.cda.controller;

import com.cda.cda.model.Associado;
import com.cda.cda.model.Noticia;
import com.cda.cda.service.NoticiaService;
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
public class NoticiaAdminController {

    @Autowired
    private NoticiaService noticiaService;

    @GetMapping("/listaNoticias")
    public String listarNoticias(Model model){
        List<Noticia> noticias = noticiaService.findAll();
        model.addAttribute("noticias", noticias);
        return "admin/lista_noticias";
    }

    @GetMapping("/novaNoticia")
    public String novaNoticia(Model model) {
        model.addAttribute("noticia", new Noticia());
        return "admin/nova_noticia";
    }

    @PostMapping("/salvarNoticia")
    public String salvarNoticia(@ModelAttribute Noticia noticia,
                                @RequestParam("imagem") MultipartFile imagem) throws IOException {
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
            noticia.setImagemUrl(caminhoArquivo.toString());
        }

        noticia.setData_publicacao(LocalDateTime.now());

        // Salva a notícia no banco de dados
        noticiaService.saveNoticia(noticia);

        return "redirect:/admin/listaNoticias";
    }


    @PostMapping("/deletarNoticia/{id}")
    public String deletarNoticia(@PathVariable("id") Long id){
        Noticia noticia = noticiaService.getById(id).orElseThrow(() -> new RuntimeException("Noticia não encontrada com ID: " + id));;

        if(noticia != null){
            String imagem_url = noticia.getImagemUrl();
            if(imagem_url!=null){
                Path caminhoImagem = Paths.get(imagem_url);
                try{
                    Files.deleteIfExists(caminhoImagem);
                } catch (IOException e) {
                    System.out.println("Erro ao deletar a imagem: " + e.getMessage());
                }
            }
        }

        noticiaService.deleteNoticia(id);

        return "redirect:/admin/listaNoticias";
    }

}
