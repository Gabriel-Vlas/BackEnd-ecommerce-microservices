package com.ecommerce.usuarios.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.usuarios.api.model.Fornecedor;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {

    Optional<Fornecedor> findByCnpj(String cnpj);

    Optional<List<Fornecedor>> findByNomeFantasiaLike(String nome);

    Optional<Fornecedor> findByRazaoSocial(String razaoSocial);

    Optional<Fornecedor> findByEmail(String email);

}
