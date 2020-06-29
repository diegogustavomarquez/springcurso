package com.formacionbdi.microservicios.app.categoria.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.formacionbdi.microservicios.app.categoria.service.CategoriaService;
import com.springcurso.entitys.entity.Categoria;
import com.springcurso.entitys.entity.Producto;

@RestController
public class CategoriaController {

	@Autowired
	private CategoriaService service;

	@GetMapping
	public ResponseEntity<?> list() {
		return ResponseEntity.ok().body(service.findAll());
	}

	@GetMapping("/pagina")
	public ResponseEntity<?> listar(Pageable pageable) {
		return ResponseEntity.ok().body(service.findAll(pageable));
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> ver(@PathVariable Long id) {
		Optional<Categoria> o = service.findById(id);
		if (o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(o.get());
	}

	@PostMapping
	public ResponseEntity<?> crear(@Valid @RequestBody Categoria entity, BindingResult result) {

		if (result.hasErrors()) {
			return this.validar(result);
		}
		Categoria entityDb = service.save(entity);
		return ResponseEntity.status(HttpStatus.CREATED).body(entityDb);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id) {
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@Valid @RequestBody Categoria entity, BindingResult result, @PathVariable Long id) {

		if (result.hasErrors()) {
			return this.validar(result);
		}

		Optional<Categoria> optionalCategoriaDB = service.findById(id);

		if (optionalCategoriaDB.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		Categoria CategoriaDB = optionalCategoriaDB.get();
		CategoriaDB.setNombre(entity.getNombre());

		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(CategoriaDB));
	}
	
	@PutMapping("/asociar-productos/{id}")
	public ResponseEntity<?> asociarProducto(@Valid @RequestBody List<Producto> productos, BindingResult result, @PathVariable Long id) {

		if (result.hasErrors()) {
			return this.validar(result);
		}

		Optional<Categoria> optionalCategoriaDB = service.findById(id);

		if (optionalCategoriaDB.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		Categoria categoriaDB = optionalCategoriaDB.get();
		productos.forEach(p -> {
			categoriaDB.addProducto(p);
		});

		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(categoriaDB));
	}

	protected ResponseEntity<?> validar(BindingResult result) {
		Map<String, Object> errores = new HashMap<>();
		result.getFieldErrors().forEach(err -> {
			errores.put(err.getField(), " El campo " + err.getField() + " " + err.getDefaultMessage());
		});
		return ResponseEntity.badRequest().body(errores);
	}

}
