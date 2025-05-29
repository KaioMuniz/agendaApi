
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
                    ├── configurations/          # Configurações da aplicação
                    ├── controllers/             # Controladores REST
                    │   ├── CategoriasController.java
                    │   └── TarefasController.java
                    ├── entities/                # Modelos de dados (Entidades)
                    │   ├── Categoria.java
                    │   └── Tarefa.java
                    ├── repositories/            # Interfaces para acesso a dados (JPA Repositories)
                    ├── scripts/                 # Scripts auxiliares (se houver)
                    └── ProjetoAgendaApiApplication.java  # Classe principal de inicialização
```

### Componentes Principais

- **Controllers**: Camada responsável por receber e tratar as requisições HTTP.
- **Entities**: Representam as tabelas no banco de dados com seus atributos.
- **Repositories**: Interfaces para abstração da persistência dos dados.
- **Configurations**: Configurações gerais do Spring e da aplicação.

---

## Tecnologias Utilizadas

- **Java 11+**
- **Spring Boot** (framework para desenvolvimento ágil de aplicações Java)
- **Spring Data JPA** (para persistência de dados)
- **Maven** (gerenciamento de dependências e build)
- **Docker & Docker Compose** (containerização da aplicação)

---

## Como Executar o Projeto

### Pré-requisitos

- JDK 11 ou superior instalado
- Maven instalado
- Docker (opcional, para rodar via container)

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
5. Acesse a aplicação pelo navegador ou cliente REST em:
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

Contribuições são sempre bem-vindas! Para colaborar:

1. Faça um fork deste repositório.
2. Crie uma branch com sua feature ou correção:
   ```bash
   git checkout -b minha-nova-funcionalidade
   ```
3. Faça commit das suas alterações:
   ```bash
   git commit -m "Descrição da sua alteração"
   ```
4. Envie para o seu fork:
   ```bash
   git push origin minha-nova-funcionalidade
   ```
5. Abra um Pull Request para revisão.

---

## Contato e Suporte

Caso tenha dúvidas ou queira reportar problemas, abra uma issue no repositório ou entre em contato.

---

## Licença

Este projeto está licenciado sob a **MIT License**. Veja o arquivo [LICENSE](LICENSE) para detalhes.
