package com.controlgastos.spring;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.controlgastos.spring.model.Gasto;
import com.controlgastos.spring.model.GastoGlobal;
import com.controlgastos.spring.model.HistoricoGasto;
import com.controlgastos.spring.model.HistoricoIngreso;
import com.controlgastos.spring.model.Ingreso;
import com.controlgastos.spring.model.IngresoGlobal;
import com.controlgastos.spring.model.Periodo;
import com.controlgastos.spring.service.GastoGlobalService;
import com.controlgastos.spring.service.GastoService;
import com.controlgastos.spring.service.HistoricoGastoService;
import com.controlgastos.spring.service.HistoricoIngresoService;
import com.controlgastos.spring.service.IngresoGlobalService;
import com.controlgastos.spring.service.IngresoService;
import com.controlgastos.spring.service.PeriodoService;
import com.controlgastos.spring.service.PlantillaGastoService;
import com.controlgastos.spring.service.PlantillaIngresoService;


@Controller
public class PeriodoController {
	
	private PeriodoService periodoService;
	private IngresoGlobalService ingresoGlobalService;
	private GastoGlobalService gastoGlobalService;
	private GastoService gastoService;
	private IngresoService ingresoService;
	private HistoricoIngresoService historicoIngresoService;
	private HistoricoGastoService historicoGastoService;
	private PlantillaIngresoService plantillaIngresoService;
	private PlantillaGastoService plantillaGastoService;
	

	@Autowired(required=true)
	@Qualifier(value="periodoService")
	public void setPeriodoService(PeriodoService ps){
		this.periodoService = ps;
	}
	
	@Autowired(required=true)
	@Qualifier(value="plantillaIngresoService")
	public void setPlantillaIngresoService(PlantillaIngresoService ps){
		this.plantillaIngresoService = ps;
	}
	
	@Autowired(required=true)
	@Qualifier(value="plantillaGastoService")
	public void setPlantillaGastoService(PlantillaGastoService ps){
		this.plantillaGastoService = ps;
	}
	
	@Autowired(required=true)
	@Qualifier(value="ingresoGlobalService")
	public void setIngresoGlobalService(IngresoGlobalService ps){
		this.ingresoGlobalService = ps;
	}
	
	@Autowired(required=true)
	@Qualifier(value="gastoGlobalService")
	public void setGastoGlobalService(GastoGlobalService ps){
		this.gastoGlobalService = ps;
	}
	
	@Autowired(required=true)
	@Qualifier(value="gastoService")
	public void setGastoService(GastoService ps){
		this.gastoService = ps;
	}
	
	@Autowired(required=true)
	@Qualifier(value="ingresoService")
	public void setIngresoService(IngresoService ps){
		this.ingresoService = ps;
	}
	
	@Autowired(required=true)
	@Qualifier(value="historicoIngresoService")
	public void setHistoricoIngresoService(HistoricoIngresoService ps){
		this.historicoIngresoService = ps;
	}
	
	@Autowired(required=true)
	@Qualifier(value="historicoGastoService")
	public void setHistoricoGastoService(HistoricoGastoService ps){
		this.historicoGastoService = ps;
	}
	
	
	
	
	@RequestMapping(value = "/altaperiodo", method = RequestMethod.GET)
	public String altaPeriodo(Model model) {
		model.addAttribute("listDistinctPlantillaIngreso", this.plantillaIngresoService.listDistinctPlantillaIngreso());
		model.addAttribute("listDistinctPlantillaGasto", this.plantillaGastoService.listDistinctPlantillaGasto());
		return "altaperiodo";
	}
	
	@RequestMapping(value = "/edicionperiodo", method = RequestMethod.GET)
	public String listPeriodo(Model model) {
		model.addAttribute("periodo", new Periodo());
		model.addAttribute("listPeriodo", this.periodoService.listPeriodo());
		return "edicionperiodo";
	}
	
