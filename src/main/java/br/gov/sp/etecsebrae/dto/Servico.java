package br.gov.sp.etecsebrae.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

public class Servico implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;

	@NotBlank
	private String servico;

	@NotBlank
	private String imagem;

	public Servico() {
		super();
	}

	public Servico(int id, @NotBlank String servico, @NotBlank String imagem) {
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

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
}
