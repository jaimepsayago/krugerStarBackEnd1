package com.kruger.demo.repository;

import java.util.Collection;

public interface CommonRepository<T> {
	
	//metodos genericos para manejar informacion 
	
	public T save(T domain); //un objeto de tipo T
	public Iterable<T> save(Collection<T> domains); //lista de objetos tipo T 
	public void delete(T domain);
	public T findById(String id);
	public Iterable<T> findAll();
	
	
	
	
}
