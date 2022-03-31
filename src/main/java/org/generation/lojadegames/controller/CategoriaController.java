// SEMANA 8 - BLOCO 2 - 31/03/22
// SPRING BOOT, MYSQL E POSTMAN/INSOMNIA
// MODEL, REPOSITORY E CONTROLLER
// GET, POST, PUT E DELETE 


/*
 * EXERCÍCIO
 * 
 * Construa a Backend para uma Loja de Games com a capacidade de manipular os dados dos Produtos da loja. Os produtos deverão estar Classificados por Categoria.
 * 
 *  1 Crie o projeto no Spring seguindo as boas práticas
 *  2 Configure o Banco de dados da aplicação no arquivo application.properties
 *  3 Faça o CRUD completo do recurso Produto (6 métodos)
 *  4 Faça o CRUD completo do recurso Categoria (6 métodos)
 *  5 Crie o Relacionamento do tipo One to Many entre as Classes Categoria e Produto
 *  6 Siga todas as boas práticas estudadas nas primeiras sessões sobre Spring (Model, Repository e Controller).
 *  7 Teste toda a API utilizando o Insomnia
 *  8 Crie um repositório remoto no seu Github 
 *  9 Envie o projeto para o repositório
 * 10 Envie o link do repositório na Plataforma da Generation
 */

package org.generation.lojadegames.controller;

import java.util.List;

import org.generation.lojadegames.model.Categoria;
import org.generation.lojadegames.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categorias")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class CategoriaController {
	
	@Autowired // 
	private CategoriaRepository repository;
	
	// METODOS
	// GET PRINCIPAL
	@GetMapping
	public ResponseEntity<List<Categoria>> getAll(){ // puxa tudo da lista de categoria
		return ResponseEntity.ok(repository.findAll()); // retorna lista de categoria com status OK
	}
	
	// GET ID
	@GetMapping("/{id}")
	public ResponseEntity<Categoria> getById(@PathVariable Long id){ // indica que o ID é variável
		return repository.findById(id) // retorna opcional com status de OK ou NOT FOUND
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	// GET TITULO
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<Categoria>> getByTitulo(@PathVariable String titulo){
		return ResponseEntity.ok(repository.findByTituloContainingIgnoreCase(titulo)); // retorna lista de títulos igual a de consulta do DB em repository 
	}

	// POST
	@PostMapping
	public ResponseEntity<Categoria> post(@RequestBody Categoria categoria){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(categoria)); // retorna status CREATED e salvamos no DB em repository a categoria através do corpo
	}
	
	// PUT
	@PutMapping
	public ResponseEntity<Categoria> put(@RequestBody Categoria categoria){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(categoria)); // retorna status OK e salvamos no DB em repository a categoria através do corpo
	}
	
	// DELETE
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
