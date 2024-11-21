package com.cda.cda.controller;

import com.cda.cda.model.Servico;
import com.cda.cda.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class ServicoAdminController {

    @Autowired
    ServicoService servicoService;

    @GetMapping("/listaServicos")
    public String listaServicos(Model model){
        List<Servico> servicos = servicoService.findAll();
        model.addAttribute("servicos", servicos);
        return "admin/lista_servicos";
    }

    @GetMapping("/novoServico")
    public String novoServico(Model model){
        model.addAttribute("servico", new Servico());
        return "admin/novo_servico";
    }

    @PostMapping("/salvarServico")
    public String salvarServico(@ModelAttribute("servico") Servico servico){
        servicoService.saveServico(servico);
        return "redirect:/admin/listaServicos";
    }
}
