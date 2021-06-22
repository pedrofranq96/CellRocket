package br.com.cellrocket.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import br.com.cellrocket.dao.CelularDao;
import br.com.cellrocket.dao.ConsertoCelularDao;
import br.com.cellrocket.dao.UsuarioDao;
import br.com.cellrocket.model.Celular;
import br.com.cellrocket.model.ConsertoCelular;
import br.com.cellrocket.model.Usuario;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioDao usuarioDao;
	
	@Autowired
	private CelularDao celularDao;
	
	@Autowired
	private ConsertoCelularDao consertoCelularDao;
	
//	@GetMapping("/formCadastro")
//	public String formCadastro(CadastroUsuarioDto usuarioDto) {		
//		return "formCadastroUsuario";
//	}
//	
//	@PostMapping("/cadastro")
//	public String cadastro(@Valid CadastroUsuarioDto usuarioDto, BindingResult result) {
//		
//		if(result.hasErrors()) {
//			return "formCadastroUsuario";
//		}
//		
//		Usuario usuario = usuarioDto.toUsuario();
//		usuarioDao.cadastrarUsuario(usuario);
//		
//		return "redirect:/home";
//	}
	
//	@GetMapping("/formCadastroCelular")
//	public String formCadastroCelular(CadastroCelularDto cadastroCelulularDto) {
//		return "formCadastroCelular";
//	}
	
//	@PostMapping("/cadastroCelular")
//	public String cadastro(@Valid CadastroCelularDto cadastroCelulularDto, BindingResult result) {
//		
//		if(result.hasErrors()) {
//			return "formCadastroCelular";
//		}
//		
//		Usuario usuario = usuarioDao.buscarPeloId(1L);
//		
//		Celular celular = cadastroCelulularDto.toCelular();
//		celular.setUsuario(usuario);
//		celularDao.cadastrarCelular(celular);
//		
//		return "redirect:/home";
//	}
	
//	@GetMapping("/formCadastroConsertoCelular")
//	public String formCadastroCelular(CadastroConsertoCelularDto cadastroConsertoCelulularDto) {		
//		return "formCadastroConsertoCelular";
//	}
	
//	@PostMapping("/cadastroConsertoCelular")
//	public String cadastro(@Valid CadastroConsertoCelularDto cadastroConsertoCelulularDto, BindingResult result) {
//		
//		if(result.hasErrors()) {
//			return "formCadastroConsertoCelular";
//		}
//		
//		ConsertoCelular consertoCelular = cadastroConsertoCelulularDto.toConsertoCelular();
//		consertoCelularDao.cadastrarConsertoCelular(consertoCelular);
//		
//		return "redirect:/home";
//	}
	
	@GetMapping("/formBuscaUsuario")
	public String formBuscaUsuario(String cpf) {
		return "formBuscaUsuario";
	}
	
	@GetMapping("/buscarUsuario")
	public String buscarUsuario(@RequestParam(value = "cpf", required = true) String cpf, Model model) {

		Usuario usuario = usuarioDao.buscarUsuarioCpf(cpf);
		if (usuario != null) {
			List<Celular> celulares = celularDao.buscarCeluarIdUsuario(usuario.getIdUsuario());
			if(celulares != null && !celulares.isEmpty()) {
				model.addAttribute("celulares", celulares);
			}
		}
		
		return "formBuscaUsuario";
	}
	
	@GetMapping("/getCelular")
	public String getCelular(@RequestParam(value = "idCelular") String idCelular) {
		System.out.println(idCelular);
		
		return "formBuscaUsuario";
	}
}
