package com.projeto.api.apicelrocket.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.projeto.api.apicelrocket.model.Funcionario;
import com.projeto.api.apicelrocket.repository.FuncionarioRepository;

@RestController
@RequestMapping("/funcionario/")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioRepository repository;
	
	@GetMapping("listarTodos")
	public List<Funcionario> getAll() {
		return repository.findAll();
	}

	@PostMapping("create")
	public Funcionario create(@RequestBody Funcionario funcionario) {
		return repository.save(funcionario);
	}
	
	@GetMapping("read/{idFuncionario}")
	public Funcionario read(@PathVariable Long idFuncionario) {
		Funcionario funcionario = repository.findByIdFuncionario(idFuncionario);
		return funcionario;
	}
	
	@PostMapping("update")
	public void update(@RequestBody Funcionario funcionario) {
		Funcionario funcionarioSalvo = repository.findByIdFuncionario(funcionario.getIdFuncionario());
		funcionarioSalvo.setNome(funcionario.getNome());
		funcionarioSalvo.setSobrenome(funcionario.getSobrenome());
		funcionarioSalvo.setCargo(funcionario.getCargo());
		repository.save(funcionarioSalvo);
	}
	
	@GetMapping("delete/{idFuncionario}")
	public void delete(@PathVariable Long idFuncionario) {
		repository.deleteById(idFuncionario);
	}
}