package com.ramon.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.ramon.basicas.Veiculo;

public class VeiculoDAO {
    private EntityManager em = GetEntityManager.getJpaConnection();

    public void add(Veiculo veiculo) {
        em.getTransaction().begin();
        em.persist(veiculo);
        em.getTransaction().commit();
    }

    public Veiculo findByIdVeiculo(int id) {
        return em.find(Veiculo.class, id);
    }

    public void update(Veiculo veiculo) {
        em.getTransaction().begin();
        em.merge(veiculo);
        em.getTransaction().commit();
    }

    public List<Veiculo> listar() {

        return em.createQuery("select v from Categoria v", Veiculo.class).getResultList();

    }
}
