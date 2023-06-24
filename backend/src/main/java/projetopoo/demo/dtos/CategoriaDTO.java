package projetopoo.demo.dtos;

public class CategoriaDTO extends ObjectDTO{
	private int quantTarefas = 0;
	
	public CategoriaDTO(Long id, String nome) {
		super(id, nome);
	}
	
	public int getQuantTarefas() {
		return quantTarefas;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Id: " + getId() + "\n");
		sb.append("Nome: " + getNome() + "\n");
		sb.append("Quant. Tarefas: " + getQuantTarefas() + "\n");
		return sb.toString();
	}
}
