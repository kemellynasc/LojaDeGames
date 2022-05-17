package TechGame.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import TechGame.model.Categoria;





public interface CategoriasRepository extends JpaRepository<Categoria, Long> {

	public List<Categoria> findAllByCategoriaContainingIgnoreCase(@Param("categoria") 
	String categoria);
	public Object findAllTituloContainigIgnoreCase(String titulo);
}
