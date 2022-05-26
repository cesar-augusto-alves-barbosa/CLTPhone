package com.exemple.cesar.augusto.phoneclt.controller;

import com.exemple.cesar.augusto.phoneclt.dto.TelefoneDTO;
import com.exemple.cesar.augusto.phoneclt.entities.Telefone;
import com.exemple.cesar.augusto.phoneclt.service.TelefoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/phones")
public class TelefoneController {

    @Autowired
    private TelefoneService service;

    @GetMapping("/{id}")
    public ResponseEntity<Telefone> findById(@PathVariable Integer id) { return service.findById(id); }

    @PostMapping()
    public ResponseEntity<Telefone> postPhone(@Valid @RequestBody TelefoneDTO telefone) { return service.postPhone(telefone); }

    @PutMapping()
    public ResponseEntity<Telefone> putPhone(@Valid @RequestBody TelefoneDTO telefone) { return service.putPhone(telefone); }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePhone(@PathVariable Integer id) { return service.deletePhone(id); }
}
