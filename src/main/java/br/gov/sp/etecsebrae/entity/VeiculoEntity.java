package br.gov.sp.etecsebrae.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_veiculos")
public class VeiculoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@OneToOne
	@JoinColumn(name = "id_condutor", referencedColumnName = "id", nullable = false)
	private CondutorEntity condutor;

	@OneToOne
	@JoinColumn(name = "id_modelo_veiculo", referencedColumnName = "id", nullable = false)
	private ModeloVeiculoEntity modelo;

	@Column(name = "placa", nullable = false)
	private String placa;

	@Column(name = "imagem", nullable = false)
	private String imagem;

	@Column(name = "cor", nullable = false)
	private String cor;

	@Column(name = "ano", nullable = false)
	private int ano;

	@OneToOne
	@JoinColumn(name = "id_tipo_combustivel", referencedColumnName = "id", nullable = false)
	private TipoCombustivelEntity tipoCombustivel;

	@Column(name = "media_kml", nullable = false)
	private double mediaKml;

	public VeiculoEntity() {
		super();
	}

	public VeiculoEntity(int id, CondutorEntity condutor, ModeloVeiculoEntity modelo, String placa, String imagem,
			String cor, int ano, TipoCombustivelEntity tipoCombustivel, double mediaKml) {
		super();
		this.id = id;
		this.condutor = condutor;
		this.modelo = modelo;
		this.placa = placa;
		this.imagem = imagem;
		this.cor = cor;
		this.ano = ano;
		this.tipoCombustivel = tipoCombustivel;
		this.mediaKml = mediaKml;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CondutorEntity getCondutor() {
		return condutor;
	}

	public void setCondutor(CondutorEntity condutor) {
		this.condutor = condutor;
	}

	public ModeloVeiculoEntity getModelo() {
		return modelo;
	}

	public void setModelo(ModeloVeiculoEntity modelo) {
		this.modelo = modelo;
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

	public TipoCombustivelEntity getTipoCombustivel() {
		return tipoCombustivel;
	}

	public void setTipoCombustivel(TipoCombustivelEntity tipoCombustivel) {
		this.tipoCombustivel = tipoCombustivel;
	}

	public double getMediaKml() {
		return mediaKml;
	}

	public void setMediaKml(double mediaKml) {
		this.mediaKml = mediaKml;
	}
}
