package com.cda.cda.controller;

import com.cda.cda.model.Associado;
import com.cda.cda.model.Noticia;
import com.cda.cda.service.AssociadoService;
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
    public String novoAssociado(Model model){
        model.addAttribute("associado", new Associado());
        return "admin/novo_associado";
    }

    @PostMapping("/salvarAssociado")
    public String salvarAssociado(@ModelAttribute("associado") Associado associado){
        associadoService.saveAssociado(associado);
        return "redirect:/admin/listaAssociados";
    }
    
}
