package TechGame.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import TechGame.Repository.JogosRepository;
import TechGame.model.Jogos;

@RestController
@RequestMapping("/jogos")
@CrossOrigin  ("*")

public class JogosController {
	@Autowired
	public JogosRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Jogos>> getAll(){
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Jogos> GetById(@PathVariable Long id){
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<Object> GetByTitulo(@PathVariable String Titulo){
		return ResponseEntity.ok(repository.findAllTituloContainigIgnoreCase(Titulo));
	}
	
}
