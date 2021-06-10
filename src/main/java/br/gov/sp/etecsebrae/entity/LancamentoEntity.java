package br.gov.sp.etecsebrae.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tb_lancamentos")
public class LancamentoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "sq_lancamentos")
	private int id;

	@ManyToOne
	@JoinColumn(name = "id_veiculo", referencedColumnName = "id", nullable = false)
	private VeiculoEntity veiculo;

	@ManyToOne
	@JoinColumn(name = "id_servico", referencedColumnName = "id", nullable = false)
	private ServicoEntity servico;

	@Column(name = "entrada", nullable = false, length = 1)
	private int entrada;

	@Column(name = "valor", nullable = false)
	private double valor;

	@Column(name = "data", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date data;

	@Column(name = "descricao", nullable = false)
	private String descricao;

	@Column(name = "info_adicional", nullable = true)
	private String infoAdicional;

	public LancamentoEntity() {
		super();
	}

	public LancamentoEntity(int id, VeiculoEntity veiculo, ServicoEntity servico, int entrada, double valor, Date data,
			String descricao, String infoAdicional) {
		super();
		this.id = id;
		this.veiculo = veiculo;
		this.servico = servico;
		this.entrada = entrada;
		this.valor = valor;
		this.data = data;
		this.descricao = descricao;
		this.infoAdicional = infoAdicional;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public VeiculoEntity getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(VeiculoEntity veiculo) {
		this.veiculo = veiculo;
	}

	public ServicoEntity getServico() {
		return servico;
	}

	public void setServico(ServicoEntity servico) {
		this.servico = servico;
	}

	public int getEntrada() {
		return entrada;
	}

	public void setEntrada(int entrada) {
		this.entrada = entrada;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getInfoAdicional() {
		return infoAdicional;
	}

	public void setInfoAdicional(String infoAdicional) {
		this.infoAdicional = infoAdicional;
	}
}
