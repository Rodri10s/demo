package com.ramon.basicas;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "cliente")
@Data
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String email;
    private String cpf;

    @OneToOne(cascade = CascadeType.ALL)
    private Cliente cliente;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private Veiculo veiculo;
}
