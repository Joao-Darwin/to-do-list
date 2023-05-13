package projetopoo.demo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import projetopoo.demo.entities.TagTarefa;
import projetopoo.demo.exceptions.DataBaseException;
import projetopoo.demo.exceptions.ResourceNotFoundByNameException;
import projetopoo.demo.exceptions.ResourceNotFoundException;
import projetopoo.demo.services.TagService;

@RestController
@RequestMapping("/tag")
public class TagResource {
	
	@Autowired
	private TagService tagService;
	
	@GetMapping
	public ResponseEntity<List<TagTarefa>> findAll() {
		try {
			List<TagTarefa> listTag = tagService.findAll();
			return ResponseEntity.status(HttpStatus.OK).body(listTag);
		} catch (DataBaseException e) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<TagTarefa> findById(@PathVariable Long id) {
		try {
			TagTarefa tag = tagService.findById(id);
			return ResponseEntity.status(HttpStatus.OK).body(tag);
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@GetMapping(value = "/nome")
	public ResponseEntity<TagTarefa> findByNome(@RequestParam(name = "nome") String nome) {
		try {
			TagTarefa tag = tagService.findByNome(nome);
			return ResponseEntity.status(HttpStatus.OK).body(tag);
		} catch (ResourceNotFoundByNameException e) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
	}
	
	@PostMapping
	public ResponseEntity<TagTarefa> insert(@RequestBody TagTarefa tag) {
		try {
			tag = tagService.insertTag(tag);
			return ResponseEntity.status(HttpStatus.OK).body(tag);
		} catch (DataBaseException e) {
			return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
		}
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		try {
			tagService.deleteById(id);
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
}
