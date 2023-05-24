package projetopoo.demo.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import projetopoo.demo.entities.enums.ImportanciaTarefas;
import projetopoo.demo.entities.enums.StatusTarefa;

@Entity
public class Tarefa implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	private String descricao;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant dataCriacao = Instant.now();
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant dataConclusao;
	
	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;
	
	@JsonIgnore
	@OneToMany(mappedBy = "tarefa")
	private List<Lembrete> lembretes = new ArrayList<>();
	
	@ManyToMany
	@JoinTable(name = "tarefas_tags", joinColumns = @JoinColumn(name = "tarefa_id"), inverseJoinColumns = @JoinColumn(name = "tag_id"))
	private List<TagTarefa> tagsTarefa = new ArrayList<>();
	
	private ImportanciaTarefas importancia;
	private StatusTarefa status = StatusTarefa.PRA_FAZER;
	
	public Tarefa() {
	}
	
	public Tarefa (String nome, String descricao, Instant dataConclusao, ImportanciaTarefas importancia) {
		this.nome = nome;
		this.descricao = descricao;
		this.dataConclusao = dataConclusao;
		this.importancia = importancia;
	}
	
	public Tarefa (String nome, String descricao, Categoria categoria, Instant dataConclusao, ImportanciaTarefas importancia) {
		this.nome = nome;
		this.descricao = descricao;
		this.dataConclusao = dataConclusao;
		this.categoria = categoria;
		this.importancia = importancia;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Instant getDataCriacao() {
		return dataCriacao;
	}
	
	public Instant getDataConclusao() {
		return dataConclusao;
	}
	
	public void setDataConclusao(Instant dataConclusao) {
		this.dataConclusao = dataConclusao;
	}
	
	public Categoria getCategoria() {
		return categoria;
	}
	
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public List<Lembrete> getLembretes() {
		return lembretes;
	}
	
	public List<TagTarefa> getTagsTarefa() {
		return tagsTarefa;
	}
	
	public ImportanciaTarefas getImportancia() {
		return importancia;
	}
	
	public void setImportancia(ImportanciaTarefas importancia) {
		this.importancia = importancia;
	}
	
	public StatusTarefa getStatus() {
		return status;
	}
	
	public void setStatus(StatusTarefa status) {
		this.status = status;
	}
	
	public int prazoTarefa(Instant dataConclusao) {
		Instant agora = Instant.now();
		return Date.from(dataConclusao).compareTo(Date.from(agora));
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tarefa other = (Tarefa) obj;
		return Objects.equals(id, other.id);
	}
}