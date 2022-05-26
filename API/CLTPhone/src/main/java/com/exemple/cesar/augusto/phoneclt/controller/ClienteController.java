package com.exemple.cesar.augusto.phoneclt.controller;


import com.exemple.cesar.augusto.phoneclt.entities.Cliente;
import com.exemple.cesar.augusto.phoneclt.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/clients")
public class ClienteController {

    @Autowired
    private ClientService service;

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> findById(@Valid @PathVariable Integer id) { return service.findById(id); }

    @PostMapping
    public  ResponseEntity<Cliente> postCliente(@Valid @RequestBody Cliente cliente) { return  service.postCliente(cliente);}

    @PutMapping
    public  ResponseEntity<Cliente> putCliente(@Valid @RequestBody Cliente cliente) { return  service.putClient(cliente);}

    @DeleteMapping("/{id}")
    public  ResponseEntity deleteCliente(@PathVariable Integer id) { return  service.deleteClient(id);}
}
