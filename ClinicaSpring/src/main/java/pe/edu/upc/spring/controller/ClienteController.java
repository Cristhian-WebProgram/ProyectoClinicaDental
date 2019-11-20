package pe.edu.upc.spring.controller;


import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;


import pe.edu.upc.spring.service.IClienteService;
import pe.edu.upc.spring.entity.Cliente;

@Controller
@RequestMapping("/cliente")

public class ClienteController {

	@Autowired
	private IClienteService cService; 
	
	
	@RequestMapping("/irRegistrar")
	public String irRegistrar(Model model) {
		model.addAttribute("cliente", new Cliente());
		return "cliente";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute @Valid Cliente objCliente, BindingResult binRes, Model  model) throws ParseException{ 
		if(binRes.hasErrors()) {
			
			return "cliente";
		}
		else {
			boolean flag=cService.insertar(objCliente);
			if(flag) {
				return "redirect:/cliente/listar";
			}
			else {
				model.addAttribute("mensaje","Ocurrió un error");
				return "redirect:/cliente/irRegistrar";
			}
		}
	
	}
	
	@RequestMapping("/actualizar")
	public String actualizar(@ModelAttribute @Valid Cliente objCliente, BindingResult binRes, Model  model, RedirectAttributes objRedir)
	throws ParseException{
		if(binRes.hasErrors()) {
			return "redirect:/cliente/listar";
		}
		else {
			boolean flag=cService.actualizar(objCliente);
			if(flag) {
				objRedir.addFlashAttribute("mensaje","Se actualizó correctamente");
				return "redirect:/cliente/listar";
			}
			else {
				objRedir.addFlashAttribute("mensaje", "ocurrió un error");
				return "redirect:/cliente/listar";
			}
			
		}
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) {
		Cliente objCliente=cService.listarId(id);
		 if(objCliente==null) {
			 objRedir.addFlashAttribute("mensaje", "ocurrió un error");
			 return "redirect:/cliente/listar";
		 }
		 else {
			
			 model.addAttribute("cliente", objCliente);
			 return "cliente";
		 }
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id")Integer id) {
	
			if(id !=null && id>0) {
				cService.eliminar(id);
				model.put("listaClientes", cService.listar());
			}
		 
	
		return "listClientes";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaClientes", cService.listar()); // size());
		return "listClientes";
	}
	
	@RequestMapping("/listarId")
	public String listarId(Map<String, Object> model, @ModelAttribute Cliente cliente) {
		cService.listarId(cliente.getDNI());
		return "listClientes";
	}
	@RequestMapping("/buscar")
	public String buscar(Map<String, Object> model, @ModelAttribute Cliente cliente) throws ParseException {

		List<Cliente> listaClientes;
		
		listaClientes = cService.findByNameCliente((cliente.getNombreCliente()));


		if (listaClientes.isEmpty())
		{

			model.put("mensaje", "No se encontro");
		}

		model.put("listaClientes", listaClientes);
		return "buscarCliente";

	}

	@RequestMapping("/irBuscar")
	public String irBuscar(Model model) {
		model.addAttribute("cliente", new Cliente());
		return "buscarCliente";
	}
	
	@GetMapping(value = "/list/{name}", produces = { "application/json" })
	public @ResponseBody List<Cliente> findByNameCliente(@PathVariable String name, Model model) {
		List<Cliente> clientes = null;
		try {
			clientes = cService.findByNameCliente(name);
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return clientes;
	}		
	
}
