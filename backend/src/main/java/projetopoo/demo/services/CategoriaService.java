package projetopoo.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projetopoo.demo.entities.Categoria;
import projetopoo.demo.entities.Tarefa;
import projetopoo.demo.exceptions.DataBaseException;
import projetopoo.demo.exceptions.ResourceNotFoundException;
import projetopoo.demo.repositories.CategoriaRepository;

@Service
public class CategoriaService {

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
			categoriaRepository.deleteById(id);
		} catch(IllegalArgumentException e) {
			throw new ResourceNotFoundException(id);
		}
	}
}
