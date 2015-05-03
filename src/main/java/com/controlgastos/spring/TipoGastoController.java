package com.controlgastos.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.controlgastos.spring.model.TipoGasto;
import com.controlgastos.spring.model.TipoIngreso;
import com.controlgastos.spring.service.TipoGastoService;

@Controller
public class TipoGastoController {
	
	private TipoGastoService tipoGastoService;
	
	@Autowired(required=true)
	@Qualifier(value="tipoGastoService")
	public void setTipoGastoService(TipoGastoService ts){
		this.tipoGastoService = ts;
	}
	
	@RequestMapping(value = "/tipogasto", method = RequestMethod.GET)
	public String listTipoGasto(Model model) {
		model.addAttribute("tipoGasto", new TipoGasto());
		model.addAttribute("listTipoGasto", this.tipoGastoService.listTipoGasto());
		return "tipogasto";
	}
	
	@RequestMapping(value = "/listargasto", method = RequestMethod.GET)
	public String listTipoGastoPlantilla(Model model) {
		model.addAttribute("tipoGasto", new TipoGasto());
		model.addAttribute("listTipoGasto", this.tipoGastoService.listTipoGasto());
		return "listargastos";
	}
	
	//For add and update person both
	@RequestMapping(value= "/tipogasto/add", method = RequestMethod.POST)
	public String addTipoGastos(@ModelAttribute("tipoGasto") TipoGasto t){
		
		if(t.getId() == 0){
			//new person, add it
			this.tipoGastoService.addTipoGasto(t);
		}else{
			//existing person, call update
			this.tipoGastoService.updateTipoGasto(t);
		}
		
		return "redirect:/tipogasto";
		
	}
	
	@RequestMapping("/removetipogasto/{id}")
    public String removeTipoGasto(@PathVariable("id") int id){
		
        this.tipoGastoService.removeTipoGasto(id);
        return "redirect:/tipogasto";
    }
 
    @RequestMapping("/edittipogasto/{id}")
    public String editTipoGasto(@PathVariable("id") int id, Model model){
        model.addAttribute("tipoGasto", this.tipoGastoService.getTipoGastoById(id));
        model.addAttribute("listTipoGasto", this.tipoGastoService.listTipoGasto());
        return "tipogasto";
    }
	
}
