package com.kruger.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kruger.demo.domain.Usuario;
import com.kruger.demo.repository.CommonRepository;

@RestController
@RequestMapping("/api")
public class UsuarioControllers {
	private CommonRepository<Usuario> repository;

	@Autowired
	public UsuarioControllers(CommonRepository<Usuario> repository) {
		this.repository=repository;
	}
	
	//buscar todos
	@GetMapping("/usuarios")
	public ResponseEntity<Iterable<Usuario>> getTodosUsuarios() {
		return ResponseEntity.ok(repository.findAll());
	}
}
