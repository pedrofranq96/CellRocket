package br.com.cellrocket.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import br.com.cellrocket.dto.CadastroUsuarioDto;
import br.com.cellrocket.dto.LoginDto;
import br.com.cellrocket.model.Usuario;
import br.com.cellrocket.repository.UsuarioRepository;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository repository;
	
	@GetMapping("/formCadastro")
	public String formCadastro(CadastroUsuarioDto usuarioDto) {		
		return "formCadastroUsuario";
	}
	
	@PostMapping("/cadastro")
	public String cadastro(@Valid CadastroUsuarioDto usuarioDto, BindingResult result) {
		
		if(result.hasErrors()) {
			return "formCadastroUsuario";
		}
		
		Usuario usuario = usuarioDto.toUsuario();
		repository.save(usuario);
		
		return "redirect:/home";
	}
	
	@GetMapping("/formLogin")
	public String formLogin(LoginDto login) {
		return "formLogin";
	}
	
	@PostMapping("/login")
	public String login(LoginDto login) {
		return "redirect:/pedidos";
	}
}
