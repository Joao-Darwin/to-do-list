package projetopoo.demo.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import org.springframework.web.bind.annotation.CrossOrigin;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@CrossOrigin("*")
public class Lembrete implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date dataLembrete;
	private String mensagem;
	
	@ManyToOne
	@JoinColumn(name = "tarefa_id")
	private Tarefa tarefa;
	
	public Lembrete (Date dataLembrete, String mensagem, Tarefa tarefa) {
		this.dataLembrete = dataLembrete;
		this.mensagem = mensagem;
		this.tarefa = tarefa;
	}
	
	public Long getId() {
		return id;
	}
	
	public Date getDataLembrete() {
		return dataLembrete;
	}
	
	public void setDataLembrete(Date dataLembrete) {
		this.dataLembrete = dataLembrete;
	}
	
	public String getMensagem() {
		return mensagem;
	}
	
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	public Tarefa getTarefa() {
		return tarefa;
	}
	
	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
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
		Lembrete other = (Lembrete) obj;
		return Objects.equals(id, other.id);
	}
}