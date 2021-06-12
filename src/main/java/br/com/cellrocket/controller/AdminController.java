package br.com.cellrocket.controller;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import br.com.cellrocket.dao.CelularDao;
import br.com.cellrocket.dao.ConsertoCelularDao;
import br.com.cellrocket.dto.ListaConsertosDto;
import br.com.cellrocket.model.Celular;
import br.com.cellrocket.model.ConsertoCelular;

@Controller
@RequestMapping("/admin/")
public class AdminController {

	Logger log = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	private CelularDao celularDao;
	
	@Autowired
	private ConsertoCelularDao consertoCelularDao;
	
	@GetMapping("pedido")
	public String listarTodosOsConsertos(Model model) {
		List<ListaConsertosDto> retorno = new ArrayList<ListaConsertosDto>();
		
		List<Celular> celulares = celularDao.getAll();
		if(celulares != null && !celulares.isEmpty()) {
			for(Celular celular : celulares) {
				ListaConsertosDto obj = new ListaConsertosDto();
				obj.setMarca(celular.getMarca());
				obj.setModelo(celular.getModelo());
				
				List<ConsertoCelular> consertos = consertoCelularDao.buscarStatusConserto(celular.getIdCelular());
				for(ConsertoCelular conserto : consertos) {
					obj.setIdConserto(conserto.getIdConserto());
					obj.setDescricaoConserto(conserto.getDescricaoConserto());
					obj.setStatus(conserto.getStatus().getValor());
					obj.setDataEntrada(conserto.getDataEntrada());
					
					retorno.add(obj);
				}
			}
		}
		
		model.addAttribute("pedidos", retorno);
		
		return "listarTodosOsConsertos";
	}
	
	@GetMapping("pedido/{status}")
	public String consertoPorStatus(@PathVariable("status") String status, Model model) {
		List<ListaConsertosDto> retorno = new ArrayList<ListaConsertosDto>();
		
		List<ConsertoCelular> consertos = consertoCelularDao.buscarConsertosPeloStatus(status);
		if(consertos != null && !consertos.isEmpty()) {
			for(ConsertoCelular conserto : consertos) {
				ListaConsertosDto obj = new ListaConsertosDto();
				
				obj.setIdConserto(conserto.getIdConserto());
				obj.setDescricaoConserto(conserto.getDescricaoConserto());
				obj.setStatus(conserto.getStatus().getValor());
				obj.setDataEntrada(conserto.getDataEntrada());
				
				Celular celular = celularDao.buscarCelularPeloId(conserto.getIdCelular());
				obj.setMarca(celular.getMarca());
				obj.setModelo(celular.getModelo());
				
				retorno.add(obj);
			}
		}
		
		model.addAttribute("pedidos", retorno);
		
		return "listarTodosOsConsertos";
	}
	
	@GetMapping("/pedido/excluirPedido/{idConserto}")
	public String excluirPedido(@PathVariable("idConserto") Long idConserto, Model model) {
		log.info(idConserto.toString());
		ConsertoCelular obj = consertoCelularDao.buscarPeloId(idConserto);
		//consertoCelularDao.excluirConserto(idConserto);
		return "listarTodosOsConsertos";
	}
	
	@GetMapping("/pedido/editarPedido/{idConserto}")
	public String editarPedido(@PathVariable("idConserto") Long idConserto, Model model) {
		log.info(idConserto.toString());
		return "";
	}
}
