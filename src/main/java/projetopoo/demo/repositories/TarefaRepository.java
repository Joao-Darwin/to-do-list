package projetopoo.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import projetopoo.demo.entities.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long>{

}
