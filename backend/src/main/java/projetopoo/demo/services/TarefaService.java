package projetopoo.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import projetopoo.demo.entities.Tarefa;
import projetopoo.demo.exceptions.DataBaseException;
import projetopoo.demo.exceptions.ResourceNotFoundException;
import projetopoo.demo.repositories.TarefaRepository;

@Service
public class TarefaService {
	
	@Autowired
	private TarefaRepository tarefaRepository;
	
	//Encontrar todos as tarefas
	public Tarefa[] findAll() {
		Tarefa[] tarefas = (Tarefa[]) tarefaRepository.findAll().toArray();
		if(tarefas.length == 0) {
			throw new DataBaseException("Nenhuma tarefa foi encontrada");
		}
		return tarefas;
	}
	
	//Encontrar por ID
	public Tarefa findById(Long id) {
		try {
			return tarefaRepository.findById(id).get();
		} catch(IllegalArgumentException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	//Deletar tarefa por ID
	public void deleteById(Long id) {
		try {
			tarefaRepository.deleteById(id);
		} catch (IllegalArgumentException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	//Atualizar uma tarefa baseada em um ID
	public Tarefa updateTarefa(Tarefa tarefa, Long id) {
		try {
			Tarefa tarefaBuscada = findById(id);
			atualizarUmaTarefa(tarefaBuscada, tarefa);
			tarefaRepository.save(tarefaBuscada);
			return tarefaBuscada;
		} catch(OptimisticLockingFailureException e) {
			throw new DataBaseException("Erro no banco de dados");
		}
	}
	
	//Atualizar uma tarefa baseado em outra
	public void atualizarUmaTarefa(Tarefa tarefa, Tarefa novaTarefa) {
		tarefa.setNome(novaTarefa.getNome());
		tarefa.setDescricao(novaTarefa.getDescricao());
		tarefa.setDataConclusao(novaTarefa.getDataConclusao());
		tarefa.setCategoria(novaTarefa.getCategoria());
		tarefa.setImportancia(novaTarefa.getImportancia());
		tarefa.setStatus(novaTarefa.getStatus());
	}
}
