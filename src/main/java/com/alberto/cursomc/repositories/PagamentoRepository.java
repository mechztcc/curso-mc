package com.alberto.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alberto.cursomc.domain.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {

}
