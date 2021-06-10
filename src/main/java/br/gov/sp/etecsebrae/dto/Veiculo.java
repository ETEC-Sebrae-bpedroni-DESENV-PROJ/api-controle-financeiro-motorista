package br.gov.sp.etecsebrae.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Veiculo implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;

	private Condutor condutor;

	@NotNull
	private int idCondutor;

	private ModeloVeiculo modeloVeiculo;

	@NotNull
	private int idModeloVeiculo;

	@NotBlank
	private String placa;

	private byte[] imagem;

	@NotBlank
	private String cor;

	@NotNull
	private int ano;

	private TipoCombustivel tipoCombustivel;

	@NotNull
	private int idTipoCombustivel;

	@NotNull
	private double mediaKml;

	public Veiculo() {
		super();
	}

	public Veiculo(int id, @NotNull int idCondutor, @NotNull int idModeloVeiculo, @NotBlank String placa, byte[] imagem,
			@NotBlank String cor, @NotNull int ano, @NotNull int idTipoCombustivel, @NotNull double mediaKml) {
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

	public Condutor getCondutor() {
		return condutor;
	}

	public void setCondutor(Condutor condutor) {
		this.condutor = condutor;
	}

	public int getIdCondutor() {
		return idCondutor;
	}

	public void setIdCondutor(int idCondutor) {
		this.idCondutor = idCondutor;
	}

	public ModeloVeiculo getModeloVeiculo() {
		return modeloVeiculo;
	}

	public void setModeloVeiculo(ModeloVeiculo modeloVeiculo) {
		this.modeloVeiculo = modeloVeiculo;
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

	public byte[] getImagem() {
		return imagem;
	}

	public void setImagem(byte[] imagem) {
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

	public TipoCombustivel getTipoCombustivel() {
		return tipoCombustivel;
	}

	public void setTipoCombustivel(TipoCombustivel tipoCombustivel) {
		this.tipoCombustivel = tipoCombustivel;
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
