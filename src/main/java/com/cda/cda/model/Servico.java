package com.cda.cda.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    @Column(columnDefinition = "TEXT")
    private String texto;

    private Float valor;

    private String tempo_realizacao;

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getTexto() {
        return texto;
    }

    public Float getValor() {
        return valor;
    }

    public String getTempo_realizacao() {
        return tempo_realizacao;
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

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public void setTempo_realizacao(String tempo_realizacao) {
        this.tempo_realizacao = tempo_realizacao;
    }

}
