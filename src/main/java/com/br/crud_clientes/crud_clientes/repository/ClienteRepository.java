package com.br.crud_clientes.crud_clientes.repository;

import com.br.crud_clientes.crud_clientes.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    Optional<Cliente> findByNome(String nome);

    Optional<Cliente> findByEmail(String email);

}
