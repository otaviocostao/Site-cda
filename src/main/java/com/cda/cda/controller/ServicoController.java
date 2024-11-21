package com.cda.cda.controller;

import com.cda.cda.model.Servico;
import com.cda.cda.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ServicoController {

    @Autowired
    ServicoService servicoService;

    @GetMapping("/servicos")
    public String servicos(Model model){
        List<Servico> servicos = servicoService.findAll();
        model.addAttribute("servicos", servicos);
        return "servicos";
    }
}