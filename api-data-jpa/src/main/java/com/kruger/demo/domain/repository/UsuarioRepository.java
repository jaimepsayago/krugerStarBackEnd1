package com.kruger.demo.domain.repository;

import org.springframework.data.repository.CrudRepository;

import com.kruger.demo.domain.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, String> {
	
	
}
