package com.cda.cda.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Noticia {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String autor;

    @Column(columnDefinition = "TEXT")
    private String texto;

    private LocalDateTime data_publicacao;

    @Column(name = "imagem_url")
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

    public LocalDateTime getData_publicacao() {
        return data_publicacao;
    }

    public String getImagemUrl() {
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

    public void setData_publicacao(LocalDateTime data_publicacao) {
        this.data_publicacao = data_publicacao;
    }

    public void setImagemUrl(String imagemUrl) {
        this.imagem_url = imagemUrl;
    }
}
