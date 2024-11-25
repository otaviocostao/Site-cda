package com.cda.cda.service;

import com.cda.cda.model.Projeto;
import com.cda.cda.repository.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjetoService {

    ProjetoRepository projetoRepository;

    @Autowired
    public ProjetoService(ProjetoRepository projetoRepository){
        this.projetoRepository = projetoRepository;
    }

    public Projeto saveProjeto(Projeto projeto){
        return projetoRepository.save(projeto);
    }

    public List<Projeto> findAll(){
        return projetoRepository.findAll();
    }

    public Optional<Projeto> getById(Long id){
        return projetoRepository.findById(id);
    }

    public Projeto updateProjeto(Projeto projeto){
        return projetoRepository.save(projeto);
    }

    public void deleteProjeto(Long id){
        projetoRepository.deleteById(id);
    }

    public List<Projeto> find3ProjetosRecentes() {
        return projetoRepository.find3ProjetosRecentes();
    }
}