	@RequestMapping(value="/grabarperiodo", method = RequestMethod.POST)
    public String grabarPlantillaIngreso(HttpServletRequest request, Model model) {

    	System.out.println("entra a grabar periodo");
    	
    	SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    	
    	
    	
    	Periodo per = new Periodo();
    	IngresoGlobal ingGlobal = new IngresoGlobal();
    	GastoGlobal gasGlobal = new GastoGlobal();
    	Ingreso ing = new Ingreso();
    	Gasto gas = new Gasto();
    	HistoricoGasto histGast = new HistoricoGasto();
    	HistoricoIngreso histIng = new HistoricoIngreso();
    	

    	
    	
    	try{
    	
    		per.setFechaIni(formato.parse(request.getParameter("fecha_inicio")));
    		per.setGastosPeriodo(0);
    		per.setIngresosPeriodo(0);
    		formato = new SimpleDateFormat("dd/MM/yyyy");
    		per.setFechaFin(formato.parse(request.getParameter("fecha_fin")));
    		if("true".equalsIgnoreCase(request.getParameter("ACTIVO"))){
    			per.setActivo(true);
    		}
    		else{
    			per.setActivo(false);
    		}
    		
    		this.periodoService.addPeriodo(per);
    		
    		
    		//ojo, hay que ver si llega el id
    		ingGlobal.setIdPeriodo(per.getId());
    		
    		ingGlobal.setTotalIngreso(Float.parseFloat(request.getParameter("total_ingreso")));
    		
    		this.ingresoGlobalService.addIngresoGlobal(ingGlobal);
    		
    		gasGlobal.setIdPeriodo(per.getId());
    		gasGlobal.setTotalGasto(Float.parseFloat(request.getParameter("total_gasto")));
    		
    		this.gastoGlobalService.addGastoGlobal(gasGlobal);
    		
    		//recuperar los ingresos y los gastos de las plantillas
    		
    		for(int i=0; i<plantillaIngresoService.listPlantillaIngresoByName(request.getParameter("plantillaIngreso")).size();i++){
    			ing = new Ingreso();
    			ing.setIdIngresoGlobal(ingGlobal.getId());
    			ing.setFijo(true);
    			ing.setNombreIngreso(plantillaIngresoService.listPlantillaIngresoByName(request.getParameter("plantillaIngreso")).get(i).getNombreIngreso().toString());
    			this.ingresoService.addIngreso(ing);
    			histIng = new HistoricoIngreso();
    			histIng.setIdIngreso(ing.getId());
    			histIng.setFechaIngreso(per.getFechaIni());
    			histIng.setConceptoIngreso("Inicializacion "+ing.getNombreIngreso());
    			histIng.setImporteIngreso(Float.parseFloat("0"));
    			this.historicoIngresoService.addHistoricoIngreso(histIng);
    			
    			
    		}
    		
    		for(int i=0; i<plantillaGastoService.listPlantillaGastoByName(request.getParameter("plantillaGasto")).size();i++){
    			gas = new Gasto();
    			gas.setIdGastoGlobal(gasGlobal.getId());
    			gas.setAcumuladoHistorico(0);
    			gas.setFijo(true);
    			gas.setNombreGasto(plantillaGastoService.listPlantillaGastoByName(request.getParameter("plantillaGasto")).get(i).getNombreGasto().toString());
    			this.gastoService.addGasto(gas);
    			histGast = new HistoricoGasto();
    			histGast.setIdGasto(gas.getId());
    			histGast.setFechaGasto(per.getFechaIni());
    			histGast.setConceptoGasto("Inicializacion "+gas.getNombreGasto());
    			histGast.setImporteGasto(Float.parseFloat("0"));
    			this.historicoGastoService.addHistoricoGasto(histGast);
    			
    		}
    		
    		//insertar tantos ingresos como haya en la plantilla
    		
    		
    		//insert tantos gastos como haya en la plantilla
    		
    		
    		
    	}
    	catch(Exception e){
    		e.printStackTrace();
    	}
    	
    	model.addAttribute("periodo", new Periodo());
		model.addAttribute("listPeriodo", this.periodoService.listPeriodo());
		return "redirect:/edicionperiodo";
	}
	
	@RequestMapping("/removeperiodo/{id}")
    public String removePeriodo(@PathVariable("id") int id){
		
        this.periodoService.removePeriodo(id);
        return "redirect:/edicionperiodo";
    }
 
    @RequestMapping("/editperiodo/{id}")
    public String editPeriodo(@PathVariable("id") int id, Model model){
        model.addAttribute("periodo", this.periodoService.getPeriodoById(id));
        model.addAttribute("listPeriodo", this.periodoService.listPeriodo());
        return "edicionperiodo";
    }
    
