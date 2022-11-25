package com.kruger.demo.domain;

public class UsuarioBuilder {
	//DTO
	public static UsuarioBuilder instance = new UsuarioBuilder();
	private String id=null;
	private String description="";
	
	private UsuarioBuilder() {
		
	}
	
	//3metodos
	public static UsuarioBuilder create() {
		return instance;
	}
	
	public UsuarioBuilder withDescription(String description) {
		this.description=description;
		return instance;
	}
	
	public UsuarioBuilder withId(String id) {
		this.id=id;
		return instance;
	}
	
	public Usuario build() {
		Usuario result = new Usuario(this.description);
		if(id != null)
			result.setId(id);
		return result;
	}
	
	
}
