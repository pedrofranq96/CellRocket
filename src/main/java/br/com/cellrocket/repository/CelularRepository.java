package br.com.cellrocket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.cellrocket.model.Celular;

public interface CelularRepository extends JpaRepository<Celular, Long>{

}
