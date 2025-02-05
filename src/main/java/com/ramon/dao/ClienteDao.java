package com.ramon.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.ramon.basicas.Cliente;

public class ClienteDao {
    private EntityManager em = GetEntityManager.getJpaConnection();

    public void add(Cliente cliente) {
        em.getTransaction().begin();
        em.persist(cliente);
        em.getTransaction().commit();
    }

    public Cliente findByIdCliente(int id) {
        return em.find(Cliente.class, id);
    }

    public void update(Cliente cliente) {
        em.getTransaction().begin();
        em.merge(cliente);
        em.getTransaction().commit();
    }

    public List<Cliente> listar() {

        return em.createQuery("select c from Categoria c", Cliente.class).getResultList();

    }
}
