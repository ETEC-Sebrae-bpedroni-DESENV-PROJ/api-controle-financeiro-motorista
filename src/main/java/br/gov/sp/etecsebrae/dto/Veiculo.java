package br.gov.sp.etecsebrae.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Veiculo implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;

	@NotNull
	private int idCondutor;

	@NotNull
	private int idModeloVeiculo;

	@NotBlank
	private String placa;

	@NotBlank
	private String imagem;

	@NotBlank
	private String cor;

	@NotNull
	private int ano;

	@NotNull
	private int idTipoCombustivel;

	@NotNull
	private double mediaKml;

	public Veiculo() {
		super();
	}

	public Veiculo(int id, @NotNull int idCondutor, @NotNull int idModeloVeiculo, @NotBlank String placa,
			@NotBlank String imagem, @NotBlank String cor, @NotNull int ano, @NotNull int idTipoCombustivel,
			@NotNull double mediaKml) {
		super();
		this.id = id;
		this.idCondutor = idCondutor;
		this.idModeloVeiculo = idModeloVeiculo;
		this.placa = placa;
		this.imagem = imagem;
		this.cor = cor;
		this.ano = ano;
		this.idTipoCombustivel = idTipoCombustivel;
		this.mediaKml = mediaKml;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdCondutor() {
		return idCondutor;
	}

	public void setIdCondutor(int idCondutor) {
		this.idCondutor = idCondutor;
	}

	public int getIdModeloVeiculo() {
		return idModeloVeiculo;
	}

	public void setIdModeloVeiculo(int idModeloVeiculo) {
		this.idModeloVeiculo = idModeloVeiculo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getIdTipoCombustivel() {
		return idTipoCombustivel;
	}

	public void setIdTipoCombustivel(int idTipoCombustivel) {
		this.idTipoCombustivel = idTipoCombustivel;
	}

	public double getMediaKml() {
		return mediaKml;
	}

	public void setMediaKml(double mediaKml) {
		this.mediaKml = mediaKml;
	}
}
