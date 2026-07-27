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

* Implementação de HATEOAS

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

+---br
    +---com
        +---sanadev
            +---rest_with_spring_boot_and_java
                |   Startup.java
                |
                +---config
                |       WebConfig.java
                |
                +---example
                +---greetings
                |   +---controller
                |   |       GreetingController.java
                |   |
                |   +---model
                |           Greeting.java
                |
                +---math
                |   +---controller
                |   |       MathController.java
                |   |
                |   +---exception
                |   |   |   ExceptionResponse.java
                |   |   |   UnsupportedMathOperationException.java
                |   |   |
                |   |   +---handler
                |   |           CustomEntityResponseHandlerForMathClasses.java
                |   |
                |   +---service
                |   |       MathService.java
                |   |
                |   +---tools
                |           NumberConverter.java
                |           ParamValidator.java
                |
                +---person
                |   +---controller
                |   |       PersonController.java
                |   |
                |   +---dto
                |   |       PersonDTO.java
                |   |
                |   +---exception
                |   |   |   ExceptionResponse.java
                |   |   |   ResourceNotFountException.java
                |   |   |
                |   |   +---handler
                |   |           CustomEntityResponseHandler.java
                |   |
                |   +---model
                |   |       Person.java
                |   |
                |   +---service
                |           PersonService.java
                |
                +---repository
                |       PersonRepository.java
                |
                +---serialization
                    +---converter
                            YamlJackson2HttpMessageConverter.java

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

Greeting

- GET /greeting — retorna uma saudação. Use o query parameter 'name' (ex.: /greeting?name=Sana). Padrão: "mundo!".

Math

- GET /math/sum/{first}/{second}
- GET /math/subtraction/{first}/{second}
- GET /math/multiplication/{first}/{second}
- GET /math/division/{first}/{second}
- GET /math/square-root/{number}
- GET /math/average/{first}/{second}

Person (suporta content negotiation: application/json, application/xml, application/x-yaml)

- GET /person — lista todas as pessoas (retorna links HATEOAS)
- GET /person/{id} — busca pessoa por id
- POST /person — cria uma pessoa (envie JSON/XML/YAML no corpo)
- PUT /person — atualiza uma pessoa (envie a representação completa no corpo)
- DELETE /person?id={id} — deleta por id (query parameter)

📖 **Documentação da API**

- Swagger / SpringDoc não está configurado no pom.xml; documentação interativa não está disponível por padrão.

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

*    Versionamento de API (conceito aplicado, mas descontinuado no decorrer do projeto)

*	Tratamento de Exceções - Tratamento global de exceções com @ExceptionHandler e @ControllerAdvice

*	Persistência de Dados - Mapeamento de entidades, repositórios Spring Data JPA

*	Camada de Serviço - Separação da lógica de negócios e gerenciamento de transações

*	Validação de Entrada - Validadores personalizados e validação de parâmetros

*	Estrutura do Projeto - Organizado por funcionalidade/módulo

*    Logging estruturado com Logger

*	Configuração - Configuração externalizada com application.properties

🔄 **Próximos Passos & Roadmap**

Metas de Curto Prazo:

*	Adicionar testes unitários abrangentes com JUnit 5 e Mockito

*	Implementar testes de integração com Testcontainers

*	Adicionar anotações de validação (Jakarta Validation)

*	Implementar paginação e ordenação para endpoints de listagem

Metas de Médio Prazo:

*	Adicionar autenticação e autorização JWT

*	Implementar controle de acesso baseado em função (RBAC)

*	Adicionar cache com Spring Cache e Redis

*	Configurar Docker e Docker Compose para conteinerização

*	Adicionar monitoramento com Spring Boot Actuator

Metas de Longo Prazo:

*	Adicionar pipeline CI/CD com GitHub Actions

*	Implementar integração de fila de mensagens (RabbitMQ/Kafka)

*	Adicionar rastreamento distribuído com Sleuth/Zipkin

*	Implantar na plataforma de nuvem (AWS/Azure/GCP)

*	Implementar endpoints GraphQL junto com REST

🤝 Contribuição

Como este é um repositório de estudo, sugestões e dicas são bem-vindas! Sinta-se à vontade para abrir issues ou pull requests.
