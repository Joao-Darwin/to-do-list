package projetopoo.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projetopoo.demo.entities.Lembrete;

@Repository
public interface LembreteRepository extends JpaRepository<Lembrete, Long>{

}
