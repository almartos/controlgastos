package com.controlgastos.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.controlgastos.spring.model.TipoIngreso;
import com.controlgastos.spring.service.TipoIngresoService;

@Controller
public class TipoIngresoController {
	
	private TipoIngresoService tipoIngresoService;
	
	@Autowired(required=true)
	@Qualifier(value="tipoIngresoService")
	public void setTipoIngresoService(TipoIngresoService ts){
		this.tipoIngresoService = ts;
	}
	
	@RequestMapping(value = "/tipoingreso", method = RequestMethod.GET)
	public String listTipoIngreso(Model model) {
		model.addAttribute("tipoIngreso", new TipoIngreso());
		model.addAttribute("listTipoIngreso", this.tipoIngresoService.listTipoIngreso());
		return "tipoingreso";
	}
	
	@RequestMapping(value = "/listaringreso", method = RequestMethod.GET)
	public String listTipoIngresoPlantilla(Model model) {
		model.addAttribute("tipoIngreso", new TipoIngreso());
		model.addAttribute("listTipoIngreso", this.tipoIngresoService.listTipoIngreso());
		return "listaringresos";
	}
	

	
	//For add and update person both
	@RequestMapping(value= "/tipoingreso/add", method = RequestMethod.POST)
	public String addTipoIngresos(@ModelAttribute("tipoIngreso") TipoIngreso t){
		
		if(t.getId() == 0){
			//new person, add it
			this.tipoIngresoService.addTipoIngreso(t);;
		}else{
			//existing person, call update
			this.tipoIngresoService.updateTipoIngreso(t);
		}
		
		return "redirect:/tipoingreso";
		
	}
	
	@RequestMapping("/removetipoingreso/{id}")
    public String removeTipoIngreso(@PathVariable("id") int id){
		
        this.tipoIngresoService.removeTipoIngreso(id);
        return "redirect:/tipoingreso";
    }
 
    @RequestMapping("/edittipoingreso/{id}")
    public String editTipoIngreso(@PathVariable("id") int id, Model model){
        model.addAttribute("tipoIngreso", this.tipoIngresoService.getTipoIngresoById(id));
        model.addAttribute("listTipoIngreso", this.tipoIngresoService.listTipoIngreso());
        return "tipoingreso";
    }
	
}
