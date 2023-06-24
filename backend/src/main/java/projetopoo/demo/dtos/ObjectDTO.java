package projetopoo.demo.dtos;

public abstract class ObjectDTO {
	
	private Long id;
	private String nome;
	
	public ObjectDTO(Long id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public abstract String toString();
}
