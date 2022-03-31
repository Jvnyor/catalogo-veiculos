package com.Jvnyor.catalogoveiculos.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Jvnyor.catalogoveiculos.model.Carro;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Long>{

	Page<Carro> findByNome(String nome, Pageable pageable);
	Page<Carro> findByMarca(String marca, Pageable pageable);
	Page<Carro> findByModelo(String modelo, Pageable pageable);
}
