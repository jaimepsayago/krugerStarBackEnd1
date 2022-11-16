package com.kruger.demo.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kruger.demo.model.Usuario;
import com.kruger.demo.service.IServicio;
import com.kruger.demo.service.MiServicio;
import com.kruger.demo.service.MiServicio2;

@org.springframework.stereotype.Controller //enviar los datos a una vista - object model 
@RequestMapping("/app/")
public class Controller {
	
	@GetMapping({"/index","/","/home"}) //mapeo de la ruta con el servicio 
	public String index(Model model) {
		model.addAttribute("titulo", "este es un atributo desde el controller");
		return "index"; //index hace refencia a la vista
		
	}
	
	@GetMapping("/perfil") //mapeo de la ruta con el servicio 
	public String perfil(Model model) {
		// capa de servicio es decir una capa de datos
		//objeto de base de datos listado, buscar o guardar 
		
		//objeto de tipo Usuario
		Usuario u = new Usuario(); //instanciando un objeto 
		u.setNombre("jaime");
		u.setApellido("sayago");
		u.setEmail("jaime@hotmail");
		
		//agregar al modelo
				model.addAttribute("usuario", u);
				model.addAttribute("titulo", u.getNombre());
		
		
		return "perfil"; //index hace refencia a la vista
		
	}
	
	
	@GetMapping("/lista") //mapeo de la ruta con el servicio 
	public String lista(Model model) {
		// capa de servicio es decir una capa de datos
		//objeto de base de datos listado, buscar o guardar 
		
		//objeto de tipo Usuario
	List<Usuario> ls = Arrays.asList(new Usuario("juan", "calle", "jc@hotmail.com"),
			new Usuario("pedro", "jimenez", "jc@hotmail.com"),
			new Usuario("pablo", "soto", "jc@hotmail.com"),
			new Usuario("juanita", "de la calle", "jc@hotmail.com"));
		//agregar al modelo
				model.addAttribute("usuario", ls);
				model.addAttribute("titulo", "lista de usuario");
		
		
		return "lista"; //index hace refencia a la vista
		
	}
	
	
	@Autowired
	@Qualifier("miservicio")
	private IServicio servicio;
	
	@GetMapping("/cdi") //mapeo de la ruta con el servicio 
	public String cdi(Model model) {
		model.addAttribute("objeto", servicio.operacion());
		return "cdi"; //index hace refencia a la vista
		
	}
	
	
	
	

}