    @RequestMapping(value= "/periodo/add", method = RequestMethod.POST)
	public String addPeriodo(@ModelAttribute("periodo") Periodo p){
		
		if(p.getId() == 0){
			//new periodo, add it
			this.periodoService.addPeriodo(p);
		}else{
			//existing person, call update
			this.periodoService.updatePeriodo(p);
		}
		
		return "redirect:/edicionperiodo";
		
	}
    
    
    @RequestMapping(value= "/listaringresoasociadoperiodo/{id}", method = RequestMethod.GET)
	public String listarIngresoAsociadoPeriodo(@PathVariable("id") int id, Model model){
		
    	float totalIngreso=0;
		float totalPresupuestado=0;
		
		Periodo per = this.periodoService.getPeriodoById(id);
		
    	List<Ingreso> ingresoAux = this.ingresoService.listIngresoByIdIngGlobal(id);
    	
		
		for(int i =0; i<ingresoAux.size();i++){
			
			//para gastos fijos
			if(ingresoAux.get(i).getFijo() == true){
				totalIngreso+=ingresoAux.get(i).getImporteIngreso();
				totalPresupuestado+=ingresoAux.get(i).getImporteIngreso();
			}
			
			else{
				totalPresupuestado+=ingresoAux.get(i).getImporteIngreso();
				totalIngreso+=ingresoAux.get(i).getAcumuladoHistorico();
			}
			
		}
		
		per.setIngresosPeriodo(totalIngreso);
		
		this.periodoService.updatePeriodo(per);
		
		model.addAttribute("listIngreso",this.ingresoService.listIngresoByIdIngGlobal(id));
		model.addAttribute("totalIngresos",totalIngreso);
		model.addAttribute("totalPresupuestado",totalPresupuestado);
		
		return "listaringresosasociadosperiodo";

		
	}
    
    @RequestMapping(value= "/listargastoasociadoperiodo/{id}", method = RequestMethod.GET)
	public String listarGastoAsociadoPeriodo(@PathVariable("id") int id, Model model){
		
		float totalGasto=0;
		float totalPresupuestado=0;
		
		Periodo per = this.periodoService.getPeriodoById(id);
		
    	List<Gasto> gastoAux = this.gastoService.listGastoByIdGasGlobal(id);
    	
		
		for(int i =0; i<gastoAux.size();i++){
			
			//para gastos fijos
			if(gastoAux.get(i).getFijo() == true){
				totalGasto+=gastoAux.get(i).getImporteGasto();
				totalPresupuestado+=gastoAux.get(i).getImporteGasto();
			}
			
			else{
				totalPresupuestado+=gastoAux.get(i).getImporteGasto();
				totalGasto+=gastoAux.get(i).getAcumuladoHistorico();
			}
			
		}
		
		per.setGastosPeriodo(totalGasto);
		
		this.periodoService.updatePeriodo(per);
		
		model.addAttribute("listGasto",this.gastoService.listGastoByIdGasGlobal(id));
		model.addAttribute("totalGastos",totalGasto);
		model.addAttribute("totalPresupuestado",totalPresupuestado);
		
		return "listargastosasociadosperiodo";
		
	}
    
    @RequestMapping(value= "/editaringresoperiodo/{id}", method=RequestMethod.GET)
    public String editarIngresoPeriodo(@PathVariable("id") int id, Model model){
    	
    	
    	
    	model.addAttribute("ingreso",this.ingresoService.getIngresoById(id));
    	
    	return "edicioningresoperiodo";
    }
    
    @RequestMapping(value= "/editargastoperiodo/{id}", method=RequestMethod.GET)
    public String editarGastoPeriodo(@PathVariable("id") int id, Model model){
    	
    	model.addAttribute("gasto",this.gastoService.getGastoById(id));
    	return "ediciongastoperiodo";
    }
    
    @RequestMapping(value= "/editaringresoperiodo2", method=RequestMethod.POST)
    public String editarIngresoPeriodo2(@ModelAttribute("ingreso") Ingreso i){
    	
    	this.ingresoService.updateIngreso(i);
    	
    	return "redirect:/editaringresoperiodo/"+i.getId();
    }
    
    
    
