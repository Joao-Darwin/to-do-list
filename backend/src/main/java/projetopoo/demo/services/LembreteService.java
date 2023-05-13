package projetopoo.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projetopoo.demo.entities.Lembrete;
import projetopoo.demo.exceptions.DataBaseException;
import projetopoo.demo.exceptions.ResourceNotFoundException;
import projetopoo.demo.repositories.LembreteRepository;

@Service
public class LembreteService {

	@Autowired
	private LembreteRepository lembreteRepository;
	
	//Método para listar todas os  lembretes
	public List<Lembrete> findAll(){
		List<Lembrete> listLembrete = lembreteRepository.findAll();
		if(listLembrete.isEmpty()) {
			throw new DataBaseException("Nenhum lembrete foi encontrado");
		}
		return listLembrete;
	}
	
	//Método para listar um lembrete pelo id
	public Lembrete findById(Long id) {
		try {
			return lembreteRepository.findById(id).get();
		} catch(IllegalArgumentException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	//Método para criar uma lembrete
	public void insert(Lembrete lembrete) {
		try {
			lembreteRepository.save(lembrete);
		} catch(IllegalArgumentException e) {
			throw new DataBaseException("O lembrete não pode ser null");
		}
	}
	
	//Método para deletar um lembrete pelo id
	public void deleteById(Long id) {
		try {
			lembreteRepository.deleteById(id);
		} catch(IllegalArgumentException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	//Método para atualizar um determinado lembrete
	public Lembrete updateLembrete(Lembrete lembrete, Long id) {
		try {
			Lembrete lembreteBuscado = findById(id);
			lembreteBuscado = atualizarLembrete(lembreteBuscado, lembrete);
			lembreteRepository.save(lembreteBuscado);
			return lembreteBuscado;	
		} catch (IllegalArgumentException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	private Lembrete atualizarLembrete(Lembrete lembrete, Lembrete novoLembrete) {
		lembrete.setDataLembrete(novoLembrete.getDataLembrete());
		lembrete.setMensagem(novoLembrete.getMensagem());
		lembrete.setTarefa(novoLembrete.getTarefa());
		return lembrete;
	}
}
