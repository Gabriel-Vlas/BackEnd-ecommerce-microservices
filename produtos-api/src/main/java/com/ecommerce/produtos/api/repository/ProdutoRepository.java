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

    @Query("SELECT p FROM tb_produto where p.categoria.nome = :nomeCategoria")
    Optional<List<Produto>> findByCategoria(@Param("nomeCategoria")String nomeCategoria);

    @Query("SELECT p FROM tb_produto where p.categoria.nome = :nomeCategoria AND p.preco <= :preco")
    Optional<List<Produto>> findByCategoriaAndPrecoSmollerThan(@Param("nomeCategoria")String nomeCategoria, @Param("preco") Double preco);

    Optional<List<Produto>> findByPrecoBeteewn(Double limiteInferior, Double limiteSuperior);

}
