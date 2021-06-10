package br.gov.sp.etecsebrae.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

public class TipoCombustivel implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;

	@NotBlank
	private String tipoCombustivel;

	public TipoCombustivel() {
		super();
	}

	public TipoCombustivel(int id, @NotBlank String tipoCombustivel) {
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
}
