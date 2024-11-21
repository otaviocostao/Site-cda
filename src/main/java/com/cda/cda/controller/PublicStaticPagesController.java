package com.cda.cda.controller;

import com.cda.cda.model.Noticia;
import com.cda.cda.service.NoticiaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PublicStaticPagesController {
    NoticiaService noticiaService;

    @GetMapping("/home")
    public String homePage(Model model){
        List<Noticia> noticias = noticiaService.findAll();
        model.addAttribute("noticias", noticias);
        return "home";
    }
}
