package com.ramon.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.ramon.basicas.Funcionario;

public class FuncionarioDAO {
    private EntityManager em = GetEntityManager.getJpaConnection();

    public void add(Funcionario funcionario) {
        em.getTransaction().begin();
        em.persist(funcionario);
        em.getTransaction().commit();
    }

    public Funcionario findByIdFuncionario(int id) {
        return em.find(Funcionario.class, id);
    }

    public void update(Funcionario funcionario) {
        em.getTransaction().begin();
        em.merge(funcionario);
        em.getTransaction().commit();
    }

    public List<Funcionario> listar() {

        return em.createQuery("select f from Categoria f", Funcionario.class).getResultList();

    }
}
