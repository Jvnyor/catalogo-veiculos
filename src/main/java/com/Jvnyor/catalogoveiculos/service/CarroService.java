package com.Jvnyor.catalogoveiculos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

	public List<Carro> listAll(){
		return carroRepository.findAll();
	}
	
	public Carro save(CarroDTO carroDTO){
		return carroRepository.save(Carro.builder().nome(carroDTO.getNome()).marca(carroDTO.getMarca()).modelo(carroDTO.getModelo()).foto(carroDTO.getFoto()).build());
	}
	
	public Carro findById(Long id){
		return carroRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
	}
	
	public Carro replace(Long id,CarroDTO carroDTO){
		Carro carroSaved = findById(id);
		carroSaved.setNome(carroDTO.getNome());
		carroSaved.setMarca(carroDTO.getMarca());
		carroSaved.setModelo(carroDTO.getModelo());
		carroSaved.setFoto(carroDTO.getFoto());
		return carroRepository.save(carroSaved);
	}
	
	public void delete(Long id) {
		carroRepository.delete(findById(id));
	}
	
	public List<Carro> findByNome(String nome){
		return carroRepository.findByNome(nome);
	}
	
	public List<Carro> findByMarca(String marca){
		return carroRepository.findByMarca(marca);
	}
	
	public List<Carro> findByModelo(String modelo){
		return carroRepository.findByModelo(modelo);
	}
}
