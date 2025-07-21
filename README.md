
# 📋 Projeto Agenda API

Este é um projeto de estudo desenvolvido durante o curso de **Spring Boot Web Developer**, com o objetivo de praticar conceitos como:

- Desenvolvimento de APIs REST com Spring Boot  
- Persistência com Spring Data JPA  
- Integração com banco de dados PostgreSQL  
- Documentação automática com Swagger (SpringDoc OpenAPI)  
- Validações com Bean Validation  
- Boas práticas de versionamento de API  

---

### 🛠 Tecnologias utilizadas

- Java 21  
- Spring Boot 3.4.5  
- Spring Data JPA  
- PostgreSQL (via Docker)  
- Maven  
- SpringDoc OpenAPI  
- Bean Validation  
- Docker + Docker Compose  

---

### 🧪 Entidades principais

#### 📁 Categoria

- `id`: UUID  
- `nome`: String (único)  
- `tarefas`: Lista de tarefas relacionadas  

#### 📝 Tarefa

- `id`: UUID  
- `titulo`: String  
- `dataHora`: Date (com data e hora)  
- `finalizado`: Boolean  
- `categoria`: Categoria associada (chave estrangeira)  

---

### 🔄 Endpoints principais (Swagger)

A API possui documentação interativa disponível via Swagger:

> 🔗 Acesse: [http://localhost:8081/swagger-ui/index.html](http://localhost:8081/swagger-ui/index.html)

#### 🧾 Tarefas

- `POST /api/v1/tarefas` – Criar nova tarefa  
- `GET /api/v1/tarefas` – Listar todas as tarefas  
- `GET /api/v1/tarefas/{id}` – Buscar tarefa por ID  
- `PUT /api/v1/tarefas/{id}` – Atualizar uma tarefa  
- `DELETE /api/v1/tarefas/{id}` – Remover uma tarefa  

#### 📂 Categorias

- `GET /api/v1/categorias` – Listar categorias  
- `GET /api/v1/categorias/{name}` – Buscar categoria por nome  

---

### ▶️ Como executar o projeto

#### 1. Subir o banco de dados PostgreSQL com Docker

Certifique-se de que o Docker está instalado e rodando.

```bash
docker-compose up -d
```
#### 2. Rodar a aplicação

No terminal (ou pela IDE):
```bash
./mvnw clean package
java -jar ./target/projetoAgendaApi-0.0.1-SNAPSHOT.jar
```
---
### ✅ Status atual
- [x] listagem de Categorias (apenas leitura)

- [X] Criação de tarefas

- [X] Listagem, busca, atualização e exclusão de tarefas

- [X] Validações completas e tratamento de exceções

- [X] Testes automatizados


## Arquitetura e Estrutura do Projeto

O projeto segue a arquitetura **MVC (Model-View-Controller)**, garantindo separação clara das responsabilidades e facilitando manutenção e escalabilidade.

### Swagger
![image](https://github.com/user-attachments/assets/1be7f87e-eb21-4783-b817-aa8cb7c5b1a9)

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
###### 👨‍💻 Autor

Feito por Kaio Muniz durante o curso de Spring Boot Web Developer na COTI.
