package com.kruger.demo.repository;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Usuario domain) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Usuario findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	//lambdas y streams en java 
	// collections map, arraylist, vector, 
	@Override
	public Iterable<Usuario> findAll() {
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
