package br.com.cellrocket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.cellrocket.model.ConsertoCelular;

public interface ConsertoCelularRepository extends JpaRepository<ConsertoCelular, Long> {
	
	List<ConsertoCelular> findByIdCelular(Long idCelular);
}
