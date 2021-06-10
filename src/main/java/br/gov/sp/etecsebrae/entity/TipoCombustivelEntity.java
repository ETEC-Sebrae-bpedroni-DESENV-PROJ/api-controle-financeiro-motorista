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
@Table(name = "tb_tipos_combustivel")
public class TipoCombustivelEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "sq_tipos_combustivel")
	private int id;

	@Column(name = "tipo_combustivel", nullable = false, unique = true)
	private String tipoCombustivel;

	@OneToMany(mappedBy = "tipoCombustivel", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<VeiculoEntity> veiculos;

	public TipoCombustivelEntity() {
		super();
	}

	public TipoCombustivelEntity(int id, String tipoCombustivel) {
		super();
		this.id = id;
		this.tipoCombustivel = tipoCombustivel;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipoCombustivel() {
		return tipoCombustivel;
	}

	public void setTipoCombustivel(String tipoCombustivel) {
		this.tipoCombustivel = tipoCombustivel;
	}

	public List<VeiculoEntity> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(List<VeiculoEntity> veiculos) {
		this.veiculos = veiculos;
	}
}
