package br.gov.sp.etecsebrae.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tb_condutores")
public class CondutorEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "sq_condutores")
	private int id;

	@Column(name = "nome", nullable = false)
	private String nome;

	@Column(name = "sobrenome", nullable = false)
	private String sobrenome;

	@Column(name = "data_nascimento", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;

	@Column(name = "email", nullable = false, unique = true)
	private String email;

	@Column(name = "senha", nullable = false)
	private String senha;

	@Column(name = "telefone", nullable = false)
	private String telefone;

	@Lob
	@Column(name = "imagem", nullable = true)
	private byte[] imagem;

	@Column(name = "endereco_cep", nullable = false)
	private String enderecoCep;

	@Column(name = "endereco_lograd", nullable = false)
	private String enderecoLogradouro;

	@Column(name = "endereco_numero", nullable = false)
	private String enderecoNumero;

	@Column(name = "endereco_bairro", nullable = false)
	private String enderecoBairro;

	@Column(name = "endereco_cidade", nullable = false)
	private String enderecoCidade;

	@Column(name = "endereco_estado", nullable = false)
	private String enderecoEstado;

	@Column(name = "endereco_compl", nullable = true)
	private String enderecoComplemento;

	@OneToMany(mappedBy = "condutor", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<VeiculoEntity> veiculos;

	public CondutorEntity() {
		super();
	}

	public CondutorEntity(int id, String nome, String sobrenome, Date dataNascimento, String email, String senha,
			String telefone, byte[] imagem, String enderecoCep, String enderecoLogradouro, String enderecoNumero,
			String enderecoBairro, String enderecoCidade, String enderecoEstado, String enderecoComplemento) {
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

	public byte[] getImagem() {
		return imagem;
	}

	public void setImagem(byte[] imagem) {
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

	public List<VeiculoEntity> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(List<VeiculoEntity> veiculos) {
		this.veiculos = veiculos;
	}
}
