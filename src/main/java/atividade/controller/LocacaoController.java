package atividade.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import atividade.domain.Locacao;
import atividade.projections.LocacaoProjection;
import atividade.service.LocacaoService;
import atividade.ws.LocacaoWs;

@RestController
@RequestMapping("/atividade/locacao")
@CrossOrigin
public class LocacaoController {

	@Autowired 
	private LocacaoService locacaoService;
	
	@PostMapping("/salvar")
	public ResponseEntity<?> salvar(@RequestBody @Valid LocacaoWs locacaoWs, BindingResult result) {
		
		Locacao locacao = this.locacaoService.salvar(locacaoWs);
		return new ResponseEntity<Locacao>(locacao, HttpStatus.OK);
	}
	
	@GetMapping("/listar-todas-locacoes")
	public ResponseEntity<?> lsitarTodasLocacoes() {
		Iterable<LocacaoProjection> locacoes = this.locacaoService.lsitarTodasLocacoes();
		return new ResponseEntity<Iterable<LocacaoProjection>>(locacoes, HttpStatus.OK);
	}
	
	@GetMapping("/listar-locacoes-ativas-projection/{data}")
	public ResponseEntity<?> listarLocacoesAtivasProjection(@PathVariable("data") @DateTimeFormat(pattern = "dd-MM-yyyy") Date data) {
		
		Iterable<LocacaoProjection> locacoes = this.locacaoService.listarLocacoesAtivasProjection(data);
		return new ResponseEntity<Iterable<LocacaoProjection>>(locacoes, HttpStatus.OK);
	}

	
	@GetMapping("/obter-valor-locacao/{idCarro}/{dataInicial}/{dataFinal}")
	public Float obterValorLocacao(@PathVariable("idCarro") Long idCarro,  
			@DateTimeFormat(pattern = "dd-MM-yyyy") @PathVariable("dataInicial") Date dataIncial, 
			@DateTimeFormat(pattern = "dd-MM-yyyy") @PathVariable("dataFinal")Date dataFinal) {
		Float result = this.locacaoService.obterValorLocacao(idCarro, dataIncial, dataFinal);
		return result;
	}
	
}
