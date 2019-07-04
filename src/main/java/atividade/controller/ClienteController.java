package atividade.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import atividade.domain.Cliente;
import atividade.service.ClienteService;

@RestController
@RequestMapping("/atividade/cliente")
@CrossOrigin
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@PostMapping("/salvar")
	public ResponseEntity<?> salvar(@RequestBody @Valid Cliente cliente, BindingResult result) {
		Cliente clienteSalvo = clienteService.salvar(cliente);
		return new ResponseEntity<Cliente>(clienteSalvo, HttpStatus.OK);
	}
	
	@GetMapping("/buscar-por-cpf/{cpf}")
	public ResponseEntity<?> procurarPorCpf(@PathVariable String cpf) {
		Cliente cliente = this.clienteService.procurarPorCpf(cpf);
		return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
	}

	@GetMapping("/buscar-por-nome/{nome}")
	public ResponseEntity<?> procurarPorNome(@PathVariable String nome) {
		Cliente cliente = this.clienteService.procurarPorNome(nome);
		return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
		
	}
	
	@GetMapping("/buscar-por-id/{id}")
	public ResponseEntity<?> procurarPorNome(@PathVariable Long id) {
		Cliente cliente = this.clienteService.buscarPorId(id);
		return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
		
	}

}
