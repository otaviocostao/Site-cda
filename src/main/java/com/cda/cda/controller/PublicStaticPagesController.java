package com.cda.cda.controller;

import com.cda.cda.model.Noticia;
import com.cda.cda.service.NoticiaService;
import com.cda.cda.service.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PublicStaticPagesController {

    @Autowired
    private ProjetoService projetoService;

    @Autowired
    private NoticiaService noticiaService;

    @GetMapping("/home")
    public String home(Model model) {


        model.addAttribute("noticiasRecentes", noticiaService.find5NoticiasRecentes());
        model.addAttribute("projetosRecentes", projetoService.find3ProjetosRecentes());
        return "home"; // Nome do template HTML
    }

    @GetMapping("/apoiadores")
    public String apoiadores(){
        return "apoiadores";
    }
}
