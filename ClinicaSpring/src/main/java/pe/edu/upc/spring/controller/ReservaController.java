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


import pe.edu.upc.spring.service.IReservaService;
import pe.edu.upc.spring.entity.Reserva;

@Controller
@RequestMapping("/reserva")

public class ReservaController {

	@Autowired
	private IReservaService cService; 
	
	
	@RequestMapping("/irRegistrar")
	public String irRegistrar(Model model) {
		model.addAttribute("Reserva", new Reserva());
		return "reserva";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute @Valid Reserva objReserva, BindingResult binRes, Model  model) throws ParseException{ 
		if(binRes.hasErrors()) {
			
			return "reserva";
		}
		else {
			boolean flag=cService.insertar(objReserva);
			if(flag) {
				return "redirect:/reserva/listar";
			}
			else {
				model.addAttribute("mensaje","Ocurrió un error");
				return "redirect:/reserva/irRegistrar";
			}
		}
	
	}
	
	@RequestMapping("/actualizar")
	public String actualizar(@ModelAttribute @Valid Reserva objReserva, BindingResult binRes, Model  model, RedirectAttributes objRedir)
	throws ParseException{
		if(binRes.hasErrors()) {
			return "redirect:/reserva/listar";
		}
		else {
			boolean flag=cService.modificar(objReserva);
			if(flag) {
				objRedir.addFlashAttribute("mensaje","Se actualizó correctamente");
				return "redirect:/reserva/listar";
			}
			else {
				objRedir.addFlashAttribute("mensaje", "ocurrió un error");
				return "redirect:/reserva/listar";
			}
			
		}
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) {
		Reserva objReserva=cService.listarId(id);
		 if(objReserva==null) {
			 objRedir.addFlashAttribute("mensaje", "ocurrió un error");
			 return "redirect:/reserva/listar";
		 }
		 else {
			
			 model.addAttribute("reserva", objReserva);
			 return "reserva";
		 }
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id")Integer id) {
	
			if(id !=null && id>0) {
				cService.eliminar(id);
				model.put("listaReservas", cService.listar());
			}
		 
	
		return "listReservas";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaReservas", cService.listar()); // size());
		return "listReservas";
	}
	
	@RequestMapping("/listarId")
	public String listarId(Map<String, Object> model, @ModelAttribute Reserva reserva) {
		cService.listarId(reserva.getIdReserva());
		return "listReservas";
	}
	
}
