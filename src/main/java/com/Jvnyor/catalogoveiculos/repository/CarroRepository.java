package com.Jvnyor.catalogoveiculos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Jvnyor.catalogoveiculos.model.Carro;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Long>{

}