    @RequestMapping(value= "/editargastoperiodo2", method=RequestMethod.POST)
    public String editarGastoPeriodo2(@ModelAttribute("gasto") Gasto g){
    	
    	this.gastoService.updateGasto(g);
    	
    	return "redirect:/editargastoperiodo/"+g.getId();
    }
    
    @RequestMapping(value= "/nuevogastoperiodo/{id}", method=RequestMethod.GET)
    public String nuevoGastoPeriodo(@PathVariable("id") int id, Model model){
    	
    	Gasto gasto = new Gasto();
    	
    	gasto.setIdGastoGlobal(id);
    	
    	this.gastoService.addGasto(gasto);
    	
    	
    	model.addAttribute("gasto",this.gastoService.getGastoById(gasto.getId()));
    	return "nuevogastoperiodo";
    }
    
    @RequestMapping(value= "/nuevoingresoperiodo/{id}", method=RequestMethod.GET)
    public String nuevoIngresoPeriodo(@PathVariable("id") int id, Model model){
    	
    	Ingreso ingreso = new Ingreso();
    	
    	ingreso.setIdIngresoGlobal(id);
    	
    	this.ingresoService.addIngreso(ingreso);
    	
    	
    	model.addAttribute("ingreso",this.ingresoService.getIngresoById(ingreso.getId()));
    	return "nuevoingresoperiodo";
    }
    
    
   
    
    @RequestMapping("/borraringresoperiodo/{id}")
    public String borrarIngresoPeriodo(@PathVariable("id") int id){
		
    	Ingreso aux = this.ingresoService.getIngresoById(id);
    	IngresoGlobal aux2= this.ingresoGlobalService.getIngresoGlobalById(aux.getIdIngresoGlobal());
    	
        this.ingresoService.removeIngreso(id);
        return "redirect:/listaringresoasociadoperiodo/"+aux2.getIdPeriodo();
    }
    
    @RequestMapping("/borrargastoperiodo/{id}")
    public String borrarGastoPeriodo(@PathVariable("id") int id){
		
    	Gasto aux = this.gastoService.getGastoById(id);
    	GastoGlobal aux2= this.gastoGlobalService.getGastoGlobalById(aux.getIdGastoGlobal());
    	
        this.gastoService.removeGasto(id);
        return "redirect:/listargastoasociadoperiodo/"+aux2.getIdPeriodo();
    }
    
    @RequestMapping("/listarapuntesasociadogasto/{id}")
    public String listarApunteAsociadoGasto(@PathVariable("id") int id, Model model){
    	
    	float totalGasto=0;
    	
    	List<HistoricoGasto> historicoGastoAux = this.historicoGastoService.listHistoricoGastoPorIdGasto(id);
    	
    	for(HistoricoGasto hg: historicoGastoAux){
    		totalGasto+=hg.getImporteGasto();
    	}
    	
    	model.addAttribute("historicoGasto", new HistoricoGasto());
    	model.addAttribute("totalGasto",totalGasto);
    	model.addAttribute("listApunteAsociadoGasto",this.historicoGastoService.listHistoricoGastoPorIdGasto(id));
    	model.addAttribute("importeGasto",this.gastoService.getGastoById(id).getImporteGasto());
    	model.addAttribute("nombreGasto",this.gastoService.getGastoById(id).getNombreGasto());
    	model.addAttribute("idGasto",this.gastoService.getGastoById(id).getId());
    	return "listarapuntesasociadogasto";
    }
    
    @RequestMapping("/listarapuntesasociadoingreso/{id}")
    public String listarApunteAsociadoIngreso(@PathVariable("id") int id, Model model){
    	
    	float totalIngreso=0;
    	
    	List<HistoricoIngreso> historicoIngresoAux = this.historicoIngresoService.listHistoricoIngresoPorIdIngreso(id);
    	
    	for(HistoricoIngreso hi: historicoIngresoAux){
    		totalIngreso+=hi.getImporteIngreso();
    	}
    	
    	model.addAttribute("historicoIngreso", new HistoricoIngreso());
    	model.addAttribute("listApunteAsociadoIngreso",this.historicoIngresoService.listHistoricoIngresoPorIdIngreso(id));
    	model.addAttribute("totalIngreso",totalIngreso);
    	model.addAttribute("importeIngreso",this.ingresoService.getIngresoById(id).getImporteIngreso());
    	model.addAttribute("nombreIngreso",this.ingresoService.getIngresoById(id).getNombreIngreso());
    	model.addAttribute("idIngreso",this.ingresoService.getIngresoById(id).getId());
    	return "listarapuntesasociadoingreso";
    }
    
