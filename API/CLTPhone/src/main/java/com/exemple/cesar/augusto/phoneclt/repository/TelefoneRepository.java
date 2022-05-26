package com.exemple.cesar.augusto.phoneclt.repository;

import com.exemple.cesar.augusto.phoneclt.entities.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface TelefoneRepository extends JpaRepository<Telefone, Integer> {

    @Modifying
    @Query(value = "DELETE FROM telefone WHERE cliente_id = :clienteId", nativeQuery = true)
    Integer deleteAllByClienteId(Integer clienteId);
}
