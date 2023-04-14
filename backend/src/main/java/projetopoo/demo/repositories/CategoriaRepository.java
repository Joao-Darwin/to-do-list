package projetopoo.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import projetopoo.demo.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}
