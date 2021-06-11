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
@Table(name = "tb_servicos")
public class ServicoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "sq_servicos")
	private int id;

	@Column(name = "servico", nullable = false, unique = true)
	private String servico;

	@Column(name = "imagem", nullable = false)
	private byte[] imagem;

	@OneToMany(mappedBy = "servico", cascade = CascadeType.ALL, orphanRemoval = false)
	private List<LancamentoEntity> lancamentos;

	public ServicoEntity() {
		super();
	}

	public ServicoEntity(int id, String servico, byte[] imagem) {
		super();
		this.id = id;
		this.servico = servico;
		this.imagem = imagem;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getServico() {
		return servico;
	}

	public void setServico(String servico) {
		this.servico = servico;
	}

	public byte[] getImagem() {
		return imagem;
	}

	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}

	public List<LancamentoEntity> getLancamentos() {
		return lancamentos;
	}

	public void setLancamentos(List<LancamentoEntity> lancamentos) {
		this.lancamentos = lancamentos;
	}
}
