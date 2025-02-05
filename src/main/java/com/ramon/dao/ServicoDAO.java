package com.ramon.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.ramon.basicas.Servico;

public class ServicoDAO {
    private EntityManager em = GetEntityManager.getJpaConnection();

    public void add(Servico servico) {
        em.getTransaction().begin();
        em.persist(servico);
        em.getTransaction().commit();
    }

    public Servico findByIdServico(int id) {
        return em.find(Servico.class, id);
    }

    public void update(Servico servico) {
        em.getTransaction().begin();
        em.merge(servico);
        em.getTransaction().commit();
    }

    public List<Servico> listar() {

        return em.createQuery("select e from Categoria e", Servico.class).getResultList();

    }
}
