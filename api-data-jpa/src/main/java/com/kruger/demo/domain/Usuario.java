package com.kruger.demo.domain;

//import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
//import java.util.Objects;
import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotNull;

import lombok.Data;

//@Data
@Entity //
public class Usuario {
	
	@NotNull //para controlar que el campo no sea nulo.
	 @Id
	 @GeneratedValue(generator = "system-uuid")
	 @GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;
	
	@NotNull
	@NotBlank
	private String description;
	
	@Column(insertable = true, updatable = false)
	private LocalDateTime created;
	private LocalDateTime modified;
	
	private boolean completed;
	
	//constructor
	//sin parametros y automaticamente generado el id
	public Usuario() {
		LocalDateTime date = LocalDateTime.now();
		this.id = UUID.randomUUID().toString(); //creando un id especifico aleatorio al objeto creado
		this.created= date;
		this.modified= date;
	}
	//con description para no generar un id nuevo
	public Usuario(String description) {
		this();
		this.description=description;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public LocalDateTime getModified() {
		return modified;
	}

	public void setModified(LocalDateTime modified) {
		this.modified = modified;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", description=" + description + ", created=" + created + ", modified=" + modified
				+ ", completed=" + completed + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(completed, created, description, id, modified);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return completed == other.completed && Objects.equals(created, other.created)
				&& Objects.equals(description, other.description) && Objects.equals(id, other.id)
				&& Objects.equals(modified, other.modified);
	}

	
	
	
	

}
