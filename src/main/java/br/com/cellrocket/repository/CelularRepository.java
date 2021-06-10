package br.com.cellrocket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.cellrocket.model.Celular;

public interface CelularRepository extends JpaRepository<Celular, Long>{
	
	List<Celular> findByIdUsuario(Long idUsuario);
}
