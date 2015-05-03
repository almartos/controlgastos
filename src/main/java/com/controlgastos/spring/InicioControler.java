package com.controlgastos.spring;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InicioControler {
	
	// Spring dispone del único servlet que hay, y se encargará de 
	// servir todas las peticiones http que se reciban hacia los 
	// controladores definidos según la url que se proporcione

	// En el web.xml hemos definido que se escucharán todas las peticiones
	// .htm, por lo que en este caso, este método se ejecutará al lanzar
	// la petición de /inicio.htm
	@RequestMapping("")
	public String inicio (Map model){
		// El atributo model (ha de llamarse así) permitirá almacenar información
		// que luego Spring, el solito se encargará de hacer que esté disponible
		// desde el jsp que se cargué al lanzar el return
		
		System.out.println("He llegado al método inicio");
		
		// Este return, debido a las definicones hechas en el fichero de spring,
		// hará que se busque y cargue un jsp llamado pagPrincipal
		return "pagPrincipal";
	}

}
