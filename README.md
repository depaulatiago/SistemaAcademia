# Sistema Academia

## Descrição do Projeto

O **Sistema Academia** é um sistema desenvolvido para gerenciar informações e processos relacionados a uma academia. Ele permite o gerenciamento de alunos, instrutores, fichas de treino e outros recursos essenciais para o funcionamento de uma academia. 

### Funcionalidades principais:

- CRUD de alunos e instrutores.
- Criação e gerenciamento de fichas de treino.
- Integração entre as entidades principais do sistema.

---

## Tecnologias Utilizadas

### Linguagem de Programação
- **Java**: Versão 17 (ou superior).

### Frontend
- **HTML**, **CSS**, **JavaScript** e **Bootstrap**: Para construção da interface do usuário.

### Frameworks e Bibliotecas
- **Spring Boot**: Versão 3.1.0 (ou superior) – para construção do backend.
- **Spring Data JPA** – para interação com o banco de dados.
- **Spring Security** – para autenticação e segurança.

### Banco de Dados
- **PostgreSQL**: Versão 15 (ou superior).

### Servidor de Desenvolvimento
- **Apache Tomcat** (embutido no Spring Boot): Versão 10.

### Ferramentas e Tecnologias Adicionais
- **Maven**: Gerenciador de dependências.
- **Thymeleaf**: Para renderização de templates no frontend.
- **H2 Database**: Banco de dados em memória para testes.

---

## Instalação e Execução

1. Clone o repositório:

   ```bash
   git clone https://github.com/usuario/SistemaAcademia.git
   ```

2. Navegue até a pasta do projeto:

   ```bash
   cd SistemaAcademia
   ```

3. Configure o arquivo `application.properties` para o acesso ao banco de dados PostgreSQL.

4. Compile e execute o projeto com o Maven:

   ```bash
   mvn spring-boot:run
   ```

5. Acesse o sistema através do navegador em [http://localhost:8080](http://localhost:8080).

---

## Estrutura do Projeto

- `src/main/java`: Contém o código fonte do projeto.
- `src/main/resources`: Contém os arquivos de configuração e templates do sistema.

---

## Contribuição

Contribuições são bem-vindas! Para contribuir, siga os passos abaixo:

1. Fork este repositório.
2. Crie uma branch com sua funcionalidade:
   ```bash
   git checkout -b MinhaFuncionalidade
   ```
3. Realize as alterações e faça commit:
   ```bash
   git commit -m 'Adiciona nova funcionalidade'
   ```
4. Envie suas alterações:
   ```bash
   git push origin MinhaFuncionalidade
   ```
5. Abra um Pull Request para revisão.

# SistemaAcademia

Este repositório contém o código-fonte e a documentação do SistemaAcademia. Aqui estão definidas as regras de uso do Git e estrutura do projeto para facilitar o trabalho colaborativo.

## Regras de Uso do Git

### Estrutura de Branches
1. **Branch principal:**
   - A branch principal do projeto é `main`. Deve conter apenas código estável e testado.
   
2. **Branches de desenvolvimento:**
   - Crie branches para novas funcionalidades, correções de bugs ou melhorias. Use a convenção:
     - `feature/nome-da-funcionalidade`
     - `fix/nome-do-bug`
     - `improvement/nome-da-melhoria`

3. **Branches de hotfix:**
   - Para correções urgentes na produção, utilize o prefixo `hotfix/`.

### Regras de Commits
1. **Estrutura de mensagens de commit:**
   - Linha 1: Resumo (50 caracteres ou menos).
   - Linha 2: (em branco)
   - Linha 3+: Detalhes (se necessário, explicando o que foi feito e por quê).

2. **Boas práticas:**
   - Use verbos no imperativo (ex.: "Adiciona funcionalidade de login").
   - Seja claro e objetivo.

### Fluxo de Pull Requests
1. Antes de criar um Pull Request:
   - Certifique-se de que o código está funcional e testado.
   - Atualize a branch com as alterações mais recentes de `main`.
   - Resolva conflitos antes de enviar o PR.

2. **Descrição do PR:**
   - Inclua uma descrição clara das mudanças implementadas.
   - Referencie issues relacionadas (ex.: "Resolve #123").

### Organização do Repositório
- **Código-fonte:**
  - Todo o código relacionado ao sistema ficará na pasta `src/`.
  
- **Documentação:**
  - Documentação geral e técnica ficará na pasta `docs/`.

- **Outros arquivos importantes:**
  - Configurações, scripts ou assets adicionais serão organizados conforme necessário em subpastas.

---

## Estrutura de Pastas do Projeto
```plaintext
/
├── docs/               # Documentação do projeto
├── src/                # Código-fonte
├── tests/              # Testes automatizados
├── .gitignore          # Arquivo de configuração do Git
├── README.md           # Documentação inicial
├── LICENSE             # Licença do Repositório     
```
---

## Licença

Este projeto está licenciado sob a **MIT License**.

---

> Inspirado por projetos como [Bootstrap](https://github.com/twbs/bootstrap) e [AMP](https://github.com/amphp/amp).
