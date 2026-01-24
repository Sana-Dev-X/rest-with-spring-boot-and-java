# REST API com Spring Boot e Java
  
Este repositório contém meus estudos práticos sobre desenvolvimento de APIs REST utilizando Spring Boot, Java, Swagger/OpenAPI, MySQL e outras tecnologias relacionadas.

📋 Descrição

  O projeto implementa uma API REST completa demonstrando conceitos fundamentais como:

    Criação de endpoints REST

    Tratamento de exceções global

    Documentação automática da API

    Estruturação de projetos Spring Boot

    Operações matemáticas via API

🛠 Tecnologias Utilizadas

    Java 25

    Spring Boot 

    Spring Web

    Spring Data JPA

    MySQL

    Swagger/OpenAPI 

    Maven

📁 Estrutura do Projeto

    src/main/java/br/com/sanadev/rest_with_spring_boot_and_java/
    ├── controller/                    # Controladores REST
    │   ├── GreetingController.java    # Endpoints de saudação
    │   └── MathController.java        # Endpoints de operações matemáticas
    ├── exception/                     # Exceções personalizadas
    │   ├── ExceptionResponse.record   # Record para resposta de exceções
    │   └── UnsupportedMathOperationException.exception
    ├── exception/handler/             # Manipulador global de exceções
    │   └── CustomEntityResponseHandler.java
    ├── model/                         # Modelos/Entidades
    │   └── Greeting.java
    └── Startup.java                   # Classe principal da aplicação

🚀 Como Executar

  Pré-requisitos

    Java 17 ou superior

    Maven 3.6+

    MySQL 8.0+

    IDE (IntelliJ, Eclipse ou VS Code)

  Configuração do Banco de Dados
  
    Crie um banco de dados MySQL:
    
    CREATE DATABASE rest_api_study;

 Configure as credenciais no application.properties :

    spring.datasource.url=jdbc:mysql://localhost:3306/rest_api_study
    spring.datasource.username=root
    spring.datasource.password=admin
    spring.jpa.hibernate.ddl-auto=update

 Executando a Aplicação

  Clone o repositório
  
    git clone https://github.com/Sana-Dev-X/rest-with-spring-boot-and-java.git

  Navegue até o diretório
  
    cd rest-with-spring-boot-and-java

  Execute com Maven

    mvn spring-boot:run

  A aplicação estará disponível em: 
  
    http://localhost:8080

📚 Endpoints da API

  Greeting Controller

    GET /greeting - Retorna uma saudação básica

    GET /greeting/{name} - Retorna uma saudação personalizada

  Math Controller

    GET /math/sum/{numberOne}/{numberTwo} - Soma de dois números

    GET /math/subtraction/{numberOne}/{numberTwo} - Subtração de dois números

    GET /math/multiplication/{numberOne}/{numberTwo} - Multiplicação de dois números

    GET /math/division/{numberOne}/{numberTwo} - Divisão de dois números

    GET /math/mean/{numberOne}/{numberTwo} - Média de dois números

    GET /math/squareRoot/{number} - Raiz quadrada de um número

📖 Documentação da API

    A documenttação interativa da API, em breve estará disponível via Swagger UI

🎯 Objetivos de Aprendizado
    
    Configuração de projeto Spring Boot

    Criação de controladores REST

    Implementação de endpoints CRUD

    Tratamento global de exceções

    Configuração do Swagger/OpenAPI

    Integração com MySQL

    Estruturação de pacotes seguindo boas práticas

    Testes unitários e de integração

    Autenticação e autorização

    Deploy em nuvem

📝 Notas de Estudo

  Este projeto faz parte da minha jornada de aprendizado em desenvolvimento backend com Spring Boot. Cada componente foi implementado para compreender na prática os conceitos fundamentais.

  Conceitos Abordados:

    Inversão de Controle (IoC) e Injeção de Dependência (DI)

    Controllers e Mapeamento de Endpoints

    Tratamento de Exceções com @ControllerAdvice

    Records do Java para objetos imutáveis

    Documentação Automática com Swagger

    Configuração de Banco de Dados MySQL

🔄 Próximos Passos
    
    Adicionar autenticação JWT

    Implementar testes com JUnit e Mockito

    Adicionar cache com Redis

    Implementar logging estruturado

    Configurar Docker e Docker Compose

    Adicionar monitoramento com Actuator

🤝 Contribuição

Como este é um repositório de estudos, sugestões e dicas são bem-vindas! Sinta-se à vontade para abrir issues ou pull requests.  
