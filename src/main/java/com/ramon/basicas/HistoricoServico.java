package com.ramon.basicas;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "historico_servico")
@Data
public class HistoricoServico implements Serializable {
    @EmbeddedId
    private HistoricoServicoPK id = new HistoricoServicoPK();

    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario;

    public HistoricoServico(Veiculo veiculo, Servico servico, Funcionario funcionario) {
        id.setServico(servico);
        id.setVeiculo(veiculo);
        this.funcionario = funcionario;
    }

}
