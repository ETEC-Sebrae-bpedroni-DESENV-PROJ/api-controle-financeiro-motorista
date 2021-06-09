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
@Table(name = "tb_modelos_veiculos")
public class ModeloVeiculoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@OneToOne
	@JoinColumn(name = "id_tipo_veiculo", referencedColumnName = "id", nullable = false)
	private TipoVeiculoEntity tipo;

	@OneToOne
	@JoinColumn(name = "id_marca_veiculo", referencedColumnName = "id", nullable = false)
	private MarcaVeiculoEntity marca;

	@Column(name = "modelo", nullable = false)
	private String modelo;

	public ModeloVeiculoEntity() {
		super();
	}

	public ModeloVeiculoEntity(int id, TipoVeiculoEntity tipo, MarcaVeiculoEntity marca, String modelo) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.marca = marca;
		this.modelo = modelo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public TipoVeiculoEntity getTipo() {
		return tipo;
	}

	public void setTipo(TipoVeiculoEntity tipo) {
		this.tipo = tipo;
	}

	public MarcaVeiculoEntity getMarca() {
		return marca;
	}

	public void setMarca(MarcaVeiculoEntity marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
}
