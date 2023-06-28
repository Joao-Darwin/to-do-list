package projetopoo.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projetopoo.demo.dtos.TarefaDTO;
import projetopoo.demo.entities.Categoria;
import projetopoo.demo.entities.Tarefa;
import projetopoo.demo.exceptions.DataBaseException;
import projetopoo.demo.exceptions.ResourceNotFoundException;
import projetopoo.demo.interfaces.Utilitarios;
import projetopoo.demo.repositories.CategoriaRepository;

@Service
public class CategoriaService implements Utilitarios{

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	//Método para listar todas as categorias
	public List<Categoria> findAll() {
		List<Categoria> listCategorias = categoriaRepository.findAll();
		if(listCategorias.isEmpty()) {
			throw new DataBaseException("Nenhuma categoria foi encontrada");
		}
		return listCategorias;
	}
	
	//Método para listar categoria pelo id
	public Categoria findById(Long id) {
		try {
			return categoriaRepository.findById(id).get();
		} catch(IllegalArgumentException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	//Método para listar tarefas de uma categoria
	public List<Tarefa> findTarefasByCategoria(Long id) {
		try {
			Categoria categoria = findById(id);
			return categoria.getTarefas();
		} catch (IllegalArgumentException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	public List<TarefaDTO> findTarefasDTOByCategoria(Long id) {
		try {
			Categoria categoria = findById(id);
			List<TarefaDTO> tarefasDto = new ArrayList<>();
			for(Tarefa tarefa : categoria.getTarefas()) {
				TarefaDTO tarefadto = new TarefaDTO(tarefa.getId(), tarefa.getNome(), tarefa.getDescricao());
				tarefasDto.add(tarefadto);
			}
			return tarefasDto;
		} catch (IllegalArgumentException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	//Método para criar categoria
	public Categoria insert(Categoria categoria) {
		try {
			return categoriaRepository.save(categoria);
		} catch(IllegalArgumentException e) {
			throw new DataBaseException("A categoria não pode ser null");
		}
	}
	
	//Método para deletar categoria
	public void deleteById(Long id) {
		try {
			List<Tarefa> tarefas = findTarefasByCategoria(id);
			for(Tarefa tarefa : tarefas) {
				tarefa.setCategoria(null);
			}
			categoriaRepository.deleteById(id);
		} catch(IllegalArgumentException e) {
			throw new ResourceNotFoundException(id);
		}
	}
}
