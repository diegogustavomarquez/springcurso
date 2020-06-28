package com.formacionbdi.microservicios.app.producto.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.formacionbdi.microservicios.app.producto.entity.Producto;

public interface ProductoDAO extends PagingAndSortingRepository<Producto, Long> {

}
