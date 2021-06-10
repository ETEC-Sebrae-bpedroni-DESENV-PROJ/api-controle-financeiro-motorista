package br.gov.sp.etecsebrae.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

public class TipoVeiculo implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;

	@NotBlank
	private String tipo;

	public TipoVeiculo() {
		super();
	}

	public TipoVeiculo(int id, @NotBlank String tipo) {
		super();
		this.id = id;
		this.tipo = tipo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
