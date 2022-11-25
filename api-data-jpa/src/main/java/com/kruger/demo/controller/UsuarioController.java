package com.kruger.demo.controller;

import java.net.URI;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.kruger.demo.domain.Usuario;
import com.kruger.demo.domain.UsuarioBuilder;
import com.kruger.demo.domain.repository.UsuarioRepository;
import com.kruger.demo.validation.UsuarioValidationError;
import com.kruger.demo.validation.UsuarioValidationErrorBuilder;

@RestController
@RequestMapping("/api")
public class UsuarioController {
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	public UsuarioController(UsuarioRepository usuarioRepository) {
		this.usuarioRepository= usuarioRepository;
	}
	
	//buscar todos
		@GetMapping("/usuarios")
		public ResponseEntity<Iterable<Usuario>> getTodosUsuarios() {
			return ResponseEntity.ok(usuarioRepository.findAll());
		}
		
		//get find por Id
		@GetMapping("/usuarios/{id}") 
		public ResponseEntity<Optional<Usuario>> getUsuarioById(@PathVariable String id){
			return ResponseEntity.ok(usuarioRepository.findById(id));
		}
		
		// guardar o actualizar
		//body del pagina web 
		//@PatchMapping("/usuarios/{id}")
		
		//guardar
		@RequestMapping(value="/usuarios", method = {RequestMethod.POST, RequestMethod.PUT})
		public ResponseEntity<?> createUsuario(@jakarta.validation.Valid @RequestBody Usuario usuario, Errors errors){
			if (errors.hasErrors()) {
				
				return ResponseEntity.badRequest().body((UsuarioValidationErrorBuilder.fromBindingError(errors)));
			}
			Usuario result = usuarioRepository.save(usuario); //guardar
			URI location = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
					.buildAndExpand(result.getId()).toUri();
			return ResponseEntity.created(location).body(result); //objeto json 
			
		}
		
		//borrar por id
		@DeleteMapping("/usuarios/{id}")
		public ResponseEntity<Usuario> deleteUsuario(@PathVariable String id){
			usuarioRepository.delete(UsuarioBuilder.create().withId(id).build());
			return ResponseEntity.noContent().build();
		}
		//borrar todo
		@DeleteMapping("/usuarios")
		public ResponseEntity<Usuario> deleteUsuario(@RequestBody Usuario usuario){
			usuarioRepository.delete(usuario);
			return ResponseEntity.noContent().build();
		}
		
		
		//manejo de errores
		@ExceptionHandler
		@ResponseStatus(value =HttpStatus.BAD_REQUEST)
		public UsuarioValidationError handleException(Exception exception) {
			return new UsuarioValidationError(exception.getMessage());
		}

}
