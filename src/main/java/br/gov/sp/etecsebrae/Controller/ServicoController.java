package br.gov.sp.etecsebrae.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.etecsebrae.dto.Servico;
import br.gov.sp.etecsebrae.service.ServicoService;

@RestController
@RequestMapping({ "/servico" })
public class ServicoController {
	@Autowired
	private ServicoService service;

	@GetMapping(path = { "", "/get-all", "/all" })
	public ResponseEntity<?> getAll() {
		try {
			List<Servico> list = service.getAll();
			return ResponseEntity.ok(list);
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping(path = { "/{id}", "/get-id/{id}", "/id/{id}" })
	public ResponseEntity<?> getById(@PathVariable int id) {
		try {
			return ResponseEntity.ok(service.getById(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}
	}

	@PostMapping(path = { "", "/add", "/create" }, consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> save(@RequestBody Servico dto) {
		try {
			dto.setId(0);
			return ResponseEntity.ok(service.save(dto));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}
	}

	@PutMapping(path = { "", "/edit", "/update" }, consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> update(@RequestBody Servico dto) {
		try {
			service.getById(dto.getId());
			return ResponseEntity.ok(service.save(dto));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}
	}

	@PutMapping(path = { "/{id}", "/edit/{id}", "/update/{id}" })
	public ResponseEntity<?> updateById(@PathVariable int id) {
		try {
			Servico dto = service.getById(id);
			return ResponseEntity.ok(service.save(dto));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}
	}

	@DeleteMapping(path = { "", "/remove", "/delete" }, consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> delete(@RequestBody Servico dto) {
		try {
			service.delete(dto);
			return ResponseEntity.status(HttpStatus.ACCEPTED).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}
	}

	@DeleteMapping(path = { "/{id}", "/remove/{id}", "/delete/{id}" })
	public ResponseEntity<?> deleteById(@PathVariable int id) {
		try {
			Servico dto = service.getById(id);
			service.delete(dto);
			return ResponseEntity.status(HttpStatus.ACCEPTED).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}
	}
}
