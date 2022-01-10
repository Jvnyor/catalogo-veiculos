package com.Jvnyor.catalogoveiculos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Jvnyor.catalogoveiculos.model.Carro;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Long>{

	List<Carro> findByNome(String nome);
	List<Carro> findByMarca(String marca);
	List<Carro> findByModelo(String modelo);
}
