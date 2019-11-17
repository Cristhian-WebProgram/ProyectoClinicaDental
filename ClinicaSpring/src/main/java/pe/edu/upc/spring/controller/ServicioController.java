package pe.edu.upc.spring.controller;

import java.util.Map;

import javax.validation.Valid;
import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;


import pe.edu.upc.spring.service.IServicioService;
import pe.edu.upc.spring.entity.Servicio;

@Controller
@RequestMapping("/servicio")

public class ServicioController {

	@Autowired
	private IServicioService cService; 
	
	
	@RequestMapping("/irRegistrar")
	public String irRegistrar(Model model) {
		model.addAttribute("servicio", new Servicio());
		return "servicio";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute @Valid Servicio objServicio, BindingResult binRes, Model  model) throws ParseException{ 
		if(binRes.hasErrors()) {
			
			return "servicio";
		}
		else {
			boolean flag=cService.insertar(objServicio);
			if(flag) {
				return "redirect:/servicio/listar";
			}
			else {
				model.addAttribute("mensaje","Ocurrió un error");
				return "redirect:/servicio/irRegistrar";
			}
		}
	
	}
	
	@RequestMapping("/actualizar")
	public String actualizar(@ModelAttribute @Valid Servicio objServicio, BindingResult binRes, Model  model, RedirectAttributes objRedir)
	throws ParseException{
		if(binRes.hasErrors()) {
			return "redirect:/servicio/listar";
		}
		else {
			boolean flag=cService.modificar(objServicio);
			if(flag) {
				objRedir.addFlashAttribute("mensaje","Se actualizó correctamente");
				return "redirect:/servicio/listar";
			}
			else {
				objRedir.addFlashAttribute("mensaje", "ocurrió un error");
				return "redirect:/servicio/listar";
			}
			
		}
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) {
		Servicio objServicio=cService.listarId(id);
		 if(objServicio==null) {
			 objRedir.addFlashAttribute("mensaje", "ocurrió un error");
			 return "redirect:/servicio/listar";
		 }
		 else {
			
			 model.addAttribute("servicio", objServicio);
			 return "servicio";
		 }
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id")Integer id) {
	
			if(id !=null && id>0) {
				cService.eliminar(id);
				model.put("listaServicios", cService.listar());
			}
		 
	
		return "listServicios";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaServicios", cService.listar()); // size());
		return "listServicios";
	}
	
	@RequestMapping("/listarId")
	public String listarId(Map<String, Object> model, @ModelAttribute Servicio servicio) {
		cService.listarId(servicio.getIdservicio());
		return "listServicios";
	}
	
}