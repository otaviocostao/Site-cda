## Página Web para a Central de Desenvolvimento de Associações

Página Web para a CDA (Central de Desenvolvimento de Associações) com a finalidade de divulgar a organização e promover suas atividades, projetos e serviços. 
A aplicação conta com uma parte pública para exibição dessas informações e uma parte para o administrador poder manipular as informações.

## Tecnologias utilizadas

- Java: Linguagem principal do projeto.
- Spring Boot: Framework para criação da aplicação, incluindo:
    - Spring Data JPA para persistência de dados.
    - Spring MVC para controle das rotas e organização em camadas.
- MySQL: Sistema de Gerenciamento de Banco de Dados para armazenamento de dados de funcionários e empréstimos.
- Thymeleaf: Motor de templates para renderizar as páginas HTML.
- HTML e CSS: Para estilização e estruturação das páginas.

## Funcionalidades

- Cadastro de noticias, projetos, serviços e associados.
- Gerenciamento desses objetos dentro desse banco de dados.
- Listagem dos objetos do banco de dados.
  
## Como Executar o Projeto

- Clone o repositório e abra o projeto em sua IDE preferida.
- Certifique-se de que o MySQL está configurado e acessível, com as credenciais ajustadas no application.properties.
- Execute a classe principal CdaApplication.java
- Abra seu navegador e acesse o sistema em http://localhost:8082.
