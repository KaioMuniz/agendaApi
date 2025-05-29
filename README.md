
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

## Como Executar o Projeto

### Pré-requisitos

- JDK 11 ou superior instalado
- Maven instalado
- Docker (opcional)

### Execução Local

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/projetoAgendaApi.git
   ```
2. Acesse o diretório do projeto:
   ```bash
   cd projetoAgendaApi
   ```
3. Instale as dependências e compile o projeto:
   ```bash
   mvn clean install
   ```
4. Execute a aplicação:
   ```bash
   mvn spring-boot:run
   ```
5. Acesse em:
   ```
   http://localhost:8080
   ```

### Executando via Docker

1. Construa a imagem Docker:
   ```bash
   docker-compose build
   ```
2. Suba os containers:
   ```bash
   docker-compose up
   ```
3. A aplicação estará disponível em:
   ```
   http://localhost:8080
   ```

---

## Como Contribuir

1. Faça um fork do projeto.
2. Crie uma branch para sua feature:
   ```bash
   git checkout -b minha-nova-funcionalidade
   ```
3. Commit suas alterações:
   ```bash
   git commit -m "Descrição da alteração"
   ```
4. Envie para seu fork:
   ```bash
   git push origin minha-nova-funcionalidade
   ```
5. Abra um Pull Request para análise.

---

## Contato e Suporte

Abra uma issue no repositório para dúvidas ou problemas, ou entre em contato diretamente.

---

## Licença

Licenciado sob a **MIT License**. Consulte o arquivo [LICENSE](LICENSE) para detalhes.
