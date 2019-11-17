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


import pe.edu.upc.spring.service.IHorarioMensualService;
import pe.edu.upc.spring.entity.HorarioMensual;

@Controller
@RequestMapping("/horarioMensual")

public class HorarioMensualController {

	@Autowired
	private IHorarioMensualService cService; 
	
	
	@RequestMapping("/irRegistrar")
	public String irRegistrar(Model model) {
		model.addAttribute("HorarioMensual", new HorarioMensual());
		return "HorarioMensual";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute @Valid HorarioMensual objHorarioMensual, BindingResult binRes, Model  model) throws ParseException{ 
		if(binRes.hasErrors()) {
			
			return "horarioMensual";
		}
		else {
			boolean flag=cService.insertar(objHorarioMensual);
			if(flag) {
				return "redirect:/HorarioMensual/listar";
			}
			else {
				model.addAttribute("mensaje","Ocurrió un error");
				return "redirect:/HorarioMensual/irRegistrar";
			}
		}
	
	}
	
	@RequestMapping("/actualizar")
	public String actualizar(@ModelAttribute @Valid HorarioMensual objHorarioMensual, BindingResult binRes, Model  model, RedirectAttributes objRedir)
	throws ParseException{
		if(binRes.hasErrors()) {
			return "redirect:/HorarioMensual/listar";
		}
		else {
			boolean flag=cService.modificar(objHorarioMensual);
			if(flag) {
				objRedir.addFlashAttribute("mensaje","Se actualizó correctamente");
				return "redirect:/HorarioMensual/listar";
			}
			else {
				objRedir.addFlashAttribute("mensaje", "ocurrió un error");
				return "redirect:/HorarioMensual/listar";
			}
			
		}
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) {
		HorarioMensual objHorarioMensual=cService.listarId(id);
		 if(objHorarioMensual==null) {
			 objRedir.addFlashAttribute("mensaje", "ocurrió un error");
			 return "redirect:/HorarioMensual/listar";
		 }
		 else {
			
			 model.addAttribute("HorarioMensual", objHorarioMensual);
			 return "HorarioMensual";
		 }
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id")Integer id) {
	
			if(id !=null && id>0) {
				cService.eliminar(id);
				model.put("listaHorarioMensuals", cService.listar());
			}
		 
	
		return "listHorarioMensuals";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaHorarioMensuals", cService.listar()); // size());
		return "listHorarioMensuals";
	}
	
	@RequestMapping("/listarId")
	public String listarId(Map<String, Object> model, @ModelAttribute HorarioMensual HorarioMensual) {
		cService.listarId(HorarioMensual.getIdHorarioMensual());
		return "listHorarioMensuals";
	}
	
}
