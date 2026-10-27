# ECleaner

**Português (Brasil)** | [English (US)](#ecleaner-english-us)

O ECleaner é uma aplicação Java para Windows desenvolvida para ajudar usuários a analisar arquivos e identificar possíveis itens para limpeza. O projeto busca oferecer uma alternativa mais segura e transparente às ferramentas tradicionais de limpeza de computadores.

A aplicação está em estágio inicial de desenvolvimento.

## Objetivos do Projeto

- Analisar diretórios e obter informações sobre os arquivos.
- Calcular a quantidade de arquivos e seu tamanho total.
- Identificar possíveis itens para limpeza por meio de regras configuráveis.
- Permitir que os usuários revisem os itens selecionados antes de qualquer operação de limpeza.
- Oferecer uma interface clara e intuitiva em versões futuras.

## Tecnologias

- Java 25
- Maven
- JUnit 5
- IntelliJ IDEA

## Estrutura do Projeto

```text
ECleaner/
├── pom.xml
├── src/
│   ├── main/
│   │   └── java/
│   │       └── br/com/ecleaner/
│   │           ├── Main.java
│   │           ├── model/
│   │           └── scanner/
│   └── test/
│       └── java/
├── .gitignore
└── README.md
```

## Como Começar

### Requisitos

- JDK 25 ou ambiente de desenvolvimento compatível com Java 25.
- Maven instalado ou disponibilizado por meio do Maven Wrapper, caso ele seja adicionado ao projeto.
- Git, caso queira clonar o repositório.

### Clonar o Repositório

```bash
git clone https://github.com/rayssasilvaa/ECleaner.git
cd ECleaner
```

### Compilar o Projeto

```bash
mvn clean package
```

### Executar os Testes

```bash
mvn test
```

As instruções de execução podem mudar conforme o desenvolvimento da aplicação e a definição de seu ponto de entrada.

## Princípios de Segurança

O ECleaner está sendo desenvolvido com foco em segurança:

- A análise e a exclusão de arquivos são operações separadas.
- A análise não deve modificar nem excluir arquivos.
- Os usuários devem poder revisar os itens candidatos à limpeza antes da remoção.
- Arquivos pessoais não devem ser considerados descartáveis sem revisão explícita.
- As futuras operações de limpeza devem tratar cuidadosamente permissões, arquivos em uso e locais protegidos do sistema.

## Estado do Desenvolvimento

O ECleaner está em desenvolvimento. As funcionalidades descritas como objetivos são planejadas e não devem ser consideradas implementadas até estarem disponíveis no código-fonte.

---

# ECleaner (English US)

ECleaner is a Java application for Windows designed to help users analyze files and identify potential candidates for cleanup. The project aims to provide a safer and more transparent alternative to traditional PC cleaning tools.

The application is currently in its early development stage.

## Project Goals

- Scan directories and gather information about files.
- Calculate the number of files and their total size.
- Identify potential cleanup candidates through configurable rules.
- Allow users to review selected items before any cleanup operation.
- Provide a clear and user-friendly interface in future versions.

## Technologies

- Java 25
- Maven
- JUnit 5
- IntelliJ IDEA

## Project Structure

```text
ECleaner/
├── pom.xml
├── src/
│   ├── main/
│   │   └── java/
│   │       └── br/com/ecleaner/
│   │           ├── Main.java
│   │           ├── model/
│   │           └── scanner/
│   └── test/
│       └── java/
├── .gitignore
└── README.md
```

## Getting Started

### Requirements

- JDK 25 or a compatible Java 25 development environment.
- Maven installed separately or provided through the Maven Wrapper, if it is added to the project.
- Git, if you want to clone the repository.

### Clone the Repository

```bash
git clone https://github.com/rayssasilvaa/ECleaner.git
cd ECleaner
```

### Build the Project

```bash
mvn clean package
```

### Run Tests

```bash
mvn test
```

Execution instructions may change as the application develops and its entry point is finalized.

## Safety Principles

ECleaner is being designed with safety as a priority:

- Scanning and deleting files are separate operations.
- Scanning must not modify or delete files.
- Users should be able to review cleanup candidates before removal.
- Personal files must not be treated as disposable without explicit review.
- Future cleanup operations should handle permissions, locked files, and protected system locations carefully.

## Development Status

ECleaner is under development. Features described as goals are planned and should not be considered implemented until they are available in the codebase.
