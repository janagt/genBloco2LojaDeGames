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

package org.generation.lojadegames.repository; //REPOSITORY: Repositório de consulta no banco de dados


import java.util.List;

import org.generation.lojadegames.model.Jogo; // importou Jogo.java
import org.springframework.data.jpa.repository.JpaRepository; // importou superclasse
import org.springframework.stereotype.Repository;

@Repository // indica que é repositório
public interface JogoRepository extends JpaRepository<Jogo, Long>{ // puxa a superclasse, indica o model e o atributo
	public List<Jogo> findAllByNomeContainingIgnoreCase(String nome); // query method consulta por título com parâmetro da string
}
