package br.com.cellrocket.dao;

import org.springframework.beans.factory.annotation.Autowired;
import br.com.cellrocket.repository.CelularRepository;

public class CelularDao {

	@Autowired
	private CelularRepository repository;
}
