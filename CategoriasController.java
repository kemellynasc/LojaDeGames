package TechGame.Controller;

import java.util.List;
import java.util.Locale.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import TechGame.Repository.CategoriasRepository;

import TechGame.model.Categoria;


@RestController
@RequestMapping("/categoria")
@CrossOrigin  ("*")
public class CategoriasController {
	@Autowired
	public CategoriasRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Categoria>> getAll(){
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Categoria> GetById(@PathVariable Long id){
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<Object>GetById(@PathVariable String Titulo){
		return ResponseEntity.ok(repository.findAllTituloContainigIgnoreCase(Titulo));
	}
	

}
