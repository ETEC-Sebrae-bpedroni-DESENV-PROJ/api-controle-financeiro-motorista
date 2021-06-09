package br.gov.sp.etecsebrae.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Condutor implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;

	@NotBlank
	private String nome;

	@NotBlank
	private String sobrenome;

	@NotNull
	private Date dataNascimento;

	@NotBlank
	private String email;

	@NotBlank
	private String senha;

	@NotBlank
	private String telefone;

	private String imagem;

	@NotBlank
	private String enderecoCep;

	@NotBlank
	private String enderecoLogradouro;

	@NotBlank
	private String enderecoNumero;

	@NotBlank
	private String enderecoBairro;

	@NotBlank
	private String enderecoCidade;

	@NotBlank
	private String enderecoEstado;

	private String enderecoComplemento;

	public Condutor() {
		super();
	}

	public Condutor(int id, @NotBlank String nome, @NotBlank String sobrenome, @NotNull Date dataNascimento,
			@NotBlank String email, @NotBlank String senha, @NotBlank String telefone, @NotBlank String imagem,
			@NotBlank String enderecoCep, @NotBlank String enderecoLogradouro, @NotBlank String enderecoNumero,
			@NotBlank String enderecoBairro, @NotBlank String enderecoCidade, @NotBlank String enderecoEstado,
			@NotBlank String enderecoComplemento) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.dataNascimento = dataNascimento;
		this.email = email;
		this.senha = senha;
		this.telefone = telefone;
		this.imagem = imagem;
		this.enderecoCep = enderecoCep;
		this.enderecoLogradouro = enderecoLogradouro;
		this.enderecoNumero = enderecoNumero;
		this.enderecoBairro = enderecoBairro;
		this.enderecoCidade = enderecoCidade;
		this.enderecoEstado = enderecoEstado;
		this.enderecoComplemento = enderecoComplemento;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public String getEnderecoCep() {
		return enderecoCep;
	}

	public void setEnderecoCep(String enderecoCep) {
		this.enderecoCep = enderecoCep;
	}

	public String getEnderecoLogradouro() {
		return enderecoLogradouro;
	}

	public void setEnderecoLogradouro(String enderecoLogradouro) {
		this.enderecoLogradouro = enderecoLogradouro;
	}

	public String getEnderecoNumero() {
		return enderecoNumero;
	}

	public void setEnderecoNumero(String enderecoNumero) {
		this.enderecoNumero = enderecoNumero;
	}

	public String getEnderecoBairro() {
		return enderecoBairro;
	}

	public void setEnderecoBairro(String enderecoBairro) {
		this.enderecoBairro = enderecoBairro;
	}

	public String getEnderecoCidade() {
		return enderecoCidade;
	}

	public void setEnderecoCidade(String enderecoCidade) {
		this.enderecoCidade = enderecoCidade;
	}

	public String getEnderecoEstado() {
		return enderecoEstado;
	}

	public void setEnderecoEstado(String enderecoEstado) {
		this.enderecoEstado = enderecoEstado;
	}

	public String getEnderecoComplemento() {
		return enderecoComplemento;
	}

	public void setEnderecoComplemento(String enderecoComplemento) {
		this.enderecoComplemento = enderecoComplemento;
	}
}
