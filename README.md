# 👉 API Loja de Games com CRUD
Desenvolvimento do Backend da API Loja de Games com Spring Boot, construção do CRUD e implementação de testes unitários com JUnit

## Lista de requisitos e boas práticas: Desenvolvimento
- Inserir todas as dependências necessárias de Spring Security
- (Model) Criar as classes necessárias de Spring Security e colocar todos os atributos necessários, incluindo os Métodos Get e Set e as Anotações. (Não sendo necessário criar um Método Construtor)
- (Controller) Criar os relacionamentos necessários de Spring Security e acrescentar todas as anotações e métodos Get e Set necessários.
- Executar a aplicação no STS e verificar sua criação no MySQL Workbench.
- (Repository) Criar o Método de Busca Específica necessário para a Spring Security.
- (Security) Criar as Classes necessárias para a Spring Security.
- (Service) Criar as classe de serviço necessárias para a Spring Security.
- (Controller) Criar a segunda Classe Controller com todos os Métodos do CRUD.
- Testar todos os métodos do CRUD através do Insomnia e Postman.

## Lista de requisitos e boas práticas: Testes Unitários
- Atualizar a dependência Spring Test (cuidado para não utilizar as versões antigas do JUnit)
- Adicionar a dependência do Banco de dados H2
- Criar a Source Folder resources (src/test)
- Criar o arquivo application.properties (src/test/resources)
- Configurar o Banco de dados de teste no arquivo application.properties (src/test/resources)
- (Repository) No pacote de testes, criar a Classe de testes da Interface UsuarioRepository
- (Controller) No pacote de testes, criar a a Classe de testes da Classe UsuarioController
- Executar todos os testes no Painel do JUnit no STS
- Experimente mudar os parâmetros dos testes e veja o resultado

## Tecnologias necessárias
- Java
- Spring Boot
- MySQL Workbench
- Insomnia/Postman
