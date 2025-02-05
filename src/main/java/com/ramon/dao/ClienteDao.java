package com.ramon.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.ramon.basicas.Cliente;

public class ClienteDao {
    private EntityManager em = GetEntityManager.getJpaConnection();

    public void adicionar(Cliente c) {
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
    }

    public Cliente buscarCategoriaId(int id) {
        return em.find(Cliente.class, id);
    }

    public void atualizar(Cliente c) {
        em.getTransaction().begin();
        em.merge(c);
        em.getTransaction().commit();
    }

    public List<Cliente> listar() {

        return em.createQuery("select c from Categoria c", Categoria.class).getResultList();

    }
}
