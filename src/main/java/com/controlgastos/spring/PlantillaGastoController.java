package com.controlgastos.spring;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.controlgastos.spring.model.PlantillaGasto;
import com.controlgastos.spring.service.PlantillaGastoService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class PlantillaGastoController {
	
	private PlantillaGastoService plantillaGastoService;
	
	@Autowired(required=true)
	@Qualifier(value="plantillaGastoService")
	public void setPlantillaGastoService(PlantillaGastoService ps){
		this.plantillaGastoService = ps;
	}
	
	@RequestMapping(value = "/plantillagasto", method = RequestMethod.GET)
	public String listPlantillaGasto(Model model) {
		model.addAttribute("plantillaGasto", new PlantillaGasto());
		model.addAttribute("listPlantillaGasto", this.plantillaGastoService.listPlantillaGasto());
		return "plantillagasto";
	}
	
	//For add and update person both
	@RequestMapping(value= "/plantillagasto/add", method = RequestMethod.POST)
	public String addPlantillaGastos(@ModelAttribute("plantillaGasto") PlantillaGasto p){
		
		if(p.getId() == 0){
			//new person, add it
			this.plantillaGastoService.addPlantillaGasto(p);;
		}else{
			//existing person, call update
			this.plantillaGastoService.updatePlantillaGasto(p);
		}
		
		return "redirect:/plantillagasto";
		
	}
	
	@RequestMapping("/removeplantillagasto/{id}")
    public String removeTipoGasto(@PathVariable("id") int id){
		
        this.plantillaGastoService.removePlantillaGasto(id);;
        return "redirect:/plantillagasto";
    }
 
    @RequestMapping("/editplantillagasto/{id}")
    public String editTipoGasto(@PathVariable("id") int id, Model model){
        model.addAttribute("plantillaGasto", this.plantillaGastoService.getPlantillaGastoById(id));
        model.addAttribute("listPlantillaGasto", this.plantillaGastoService.listPlantillaGasto());
        return "plantillagasto";
    }
    
    @RequestMapping(value="/grabarplantillagastos", method = RequestMethod.POST)
    public String grabarPlantillaGasto(HttpServletRequest request, Model model) {

    	System.out.println("entra a grabar plantilla");
    	
    	PlantillaGasto p = new PlantillaGasto();
    	
    	String nombrePlantilla=request.getParameter("nombre_plantilla");
    	    	
    	Enumeration enume = request.getParameterNames();
    	
    	ArrayList<String> array = new ArrayList<String>();
    	
    	while(enume.hasMoreElements()){
    		array.add(enume.nextElement().toString());
    	}
    	
    	for(int i=0; i<array.size();i++){
    		
    		if(!"nombre_plantilla".equalsIgnoreCase(array.get(i))){
    			p.setId(0);
        		p.setName(nombrePlantilla);
    			p.setNombreGasto(array.get(i));
        		this.plantillaGastoService.addPlantillaGasto(p);
    		}
    	}
    	
		model.addAttribute("plantillaGasto", new PlantillaGasto());
		model.addAttribute("listPlantillaGasto", this.plantillaGastoService.listPlantillaGasto());
    	
    	
    	
		return "plantillagasto";
	}
	
}
