package atividade.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import atividade.domain.Veiculo;
import atividade.repositories.VeiculoRepository;

@Service
public class VeiculoService {
	
	@Autowired
	private VeiculoRepository veiculoRepository;

	public Veiculo salvar(Veiculo veiculo) {
		Optional<Veiculo> veiculoOptional = this.veiculoRepository.findByPlaca(veiculo.getPlaca());
		if (veiculoOptional.isPresent()) {
			Veiculo veiculoObj = veiculoOptional.get();
			veiculo.setIdVeiculo(veiculoObj.getIdVeiculo());
		}
		return this.veiculoRepository.save(veiculo);
	}

	public Veiculo buscarPorId(Long id) {
		Optional<Veiculo> veiculoOptional = this.veiculoRepository.findById(id);
		if (veiculoOptional.isPresent()) {
			return veiculoOptional.get();
		}
		return null;
	}
	
	public Veiculo buscarPorPlaca(String placa) {
		if (placa.trim().isEmpty()) {
			//throw new CustomRuntimeException("placa", "Não foi informada uma placa para consulta!");
		}
		
		Optional<Veiculo> veiculo = this.veiculoRepository.findByPlaca(placa);
		
		if (veiculo.isPresent()) {
			return veiculo.get();
		}
		return null;
	}	
	
	public Iterable<Veiculo> buscarTodos() {
		return this.veiculoRepository.findAll();
	}
	
	public void removerPorPlaca(String placa) {
		Optional<Veiculo> veiculoOptional = this.veiculoRepository.findByPlaca(placa);
		if (veiculoOptional.isPresent()) {
			this.veiculoRepository.deleteById(veiculoOptional.get().getIdVeiculo());
		} else {
			throw new RuntimeException("Veiculo com placa (" + placa + ") não encontrado.");
		}
		
	}
	
	public Iterable<Veiculo>buscarPorValorEntre(float inicio, float termino) {
		if (inicio > termino) {
			//throw new CustomRuntimeException("cargaHoraria", "O primeiro valor deve ser inferior ao segundo!");
		}

		return this.veiculoRepository.buscaPorPrecoEntre(inicio, termino);
	}
	
}
