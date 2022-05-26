package com.exemple.cesar.augusto.phoneclt.repository;

import com.exemple.cesar.augusto.phoneclt.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    Cliente findByNmEmail(String email);
}
