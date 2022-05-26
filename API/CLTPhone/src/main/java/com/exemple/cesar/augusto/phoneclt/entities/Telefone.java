package com.exemple.cesar.augusto.phoneclt.entities;

import com.exemple.cesar.augusto.phoneclt.dto.TelefoneDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "telefone")
public class Telefone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "cliente_id")
    @NotNull(message = "Cliente não informado")
    private Cliente cliente;

    @NotNull
    private String nrTelefone;

    public Telefone() {
    }

    public Telefone(Cliente cliente, String nrTelefone) {
        this.cliente = cliente;
        this.nrTelefone = nrTelefone;
    }

    public Telefone(Integer id, Cliente cliente, String nrTelefone) {
        this.id = id;
        this.cliente = cliente;
        this.nrTelefone = nrTelefone;
    }

    public String getNrTelefone() {
        return nrTelefone;
    }

    public void setNrTelefone(String nrTelefone) {
        this.nrTelefone = nrTelefone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
