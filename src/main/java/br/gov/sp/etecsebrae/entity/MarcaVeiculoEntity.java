package br.gov.sp.etecsebrae.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_marcas_veiculos")
public class MarcaVeiculoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "sq_marcas_veiculos")
	private int id;

	@Column(name = "marca", nullable = false, unique = true)
	private String marca;

	@OneToMany(mappedBy = "marca", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ModeloVeiculoEntity> modelos;

	public MarcaVeiculoEntity() {
		super();
	}

	public MarcaVeiculoEntity(int id, String marca) {
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

	public List<ModeloVeiculoEntity> getModelos() {
		return modelos;
	}

	public void setModelos(List<ModeloVeiculoEntity> modelos) {
		this.modelos = modelos;
	}
}
