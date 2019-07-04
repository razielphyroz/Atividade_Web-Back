package atividade.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import atividade.domain.Veiculo;
import atividade.service.VeiculoService;

@RestController
@RequestMapping("/atividade/veiculo")
@CrossOrigin
public class VeiculoController {

	@Autowired
	private VeiculoService veiculoService;
	
	@PostMapping("/salvar")
	public ResponseEntity<?> salvar(@RequestBody @Valid Veiculo veiculo, BindingResult result) {
		Veiculo veiculoSalvo = this.veiculoService.salvar(veiculo);
		return new ResponseEntity<Veiculo>(veiculoSalvo, HttpStatus.OK);
	}
	
	@GetMapping("/buscar-por-placa/{placa}")
	public ResponseEntity<?> buscarPorId(@PathVariable("placa") String placa) {
		Veiculo veiculo = this.veiculoService.buscarPorPlaca(placa);
		return new ResponseEntity<Veiculo>(veiculo, HttpStatus.OK);
	}
	
	@GetMapping("/buscar-por-id/{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable("id") Long id) {
		Veiculo veiculo = this.veiculoService.buscarPorId(id);
		return new ResponseEntity<Veiculo>(veiculo, HttpStatus.OK);
	}

	@GetMapping("/listar-todos")
	public ResponseEntity<?> listarTodos() {
		Iterable<Veiculo> veiculos = this.veiculoService.buscarTodos();
		return new ResponseEntity<Iterable<Veiculo>>(veiculos, HttpStatus.OK);
	}
	
	@GetMapping("/listar-por-valor-entre/{inicio}/{termino}")
	public ResponseEntity<?> listarPorCargaHorariaEntre(@PathVariable("inicio") float inicio, @PathVariable("termino") float termino) {
		Iterable<Veiculo> veiculos = this.veiculoService.buscarPorValorEntre(inicio, termino);
		return new ResponseEntity<Iterable<Veiculo>>(veiculos, HttpStatus.OK);
	}
	
	@DeleteMapping("/remover-por-placa/{placa}")
	public ResponseEntity<?> removerPorId(@PathVariable("placa") String placa) {
		this.veiculoService.removerPorPlaca(placa);
		return new ResponseEntity<String>("Ok", HttpStatus.OK);
	}
	
	
}
