package br.com.cellrocket.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import br.com.cellrocket.dao.CelularDao;
import br.com.cellrocket.dao.ConsertoCelularDao;
import br.com.cellrocket.dao.UsuarioDao;
import br.com.cellrocket.dto.BuscarStatusConsertoDto;
import br.com.cellrocket.model.Celular;
import br.com.cellrocket.model.ConsertoCelular;
import br.com.cellrocket.model.Usuario;

@Controller
@RequestMapping("cliente")
public class ClienteController {

	@Autowired
	private UsuarioDao usuarioDao;
	
	@Autowired
	private CelularDao celularDao;
	
	@Autowired
	private ConsertoCelularDao consertoCelularDao;
	
	@GetMapping("formBuscarStatusConserto")
	public String formBuscarStatusConserto() {
		return "formBuscarStatusConserto";
	}
	
	@GetMapping("buscarStatusConserto")
	public String buscarStatusConserto(@RequestParam(value = "cpf", required = true) String cpf, Model model) {
		var retorno = new BuscarStatusConsertoDto();
		System.out.println(cpf);
		
		Usuario usuario = usuarioDao.buscarUsuarioCpf(cpf);
		if (usuario != null) {
			retorno.setUsuario(usuario);
			
			List<Celular> celulares = celularDao.buscarCeluarIdUsuario(usuario.getIdUsuario());
			if(celulares != null && !celulares.isEmpty()) {
				for(Celular item : celulares) {
					retorno.getCelulares().add(item);
					
					List<ConsertoCelular> consertos = consertoCelularDao.buscarStatusConserto(item.getIdCelular());
					if(consertos != null && !consertos.isEmpty()) {
						retorno.setConsertosCelulares(consertos);
					}
				}
				
				model.addAttribute("listaConsertos", retorno);
			}
		}
		
		return "formBuscarStatusConserto";
	}
}
