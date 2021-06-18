package br.com.cellrocket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.cellrocket.model.Celular;

public interface CelularRepository extends JpaRepository<Celular, Long>{
	
	@Query("SELECT c FROM Celular c WHERE usuario_id_usuario = :idUsuario")
	List<Celular> findByIdUsuario(Long idUsuario);
}
