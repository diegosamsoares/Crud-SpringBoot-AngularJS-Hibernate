package br.com.caloteiro.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.caloteiro.ws.model.Estado;
@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer>{

}
