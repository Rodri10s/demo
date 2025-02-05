package com.ramon.basicas;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "endereco")
@Data
public class Endereco implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String cidade;
    private String bairro;
    private String rua;
    private String numero;
    private String cep;

    @OneToOne(mappedBy = "endereco")
    private Cliente cliente;
}
