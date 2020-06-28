package com.formacionbdi.microservicios.app.producto.controller;

import java.util.HashMap;
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

import com.formacionbdi.microservicios.app.producto.entity.Producto;
import com.formacionbdi.microservicios.app.producto.services.ProductoService;

@RestController
public class ProductoController {

	@Autowired
	private ProductoService service;

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
		Optional<Producto> o = service.findById(id);
		if (o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(o.get());
	}

	@PostMapping
	public ResponseEntity<?> crear(@Valid @RequestBody Producto entity, BindingResult result) {

		if (result.hasErrors()) {
			return this.validar(result);
		}
		Producto entityDb = service.save(entity);
		return ResponseEntity.status(HttpStatus.CREATED).body(entityDb);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id) {
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@Valid @RequestBody Producto entity, BindingResult result, @PathVariable Long id) {

		if (result.hasErrors()) {
			return this.validar(result);
		}

		Optional<Producto> optionalProductoDB = service.findById(id);

		if (optionalProductoDB.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		Producto productoDB = optionalProductoDB.get();
		productoDB.setNombre(entity.getNombre());
		productoDB.setPrecio(entity.getPrecio());

		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(productoDB));
	}

	protected ResponseEntity<?> validar(BindingResult result) {
		Map<String, Object> errores = new HashMap<>();
		result.getFieldErrors().forEach(err -> {
			errores.put(err.getField(), " El campo " + err.getField() + " " + err.getDefaultMessage());
		});
		return ResponseEntity.badRequest().body(errores);
	}

}
