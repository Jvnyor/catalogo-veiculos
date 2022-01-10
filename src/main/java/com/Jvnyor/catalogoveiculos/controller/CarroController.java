package com.Jvnyor.catalogoveiculos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Jvnyor.catalogoveiculos.model.Carro;
import com.Jvnyor.catalogoveiculos.model.CarroDTO;
import com.Jvnyor.catalogoveiculos.service.CarroService;

@RestController
@RequestMapping("/carros")
public class CarroController {

	private CarroService carroService;
	
	@Autowired
	public CarroController(CarroService carroService) {
		this.carroService = carroService;
	}

	@GetMapping
	public ResponseEntity<List<Carro>> listAllCarros(){
		return ResponseEntity.ok(carroService.listAll());
	}
	
	@GetMapping("/{nome}")
	public ResponseEntity<List<Carro>> findCarroByName(@PathVariable String nome){
		return ResponseEntity.ok(carroService.findByNome(nome));
	}
	
	@GetMapping("/{modelo}")
	public ResponseEntity<List<Carro>> findCarroByModelo(@PathVariable String modelo){
		return ResponseEntity.ok(carroService.findByModelo(modelo));
	}
	
	@GetMapping("/{marca}")
	public ResponseEntity<List<Carro>> findCarroByMarca(@PathVariable String marca){
		return ResponseEntity.ok(carroService.findByMarca(marca));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Carro> findCarroById(@PathVariable Long id){
		return ResponseEntity.ok(carroService.findById(id));
	}
	
	@PostMapping
	public ResponseEntity<Carro> saveCarro(@RequestBody CarroDTO carroDTO){
		return new ResponseEntity<>(carroService.save(carroDTO),HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Carro> replaceCarro(@PathVariable Long id,@RequestBody CarroDTO carroDTO){
		return ResponseEntity.ok(carroService.replace(id,carroDTO));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCarro(Long id){
		carroService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
