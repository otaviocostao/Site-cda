package com.cda.cda.controller;

import com.cda.cda.model.Noticia;
import com.cda.cda.service.NoticiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin/noticias")
public class NoticiaAdminController {

    @Autowired
    NoticiaService noticiaService;

    @GetMapping
    public String listarNoticias(Model model){
        List<Noticia> noticias = noticiaService.findAll();
        model.addAttribute("noticias", noticias);
        return "admin/lista_noticias";
    }

    @GetMapping("/nova")
    public String novaNoticia(Model model){
        model.addAttribute("noticia", new Noticia());
        return "admin/nova_noticia";
    }

    @PostMapping("/salvarNoticia")
    public String salvarNoticia(@ModelAttribute("noticia") Noticia noticia){
        noticiaService.saveNoticia(noticia);
        return "redirect:/admin/noticias";
    }
}
