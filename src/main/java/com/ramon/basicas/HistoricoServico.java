package com.ramon.basicas;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "historico_servico")
public class HistoricoServico {
    @EmbeddedId
    private HistoricoServicoPK id = new HistoricoServicoPK();

    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario;
}
