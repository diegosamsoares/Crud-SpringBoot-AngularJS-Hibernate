package br.com.caloteiro.ws.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.caloteiro.ws.model.Cliente;
import br.com.caloteiro.ws.service.ClienteService;

@RestController // torna essa classe um REST
public class ClienteController {

	// negocios
	@Autowired//injeção de dependencia
 ClienteService clienteService;

	// EndPoints

	@RequestMapping(method = RequestMethod.POST, value = "/clientes", consumes = MediaType.APPLICATION_JSON_VALUE)
	// mapeamento usand o metodo POST , CONSUMINDO UM JSON
	public ResponseEntity<Cliente> cadastrarCliente(@RequestBody Cliente cliente) {
		Cliente clientesalvo = clienteService.cadastrar(cliente);

		return new ResponseEntity<Cliente>(clientesalvo, HttpStatus.CREATED);

	}

	@RequestMapping(method = RequestMethod.GET, value = "/clientes", produces = MediaType.APPLICATION_JSON_VALUE)
	// mapeamento usand o metodo GET , PRODUZ UM JSON
	public ResponseEntity<Collection<Cliente>> listarCliente() {
		Collection<Cliente> clientesBuscados = clienteService.buscartodos();
		return new ResponseEntity<Collection<Cliente>>(clientesBuscados, HttpStatus.OK);

	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/clientes/{id}")
	// mapeamento usand o metodo GET , PRODUZ UM JSON
	public ResponseEntity<Cliente> excluirCliente(@PathVariable Integer id) {

		Cliente clienteEcontrado = clienteService.buscaPorId(id);
		if (clienteEcontrado == null) {
			// mensagem
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		clienteService.Excluir(clienteEcontrado);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/clientes", consumes = MediaType.APPLICATION_JSON_VALUE)

	public ResponseEntity<Cliente> alterarCliente(@RequestBody Cliente cliente) {

		clienteService.alterar(cliente);
		return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
	}

}
