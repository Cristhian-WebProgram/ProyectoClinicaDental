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


import pe.edu.upc.spring.service.IHistorialClinicoService;
import pe.edu.upc.spring.entity.HistorialClinico;

@Controller
@RequestMapping("/historialClinico")

public class HistorialClinicoController {

	@Autowired
	private IHistorialClinicoService cService; 
	
	
	@RequestMapping("/irRegistrar")
	public String irRegistrar(Model model) {
		model.addAttribute("historialClinico", new HistorialClinico());
		return "historialClinico";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute @Valid HistorialClinico objHistorialClinico, BindingResult binRes, Model  model) throws ParseException{ 
		if(binRes.hasErrors()) {
			
			return "historialClinico";
		}
		else {
			boolean flag=cService.insertar(objHistorialClinico);
			if(flag) {
				return "redirect:/historialClinico/listar";
			}
			else {
				model.addAttribute("mensaje","Ocurrió un error");
				return "redirect:/historialClinico/irRegistrar";
			}
		}
	
	}
	
	@RequestMapping("/actualizar")
	public String actualizar(@ModelAttribute @Valid HistorialClinico objHistorialClinico, BindingResult binRes, Model  model, RedirectAttributes objRedir)
	throws ParseException{
		if(binRes.hasErrors()) {
			return "redirect:/historialClinico/listar";
		}
		else {
			boolean flag=cService.modificar(objHistorialClinico);
			if(flag) {
				objRedir.addFlashAttribute("mensaje","Se actualizó correctamente");
				return "redirect:/historialClinico/listar";
			}
			else {
				objRedir.addFlashAttribute("mensaje", "ocurrió un error");
				return "redirect:/historialClinico/listar";
			}
			
		}
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) {
		HistorialClinico objHistorialClinico=cService.listarId(id);
		 if(objHistorialClinico==null) {
			 objRedir.addFlashAttribute("mensaje", "ocurrió un error");
			 return "redirect:/historialClinico/listar";
		 }
		 else {
			
			 model.addAttribute("historialClinico", objHistorialClinico);
			 return "historialClinico";
		 }
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id")Integer id) {
	
			if(id !=null && id>0) {
				cService.eliminar(id);
				model.put("listaHistorialClinicos", cService.listar());
			}
		 
	
		return "listHistorialClinicos";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaHistorialClinicos", cService.listar()); // size());
		return "listHistorialClinicos";
	}
	
	@RequestMapping("/listarId")
	public String listarId(Map<String, Object> model, @ModelAttribute HistorialClinico historialClinico) {
		cService.listarId(historialClinico.getIdHistorialClinico());
		return "listHistorialClinicos";
	}
	
}
