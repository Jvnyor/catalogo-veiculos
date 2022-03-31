package com.Jvnyor.catalogoveiculos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.Jvnyor.catalogoveiculos.model.Carro;
import com.Jvnyor.catalogoveiculos.model.CarroDTO;
import com.Jvnyor.catalogoveiculos.repository.CarroRepository;

@Service
public class CarroService {

	private CarroRepository carroRepository;
		
	@Autowired
	public CarroService(CarroRepository carroRepository) {
		this.carroRepository = carroRepository;
	}

	public Page<Carro> listAll(Pageable pageable){
		return carroRepository.findAll(pageable);
	}
	
	public Page<Carro> findByNome(String nome, Pageable pageable) {
		return carroRepository.findByNome(nome, pageable);
	}

	public Page<Carro> findByMarca(String marca, Pageable pageable) {
		return carroRepository.findByMarca(marca, pageable);
	}
	
	public Page<Carro> findByModelo(String modelo, Pageable pageable) {
		return carroRepository.findByModelo(modelo, pageable);
	}
	
	public Carro save(CarroDTO carroDTO){
		return carroRepository.save(Carro.builder()
				.nome(carroDTO.getNome())
				.marca(carroDTO.getMarca())
				.modelo(carroDTO.getModelo())
				.foto(carroDTO.getFoto())
				.build());
	}
	
	public Carro findById(Long id){
		return carroRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
	}
	
	public Carro replace(Long id,CarroDTO carroDTO){
		return carroRepository.save(Carro.builder()
				.id(id)
				.nome(carroDTO.getNome())
				.marca(carroDTO.getMarca())
				.modelo(carroDTO.getModelo())
				.foto(carroDTO.getFoto())
				.build());
	}
	
	public void delete(Long id) {
		carroRepository.delete(findById(id));
	}

}
