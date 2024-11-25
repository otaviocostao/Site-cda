package com.cda.cda.service;

import com.cda.cda.model.Noticia;
import com.cda.cda.repository.NoticiaRepository;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoticiaService {

    NoticiaRepository noticiaRepository;

    @Autowired
    public NoticiaService(NoticiaRepository noticiaRepository){
        this.noticiaRepository = noticiaRepository;
    }

    public Noticia saveNoticia(Noticia noticia){
        return noticiaRepository.save(noticia);
    }

    public List<Noticia> findAll(){
        return noticiaRepository.findAll();
    }

    public Optional<Noticia> getById(Long id){
        return noticiaRepository.findById(id);
    }

    public Noticia updateNoticia(Noticia noticia){
        return noticiaRepository.save(noticia);
    }

    public void deleteNoticia(Long id){
        noticiaRepository.deleteById(id);
    }

    public List<Noticia> find5NoticiasRecentes() {
        return noticiaRepository.find5NoticiasRecentes();
    }
    public List<Noticia> findNoticiasDesc() {
        return noticiaRepository.findNoticiasDesc();
    }
}
