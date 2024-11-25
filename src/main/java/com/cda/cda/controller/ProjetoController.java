package com.cda.cda.controller;

import com.cda.cda.model.Projeto;
import com.cda.cda.service.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProjetoController {

    @Autowired
    ProjetoService projetoService;

    @GetMapping("/projetos")
    public String projetos(Model model){
        List<Projeto> projetos = projetoService.findAll();
        model.addAttribute("projetos", projetos);
        return "/projetos";
    }
}
