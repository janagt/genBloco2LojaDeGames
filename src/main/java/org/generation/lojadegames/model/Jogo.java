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

package org.generation.lojadegames.model; // MODEL: estrutura/modela dados no banco de dados

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity // Indica que é tabela
@Table(name="tb_jogos") // Nomeia a tabela
public class Jogo {
	@Id // Indica que o atributo é ID
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Autoincrement
	private Long id;
	
	@NotNull // Não permite campo nulo
	@Size(min=4,max=100) // Estipula número de caractere
	private String nome;
	
	@NotNull // Não permite campo nulo
	@Size(min=2,max=100) // Estipula número de caractere
	private String desenvolvedora;
	
	@NotNull // Não permite campo nulo
	@Size(min=2,max=100) // Estipula número de caractere
	private String publicadora;
	
	private int lancamento;
	
	private String idioma;
	
	private String indicacao;
	
	private boolean online;
	
	@ManyToOne
	@JsonIgnoreProperties("jogo") // freia o loop
	private Categoria categoria; // cria atributo categoria através da categoria
	
	// METODOS PARA PUXAR NO POSTMAN

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDesenvolvedora() {
		return desenvolvedora;
	}

	public void setDesenvolvedora(String desenvolvedora) {
		this.desenvolvedora = desenvolvedora;
	}

	public String getPublicadora() {
		return publicadora;
	}

	public void setPublicadora(String publicadora) {
		this.publicadora = publicadora;
	}

	public int getLancamento() {
		return lancamento;
	}

	public void setLancamento(int lancamento) {
		this.lancamento = lancamento;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public String getIndicacao() {
		return indicacao;
	}

	public void setIndicacao(String indicacao) {
		this.indicacao = indicacao;
	}

	public boolean isOnline() {
		return online;
	}

	public void setOnline(boolean online) {
		this.online = online;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}
