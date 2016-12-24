package br.com.caloteiro.ws.controller;

import java.util.Collection;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import br.com.caloteiro.ws.model.Estado;
import br.com.caloteiro.ws.service.EstadoService;


@RestController
public class EstadoController {
	
	@Autowired
	EstadoService estadoService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/estados", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Estado> cadastrarEstado(@RequestBody Estado estado) {
      Estado estadosalvo = estadoService.cadastrar(estado);

      return new ResponseEntity<Estado>(estadosalvo, HttpStatus.CREATED);

       }
	
	@RequestMapping(method = RequestMethod.GET , value = "/estados", produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Estado>> listarEstado(){
		Collection<Estado> lista=estadoService.listar();
		return  new ResponseEntity<Collection<Estado>>(lista, HttpStatus.OK);
	}
	
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/estados/{id}")
	// mapeamento usand o metodo GET , PRODUZ UM JSON
	public ResponseEntity<Estado> excluirEstado(@PathVariable Integer id) {

		Estado estadoEcontrado = estadoService.buscaporId(id);
		if (estadoEcontrado == null) {
			// mensagem
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		estadoService.remove(estadoEcontrado);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	@RequestMapping(method = RequestMethod.PUT, value = "/estados", consumes = MediaType.APPLICATION_JSON_VALUE)

	public ResponseEntity<Estado> alterarEstado(@RequestBody Estado estado) {

		estadoService.alterar(estado);
		return new ResponseEntity<Estado>(estado, HttpStatus.OK);
	}
}
