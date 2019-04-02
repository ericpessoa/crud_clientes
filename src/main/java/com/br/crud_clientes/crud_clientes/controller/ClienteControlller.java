package com.br.crud_clientes.crud_clientes.controller;

import com.br.crud_clientes.crud_clientes.model.Cliente;
import com.br.crud_clientes.crud_clientes.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.ValidationException;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteControlller {

    @Autowired
    private ClienteRepository clienteRepository;

    private final ValidationException CLIENTE_NAO_ENCONTRADO_ERROR = new ValidationException("Cliente não encontrado");
    private final ValidationException CLIENTE_ERROR = new ValidationException("Erro ao realizar operação");

    @GetMapping("/todos")
    public List<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    @GetMapping("/buscar/{id}")
    public Cliente buscarUm(@PathVariable Integer id) {
        return clienteRepository.findById(id).orElseThrow(
            () -> CLIENTE_NAO_ENCONTRADO_ERROR);
    }

    @PostMapping("/salvar")
    public void salvar(@RequestBody Cliente cliente) {
        try {
            clienteRepository.save(cliente);
        } catch (Exception e) {
            throw CLIENTE_ERROR;
        }
    }

    @GetMapping("/nome/{nome}")
    public Cliente buscarPorNome(@PathVariable String nome) {
        return clienteRepository.findByNome(nome)
                .orElseThrow(() -> CLIENTE_NAO_ENCONTRADO_ERROR);
    }

    @GetMapping("/email/{email}")
    public Cliente buscarPorEmail(@PathVariable String email) {
        return clienteRepository.findByEmail(email)
                .orElseThrow(() -> CLIENTE_NAO_ENCONTRADO_ERROR);
    }

    @GetMapping("/deletar/{id}")
    public void deletar(@PathVariable Integer id) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> CLIENTE_NAO_ENCONTRADO_ERROR);
        try {
            clienteRepository.delete(cliente);
        } catch (Exception e) {
            throw CLIENTE_ERROR;
        }
    }

}
