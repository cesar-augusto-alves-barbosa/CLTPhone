package com.exemple.cesar.augusto.phoneclt.dto;


import javax.validation.constraints.NotNull;

public class TelefoneDTO {

    private Integer id;

    @NotNull
    private Integer clienteId;

    @NotNull
    private String nrTelefone;

    public TelefoneDTO() {
    }

    public TelefoneDTO(Integer id, Integer clienteId, String nrTelefone) {
        this.id = id;
        this.clienteId = clienteId;
        this.nrTelefone = nrTelefone;
    }

    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
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
}
