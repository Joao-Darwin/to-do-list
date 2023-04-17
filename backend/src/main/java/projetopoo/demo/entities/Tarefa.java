package projetopoo.demo.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;
import java.util.Objects;

import org.springframework.web.bind.annotation.CrossOrigin;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import projetopoo.demo.entities.enums.ImportanciaTarefas;
import projetopoo.demo.entities.enums.StatusTarefa;

@Entity
@CrossOrigin("*")
public class Tarefa implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	private String descricao;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT")
	private Instant dataCriacao = Instant.now();
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT")
	private Instant dataConclusao;
	
	private ImportanciaTarefas importancia;
	private StatusTarefa status = StatusTarefa.PRA_FAZER;
	
	public Tarefa (String nome, String descricao, Instant dataConclusao, ImportanciaTarefas importancia) {
		this.nome = nome;
		this.descricao = descricao;
		this.dataConclusao = dataConclusao;
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
	
	public Instant getDataComclusao() {
		return dataConclusao;
	}
	
	public void setDataConclusao(Instant dataConclusao) {
		this.dataConclusao = dataConclusao;
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
	
	public static int prazoTarefa(Instant dataConclusao) {
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