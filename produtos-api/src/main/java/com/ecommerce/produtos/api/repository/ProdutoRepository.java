package com.ecommerce.produtos.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecommerce.produtos.api.model.Produto;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{

    Optional<Produto> findByCodigo(String codigo);

    @Query("SELECT p FROM Produto p WHERE p.categoria.nome = :nomeCategoria")
    Optional<List<Produto>> findByCategoria(@Param("nomeCategoria") String nomeCategoria);

    @Query("SELECT p FROM Produto p WHERE p.categoria.nome = :nomeCategoria AND p.preco <= :preco")
    Optional<List<Produto>> findByCategoriaAndPrecoSmallerThan(@Param("nomeCategoria") String nomeCategoria, @Param("preco") Double preco);

    @Query("SELECT p FROM Produto p WHERE p.preco BETWEEN :limiteInferior AND :limiteSuperior")
    Optional<List<Produto>> findByPrecoBetween(@Param("limiteInferior") Double limiteInferior, @Param("limiteSuperior") Double limiteSuperior);

}
