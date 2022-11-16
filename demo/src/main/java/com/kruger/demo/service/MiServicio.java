package com.kruger.demo.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component("miservicio")
public class MiServicio implements IServicio {

	@Override
	public String operacion() {
		//operaciones de bddd, intregracion de servicios web 
		return "ejecutando algun proceso imporante...";
	}

	
	//metodos
	
}
