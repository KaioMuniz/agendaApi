
# Agenda API

Agenda API é uma aplicação Java baseada em Spring Boot para gerenciamento simples e eficiente de tarefas e categorias. O sistema oferece operações completas de CRUD para tarefas e categorias, permitindo organizar e controlar atividades de forma prática.

---

## Funcionalidades

- **Gerenciamento de Categorias**: Criação, leitura, atualização e exclusão de categorias para melhor organização das tarefas.
- **Gerenciamento de Tarefas**: CRUD completo para tarefas, incluindo a associação de cada tarefa a uma categoria específica.

---

## Arquitetura e Estrutura do Projeto

O projeto segue a arquitetura **MVC (Model-View-Controller)**, garantindo separação clara das responsabilidades e facilitando manutenção e escalabilidade.

### Organização dos Pacotes

```
src/
└── main/
    └── java/
        └── br/
            └── com/
                └── cotiinformatica/
                    ├── configurations/          # Configurações gerais da aplicação (ex: segurança, CORS, beans)
                    ├── controllers/             # Controladores REST que recebem e processam requisições HTTP
                    │   ├── CategoriasController.java
                    │   └── TarefasController.java
                    ├── dtos/                    # Data Transfer Objects para comunicação entre camadas
                    │   ├── CategoriaDTO.java
                    │   └── TarefaDTO.java
                    ├── entities/                # Entidades JPA que representam tabelas do banco de dados
                    │   ├── Categoria.java
                    │   └── Tarefa.java
                    ├── exceptions/              # Handlers e classes para tratamento de exceções personalizadas
                    │   ├── ApiExceptionHandler.java
                    │   └── ResourceNotFoundException.java
                    ├── repositories/            # Interfaces JPA para acesso e manipulação dos dados no banco
                    ├── scripts/                 # Scripts auxiliares e utilitários diversos (se houver)
                    ├── services/                # Serviços com lógica de negócio da aplicação
                    │   ├── CategoriaService.java
                    │   └── TarefaService.java
                    └── ProjetoAgendaApiApplication.java  # Classe principal para inicialização do Spring Boot
```

### Descrição dos Componentes

- **Configurations**: Configurações de aplicação, como segurança, beans, CORS e outras personalizações.
- **Controllers**: Camada que expõe endpoints REST para interagir com as tarefas e categorias.
- **DTOs**: Objetos para transferência segura e controlada de dados entre a API e os clientes.
- **Entities**: Representação das tabelas do banco de dados com seus atributos.
- **Exceptions**: Classes para tratamento centralizado de erros e exceções, garantindo respostas padronizadas.
- **Repositories**: Interfaces que abstraem o acesso ao banco de dados, utilizando Spring Data JPA.
- **Services**: Implementam a lógica de negócio da aplicação, sendo intermediárias entre Controllers e Repositories.
- **Scripts**: Arquivos auxiliares, podem conter scripts SQL, scripts para tarefas automáticas ou utilitários.
- **ProjetoAgendaApiApplication**: Classe principal que inicializa o contexto do Spring Boot.

---

## Tecnologias Utilizadas

- **Java 11+**
- **Spring Boot**
- **Spring Data JPA**
- **Maven**
- **Docker & Docker Compose**

---

