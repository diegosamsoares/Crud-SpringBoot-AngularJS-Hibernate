package br.com.caloteiro.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.caloteiro.ws.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Integer> {

	
	
}
