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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import projetopoo.demo.entities.Categoria;
import projetopoo.demo.entities.Tarefa;
import projetopoo.demo.exceptions.DataBaseException;
import projetopoo.demo.exceptions.ResourceNotFoundException;
import projetopoo.demo.services.CategoriaService;

@RestController
@RequestMapping("/categorias")
@CrossOrigin(origins = "*")
public class CategoriaResource {

	@Autowired
	private CategoriaService categoriaService;

	@PostMapping
	public ResponseEntity<Categoria> insert(@RequestBody Categoria categoria) {
		try {
			categoria = categoriaService.insert(categoria);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(categoria.getId())
					.toUri();
			return ResponseEntity.created(uri).body(categoria);
		} catch (DataBaseException e) {
			return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
		}
	}

	@GetMapping
	public ResponseEntity<List<Categoria>> findAll() {
		try {
			List<Categoria> listCategoria = categoriaService.findAll();
			return ResponseEntity.status(HttpStatus.OK).body(listCategoria);
		} catch (DataBaseException e) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
	}
	
	@GetMapping(value = "/{id}/tarefas")
	public ResponseEntity<List<Tarefa>> findTarefaByCategoria(@PathVariable Long id) {
		try {
			List<Tarefa> listTarefas = categoriaService.findTarefasByCategoria(id);
			return ResponseEntity.status(HttpStatus.OK).body(listTarefas);
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Categoria> findById(@PathVariable Long id) {
		try {
			Categoria categoria = categoriaService.findById(id);
			return ResponseEntity.status(HttpStatus.OK).body(categoria);
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		try {
			categoriaService.deleteById(id);
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
}
