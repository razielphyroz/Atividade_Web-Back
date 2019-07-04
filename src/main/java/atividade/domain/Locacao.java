package atividade.domain;

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

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="locacao")
public class Locacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idlocacao")
	private Long idLocacao;
	
	@ManyToOne(optional = false)
	@JoinColumn(name="idcliente", nullable=false)
	private Cliente cliente;
	
	@ManyToOne(optional = false)
	@JoinColumn(name="idveiculo", nullable=false)
	private Veiculo veiculo;
	
	@Column(name="datainicio", nullable=false)
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date inicioLocacao;
	
	@Column(name="datatermino", nullable=false)
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date terminoLocacao;
	
	@Column(name = "valorlocacao", nullable=false)
	private Float valorLocacao;
	
	
	public void setValorLocacao(float valorLocacao) {
		this.valorLocacao = valorLocacao;
	}

	public Float getValorLocacao() {
		return valorLocacao;
	}
	
	
	public String getNomeCliente() {
		return cliente.getNome();
	}

	public String getClienteCpf() {
		return cliente.getCpf();
	}
	
	public String getVeiculoMarca() {
		return veiculo.getMarca();
	}
	
	public String getVeiculoPlaca() {
		return veiculo.getPlaca();
	}
	
	public Long getIdLocacao() {
		return idLocacao;
	}


	public void setIdLocacao(Long idLocacao) {
		this.idLocacao = idLocacao;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public Veiculo getVeiculo() {
		return veiculo;
	}


	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}


	public Date getInicioLocacao() {
		return inicioLocacao;
	}


	public void setInicioLocacao(Date inicioLocacao) {
		this.inicioLocacao = inicioLocacao;
	}


	public Date getTerminoLocacao() {
		return terminoLocacao;
	}


	public void setTerminoLocacao(Date terminoLocacao) {
		this.terminoLocacao = terminoLocacao;
	}
	
	
	
}
