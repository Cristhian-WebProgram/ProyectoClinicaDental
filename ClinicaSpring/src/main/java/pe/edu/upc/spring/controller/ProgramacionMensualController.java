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


import pe.edu.upc.spring.service.IProgramacionMensualService;
import pe.edu.upc.spring.entity.ProgramacionMensual;

@Controller
@RequestMapping("/programacionmensual")

public class ProgramacionMensualController {

	@Autowired
	private IProgramacionMensualService cService; 
	
	
	@RequestMapping("/irRegistrar")
	public String irRegistrar(Model model) {
		model.addAttribute("programacionmensual", new ProgramacionMensual());
		return "programacionmensual";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute @Valid ProgramacionMensual objProgramacionMensual, BindingResult binRes, Model  model) throws ParseException{ 
		if(binRes.hasErrors()) {
			
			return "programacionmensual";
		}
		else {
			boolean flag=cService.insertar(objProgramacionMensual);
			if(flag) {
				return "redirect:/programacionmensual/listar";
			}
			else {
				model.addAttribute("mensaje","Ocurrió un error");
				return "redirect:/programacionmensual/irRegistrar";
			}
		}
	
	}
	
	@RequestMapping("/actualizar")
	public String actualizar(@ModelAttribute @Valid ProgramacionMensual objProgramacionMensual, BindingResult binRes, Model  model, RedirectAttributes objRedir)
	throws ParseException{
		if(binRes.hasErrors()) {
			return "redirect:/programacionmensual/listar";
		}
		else {
			boolean flag=cService.modificar(objProgramacionMensual);
			if(flag) {
				objRedir.addFlashAttribute("mensaje","Se actualizó correctamente");
				return "redirect:/programacionmensual/listar";
			}
			else {
				objRedir.addFlashAttribute("mensaje", "ocurrió un error");
				return "redirect:/programacionmensual/listar";
			}
			
		}
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) {
		ProgramacionMensual objProgramacionMensual=cService.listarId(id);
		 if(objProgramacionMensual==null) {
			 objRedir.addFlashAttribute("mensaje", "ocurrió un error");
			 return "redirect:/ProgramacionMensual/listar";
		 }
		 else {
			
			 model.addAttribute("programacionmensual", objProgramacionMensual);
			 return "programacionmensual";
		 }
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id")Integer id) {
	
			if(id !=null && id>0) {
				cService.eliminar(id);
				model.put("listaProgramacionMensuals", cService.listar());
			}
		 
	
		return "listProgramacionMensuals";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaProgramacionMensuals", cService.listar()); // size());
		return "listProgramacionMensuals";
	}
	
	@RequestMapping("/listarId")
	public String listarId(Map<String, Object> model, @ModelAttribute ProgramacionMensual programacionmensual) {
		cService.listarId(programacionmensual.getIdProgramacionMensual());
		return "listProgramacionMensuals";
	}
	
}
