package projetopoo.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import projetopoo.demo.entities.TagTarefa;

public interface TagRepository extends JpaRepository<TagTarefa, Long>{

}
