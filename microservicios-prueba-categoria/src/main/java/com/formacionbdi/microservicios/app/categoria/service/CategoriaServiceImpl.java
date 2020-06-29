package com.formacionbdi.microservicios.app.categoria.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.formacionbdi.microservicios.app.categoria.dao.CategoriaDAO;
import com.springcurso.entitys.entity.Categoria;

@Service
public class CategoriaServiceImpl implements CategoriaService {

	@Autowired
	private CategoriaDAO CategoriaDAO;


	@Override
	public Iterable<Categoria> findAll() {
		return CategoriaDAO.findAll();
	}

	@Override
	public Categoria save(Categoria entity) {
		return CategoriaDAO.save(entity);
	}

	@Override
	public void deleteById(Long id) {
		CategoriaDAO.deleteById(id);	
	}

	@Override
	public Iterable<Categoria> findAll(Pageable pageable) {
		return CategoriaDAO.findAll(pageable);
	}

	@Override
	public Optional<Categoria> findById(Long id) {
		return CategoriaDAO.findById(id);
	}

}
