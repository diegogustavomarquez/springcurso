package com.formacionbdi.microservicios.app.producto.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.springcurso.entitys.entity.Producto;

public interface ProductoDAO extends PagingAndSortingRepository<Producto, Long> {

}
