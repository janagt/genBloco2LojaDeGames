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

package org.generation.lojadegames.controller; // CONTROLLER: Camada controladora da aplicação, onde estão endpoints, funções.

import java.util.List;

import org.generation.lojadegames.model.Jogo; // importa Jogo.java
import org.generation.lojadegames.repository.JogoRepository; // importa JogoRepository.java
import org.springframework.beans.factory.annotation.Autowired; // instancia em controller JogoRepository.java
import org.springframework.http.HttpStatus; // importa todos status http
import org.springframework.http.ResponseEntity; // importa a RE
import org.springframework.web.bind.annotation.CrossOrigin; // libera acesso às portas
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping; // importa metodo get
import org.springframework.web.bind.annotation.PathVariable; // importa uri variável
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping; // fornece endpoint de consulta
import org.springframework.web.bind.annotation.RestController; // indica que é controller

@RestController // indica que é controller
@RequestMapping("/jogos") // fornece endpoint de consulta
@CrossOrigin(origins="*") // libera acesso às portas
public class JogoController {
	
	@Autowired // instancia o repositório, permitindo tudo de JogoRepository.java fique acessível para os métodos
	private JogoRepository repository; // puxa JogoRepository.java e o apelida
	
	// METODOS
	
	// GET PRINCIPAL
	@GetMapping 
	public ResponseEntity<List<Jogo>> getAll(){ // usa RE puxa métodos, importando Jogo.java para criar a lista
		return ResponseEntity.ok((repository.findAll())); // retorna lista de jogos com status OK de RE
	}
	
	// GET ID
	@GetMapping("/{id}") // indica endpoint variável
	public ResponseEntity<Jogo> getById(@PathVariable Long id){ // puxa URI variável do {id}
		return repository.findById(id) // retorna um opcional (nulo ou preenchido) pro id
				.map(resp -> ResponseEntity.ok(resp)) // mostra OK 200
				.orElse(ResponseEntity.notFound().build()); // mostra 400 NOT FOUND
	}
	
	// GET NOME
	@GetMapping("/nome/{nome}") // indica endpoint variável
	public ResponseEntity<List<Jogo>> getByNome(@PathVariable String nome){ // puxa método da Re, para a lista de jogos por nome
		return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome)); // retorna mesma consulta do DB
	}
	
	// POST
	@PostMapping // indica que é postagem
	public ResponseEntity<Jogo> post(@RequestBody Jogo jogo){ // puxa lista pro método post, solicita body para criação de objetos
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(jogo)); // retorno CREATED 200 e dentro do body salvo o repositório do jogo
	}
	
	// PUT
	@PutMapping // indica que é update
	public ResponseEntity<Jogo> put(@RequestBody Jogo jogo){ // igual ao post
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(jogo)); // retorna OK 200 e o body salva o repositório do jogo
	}
	
	// DELETE
	@DeleteMapping("/{id}") // indica que é delete por endpoint variável de id
	public void delete(@PathVariable Long id) { // puxa URI variável do {id}
		repository.deleteById(id); // puxa do repositório o ID para deletar
	}
}
