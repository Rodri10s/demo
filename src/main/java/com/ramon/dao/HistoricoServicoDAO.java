package com.ramon.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.ramon.basicas.HistoricoServico;

public class HistoricoServicoDAO {
    private EntityManager em = GetEntityManager.getJpaConnection();

    public void add(HistoricoServico historicoServico) {
        em.getTransaction().begin();
        em.persist(historicoServico);
        em.getTransaction().commit();
    }

    public HistoricoServico findByIdHistoricoServico(int id) {
        return em.find(HistoricoServico.class, id);
    }

    public void update(HistoricoServico historicoServico) {
        em.getTransaction().begin();
        em.merge(historicoServico);
        em.getTransaction().commit();
    }

    public List<HistoricoServico> listar() {

        return em.createQuery("select h from Categoria h", HistoricoServico.class).getResultList();

    }
}
