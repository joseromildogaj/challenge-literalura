# 📚 Challenge - Literalura

-----

## 📖 Sobre o Projeto

O Literalura é uma aplicação Java, desenvolvida com o framework Spring Boot, cujo objetivo é gerenciar um catálogo de livros através de uma interface de console. O projeto foi criado como parte de um desafio proposto pela Formação Java e Spring Framework do programa ONE (Oracle Next Education), em parceria com a Alura. A aplicação se conecta à API pública do [Gutendex](https://gutendex.com/) para buscar informações sobre livros, as quais são então salvas em um banco de dados PostgreSQL.

-----

## ✨ Funcionalidades

  * **Buscar um livro pelo título**: A aplicação consulta a API Gutendex e salva os dados do livro e de seu autor no banco, caso ainda não existam.
  * **Listar livros registrados**: Exibe todos os livros que já foram salvos no banco de dados.
  * **Listar autores registrados**: Mostra todos os autores que já foram salvos na aplicação.
  * **Listar autores vivos**: Permite pesquisar autores que estavam vivos em um ano específico.
  * **Listar livros por idioma**: Filtra e exibe os livros registrados de um idioma específico.
  * **Sair**: Finaliza a aplicação.

-----

## 🛠️ Tecnologias Utilizadas

  * **Java 21+**: A linguagem de programação utilizada.
  * **Spring Boot 3.x**: O framework principal para o desenvolvimento da aplicação.
  * **Spring Data JPA e Hibernate**: Usado para a persistência de dados e mapeamento objeto-relacional.
  * **PostgreSQL**: O sistema de gerenciamento de banco de dados relacional.
  * **Maven**: Ferramenta para gerenciar dependências e o processo de build do projeto.
  * **Jackson Databind**: Biblioteca para processamento de JSON.

-----

## ▶️ Como Executar o Projeto

### Pré-requisitos

  * Java 21+
  * Maven 3.8+
  * PostgreSQL 14+

### Passo a passo

1.  **Clone o repositório:**
    ```bash
    git clone https://github.com/joseromildogaj/literalura.git
    cd literalura
    ```
2.  **Configure o banco de dados:**
      * Crie um banco de dados chamado `literalura` no PostgreSQL.

3.  **Configure as propriedades de conexão:**
      * No arquivo `src/main/resources/application.properties`, ajuste as configurações de acesso ao seu banco de dados.
	```properties
    	spring.datasource.url=jdbc:postgresql://localhost:5432/literalura
    	spring.datasource.username=seu_usuario
    	spring.datasource.password=sua_senha
    	spring.jpa.hibernate.ddl-auto=update
    	spring.jpa.show-sql=true
    	spring.jpa.properties.hibernate.format_sql=true
 
4.  **Instale as dependências:**
    ```bash
    mvn install
    ```
5.  **Inicie a aplicação:**
    ```bash
    mvn spring-boot:run
    ```
    O menu interativo será exibido no seu terminal.

-----

## 📜 Licença

Este projeto está sob a licença MIT.
