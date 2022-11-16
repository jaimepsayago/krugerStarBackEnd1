package com.kruger.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.kruger.demo.model.ItemFactura;
import com.kruger.demo.model.Producto;
import com.kruger.demo.service.IServicio;
import com.kruger.demo.service.MiServicio;

@Configuration
public class AppConfig {
	
	//trabajar componentes BEANs  
	//implementar beans como servicios
	//configuraciones de objetos por ejmplo agregar datos a una lista para utilzarla
	
	/*@Bean("miservicio")
	@Primary
	public IServicio registrarServicio() {
		return new MiServicio();
	}*/
	
	//item de la facutra y los productos
	@Bean("itemsFactura")
	public List<ItemFactura> registrarItems(){
		Producto producto1 = new Producto("Camara sony",100);
		Producto producto2 = new Producto("Bicicleta",200);
		
		ItemFactura linea1 = new ItemFactura(producto1, 2);
		ItemFactura linea2 = new ItemFactura(producto2, 4);
		
		return Arrays.asList(linea1, linea2);
	}
	
	//items de la factura
	//@Bean("itemsFacturaOficina")

}
