package com.exemple.cesar.augusto.phoneclt.service;


import com.exemple.cesar.augusto.phoneclt.dto.TelefoneDTO;
import com.exemple.cesar.augusto.phoneclt.entities.Cliente;
import com.exemple.cesar.augusto.phoneclt.entities.Telefone;
import com.exemple.cesar.augusto.phoneclt.repository.ClienteRepository;
import com.exemple.cesar.augusto.phoneclt.repository.TelefoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.util.Optional;

@Service
public class TelefoneService {

    @Autowired
    private TelefoneRepository repository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional(readOnly = true)
    public ResponseEntity<Telefone> findById(Integer id){
        Optional<Telefone> telefoneOptional =repository.findById(id);
        if (!telefoneOptional.isPresent()) {
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.status(200).body(telefoneOptional.get());
    }

    @Transactional
    public ResponseEntity postPhone(TelefoneDTO telefoneDTO){
        Optional<Cliente> clienteOptional = clienteRepository.findById(telefoneDTO.getClienteId());
        if (!clienteOptional.isPresent()) {
            return ResponseEntity.status(404).body("Cliente não encontrado");
        }
        Cliente cliente = clienteOptional.get();
        Telefone telefone = new Telefone(cliente, telefoneDTO.getNrTelefone());
        return ResponseEntity.status(201).body(repository.save(telefone));
    }

    @Transactional
    public ResponseEntity putPhone(TelefoneDTO telefoneDTO){
        Optional<Telefone> telefoneOptional = repository.findById(telefoneDTO.getId());
        Optional<Cliente> clienteOptional = clienteRepository.findById(telefoneDTO.getClienteId());
        if (!clienteOptional.isPresent()) {
            return ResponseEntity.status(404).body("Cliente não encontrado");
        }
        if(!telefoneOptional.isPresent()) {
            return ResponseEntity.status(404).body("Telefone não cadastrado");
        }
        Telefone telefone = new Telefone(telefoneDTO.getId(), clienteOptional.get(), telefoneDTO.getNrTelefone());
        return ResponseEntity.status(200).body(repository.save(telefone));
    }

    @Transactional
    public ResponseEntity deletePhone(Integer id){
        Optional<Telefone> telefoneOptional = repository.findById(id);
        if(!telefoneOptional.isPresent()) {
            return ResponseEntity.status(404).body("Telefone não cadastrado");
        }
        repository.deleteById(id);
        return ResponseEntity.status(200).build();
    }
}
