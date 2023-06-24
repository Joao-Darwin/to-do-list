package projetopoo.demo.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import projetopoo.demo.entities.Lembrete;
import projetopoo.demo.exceptions.DataBaseException;
import projetopoo.demo.exceptions.ResourceNotFoundException;
import projetopoo.demo.services.LembreteService;

@RestController
@RequestMapping("/lembretes")
@CrossOrigin(origins = "*")
public class LembreteResource {

	@Autowired
	private LembreteService lembreteService;

	@PostMapping
	public ResponseEntity<Lembrete> insert(@RequestBody Lembrete lembrete) {
		try {
			lembrete = lembreteService.insert(lembrete);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(lembrete.getId())
					.toUri();
			return ResponseEntity.created(uri).body(lembrete);
		} catch (DataBaseException e) {
			return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
		}
	}

	@GetMapping
	public ResponseEntity<List<Lembrete>> findAll() {
		try {
			List<Lembrete> listLembrete = lembreteService.findAll();
			return ResponseEntity.status(HttpStatus.OK).body(listLembrete);
		} catch (DataBaseException e) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Lembrete> findById(@PathVariable Long id) {
		try {
			Lembrete lembrete = lembreteService.findById(id);
			return ResponseEntity.status(HttpStatus.OK).body(lembrete);
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		try {
			lembreteService.deleteById(id);
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Lembrete> updateLembrete(@PathVariable Long id, @RequestBody Lembrete lembrete) {
		try {
			lembrete = lembreteService.updateLembrete(lembrete, id);
			return ResponseEntity.status(HttpStatus.OK).body(lembrete);
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		} catch (DataBaseException e) {
			return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
		}
	}
}
