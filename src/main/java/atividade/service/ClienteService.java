package atividade.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import atividade.domain.Cliente;
import atividade.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente salvar(Cliente cliente) {
		if (cliente.getIdCliente() != null) {
			Optional<Cliente> clienteOptional = this.clienteRepository.findById(cliente.getIdCliente());
			if (clienteOptional.isPresent()) {
				Cliente clienteObj = clienteOptional.get();
				if (!cliente.getCpf().equalsIgnoreCase(clienteObj.getCpf())) {
					throw new RuntimeException("O CPF informado não coincide ao CPF do cliente de ID: " + cliente.getIdCliente() + ". (" + clienteObj.getCpf() + ")");
				} 	
			}
		} 
		return this.clienteRepository.save(cliente);
	}
	
	public Cliente buscarPorId(Long id) {
		Optional<Cliente> cliente = this.clienteRepository.findById(id);
		if (cliente.isPresent()) {
			return cliente.get();
		}
		return null;
	}
	
	public Cliente procurarPorCpf(String cpf) {
		Optional<Cliente> cliente = this.clienteRepository.buscarPorCpf(cpf);
		if (cliente.isPresent()) {
			return cliente.get();
		}
		return null;
	}
	
	public Cliente procurarPorNome(String nome) {
		Optional<Cliente> cliente = this.clienteRepository.buscarPorNome(nome);
		if (cliente.isPresent()) {
			return cliente.get();
		}
		return null;
	}
	
}
