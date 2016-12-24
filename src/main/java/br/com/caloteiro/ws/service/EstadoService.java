package br.com.caloteiro.ws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.caloteiro.ws.model.Estado;
import br.com.caloteiro.ws.repository.EstadoRepository;
@Service
public class EstadoService {
	@Autowired
	EstadoRepository estadoRepository;
	
	
	
	public Estado cadastrar(Estado estado) {
		estadoRepository.save(estado);
		

		return estado;
	}
	
	
	public List<Estado> listar(){
		List<Estado>lista = estadoRepository.findAll();
		
		return lista;
	}
	
	
	public void remove(Estado estado){
		estadoRepository.delete(estado);
	}
	
	public void alterar(Estado estado){
		estadoRepository.save(estado);
	}
	
	public Estado buscaporId(Integer id){
		return  estadoRepository.findOne(id);
		
	}
	
}
