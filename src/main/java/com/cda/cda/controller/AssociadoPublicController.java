package com.cda.cda.controller;

import com.cda.cda.model.Associado;
import com.cda.cda.service.AssociadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AssociadoPublicController {

    @Autowired
    AssociadoService associadoService;

    @GetMapping("/associados")
    public String associados(Model model){
        List<Associado> associados = associadoService.findAll();
        model.addAttribute("associados", associados);
        return "/admin/lista_associados";
    }
}
