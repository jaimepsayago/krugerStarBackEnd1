package com.kruger.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  //agregar funcionalidad de servicios web de tipo rest
@RequestMapping ("/api/") //da la ruta inicial al servicio
public class Web {
	
	@GetMapping("/1") //servicio rest localhost:8080 + / + metodo
	public String welcome() {
		return "Hola Krugers estamos con BackEnd";
	}
	
	@GetMapping("/2")
	public String welcomehtml() {
		return "<h1> <font face='verdana'>Backend Kruger!!!</font></h1>";
	}
	
	

}