    @RequestMapping(value="/nuevoapuntegasto",method = RequestMethod.POST)
    public String addApunteHistoricoGasto(HttpServletRequest request, Model model){
    	
    	    	
    	SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
  
    	HistoricoGasto histGast = new HistoricoGasto();
    	Gasto gasto = this.gastoService.getGastoById(Integer.parseInt(request.getParameter("idGasto")))	;
    	
    	
    	try{
    		
    		histGast.setFechaGasto(formato.parse(request.getParameter("fechaGasto")));
    		histGast.setConceptoGasto(request.getParameter("conceptoGasto"));
    		histGast.setImporteGasto(Float.parseFloat(request.getParameter("importeGasto")));
    		histGast.setIdGasto(Integer.parseInt(request.getParameter("idGasto")));
    		this.historicoGastoService.addHistoricoGasto(histGast);
    		gasto.setAcumuladoHistorico(Float.parseFloat(request.getParameter("acumuladoHistorico"))+Float.parseFloat(request.getParameter("importeGasto")));
    		this.gastoService.updateGasto(gasto);
    		
    	}
    	catch(Exception e){
    		e.printStackTrace();
    	}
    	    	
    	return "redirect:/listarapuntesasociadogasto/"+histGast.getIdGasto();
    }
    
    @RequestMapping(value="/nuevoapunteingreso",method = RequestMethod.POST)
    public String addApunteHistoricoIngreso(HttpServletRequest request, Model model){
    	
    	    	
    	SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
  
    	HistoricoIngreso histIng = new HistoricoIngreso();
    	Ingreso ingreso = this.ingresoService.getIngresoById(Integer.parseInt(request.getParameter("idIngreso")))	;
    	
    	
    	try{
    		
    		histIng.setFechaIngreso(formato.parse(request.getParameter("fechaIngreso")));
    		histIng.setConceptoIngreso(request.getParameter("conceptoIngreso"));
    		histIng.setImporteIngreso(Float.parseFloat(request.getParameter("importeIngreso")));
    		histIng.setIdIngreso(Integer.parseInt(request.getParameter("idIngreso")));
    		this.historicoIngresoService.addHistoricoIngreso(histIng);
    		ingreso.setAcumuladoHistorico(Float.parseFloat(request.getParameter("acumuladoHistorico"))+Float.parseFloat(request.getParameter("importeIngreso")));
    		this.ingresoService.updateIngreso(ingreso);
    		
    	}
    	catch(Exception e){
    		e.printStackTrace();
    	}
    	    	
    	return "redirect:/listarapuntesasociadoingreso/"+histIng.getIdIngreso();
    }
    
    @RequestMapping("/eliminarlineahistoricogasto/{id}")
    public String eliminarApunteHistoricoGasto(@PathVariable("id") int id){
    	
    	int aux = this.historicoGastoService.getHistoricoGastoById(id).getIdGasto();
    	
    	Gasto gasto =this.gastoService.getGastoById(aux);
    	
    	gasto.setAcumuladoHistorico(gasto.getAcumuladoHistorico() - this.historicoGastoService.getHistoricoGastoById(id).getImporteGasto());
    	this.gastoService.updateGasto(gasto);
    	
    	
    	this.historicoGastoService.removeHistoricoGasto(id);
    	
    	return "redirect:/listarapuntesasociadogasto/"+aux;
    }
	
    @RequestMapping("/eliminarlineahistoricoingreso/{id}")
    public String eliminarApunteHistoricoIngreso(@PathVariable("id") int id){
    	
    	int aux = this.historicoIngresoService.getHistoricoIngresoById(id).getIdIngreso();
    	
    	Ingreso ingreso =this.ingresoService.getIngresoById(aux);
    	
    	ingreso.setAcumuladoHistorico(ingreso.getAcumuladoHistorico() - this.historicoIngresoService.getHistoricoIngresoById(id).getImporteIngreso());
    	this.ingresoService.updateIngreso(ingreso);
    	
    	
    	this.historicoIngresoService.removeHistoricoIngreso(id);
    	
    	return "redirect:/listarapuntesasociadoingreso/"+aux;
    }
	
}
