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

import projetopoo.demo.entities.Tarefa;
import projetopoo.demo.exceptions.DataBaseException;
import projetopoo.demo.exceptions.ResourceNotFoundException;
import projetopoo.demo.services.TarefaService;

@RestController
@RequestMapping("/tarefas")
@CrossOrigin(origins = "http://localhost:3000")
public class TarefaResource {

	@Autowired
	private TarefaService tarefaService;

	@PostMapping
	public ResponseEntity<Tarefa> insert(@RequestBody Tarefa tarefa) {
		try {
			tarefa = tarefaService.insert(tarefa);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(tarefa.getId())
					.toUri();
			return ResponseEntity.created(uri).body(tarefa);
		} catch (DataBaseException e) {
			return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
		}
	}

	@GetMapping
	public ResponseEntity<List<Tarefa>> findAll() {
		try {
			List<Tarefa> listTarefa = tarefaService.findAll();
			return ResponseEntity.status(HttpStatus.OK).body(listTarefa);
		} catch (DataBaseException e) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Tarefa> findById(@PathVariable Long id) {
		try {
			Tarefa tarefa = tarefaService.findById(id);
			return ResponseEntity.status(HttpStatus.OK).body(tarefa);
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		try {
			tarefaService.deleteById(id);
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Tarefa> updateTarefa(@PathVariable Long id, @RequestBody Tarefa tarefa) {
		try {
			tarefa = tarefaService.updateTarefa(tarefa, id);
			return ResponseEntity.status(HttpStatus.OK).body(tarefa);
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		} catch (DataBaseException e) {
			return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
		}
	}
	
	@PutMapping(value = "/{id}/concluir")
	public ResponseEntity<Tarefa> updateTarefa(@PathVariable Long id) {
		try {
			Tarefa tarefa = tarefaService.updateStatusTarefa(id);
			return ResponseEntity.status(HttpStatus.OK).body(tarefa);
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		} catch (DataBaseException e) {
			return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
		}
	}
}
