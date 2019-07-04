package atividade.ws;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

public class LocacaoWs {
	
	@NotNull(message = "É necessário informar o CPF do cliente que deseja alugar o carro!")
	private String cpfCliente;
	
	@NotNull(message = "É necessário informar o ID do veículo à ser alugado!")
	private Long idVeiculo;

	@NotNull(message = "É necessário informar a data de inicio do aluguel!")
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date inicioLocacao;
	
	@NotNull(message = "É necessário informar a data de término do aluguel!")
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date terminoLocacao;
	
	
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

	public String getCpfCliente() {
		return cpfCliente;
	}

	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}

	public Long getIdVeiculo() {
		return idVeiculo;
	}

	public void setIdVeiculo(Long idVeiculo) {
		this.idVeiculo = idVeiculo;
	}

	
}
