package br.gov.sp.etecsebrae.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Lancamento implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;

	@NotNull
	private int idVeiculo;

	@NotNull
	private int idServico;

	@NotNull
	private double valor;

	@NotNull
	private Date data;

	@NotBlank
	private String descricao;

	private String infoAdicional;

	public Lancamento() {
		super();
	}

	public Lancamento(int id, @NotNull int idVeiculo, @NotNull int idServico, @NotNull double valor, @NotNull Date data,
			@NotBlank String descricao, @NotBlank String infoAdicional) {
		super();
		this.id = id;
		this.idVeiculo = idVeiculo;
		this.idServico = idServico;
		this.valor = valor;
		this.data = data;
		this.descricao = descricao;
		this.infoAdicional = infoAdicional;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdVeiculo() {
		return idVeiculo;
	}

	public void setIdVeiculo(int idVeiculo) {
		this.idVeiculo = idVeiculo;
	}

	public int getIdServico() {
		return idServico;
	}

	public void setIdServico(int idServico) {
		this.idServico = idServico;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getInfoAdicional() {
		return infoAdicional;
	}

	public void setInfoAdicional(String infoAdicional) {
		this.infoAdicional = infoAdicional;
	}
}
