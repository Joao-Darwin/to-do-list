package projetopoo.demo.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import org.springframework.web.bind.annotation.CrossOrigin;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@CrossOrigin("*")
public class Lembrete implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date dataLembrete;
	private String mensagem;
	
	public Lembrete (Date dataLembrete, String mensagem) {
		this.dataLembrete = dataLembrete;
		this.mensagem = mensagem;
	}
	
	public Long getId() {
		return id;
	}
	
	public Date getDataLembrete() {
		return dataLembrete;
	}
	
	public String getMensagem() {
		return mensagem;
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