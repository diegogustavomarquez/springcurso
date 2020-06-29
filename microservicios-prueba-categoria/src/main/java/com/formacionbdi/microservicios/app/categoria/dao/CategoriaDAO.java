package com.formacionbdi.microservicios.app.categoria.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.springcurso.entitys.entity.Categoria;

public interface CategoriaDAO extends PagingAndSortingRepository<Categoria, Long> {

}
