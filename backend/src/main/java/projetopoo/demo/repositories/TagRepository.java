package projetopoo.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projetopoo.demo.entities.TagTarefa;

@Repository
public interface TagRepository extends JpaRepository<TagTarefa, Long>{
	public TagTarefa findByNome(String nome);
}
