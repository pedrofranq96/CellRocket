package br.com.cellrocket.controller;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import br.com.cellrocket.dao.CelularDao;
import br.com.cellrocket.dao.ConsertoCelularDao;
import br.com.cellrocket.dao.UsuarioDao;
import br.com.cellrocket.dto.EditarPedidoDto;
import br.com.cellrocket.dto.ListaCelularesDto;
import br.com.cellrocket.dto.ListaConsertosDto;
import br.com.cellrocket.dto.UsuarioDto;
import br.com.cellrocket.enums.Status;
import br.com.cellrocket.model.Celular;
import br.com.cellrocket.model.ConsertoCelular;
import br.com.cellrocket.model.Usuario;

@Controller
@RequestMapping("/admin/")
public class AdminController {

	Logger log = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	private UsuarioDao usuarioDao;
	
	@Autowired
	private CelularDao celularDao;
	
	@Autowired
	private ConsertoCelularDao consertoCelularDao;
	
	@GetMapping("pedido")
	public String listarTodosOsConsertos(Model model) {
		List<ListaCelularesDto> retorno = new ArrayList<ListaCelularesDto>();
		
		List<Celular> celulares = celularDao.getAll();
		if(celulares != null && !celulares.isEmpty()) {
			for(Celular celular : celulares) {
				ListaCelularesDto objCelulares = new ListaCelularesDto();
				objCelulares.setMarca(celular.getMarca());
				objCelulares.setModelo(celular.getModelo());
				
				List<ConsertoCelular> consertos = consertoCelularDao.buscarStatusConserto(celular.getIdCelular());
				for(ConsertoCelular conserto : consertos) {
					ListaConsertosDto objConsertos = new ListaConsertosDto();
					objConsertos.setIdConserto(conserto.getIdConserto());
					objConsertos.setDescricaoConserto(conserto.getDescricaoConserto());
					objConsertos.setStatus(conserto.getStatus().getValor());
					objConsertos.setDataEntrada(conserto.getDataEntrada());
					
					objCelulares.getConsertos().add(objConsertos);
				}
				
				retorno.add(objCelulares);
			}
		}
		
		model.addAttribute("celulares", retorno);
		
		return "listarTodosOsConsertos";
	}
	
	@GetMapping("pedido/{status}")
	public String consertoPorStatus(@PathVariable("status") String status, Model model) {
		List<ListaCelularesDto> retorno = new ArrayList<ListaCelularesDto>();
		
		List<ConsertoCelular> consertos = consertoCelularDao.buscarConsertosPeloStatus(status);
		if(consertos != null && !consertos.isEmpty()) {
			for(ConsertoCelular conserto : consertos) {
				ListaConsertosDto objConsertos = new ListaConsertosDto();
				
				objConsertos.setIdConserto(conserto.getIdConserto());
				objConsertos.setDescricaoConserto(conserto.getDescricaoConserto());
				objConsertos.setStatus(conserto.getStatus().getValor());
				objConsertos.setDataEntrada(conserto.getDataEntrada());
				
				Celular celular = celularDao.buscarCelularPeloId(conserto.getIdCelular());
				ListaCelularesDto objCelulares = new ListaCelularesDto();
				objCelulares.setMarca(celular.getMarca());
				objCelulares.setModelo(celular.getModelo());
				objCelulares.getConsertos().add(objConsertos);
				
				retorno.add(objCelulares);
			}
		}
		
		model.addAttribute("celulares", retorno);
		
		return "listarTodosOsConsertos";
	}
	
	@GetMapping("pedido/excluirPedido/{idConserto}")
	public String excluirPedido(@PathVariable("idConserto") Long idConserto, Model model) {
		consertoCelularDao.excluirConserto(idConserto);
		return "listarTodosOsConsertos";
	}
	
	@RequestMapping(value = "/pedido/editarPedido", method = RequestMethod.GET)
	public ModelAndView editarPedido(Long id) {
		ConsertoCelular consertoCelular = consertoCelularDao.buscarPeloId(id);
		
		EditarPedidoDto obj = new EditarPedidoDto();
		obj.setIdConserto(consertoCelular.getIdConserto());
		obj.setStatus(consertoCelular.getStatus().getValor());
		obj.setDescricao(consertoCelular.getDescricaoConserto());
		
		return new ModelAndView("formEditarPedido", "obj", obj);
	}
	
	@RequestMapping(value = "/pedido/editarPedido", method = RequestMethod.POST)
	public String alterarPedido(@Valid @ModelAttribute("obj") EditarPedidoDto obj, BindingResult result, Model model) {
		ConsertoCelular consertoCelular = consertoCelularDao.buscarPeloId(obj.getIdConserto());
		consertoCelular.setDescricaoConserto(obj.getDescricao());
		consertoCelular.setStatus(Status.valueOf(obj.getStatus().toUpperCase()));
		
		consertoCelularDao.updatePedido(consertoCelular);
		
		return "redirect:/admin/pedido";
	}
	
	@RequestMapping(value = "/buscarUsuario", method = RequestMethod.GET)
	public ModelAndView buscarUsuario(String cpf) {
		UsuarioDto usuarioDto = new UsuarioDto();
		
		Usuario usuario = usuarioDao.buscarUsuarioCpf(cpf);
		if (usuario != null) {
			usuarioDto.setId(usuario.getId());
			usuarioDto.setNome(usuario.getNome());
			usuarioDto.setCpf(usuario.getCpf());
			usuarioDto.setEmail(usuario.getEmail());
			usuarioDto.setSenha(usuario.getSenha());
			
			List<Celular> celulares = celularDao.buscarCeluarIdUsuario(usuario.getId());
			if(celulares != null && !celulares.isEmpty()) {
				usuarioDto.setCelulares(celulares);
			}
		}
		
		return new ModelAndView("formCadastroUsuario", "usuarioDto", usuarioDto);
	}
}
