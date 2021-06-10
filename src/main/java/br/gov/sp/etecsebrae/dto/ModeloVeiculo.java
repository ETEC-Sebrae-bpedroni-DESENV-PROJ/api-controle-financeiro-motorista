package br.gov.sp.etecsebrae.dto;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ModeloVeiculo implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;

	private TipoVeiculo tipoVeiculo;

	@NotNull
	private int idTipoVeiculo;

	private MarcaVeiculo marcaVeiculo;

	@NotNull
	private int idMarcaVeiculo;

	@NotBlank
	private String modelo;

	private List<Veiculo> veiculos;

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

	public TipoVeiculo getTipoVeiculo() {
		return tipoVeiculo;
	}

	public void setTipoVeiculo(TipoVeiculo tipoVeiculo) {
		this.tipoVeiculo = tipoVeiculo;
	}

	public int getIdTipoVeiculo() {
		return idTipoVeiculo;
	}

	public void setIdTipoVeiculo(int idTipoVeiculo) {
		this.idTipoVeiculo = idTipoVeiculo;
	}

	public MarcaVeiculo getMarcaVeiculo() {
		return marcaVeiculo;
	}

	public void setMarcaVeiculo(MarcaVeiculo marcaVeiculo) {
		this.marcaVeiculo = marcaVeiculo;
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

	public List<Veiculo> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}
}
