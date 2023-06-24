package projetopoo.demo.dtos;

public class TarefaDTO extends ObjectDTO{
	
	private String descricao;
	
	public TarefaDTO (Long id, String nome, String descricao) {
		super(id, nome);
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Id: " + getId() + "\n");
		sb.append("Nome: " + getNome() + "\n");
		sb.append("Descrição: " + getDescricao() + "\n");
		return sb.toString();
	}
}
