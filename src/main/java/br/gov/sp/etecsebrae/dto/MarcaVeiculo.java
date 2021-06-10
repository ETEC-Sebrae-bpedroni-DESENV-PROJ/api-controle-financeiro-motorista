package br.gov.sp.etecsebrae.dto;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotBlank;

public class MarcaVeiculo implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;

	@NotBlank
	private String marca;

	private List<ModeloVeiculo> modelos;

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

	public List<ModeloVeiculo> getModelos() {
		return modelos;
	}

	public void setModelos(List<ModeloVeiculo> modelos) {
		this.modelos = modelos;
	}
}
