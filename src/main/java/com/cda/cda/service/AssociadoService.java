package com.cda.cda.service;

import com.cda.cda.model.Associado;
import com.cda.cda.repository.AssociadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssociadoService {

    AssociadoRepository associadoRepository;

    @Autowired
    public AssociadoService(AssociadoRepository associadoRepository){
        this.associadoRepository = associadoRepository;
    }

    public Associado saveAssociado(Associado associado){
        return associadoRepository.save(associado);
    }

    public List<Associado> findAll(){
        return associadoRepository.findAll();
    }

    public Optional<Associado> getById(Long id){
        return associadoRepository.findById(id);
    }

    public Associado updateAssociado(Associado associado){
        return associadoRepository.save(associado);
    }

    public void deleteAssociado(Long id){
        associadoRepository.deleteById(id);
    }

}
