package com.formacionbdi.microservicios.app.producto.services;

import java.util.Optional;

import org.springframework.data.domain.Pageable;

import com.formacionbdi.microservicios.app.producto.entity.Producto;

public interface ProductoService {
	
	public Producto save(Producto entity);
	
	public Iterable<Producto> findAll();

	public void deleteById(Long id);

	public Iterable<Producto> findAll(Pageable pageable);

	public Optional<Producto> findById(Long id);

}
