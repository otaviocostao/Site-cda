package com.cda.cda.service;

import com.cda.cda.model.Servico;
import com.cda.cda.repository.ServicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicoService {

    ServicoRepository servicoRepository;

    public ServicoService(ServicoRepository servicoRepository){
        this.servicoRepository = servicoRepository;
    }

    public Servico saveServico(Servico servico){
        return servicoRepository.save(servico);
    }

    public List<Servico> findAll(){
        return servicoRepository.findAll();
    }

    public Optional<Servico> getById(Long id){
        return servicoRepository.findById(id);
    }

    public Servico updateServico(Servico servico){
        return servicoRepository.save(servico);
    }

    public void deleteServico(Long id){
        servicoRepository.deleteById(id);
    }

}
