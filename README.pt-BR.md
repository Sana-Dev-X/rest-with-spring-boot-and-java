# API REST com Spring Boot e Java

Este repositório contém meus estudos práticos sobre o desenvolvimento de API REST usando Spring Boot, Java, Swagger/OpenAPI, MySQL e outras tecnologias relacionadas.

📋 **Descrição**

* O projeto implementa uma API REST completa demonstrando conceitos fundamentais como:

* Criação de endpoints REST

* Tratamento global de exceções

* Documentação automática da API

* Estruturação de projetos Spring Boot

* Operações matemáticas via API

* Operações CRUD com integração de banco de dados

* Validação de entrada e tratamento de erros

🛠 **Tecnologias Utilizadas**

* Java 17+

* Spring Boot 3.x

* Spring Web

* Spring Data JPA

* MySQL 8.0+

* Swagger/OpenAPI (SpringDoc)

* Maven

* Docker (planejado)

📁 **Estrutura do Projeto**

        rest-with-spring-boot-and-java/
        ├── src/main/java/br/com/sanadev/rest_with_spring_boot_and_java/
        │   ├── Startup.java
        │   ├── config/
        │   ├── greetings/
        │   │   ├── controller/
        │   │   │   └── GreetingController.java
        │   │   └── model/
        │   │       └── Greeting.java
        │   ├── math/
        │   │   ├── controller/
        │   │   │   └── MathController.java
        │   │   ├── exception/
        │   │   │   ├── ExceptionResponse.java
        │   │   │   ├── UnsupportedMathOperationException.java
        │   │   │   └── handler/
        │   │   │       └── CustomEntityResponseHandlerForMathClasses.java
        │   │   ├── service/
        │   │   │   └── MathService.java
        │   │   └── tools/
        │   │       ├── NumberConverter.java
        │   │       └── ParamValidator.java
        │   └── person/
        │       ├── controller/
        │       │   └── PersonController.java
        │       ├── exception/
        │       │   ├── ExceptionResponse.java
        │       │   ├── ResourceNotFoundException.java
        │       │   └── handler/
        │       │       └── CustomEntityResponseHandler.java
        │       ├── mock/
        │       │   └── Mock.java
        │       ├── model/
        │       │   └── Person.java
        │       ├── repository/
        │       │   └── PersonRepository.java
        │       └── service/
        │           └── PersonService.java
        ├── src/main/resources/
        │   ├── application.properties
        │   └── application-dev.properties
        ├── src/test/java/
        │   └── [test packages mirror main structure]
        ├── pom.xml
        ├── docker-compose.yml (planejado)
        ├── Dockerfile (planejado)
        └── README.md  

🚀 **Como Executar**

Pré-requisitos

*   Java 17 ou superior

*   Maven 3.6+

*   MySQL 8.0+

*   IDE (IntelliJ, Eclipse ou VS Code)

Configuração do Banco de Dados

Crie um banco de dados MySQL:

    CREATE DATABASE rest_with_spring_boot_and_java;

Configure as credenciais em application.properties:

    spring.datasource.url=jdbc:mysql://localhost:3306/rest_with_spring_boot_and_java
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

📚 **Endpoints da API**

Greeting Controller

*   GET /greeting - Retorna uma saudação básica

*   GET /greeting/{name} - Retorna uma saudação personalizada

Math Controller

*   GET /math/sum/{numberOne}/{numberTwo} - Soma de dois números

*   GET /math/subtraction/{numberOne}/{numberTwo} - Subtração de dois números

*   GET /math/multiplication/{numberOne}/{numberTwo} - Multiplicação de dois números

*   GET /math/division/{numberOne}/{numberTwo} - Divisão de dois números

*   GET /math/mean/{numberOne}/{numberTwo} - Média de dois números

*   GET /math/squareRoot/{number} - Raiz quadrada de um número

Person Controller (Operações CRUD)

*   GET /person - Lista todas as pessoas

*   GET /person/{id} - Encontra pessoa por ID

*   POST /person - Cria nova pessoa

*   PUT /person/{id} - Atualiza pessoa existente

*   DELETE /person/{id} - Deleta pessoa

📖 **Documentação da API**

A documentação interativa da API estará disponível em breve via Swagger UI

🎯 **Objetivos de Aprendizagem**

*   Configuração e auto-configuração do projeto Spring Boot

*   Criação de controllers REST com métodos HTTP adequados

*   Implementação de operações CRUD com Spring Data JPA

*   Tratamento global de exceções com @ControllerAdvice

*   Validação de entrada e validadores personalizados

*   Configuração do Swagger/OpenAPI para documentação automática

*   Integração com MySQL e mapeamento de entidades

*   Estruturação adequada de pacotes seguindo as melhores práticas

*   Abstração da camada de serviço e separação da lógica de negócios

*   Implementação do padrão Repository

📝 **Notas de Estudo**

Este projeto faz parte da minha jornada de aprendizado no desenvolvimento backend com Spring Boot. Cada componente foi implementado para entender na prática os conceitos fundamentais.

Conceitos Abordados:

*	Inversão de Controle (IoC) e Injeção de Dependência (DI) - Gerenciamento do contêiner Spring

*	Controllers e Mapeamento de Endpoints - @RestController, @RequestMapping, anotações de método HTTP

*	Tratamento de Exceções - Tratamento global de exceções com @ExceptionHandler e @ControllerAdvice

*	Persistência de Dados - Mapeamento de entidades, repositórios Spring Data JPA

*	Camada de Serviço - Separação da lógica de negócios e gerenciamento de transações

*	Validação de Entrada - Validadores personalizados e validação de parâmetros

*	Estrutura do Projeto - Organizado por funcionalidade/módulo

*	Configuração - Configuração externalizada com application.properties

🔄 **Próximos Passos & Roadmap**

Metas de Curto Prazo:

*	Adicionar testes unitários abrangentes com JUnit 5 e Mockito

*	Implementar testes de integração com Testcontainers

*	Adicionar anotações de validação (Jakarta Validation)

*	Implementar paginação e ordenação para endpoints de listagem

*	Adicionar logging estruturado com SLF4J

*	Metas de Médio Prazo:

*	Adicionar autenticação e autorização JWT

*	Implementar controle de acesso baseado em função (RBAC)

*	Adicionar cache com Spring Cache e Redis

*	Configurar Docker e Docker Compose para conteinerização

*	Adicionar monitoramento com Spring Boot Actuator

*	Implementar versionamento de API

Metas de Longo Prazo:

*	Adicionar pipeline CI/CD com GitHub Actions

*	Implementar integração de fila de mensagens (RabbitMQ/Kafka)

*	Adicionar rastreamento distribuído com Sleuth/Zipkin

*	Implantar na plataforma de nuvem (AWS/Azure/GCP)

*	Implementar endpoints GraphQL junto com REST

🤝 Contribuição

Como este é um repositório de estudo, sugestões e dicas são bem-vindas! Sinta-se à vontade para abrir issues ou pull requests.
