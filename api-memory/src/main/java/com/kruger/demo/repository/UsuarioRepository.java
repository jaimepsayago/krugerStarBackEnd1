package com.kruger.demo.repository;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.kruger.demo.domain.Usuario;
@Repository
public class UsuarioRepository implements CommonRepository<Usuario> {

	//map <key, valor)
	//key= numero
	//valor = datos o un objeto o una lista de objeto 
	private Map<String, Usuario> usuarios = new HashMap<>();
	
	
	@Override
	public Usuario save(Usuario domain) {
		Usuario result = usuarios.get(domain.getId());
		if(result!=null) {
			result.setModified(LocalDateTime.now());
			result.setDescription(domain.getDescription());
			result.setCompleted(domain.isCompleted());
			domain = result;
		}
		usuarios.put(domain.getId(), domain);
		return usuarios.get(domain.getId());
	}

	@Override
	public Iterable<Usuario> save(Collection<Usuario> domains) {
		domains.forEach(this::save);
		return findAll();
	}

	@Override
	public void delete(Usuario domain) {
		usuarios.remove(domain.getId());
		
	}

	@Override
	public Usuario findById(String id) {
		return usuarios.get(id);
	}
	
	//lambdas y streams en java 
	// collections map, arraylist, vector,
	//agregar un array list y visualizar en la api rest
	
	private List<Usuario> usuariosLista = new LinkedList<Usuario>(Arrays.asList(
			new Usuario("hola jaime"),
			new Usuario("este es un objeto"),
			new Usuario("desde spring boot")			
			));
	
	@Override
	public Iterable<Usuario> findAll() {
		
	//	return this.usuariosLista;
		
		return usuarios.entrySet()
				.stream()
					.sorted(entryComparator)
						.map(Map.Entry::getValue)
							.collect(Collectors.toList());
	}
	
	private Comparator<Map.Entry<String, Usuario>>  entryComparator =(
			Map.Entry<String, Usuario> o1,
			Map.Entry<String, Usuario> o2) ->{
				return o1.getValue().getCreated().compareTo(
							o2.getValue().getCreated());
			};
					


}
