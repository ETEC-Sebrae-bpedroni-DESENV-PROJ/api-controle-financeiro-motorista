package br.gov.sp.etecsebrae.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

public class MarcaVeiculo implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;

	@NotBlank
	private String marca;

	public MarcaVeiculo() {
		super();
	}

	public MarcaVeiculo(int id, @NotBlank String marca) {
		super();
		this.id = id;
		this.marca = marca;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
}
