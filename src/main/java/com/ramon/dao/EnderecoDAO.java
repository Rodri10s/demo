package com.ramon.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.ramon.basicas.Endereco;

public class EnderecoDAO {
    private EntityManager em = GetEntityManager.getJpaConnection();

    public void add(Endereco endereco) {
        em.getTransaction().begin();
        em.persist(endereco);
        em.getTransaction().commit();
    }

    public Endereco findByIdEndereco(int id) {
        return em.find(Endereco.class, id);
    }

    public void update(Endereco endereco) {
        em.getTransaction().begin();
        em.merge(endereco);
        em.getTransaction().commit();
    }

    public List<Endereco> listar() {

        return em.createQuery("select e from Categoria e", Endereco.class).getResultList();

    }
}
