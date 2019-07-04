package atividade.service;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import atividade.domain.Cliente;
import atividade.domain.Locacao;
import atividade.domain.Veiculo;
import atividade.projections.LocacaoProjection;
import atividade.repositories.LocacaoRepository;
import atividade.ws.LocacaoWs;

@Service
public class LocacaoService {

	@Autowired
	public LocacaoRepository locacaoRepository;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private VeiculoService veiculoService;
	
	public Iterable<LocacaoProjection> lsitarTodasLocacoes() {
		Iterable<LocacaoProjection> locacoes = this.locacaoRepository.buscarTodasLocacoes(null);
		return locacoes;
	}
	
	public Iterable<LocacaoProjection> listarLocacoesAtivasProjection(Date data) {
		Iterable<LocacaoProjection> locacoesAtivas = locacaoRepository.buscarLocacoesAtivasProjection(data);
		return locacoesAtivas;
	}
	
	public Locacao salvar(LocacaoWs locacaoWs) {
		Locacao locacao = this.parseLocacaoWsToLocacao(locacaoWs);
		locacao = this.locacaoRepository.save(locacao);
		return locacao;
	}
		
	private Veiculo obterVeiculoentePorId(Long id) {
		Veiculo veiculo = this.veiculoService.buscarPorId(id);
		if (veiculo == null) {
			throw new RuntimeException("[Locacao Service] Não existe nenhum veículo com o ID informado.");
		}
		return veiculo;
	}
	
	private int calcularData(Date dataInicial, Date dataFinal) {
			Calendar calOne = Calendar.getInstance();
		    Calendar caltwo = Calendar.getInstance(); 
		    calOne.setTime(dataInicial);
		    caltwo.setTime(dataFinal);
		    int days = caltwo.get(Calendar.DAY_OF_YEAR) - calOne.get(Calendar.DAY_OF_YEAR);
			return days;
	}
	
	public Float obterValorLocacao(Long idCarro, Date dataIncial, Date dataFinal) {
		Veiculo veiculo = this.obterVeiculoentePorId(idCarro);
		 
	    int days = calcularData(dataIncial, dataFinal);
		float result = (float) days * veiculo.getValorDiaria();
		return result;
	}
	
	private Locacao parseLocacaoWsToLocacao(LocacaoWs locacaoWs) {
		Cliente cliente = this.clienteService.procurarPorCpf(locacaoWs.getCpfCliente());
		if (cliente == null) {
			throw new RuntimeException("O cliente com este CPF não existe!");
		}
		Veiculo veiculo = this.obterVeiculoentePorId(locacaoWs.getIdVeiculo());
		Locacao locacao = new Locacao();
		locacao.setCliente(cliente);
		locacao.setVeiculo(veiculo);

	    int days = calcularData(locacaoWs.getInicioLocacao(), locacaoWs.getTerminoLocacao());
		float total = (float) days * veiculo.getValorDiaria();
				
		locacao.setValorLocacao(total);
		locacao.setInicioLocacao(locacaoWs.getInicioLocacao());
		locacao.setTerminoLocacao(locacaoWs.getTerminoLocacao());
		return locacao;
	}
}
