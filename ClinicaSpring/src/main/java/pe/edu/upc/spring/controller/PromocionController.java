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


import pe.edu.upc.spring.service.IPromocionService;
import pe.edu.upc.spring.entity.Promocion;

@Controller
@RequestMapping("/promocion")

public class PromocionController {

	@Autowired
	private IPromocionService cService; 
	
	@RequestMapping("/")
	public String irPromocion(Map<String, Object>model) {
		model.put("listaPromociones", cService.listar());
		return "listPromociones";
	}
	
	
	@RequestMapping("/irRegistrar")
	public String irRegistrar(Model model) {
		model.addAttribute("promocion", new Promocion());
		return "promocion";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute @Valid Promocion objPromocion, BindingResult binRes, Model  model) throws ParseException{ 
		if(binRes.hasErrors()) {
			
			return "promocion";
		}
		else {
			boolean flag=cService.insertar(objPromocion);
			if(flag) {
				return "redirect:/promocion/listar";
			}
			else {
				model.addAttribute("mensaje","Ocurrió un error");
				return "redirect:/promocion/irRegistrar";
			}
		}
	
	}
	
	@RequestMapping("/actualizar")
	public String actualizar(@ModelAttribute @Valid Promocion objPromocion, BindingResult binRes, Model  model, RedirectAttributes objRedir)
	throws ParseException{
		if(binRes.hasErrors()) {
			return "redirect:/promocion/listar";
		}
		else {
			boolean flag=cService.modificar(objPromocion);
			if(flag) {
				objRedir.addFlashAttribute("mensaje","Se actualizó correctamente");
				return "redirect:/promocion/listar";
			}
			else {
				objRedir.addFlashAttribute("mensaje", "ocurrió un error");
				return "redirect:/promocion/listar";
			}
			
		}
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) {
		Promocion objPromocion=cService.listarId(id);
		 if(objPromocion==null) {
			 objRedir.addFlashAttribute("mensaje", "ocurrió un error");
			 return "redirect:/promocion/listar";
		 }
		 else {
			
			 model.addAttribute("promocion", objPromocion);
			 return "promocion";
		 }
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id")Integer id) {
	
			if(id !=null && id>0) {
				cService.eliminar(id);
				model.put("listaPromociones", cService.listar());
			}
		 
	
		return "listPromocions";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaPromocions", cService.listar()); // size());
		return "listPromociones";
	}
	
	@RequestMapping("/listarId")
	public String listarId(Map<String, Object> model, @ModelAttribute Promocion promocion) {
		cService.listarId(promocion.getIdPromocion());
		return "listPromociones";
	}
	
}
