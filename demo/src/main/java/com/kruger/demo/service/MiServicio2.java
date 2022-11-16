package com.kruger.demo.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("miservicio2")

public class MiServicio2 implements IServicio {

	@Override
	public String operacion() {
		//operaciones de bddd, intregracion de servicios web 
		return "ejecutando algun proceso imporante servicio2...";
	}

	
	//metodos
	
}