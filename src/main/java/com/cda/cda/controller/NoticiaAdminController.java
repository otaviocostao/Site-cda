package com.cda.cda.controller;

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
    NoticiaService noticiaService;

    @GetMapping("/listaNoticias")
    public String listarNoticias(Model model){
        List<Noticia> noticias = noticiaService.findAll();
        model.addAttribute("noticias", noticias);
        return "admin/lista_noticias";
    }

    @GetMapping("/novaNoticia")
    public String novaNoticia(Model model){
        model.addAttribute("noticia", new Noticia());
        return "admin/nova_noticia";
    }

    @PostMapping("/salvarNoticia")
    public String salvarNoticia(@ModelAttribute Noticia noticia,
                                @RequestParam("imagem") MultipartFile imagem) throws IOException {
        if (!imagem.isEmpty()) {
            String nomeArquivo = System.currentTimeMillis() + "_" + imagem.getOriginalFilename();
            Path caminhoArquivo = Paths.get("uploads/" + nomeArquivo);
            Files.createDirectories(caminhoArquivo.getParent());
            Files.write(caminhoArquivo, imagem.getBytes());

            noticia.setImagemUrl("/uploads/" + nomeArquivo);
        }
        noticia.setData_publicacao(LocalDateTime.now());
        noticiaService.saveNoticia(noticia);
        return "redirect:/admin/noticias";
    }

    @GetMapping("/visualizarNoticias/{id}")
    public String visualizarNoticia(@PathVariable Long id, Model model) {
        Noticia noticia = noticiaService.getById(id)
                .orElseThrow(() -> new IllegalArgumentException("Notícia não encontrada: " + id));
        model.addAttribute("noticia", noticia);
        return "noticias/detalhes";
    }
}
