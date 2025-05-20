
# Agenda API

Agenda API é uma aplicação Java desenvolvida para gerenciar tarefas e categorias, com funcionalidades básicas de CRUD (criar, ler, atualizar e excluir). Utiliza o **Spring Framework** para facilitar a construção de uma aplicação escalável e flexível.

## Funcionalidades

- **Gerenciamento de Categorias**: Criação, leitura, atualização e exclusão de categorias para organizar tarefas.
- **Gerenciamento de Tarefas**: Criação, leitura, atualização e exclusão de tarefas, com a possibilidade de associá-las a categorias específicas.

## Estrutura do Projeto

O projeto segue a arquitetura **MVC (Model-View-Controller)**, separando as responsabilidades de forma organizada. Abaixo está a estrutura geral do código-fonte:

### Estrutura de Pastas

```
src/
└── main/
    └── java/
        └── br/
            └── com/
                └── cotiinformatica/
                    ├── configurations/          # Configurações gerais da aplicação (não listadas)
                    ├── controllers/             # Controladores da aplicação
                    │   ├── CategoriasController.java
                    │   └── TarefasController.java
                    ├── entities/                # Entidades do sistema
                    │   ├── Categoria.java
                    │   └── Tarefa.java
                    ├── repositories/            # Repositórios para acesso ao banco de dados (não listados)
                    ├── scripts/                 # Scripts auxiliares (não listados)
                    ├── ProjetoAgendaApiApplication.java  # Classe principal, inicializa a aplicação Spring
```

### Descrição dos Componentes

- **Controllers**:
  - `CategoriasController.java`: Controlador responsável pela gestão das categorias de tarefas.
  - `TarefasController.java`: Controlador responsável pela gestão das tarefas.

- **Entities**:
  - `Categoria.java`: Entidade que representa uma categoria no sistema.
  - `Tarefa.java`: Entidade que representa uma tarefa associada a uma categoria.

- **ProjetoAgendaApiApplication.java**: Classe principal da aplicação que inicializa o contexto Spring e executa a aplicação.

## Como Rodar o Projeto

### Pré-requisitos

- Java 11 ou superior
- Maven
- Docker (opcional, para rodar com Docker)

### Passos para Rodar Localmente

1. **Clone o repositório**:
   ```bash
   git clone https://github.com/seu-usuario/projetoAgendaApi.git
   ```

2. **Entre no diretório do projeto**:
   ```bash
   cd projetoAgendaApi
   ```

3. **Instale as dependências** utilizando Maven:
   ```bash
   mvn clean install
   ```

4. **Inicie a aplicação**:
   ```bash
   mvn spring-boot:run
   ```

   A aplicação estará rodando em `http://localhost:8080`.

### Rodando com Docker

1. **Construa a imagem Docker**:
   ```bash
   docker-compose build
   ```

2. **Suba os contêineres**:
   ```bash
   docker-compose up
   ```

   A aplicação estará disponível em `http://localhost:8080`.

## Como Contribuir

Sinta-se à vontade para contribuir com melhorias, correções ou novas funcionalidades! Para contribuir:

1. Faça um **fork** deste repositório.
2. Crie uma **branch** para suas mudanças (`git checkout -b minha-nova-funcionalidade`).
3. **Commit** suas mudanças (`git commit -am 'Adicionando nova funcionalidade'`).
4. Envie para o repositório remoto (`git push origin minha-nova-funcionalidade`).
5. Crie um **Pull Request** para revisão.

## Licença

Este projeto está licenciado sob a **MIT License** - veja o arquivo [LICENSE](LICENSE) para mais detalhes.

---

## Detalhamento de Tecnologias Utilizadas

- **Spring Boot**: Framework principal para o desenvolvimento da aplicação, fornecendo uma configuração mínima e rápida para criar aplicações Java independentes.
- **Maven**: Sistema de automação de compilação utilizado para gerenciar dependências e construir o projeto.
- **Docker**: Usado para containerizar a aplicação e garantir que ela seja executada de forma consistente em qualquer ambiente.
