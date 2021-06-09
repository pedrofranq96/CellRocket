package br.com.cellrocket.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import br.com.cellrocket.repository.CelularRepository;

@Repository
public class CelularDao {

	@Autowired
	private CelularRepository repository;
}
