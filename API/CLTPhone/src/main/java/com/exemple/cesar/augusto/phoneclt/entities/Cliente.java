package com.exemple.cesar.augusto.phoneclt.entities;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String nmCliente;

    @Email
    @NotNull
    private String nmEmail;

    @NotNull
    private String nrCep;

    @NotNull
    private String nmEndereco;

    @NotNull
    private String nmBairro;

    @NotNull
    private String nmComplemento;

    @NotNull
    private String nmCidade;

    @OneToMany(mappedBy = "cliente")
    private Set<Telefone> telefones;

    private Cliente() {
    }

    public Cliente(Integer id, String nmCliente, String nmEmail, String nrCep, String nmEndereco, String nmBairro, String nmComplemento, String nmCidade, Set<Telefone> telefones) {
        this.id = id;
        this.nmCliente = nmCliente;
        this.nmEmail = nmEmail;
        this.nrCep = nrCep;
        this.nmEndereco = nmEndereco;
        this.nmBairro = nmBairro;
        this.nmComplemento = nmComplemento;
        this.nmCidade = nmCidade;
        this.telefones = telefones;
    }

    public Set<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(Set<Telefone> telefones) {
        this.telefones = telefones;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNmCliente() {
        return nmCliente;
    }

    public void setNmCliente(String nmCliente) {
        this.nmCliente = nmCliente;
    }

    public String getNmEmail() {
        return nmEmail;
    }

    public void setNmEmail(String nmEmail) {
        this.nmEmail = nmEmail;
    }

    public String getNrCep() {
        return nrCep;
    }

    public void setNrCep(String nrCep) {
        this.nrCep = nrCep;
    }

    public String getNmEndereco() {
        return nmEndereco;
    }

    public void setNmEndereco(String nmEndereco) {
        this.nmEndereco = nmEndereco;
    }

    public String getNmBairro() {
        return nmBairro;
    }

    public void setNmBairro(String nmBairro) {
        this.nmBairro = nmBairro;
    }

    public String getNmComplemento() {
        return nmComplemento;
    }

    public void setNmComplemento(String nmComplemento) {
        this.nmComplemento = nmComplemento;
    }

    public String getNmCidade() {
        return nmCidade;
    }

    public void setNmCidade(String nmCidade) {
        this.nmCidade = nmCidade;
    }
}
