package br.com.cellrocket.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import br.com.cellrocket.enums.Status;
import br.com.cellrocket.model.ConsertoCelular;
import br.com.cellrocket.repository.ConsertoCelularRepository;

@Repository
public class ConsertoCelularDao {
	
	@Autowired
	private ConsertoCelularRepository repository;
	
	public List<ConsertoCelular> getAll(){
		return repository.findAll();
	}
	
	public ConsertoCelular cadastrarConsertoCelular(ConsertoCelular consertoCelular) {
		return repository.save(consertoCelular);
	}
	
	public List<ConsertoCelular> buscarStatusConserto(Long idCelular) {
		return repository.findByIdCelular(idCelular);
	}
	
	public List<ConsertoCelular> buscarConsertosPeloStatus(String status) {
		return repository.findByStatus(Status.valueOf(status.toUpperCase()));
	}
	
	public void excluirConserto(Long idConserto) {
		repository.deleteById(idConserto);
	}
	
	public ConsertoCelular buscarPeloId(Long id) {
		return repository.buscarPeloIdConsertoCelular(id);
	}
	
	public void updatePedido(ConsertoCelular consertoCelular) {
		repository.save(consertoCelular);
	}
}
