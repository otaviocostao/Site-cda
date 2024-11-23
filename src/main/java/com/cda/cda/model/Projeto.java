package com.cda.cda.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    @Column(columnDefinition = "TEXT")
    private String texto;

    private String imagem_url;

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getTexto() {
        return texto;
    }

    public String getImagem_url() {
        return imagem_url;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public void setImagem_url(String imagem_url) {
        this.imagem_url = imagem_url;
    }
}
