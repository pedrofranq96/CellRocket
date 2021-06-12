package br.com.cellrocket.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.cellrocket.model.Celular;
import br.com.cellrocket.repository.CelularRepository;

@Repository
public class CelularDao {

	@Autowired
	private CelularRepository repository;
	
	public List<Celular> getAll(){
		return repository.findAll();
	}
	
	public void cadastrarCelular(Celular celular) {
		repository.save(celular);
	}
	
	public List<Celular> buscarCeluarIdUsuario(Long idUsuario) {
		List<Celular> celulares = repository.findByIdUsuario(idUsuario);
		if(celulares != null && !celulares.isEmpty()) {
			return celulares;
		}
		
		return null;
	}
	
	public Celular buscarCelularPeloId(Long idCelular) {
		return repository.getById(idCelular);
	}
}
