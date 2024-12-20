package com.cda.cda.controller;

import com.cda.cda.model.Associado;
import com.cda.cda.model.Servico;
import com.cda.cda.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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


    @PostMapping("/deletarServico/{id}")
    public String deletarServico(@PathVariable("id") Long id){
        servicoService.deleteServico(id);

        return "redirect:/admin/listaServicos";
    }

    @GetMapping("/editarServico/{id}")
    public String editarServico(@PathVariable("id") Long id, Model model){
        Servico servico = servicoService.getById(id).orElseThrow(() -> new RuntimeException("Serviço não encontrado com ID: " + id));
        model.addAttribute("servico", servico);
        return "admin/editar_servico";
    }

    @PostMapping("/salvarEdicaoServico")
    public String salvarEdicaoServico(@ModelAttribute("servico") Servico servico){
        servicoService.saveServico(servico);
        return "redirect:/admin/listaServicos";
    }
}
