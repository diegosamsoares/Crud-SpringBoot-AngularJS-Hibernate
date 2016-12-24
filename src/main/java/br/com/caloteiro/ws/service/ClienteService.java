package br.com.caloteiro.ws.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.caloteiro.ws.model.Cliente;
import br.com.caloteiro.ws.repository.ClienteRepository;

@Service
public class ClienteService {
	@Autowired
	ClienteRepository clienteRepository;
	
	
	//negocios


	public Cliente cadastrar(Cliente cliente) {
		clienteRepository.save(cliente);
		

		return cliente;
	}

	public Collection<Cliente> buscartodos() {
		
		return clienteRepository.findAll();
	}

	public void Excluir(Cliente cliente) {
		clienteRepository.delete(cliente);
	}

	public Cliente buscaPorId(Integer id) {

		return clienteRepository.findOne(id);
	}

	public void alterar(Cliente cliente) {
		clienteRepository.save(cliente);
	}
}
