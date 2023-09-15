package com.example.demo.repository;

import com.example.demo.models.Produto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class ProdutoRepository {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public Produto inserir(Produto produto) {
        entityManager.merge(produto);
        return produto;
    }

    @Transactional
    public Produto editar(Produto produto) {
        entityManager.merge(produto);
        return produto;
    }

    public List<Produto> obterTodos() {
        return entityManager.createQuery("from Produto",
                Produto.class).getResultList();
    }

    @Transactional
    public void excluirProdutoPorId(Long id) {
        Produto produtoExcluido = entityManager
                .find(Produto.class, id);
        this.entityManager.remove(produtoExcluido);
    }

    @Transactional
    public void excluir(Produto produto) {
        entityManager.remove(produto);
    }

    public Produto obterProdutoPorId(Long id) {
        String jpql = "select c from Produto c where c.id like :id";
        TypedQuery<Produto> query = entityManager
                .createQuery(jpql, Produto.class);
        query.setParameter("id", "%" + id + "%");
        return query.getSingleResult();
    }
}
