package com.cda.cda.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Associado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cnpj;

    private String razao_social;

    private String localizacao;

    private String presidente;

    private String telefone;

    private String observacoes;

    public Long getId() {
        return id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getRazao_social() {
        return razao_social;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public String getPresidente() {
        return presidente;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setRazao_social(String razao_social) {
        this.razao_social = razao_social;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public void setPresidente(String presidente) {
        this.presidente = presidente;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
}
