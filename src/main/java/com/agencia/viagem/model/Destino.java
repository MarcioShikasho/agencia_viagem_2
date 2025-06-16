package com.agencia.viagem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Destino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String local;
    private String descricao;
    private double notaMedia;
    private int totalAvaliacoes;

    public Destino() {}

    public Destino(Long id, String nome, String local, String descricao) {
        this.id = id;
        this.nome = nome;
        this.local = local;
        this.descricao = descricao;
    }

    public Long getId() {
        return id; 
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome; 
    }
    public void setNome(String nome) {
        this.nome = nome; 
    }

    public String getLocal() {
        return local; 
    }
    public void setLocal(String local) {
        this.local = local;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getNotaMedia() {
        return notaMedia;
    }
    public int getTotalAvaliacoes() {
        return totalAvaliacoes;
    }
    public void avaliar(int nota) {
        this.notaMedia = (this.notaMedia * totalAvaliacoes + nota) / (++totalAvaliacoes);
    }
}