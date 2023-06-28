package projetopoo.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projetopoo.demo.dtos.TarefaDTO;
import projetopoo.demo.entities.TagTarefa;
import projetopoo.demo.entities.Tarefa;
import projetopoo.demo.exceptions.DataBaseException;
import projetopoo.demo.exceptions.ResourceNotFoundByNameException;
import projetopoo.demo.exceptions.ResourceNotFoundException;
import projetopoo.demo.interfaces.Utilitarios;
import projetopoo.demo.repositories.TagRepository;

@Service
public class TagService implements Utilitarios{

	@Autowired
	private TagRepository tagRepository;
	
	//Método que retornar todas as tags
	public List<TagTarefa> findAll() {
		List<TagTarefa> listTags = tagRepository.findAll();
		if(listTags.isEmpty()) {
			throw new DataBaseException("Nenhuma tag foi encontrado!");
		}
		return listTags;
	}
	
	public TagTarefa findById(Long id) {
		try {
			TagTarefa tag = tagRepository.findById(id).get();
			return tag;
		} catch (IllegalArgumentException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	//Método para encontrar uma tag pelo nome
	public TagTarefa findByNome(String nome) {
		TagTarefa tagTarefa = tagRepository.findByNome(nome);
		if(tagTarefa == null) {
			throw new ResourceNotFoundByNameException(nome);
		}
		return tagTarefa;
	}
	
	//Método para criar uma nova tag
	public TagTarefa insertTag(TagTarefa tag) {
		try {
			return tagRepository.save(tag);
		}catch(IllegalArgumentException e) {
			throw new DataBaseException("A entidade não pode ser null");
		}
	}
	
	//Método para deletar uma tag pelo seu ID
	public void deleteById(Long id) {
		try {
			List<Tarefa> tarefas = findById(id).getTarefas();
	        if (!tarefas.isEmpty()) {
	            List<TagTarefa> tagsToRemove = new ArrayList<>();

	            for (Tarefa tarefa : tarefas) {
	                List<TagTarefa> tags = tarefa.getTagsTarefa();

	                for (TagTarefa tag : tags) {
	                    if (tag.getId() == id) {
	                        tagsToRemove.add(tag);
	                    }
	                }

	                tags.removeAll(tagsToRemove);
	            }
	        }
			tarefas.clear();
			tagRepository.deleteById(id);
		} catch (IllegalArgumentException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	public List<TarefaDTO> findTarefasDTOByTag(Long id) {
		try {
			TagTarefa tag = findById(id);
			List<TarefaDTO> tarefasDto = new ArrayList<>();
			for(Tarefa tarefa : tag.getTarefas()) {
				TarefaDTO tarefaDto = new TarefaDTO(tarefa.getId(),tarefa.getNome(), tarefa.getDescricao());
				tarefasDto.add(tarefaDto);
			}
			return tarefasDto;
		} catch (IllegalArgumentException e) {
			throw new ResourceNotFoundException(id);
		}
	}
}
