package br.gov.sp.etecsebrae.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ModeloVeiculo implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;

	@NotNull
	private int idTipoVeiculo;

	@NotNull
	private int idMarcaVeiculo;

	@NotBlank
	private String modelo;

	public ModeloVeiculo() {
		super();
	}

	public ModeloVeiculo(int id, @NotNull int idTipoVeiculo, @NotNull int idMarcaVeiculo, @NotBlank String modelo) {
		super();
		this.id = id;
		this.idTipoVeiculo = idTipoVeiculo;
		this.idMarcaVeiculo = idMarcaVeiculo;
		this.modelo = modelo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdTipoVeiculo() {
		return idTipoVeiculo;
	}

	public void setIdTipoVeiculo(int idTipoVeiculo) {
		this.idTipoVeiculo = idTipoVeiculo;
	}

	public int getIdMarcaVeiculo() {
		return idMarcaVeiculo;
	}

	public void setIdMarcaVeiculo(int idMarcaVeiculo) {
		this.idMarcaVeiculo = idMarcaVeiculo;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
}
