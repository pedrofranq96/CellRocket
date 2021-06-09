package br.com.cellrocket.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import br.com.cellrocket.dao.UsuarioDao;
import br.com.cellrocket.dto.CadastroCelularDto;
import br.com.cellrocket.dto.CadastroConsertoCelularDto;
import br.com.cellrocket.dto.CadastroUsuarioDto;
import br.com.cellrocket.dto.LoginDto;
import br.com.cellrocket.model.Celular;
import br.com.cellrocket.model.ConsertoCelular;
import br.com.cellrocket.model.Usuario;
import br.com.cellrocket.repository.CelularRepository;
import br.com.cellrocket.repository.ConsertoCelularRepository;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioDao usuarioDao;
	
	@Autowired
	private CelularRepository celularRepository;
	
	@Autowired
	private ConsertoCelularRepository consertoCelularRepository;
	
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
		usuarioDao.cadastrarUsuario(usuario);
		
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
	
	@GetMapping("formCadastroCelular")
	public String formCadastroCelular(CadastroCelularDto cadastroCelulularDto) {
		return "formCadastroCelular";
	}
	
	@PostMapping("/cadastroCelular")
	public String cadastro(@Valid CadastroCelularDto cadastroCelulularDto, BindingResult result) {
		
		if(result.hasErrors()) {
			return "formCadastroCelular";
		}
		
		Celular celular = cadastroCelulularDto.toCelular();
		celularRepository.save(celular);
		
		return "redirect:/home";
	}
	
	@GetMapping("/formCadastroConsertoCelular")
	public String formCadastroCelular(CadastroConsertoCelularDto cadastroConsertoCelulularDto) {		
		return "formCadastroConsertoCelular";
	}
	
	@PostMapping("/cadastroConsertoCelular")
	public String cadastro(@Valid CadastroConsertoCelularDto cadastroConsertoCelulularDto, BindingResult result) {
		
		if(result.hasErrors()) {
			return "formCadastroConsertoCelular";
		}
		
		ConsertoCelular consertoCelular = cadastroConsertoCelulularDto.toConsertoCelular();
		consertoCelularRepository.save(consertoCelular);
		
		return "redirect:/home";
	}
}
