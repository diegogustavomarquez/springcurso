package com.formacionbdi.microservicios.app.producto.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.formacionbdi.microservicios.app.producto.dao.ProductoDAO;
import com.formacionbdi.microservicios.app.producto.entity.Producto;

@Service
public class ProductoServiceImpl implements ProductoService {
	
	@Autowired
	private ProductoDAO productoDAO;


	@Override
	public Iterable<Producto> findAll() {
		return productoDAO.findAll();
	}

	@Override
	public Producto save(Producto entity) {
		return productoDAO.save(entity);
	}

	@Override
	public void deleteById(Long id) {
		productoDAO.deleteById(id);	
	}

	@Override
	public Iterable<Producto> findAll(Pageable pageable) {
		return productoDAO.findAll(pageable);
	}

	@Override
	public Optional<Producto> findById(Long id) {
		return productoDAO.findById(id);
	}

}
