package projetopoo.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projetopoo.demo.entities.TagTarefa;
import projetopoo.demo.exceptions.DataBaseException;
import projetopoo.demo.exceptions.ResourceNotFoundByName;
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
			throw new DataBaseException("Nenhuma tag foi encontrad!");
		}
		return listTags;
	}
	
	//Método para encontrar uma tag pelo nome
	public TagTarefa findByNome(String nome) {
		TagTarefa tag = tagRepository.findByNome(nome);
		if(tag != null) {
			throw new ResourceNotFoundByName(nome);
		}
		return tag;
	}
	
	//Método para criar uma nova tag
	public void insertTag(TagTarefa tag) {
		try {
			tagRepository.save(tag);
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
