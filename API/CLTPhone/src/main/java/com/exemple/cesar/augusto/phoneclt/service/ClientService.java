package com.exemple.cesar.augusto.phoneclt.service;

import com.exemple.cesar.augusto.phoneclt.entities.Cliente;
import com.exemple.cesar.augusto.phoneclt.repository.ClienteRepository;
import com.exemple.cesar.augusto.phoneclt.repository.TelefoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClienteRepository repository;

    @Autowired
    private TelefoneRepository telefoneRepository;

    @Transactional(readOnly = true)
    public ResponseEntity<Cliente> findById(Integer id){
        Optional<Cliente> clienteOptional = repository.findById(id);
        if (!clienteOptional.isPresent()) {
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.status(200).body(clienteOptional.get());
    }

    @Transactional
    public ResponseEntity postCliente(Cliente cliente){
        Cliente clienteOptional = repository.findByNmEmail(cliente.getNmEmail());
        if(!(clienteOptional instanceof Cliente)) {
            return ResponseEntity.status(422).body("Cliente já cadastrado");
        }
        return ResponseEntity.status(200).body(repository.save(cliente));
    }

    @Transactional
    public ResponseEntity putClient(Cliente cliente){
        Optional<Cliente> clienteOptional = repository.findById(cliente.getId());
        if(!clienteOptional.isPresent()) {
            return ResponseEntity.status(404).body("Cliente não cadastrado");
        }
        return ResponseEntity.status(200).body(repository.save(cliente));
    }

    @Transactional
    public ResponseEntity deleteClient(Integer id){
        Optional<Cliente> clienteOptional = repository.findById(id);
        if(!clienteOptional.isPresent()) {
            return ResponseEntity.status(404).body("Cliente não cadastrado");
        }
        telefoneRepository.deleteAllByClienteId(id);
        repository.deleteById(id);
        return ResponseEntity.status(200).build();
    }
}
