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


import pe.edu.upc.spring.service.IConsultorioService;
import pe.edu.upc.spring.entity.Consultorio;


@Controller
@RequestMapping("/consultorio")

public class ConsultorioController {

	@Autowired
	private IConsultorioService cService; 
	
	
	@RequestMapping("/irRegistrar")
	public String irRegistrar(Model model) {
		model.addAttribute("Consultorio", new Consultorio());
		return "Consultorio";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute @Valid Consultorio objConsultorio, BindingResult binRes, Model  model) throws ParseException{ 
		if(binRes.hasErrors()) {
			
			return "Consultorio";
		}
		else {
			boolean flag=cService.insertar(objConsultorio);
			if(flag) {
				return "redirect:/consultorio/listar";
			}
			else {
				model.addAttribute("mensaje","Ocurrió un error");
				return "redirect:/consultorio/irRegistrar";
			}
		}
	
	}
	
	@RequestMapping("/actualizar")
	public String actualizar(@ModelAttribute @Valid Consultorio objConsultorio, BindingResult binRes, Model  model, RedirectAttributes objRedir)
	throws ParseException{
		if(binRes.hasErrors()) {
			return "redirect:/Consultorio/listar";
		}
		else {
			boolean flag=cService.modificar(objConsultorio);
			if(flag) {
				objRedir.addFlashAttribute("mensaje","Se actualizó correctamente");
				return "redirect:/consultorio/listar";
			}
			else {
				objRedir.addFlashAttribute("mensaje", "ocurrió un error");
				return "redirect:/consultorio/listar";
			}
			
		}
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) {
		Consultorio objConsultorio=cService.listarId(id);
		 if(objConsultorio==null) {
			 objRedir.addFlashAttribute("mensaje", "ocurrió un error");
			 return "redirect:/consultorio/listar";
		 }
		 else {
			
			 model.addAttribute("consultorio", objConsultorio);
			 return "consultorio";
		 }
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id")Integer id) {
	
			if(id !=null && id>0) {
				cService.eliminar(id);
				model.put("listaConsultorios", cService.listar());
			}
		 
	
		return "listConsultorios";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaConsultorios", cService.listar()); // size());
		return "listConsultorios";
	}
	
	@RequestMapping("/listarId")
	public String listarId(Map<String, Object> model, @ModelAttribute Consultorio consultorio) {
		cService.listarId(consultorio.getIdConsultorio());
		return "listConsultorios";
	}
	
	
}
