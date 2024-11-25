package com.cda.cda.repository;

import com.cda.cda.model.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, Long> {

    @Query(value = "SELECT * FROM projeto ORDER BY id DESC LIMIT 3", nativeQuery = true)
    List<Projeto> find3ProjetosRecentes();

}
