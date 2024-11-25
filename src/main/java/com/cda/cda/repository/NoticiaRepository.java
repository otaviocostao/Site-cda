package com.cda.cda.repository;

import com.cda.cda.model.Noticia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticiaRepository extends JpaRepository<Noticia, Long> {

    @Query(value = "SELECT * FROM noticia ORDER BY id DESC LIMIT 3", nativeQuery = true)
    List<Noticia> find5NoticiasRecentes();

    @Query(value = "SELECT * FROM noticia ORDER BY id DESC", nativeQuery = true)
    List<Noticia> findNoticiasDesc();

}
