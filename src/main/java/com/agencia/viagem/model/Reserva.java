package com.agencia.viagem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeCliente;
    private String data;

    @ManyToOne
    @JoinColumn(name = "destino_id")
    private Destino destino;

    public Reserva() {}

    public Reserva(Long id, String nomeCliente, String data, Destino destino) {
        this.id = id;
        this.nomeCliente = nomeCliente;
        this.data = data;
        this.destino = destino;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id; 
    }

    public String getNomeCliente() {
        return nomeCliente; 
    }
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }

    public Destino getDestino() {
        return destino;
    }
    public void setDestino(Destino destino) {
        this.destino = destino;
    }
}