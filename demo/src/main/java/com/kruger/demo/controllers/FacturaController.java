package com.kruger.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kruger.demo.model.Factura;

@Controller
@RequestMapping("/factura")
public class FacturaController {

	@Autowired
	private Factura factura;
	
	@GetMapping("/ver") //mapeo de la ruta con el servicio 
	public String index(Model model) {
		model.addAttribute("factura", factura);
		model.addAttribute("titulo", "ejemplo factura con inyeccion de dependencia");
		return "factura/ver"; //index hace refencia a la vista
		
	}
}
