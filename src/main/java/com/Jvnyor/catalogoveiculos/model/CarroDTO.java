package com.Jvnyor.catalogoveiculos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarroDTO {

	private String nome;
	private String marca;
	private String modelo;
	private String foto;
	
	
}
