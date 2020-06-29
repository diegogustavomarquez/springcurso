package com.formacionbdi.microservicios.app.categoria.service;

import java.util.Optional;

import org.springframework.data.domain.Pageable;

import com.springcurso.entitys.entity.Categoria;

public interface CategoriaService {
	
public Categoria save(Categoria entity);
	
	public Iterable<Categoria> findAll();

	public void deleteById(Long id);

	public Iterable<Categoria> findAll(Pageable pageable);

	public Optional<Categoria> findById(Long id);

}
