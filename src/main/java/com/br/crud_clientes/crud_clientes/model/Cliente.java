package com.br.crud_clientes.crud_clientes.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @NotNull
    private String nome;

    @Column
    @NotNull
    private String endereco;

    @Column
    @NotNull
    private String email;

    @Column(name = "data_nascimento")
    @NotNull
    private LocalDate dataNascimento;

}
