package br.com.cellrocket.interfaces;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import br.com.cellrocket.model.Funcionario;

@FeignClient(url= "http://localhost:8082/funcionario/", name = "ApiCellrocketInterface")
public interface ApiCellrocketInterface {
	
	@GetMapping("listarTodos")
	List<Funcionario> listarTodos();
	
	@PostMapping("create")
	Funcionario create(Funcionario funcionario);
	
	@PostMapping("update")
	void update(Funcionario funcionario);
	
	@GetMapping("read/{idFuncionario}")
	Funcionario read(@PathVariable Long idFuncionario);
	
	@GetMapping("delete/{idFuncionario}")
	void delete(@PathVariable Long idFuncionario);
}
