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

import br.gov.sp.etecsebrae.dto.Condutor;
import br.gov.sp.etecsebrae.service.CondutorService;

@RestController
@RequestMapping({ "/condutor" })
public class CondutorController {
	@Autowired
	private CondutorService service;

	@GetMapping(path = { "", "/get-all", "/get_all", "/all" })
	public ResponseEntity<?> getAll() {
		try {
			List<Condutor> list = service.getAll();
			return ResponseEntity.ok(list);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}
	}

	@GetMapping(path = { "/{id}", "/get-id/{id}", "/get_id/{id}", "/id/{id}" })
	public ResponseEntity<?> getById(@PathVariable int id) {
		try {
			return ResponseEntity.ok(service.getById(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}
	}

	@GetMapping(path = { "/email/{email}", "/get-email/{email}", "/get_email/{email}" })
	public ResponseEntity<?> getByEmail(@PathVariable String email) {
		try {
			return ResponseEntity.ok(service.getByEmail(email));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}
	}

	@PostMapping(path = { "", "/add", "/create" }, consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> save(@RequestBody Condutor dto) {
		try {
			dto.setId(0);
			return ResponseEntity.ok(service.save(dto));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}
	}

	@PutMapping(path = { "", "/edit", "/update" }, consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> update(@RequestBody Condutor dto) {
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
			Condutor dto = service.getById(id);
			return ResponseEntity.ok(service.save(dto));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}
	}

	@DeleteMapping(path = { "", "/remove", "/delete" }, consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> delete(@RequestBody Condutor dto) {
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
			Condutor dto = service.getById(id);
			service.delete(dto);
			return ResponseEntity.status(HttpStatus.ACCEPTED).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}
	}
}
