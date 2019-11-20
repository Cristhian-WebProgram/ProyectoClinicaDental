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


import pe.edu.upc.spring.service.IEspecialistaService;


import pe.edu.upc.spring.entity.Especialista;

@Controller
@RequestMapping("/especialista")

public class EspecialistaController {

	@Autowired
	private IEspecialistaService cService; 
	
	
	@RequestMapping("/irRegistrar")
	public String irRegistrar(Model model) {
		model.addAttribute("Especialista", new Especialista());
		return "Especialista";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute @Valid Especialista objEspecialista, BindingResult binRes, Model  model) throws ParseException{ 
		if(binRes.hasErrors()) {
			
			return "especialista";
		}
		else {
			boolean flag=cService.insertar(objEspecialista);
			if(flag) {
				return "redirect:/especialista/listar";
			}
			else {
				model.addAttribute("mensaje","Ocurrió un error");
				return "redirect:/especialista/irRegistrar";
			}
		}
	
	}
	
	@RequestMapping("/actualizar")
	public String actualizar(@ModelAttribute @Valid Especialista objEspecialista, BindingResult binRes, Model  model, RedirectAttributes objRedir)
	throws ParseException{
		if(binRes.hasErrors()) {
			return "redirect:/especialista/listar";
		}
		else {
			boolean flag=cService.modificar(objEspecialista);
			if(flag) {
				objRedir.addFlashAttribute("mensaje","Se actualizó correctamente");
				return "redirect:/especialista/listar";
			}
			else {
				objRedir.addFlashAttribute("mensaje", "ocurrió un error");
				return "redirect:/especialista/listar";
			}
			
		}
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) {
		Especialista objEspecialista=cService.listarId(id);
		 if(objEspecialista==null) {
			 objRedir.addFlashAttribute("mensaje", "ocurrió un error");
			 return "redirect:/especialista/listar";
		 }
		 else {
			
			 model.addAttribute("especialista", objEspecialista);
			 return "especialista";
		 }
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id")Integer id) {
	
			if(id !=null && id>0) {
				cService.eliminar(id);
				model.put("listaEspecialistas", cService.listar());
			}
		 
	
		return "listEspecialistas";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaEspecialistas", cService.listar()); // size());
		return "listEspecialistas";
	}
	
	@RequestMapping("/listarId")
	public String listarId(Map<String, Object> model, @ModelAttribute Especialista especialista) {
		cService.listarId(especialista.getIdEspecialista());
		return "listEspecialistas";
	}
	
	@RequestMapping("/buscar")
	public String buscar(Map<String, Object> model, @ModelAttribute Especialista especialista) throws ParseException {

		List<Especialista> listaEspecialistas;
		
		listaEspecialistas = cService.findByEspecialista((especialista.getNombreEspecialista()));


		if (listaEspecialistas.isEmpty())
		{

			model.put("mensaje", "No se encontro");
		}

		model.put("listaEspecialistas", listaEspecialistas);
		return "buscarEspecialista";

	}

	@RequestMapping("/irBuscar")
	public String irBuscar(Model model) {
		model.addAttribute("especialista", new Especialista());
		return "buscarEspecialista";
	}
	
	@GetMapping(value = "/list/{name}", produces = { "application/json" })
	public @ResponseBody List<Especialista> findByEspecialista(@PathVariable String name, Model model) {
		List<Especialista> especialistas = null;
		try {
			especialistas = cService.findByEspecialista(name);
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return especialistas;
	}	
}
