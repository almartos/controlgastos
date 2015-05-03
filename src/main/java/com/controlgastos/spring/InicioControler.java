package com.controlgastos.spring;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InicioControler {
	
	// Spring dispone del �nico servlet que hay, y se encargar� de 
	// servir todas las peticiones http que se reciban hacia los 
	// controladores definidos seg�n la url que se proporcione

	// En el web.xml hemos definido que se escuchar�n todas las peticiones
	// .htm, por lo que en este caso, este m�todo se ejecutar� al lanzar
	// la petici�n de /inicio.htm
	@RequestMapping("")
	public String inicio (Map model){
		// El atributo model (ha de llamarse as�) permitir� almacenar informaci�n
		// que luego Spring, el solito se encargar� de hacer que est� disponible
		// desde el jsp que se cargu� al lanzar el return
		
		System.out.println("He llegado al m�todo inicio");
		
		// Este return, debido a las definicones hechas en el fichero de spring,
		// har� que se busque y cargue un jsp llamado pagPrincipal
		return "pagPrincipal";
	}

}
