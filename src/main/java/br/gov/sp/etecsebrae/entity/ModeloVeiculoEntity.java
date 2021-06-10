package br.gov.sp.etecsebrae.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_modelos_veiculos")
public class ModeloVeiculoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "sq_modelos_veiculos")
	private int id;

	@ManyToOne
	@JoinColumn(name = "id_tipo_veiculo", referencedColumnName = "id", nullable = false)
	private TipoVeiculoEntity tipo;

	@ManyToOne
	@JoinColumn(name = "id_marca_veiculo", referencedColumnName = "id", nullable = false)
	private MarcaVeiculoEntity marca;

	@Column(name = "modelo", nullable = false)
	private String modelo;

	@OneToMany(mappedBy = "modelo", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<VeiculoEntity> veiculos;

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

	public List<VeiculoEntity> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(List<VeiculoEntity> veiculos) {
		this.veiculos = veiculos;
	}
}
