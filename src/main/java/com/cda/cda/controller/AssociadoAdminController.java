package com.cda.cda.controller;

import com.cda.cda.model.Associado;
import com.cda.cda.service.AssociadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AssociadoAdminController {

    @Autowired
    AssociadoService associadoService;

    @GetMapping("/listaAssociados")
    public String listarAssociados(Model model){
        List<Associado> associados = associadoService.findAll();
        model.addAttribute("associados", associados);
        return "admin/lista_associados";
    }

    @GetMapping("/novoAssociado")
    public String novoAssociado(Model model) {
        model.addAttribute("associado", new Associado());
        return "admin/novo_associado";
    }

    @PostMapping("/salvarAssociado")
    public String salvarAssociado(@ModelAttribute("associado") Associado associado){
        associadoService.saveAssociado(associado);
        return "redirect:/admin/listaAssociados";
    }


    @PostMapping("/deletarAssociado/{id}")
    public String deletarAssociado(@PathVariable("id") Long id){
        associadoService.deleteAssociado(id);

        return "redirect:/admin/listaAssociados";
    }


    @GetMapping("/editarAssociado")
    public String editarAssociado(Model model){
        model.addAttribute("associado", new Associado());
        return "admin/editar_associado";
    }

    @PostMapping("/salvarEdicaoAssociado")
    public String salvarEdicaoAssociado(@ModelAttribute("associado") Associado associado){
        associadoService.saveAssociado(associado);
        return "redirect:/admin/listaAssociados";
    }
}
