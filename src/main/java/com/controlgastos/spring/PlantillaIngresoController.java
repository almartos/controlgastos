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

import com.controlgastos.spring.model.PlantillaIngreso;
import com.controlgastos.spring.service.PlantillaIngresoService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class PlantillaIngresoController {
	
	private PlantillaIngresoService plantillaIngresoService;
	
	@Autowired(required=true)
	@Qualifier(value="plantillaIngresoService")
	public void setPlantillaIngresoService(PlantillaIngresoService ps){
		this.plantillaIngresoService = ps;
	}
	
	@RequestMapping(value = "/plantillaingreso", method = RequestMethod.GET)
	public String listPlantillaIngreso(Model model) {
		model.addAttribute("plantillaIngreso", new PlantillaIngreso());
		model.addAttribute("listPlantillaIngreso", this.plantillaIngresoService.listPlantillaIngreso());
		return "plantillaingreso";
	}
	
	//For add and update person both
	@RequestMapping(value= "/plantillaingreso/add", method = RequestMethod.POST)
	public String addPlantillaIngresos(@ModelAttribute("plantillaIngreso") PlantillaIngreso p){
		
		if(p.getId() == 0){
			//new person, add it
			this.plantillaIngresoService.addPlantillaIngreso(p);;
		}else{
			//existing person, call update
			this.plantillaIngresoService.updatePlantillaIngreso(p);
		}
		
		return "redirect:/plantillaingreso";
		
	}
	
	@RequestMapping("/removeplantillaingreso/{id}")
    public String removeTipoIngreso(@PathVariable("id") int id){
		
        this.plantillaIngresoService.removePlantillaIngreso(id);;
        return "redirect:/plantillaingreso";
    }
 
    @RequestMapping("/editplantillaingreso/{id}")
    public String editTipoIngreso(@PathVariable("id") int id, Model model){
        model.addAttribute("plantillaIngreso", this.plantillaIngresoService.getPlantillaIngresoById(id));
        model.addAttribute("listPlantillaIngreso", this.plantillaIngresoService.listPlantillaIngreso());
        return "plantillaingreso";
    }
    
    @RequestMapping(value="/grabarplantilla", method = RequestMethod.POST)
    public String grabarPlantillaIngreso(HttpServletRequest request, Model model) {

    	System.out.println("entra a grabar plantilla");
    	
    	PlantillaIngreso p = new PlantillaIngreso();
    	
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
    			p.setNombreIngreso(array.get(i));
        		this.plantillaIngresoService.addPlantillaIngreso(p);
    		}
    		
    		
    		
    	}
    	
		model.addAttribute("plantillaIngreso", new PlantillaIngreso());
		model.addAttribute("listPlantillaIngreso", this.plantillaIngresoService.listPlantillaIngreso());
    	
    	
    	
		return "plantillaingreso";
	}
	
}
