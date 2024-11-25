package com.cda.cda.controller;

import com.cda.cda.model.Noticia;
import com.cda.cda.service.NoticiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class NoticiaController {

    @Autowired
    NoticiaService noticiaService;

    @GetMapping("/noticias")
    public String listaNoticias(Model model){
        List<Noticia> noticias = noticiaService.findNoticiasDesc();
        model.addAttribute("noticias", noticias);
        return "noticias";
    }

    @GetMapping("/noticia/{id}")
    public String noticia(@PathVariable("id") Long id, Model model){
        Noticia noticia = noticiaService.getById(id).orElseThrow(() -> new RuntimeException("Noticia não encontrada com ID: " + id));
        model.addAttribute("noticia", noticia);
        return "noticia";
    };
}
