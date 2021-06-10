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
@Table(name = "tb_tipos_veiculos")
public class TipoVeiculoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "sq_tipos_veiculos")
	private int id;

	@Column(name = "tipo", nullable = false, unique = true)
	private String tipo;

	@OneToMany(mappedBy = "tb_tipos_veiculos", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ModeloVeiculoEntity> modelos;

	public TipoVeiculoEntity() {
		super();
	}

	public TipoVeiculoEntity(int id, String tipo) {
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

	public List<ModeloVeiculoEntity> getModelos() {
		return modelos;
	}

	public void setModelos(List<ModeloVeiculoEntity> modelos) {
		this.modelos = modelos;
	}
}
