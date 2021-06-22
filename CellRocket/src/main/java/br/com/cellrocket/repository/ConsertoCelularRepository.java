package br.com.cellrocket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.cellrocket.enums.Status;
import br.com.cellrocket.model.ConsertoCelular;

public interface ConsertoCelularRepository extends JpaRepository<ConsertoCelular, Long> {
	
	List<ConsertoCelular> findByIdCelular(Long idCelular);
	
	List<ConsertoCelular> findByStatus(Status status);
	
	@Query("SELECT c FROM ConsertoCelular c WHERE idConserto = :idConsertoCelular")
	ConsertoCelular buscarPeloIdConsertoCelular(Long idConsertoCelular);
}
