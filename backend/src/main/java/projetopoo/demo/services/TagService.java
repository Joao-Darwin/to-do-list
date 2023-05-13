package projetopoo.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projetopoo.demo.entities.TagTarefa;
import projetopoo.demo.exceptions.DataBaseException;
import projetopoo.demo.exceptions.ResourceNotFoundByNameException;
import projetopoo.demo.exceptions.ResourceNotFoundException;
import projetopoo.demo.repositories.TagRepository;

@Service
public class TagService {

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
		TagTarefa tagTarefa = null;
		List<TagTarefa> listTag = tagRepository.findAll();
		for(TagTarefa tag : listTag) {
			int result = tag.getNome().compareToIgnoreCase(nome);
			if(result == 0) {
				tagTarefa = tag;
			}
		}
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
			tagRepository.deleteById(id);
		} catch(IllegalArgumentException e) {
			throw new ResourceNotFoundException(id);
		}
	}
}
