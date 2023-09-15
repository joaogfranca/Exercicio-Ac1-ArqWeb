package com.example.demo.repository;

import com.example.demo.models.Categoria;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class CategoriaRepository {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public Categoria inserir(Categoria categoria) {
        entityManager.merge(categoria);
        return categoria;
    }

    @Transactional
    public Categoria editar(Categoria categoria) {
        entityManager.merge(categoria);
        return categoria;
    }

    public List<Categoria> obterTodos() {
        return entityManager.createQuery("from Categoria",
                Categoria.class).getResultList();
    }

    @Transactional
    public void excluirCategoriaPorId(Long id) {
        Categoria categoriaExcluida = entityManager
                .find(Categoria.class, id);
        this.entityManager.remove(categoriaExcluida);
    }

    @Transactional
    public void excluir(Categoria categoria) {
        entityManager.remove(categoria);
    }

    public Categoria obterCategoriaPorId(Long id) {
        String jpql = "select c from Categoria c where c.id like :id";
        TypedQuery<Categoria> query = entityManager.createQuery(jpql, Categoria.class);
        query.setParameter("id", "%" + id + "%");
        return query.getSingleResult();
    }
}
