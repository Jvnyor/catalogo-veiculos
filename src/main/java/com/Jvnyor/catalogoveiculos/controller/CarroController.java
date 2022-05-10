package com.Jvnyor.catalogoveiculos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
@RequestMapping("/api/carros")
public class CarroController {

	private CarroService carroService;

	@Autowired
	public CarroController(CarroService carroService) {
		this.carroService = carroService;
	}

	@GetMapping
	public ResponseEntity<Page<Carro>> listAllCarros(Pageable pageable) {
		return ResponseEntity.ok(carroService.listAll(pageable));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Carro> findCarroById(@PathVariable Long id) {
		return ResponseEntity.ok(carroService.findById(id));
	}

	@GetMapping("/nome/{nome}")
	public ResponseEntity<Page<Carro>> findCarroByNome(@PathVariable String nome, Pageable pageable) {
		return ResponseEntity.ok(carroService.findByNome(nome, pageable));
	}

	@GetMapping("/marca/{marca}")
	public ResponseEntity<Page<Carro>> findCarroByMarca(@PathVariable String marca, Pageable pageable) {
		return ResponseEntity.ok(carroService.findByMarca(marca, pageable));
	}

	@GetMapping("/modelo/{modelo}")
	public ResponseEntity<Page<Carro>> findCarroByModelo(@PathVariable String modelo, Pageable pageable) {
		return ResponseEntity.ok(carroService.findByModelo(modelo, pageable));
	}

	@PostMapping
	public ResponseEntity<Carro> saveCarro(@RequestBody CarroDTO carroDTO) {
		return ResponseEntity.status(HttpStatus.CREATED).body(carroService.save(carroDTO));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Carro> replaceCarro(@PathVariable Long id, @RequestBody CarroDTO carroDTO) {
		return ResponseEntity.ok(carroService.replace(id, carroDTO));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCarro(@PathVariable Long id) {
		carroService.delete(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
}
