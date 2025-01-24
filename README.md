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
- **H2 Database**: Banco de dados em memória para testes.
  
### Servidor de Desenvolvimento
- **Apache Tomcat** (embutido no Spring Boot): Versão 10.

### Ferramentas e Tecnologias Adicionais
- **Maven**: Gerenciador de dependências.
- **Thymeleaf**: Para renderização de templates no frontend.
- **H2 Database**: Banco de dados em memória para testes.

---

## Instalação e Execução

1. Clone o repositório:

   
bash
   git clone https://github.com/usuario/SistemaAcademia.git


2. Navegue até a pasta do projeto:

   
bash
   cd SistemaAcademia


3. Configure o arquivo application.properties para o uso do banco de dados H2:

No arquivo src/main/resources/application.properties, certifique-se de que as seguintes configurações estão presentes:

   
bash
   spring.datasource.url=jdbc:h2:mem:sistema_academia
   spring.datasource.driver-class-name=org.h2.Driver
   spring.datasource.username=sa
   spring.datasource.password=
   spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
   spring.h2.console.enabled=true
   spring.h2.console.path=/h2-console


4. Compile e execute o projeto com o Maven:

   
bash
   mvn spring-boot:run


5. Acesse o sistema através do navegador em [http://localhost:8080](http://localhost:8080).

6. Para acessar o banco de dados H2:

   
bash
   http://localhost:8080/h2-console

   Utilize as credenciais configuradas no application.properties.

7. Para rodar o frontend, baixe e instale o Live Server como extensão no VS Code (ou similar) e inicie o servidor na porta 5500. O frontend estará acessível em:
bash
  http://127.0.0.1:5500.
---

## Estrutura do Projeto
### Pacotes Principais
   
* Model: Contém as classes que representam as entidades do sistema (por exemplo, Aluno, Instrutor).

* Repository: Contém interfaces para interação com o banco de dados.

* Service: Contém a lógica de negócio do sistema.

* Controller: Contém os controladores REST para cada entidade do sistema.

## API Endpoints Principais
* GET /api/instrutores: Retorna todos os instrutores.

* GET /api/instrutores/{id}: Retorna um instrutor específico pelo ID.

* POST /api/instrutores: Salva um novo instrutor.

* PUT /api/instrutores/{id}: Atualiza os dados de um instrutor.

* DELETE /api/instrutores/{id}: Exclui um instrutor pelo ID.

---

## Contribuição

Contribuições são bem-vindas! Para contribuir, siga os passos abaixo:

1. Fork este repositório.
2. Crie uma branch com sua funcionalidade:
   
bash
   git checkout -b MinhaFuncionalidade

3. Realize as alterações e faça commit:
   
bash
   git commit -m 'Adiciona nova funcionalidade'

4. Envie suas alterações:
   
bash
   git push origin MinhaFuncionalidade

5. Abra um Pull Request para revisão.

## Regras de Uso do Git

### Estrutura de Branches
1. **Branch principal:**
   - A branch principal do projeto é main. Deve conter apenas código estável e testado.
   
2. **Branches de desenvolvimento:**
   - Crie branches para novas funcionalidades, correções de bugs ou melhorias. Use a convenção:
     - feature/nome-da-funcionalidade
     - fix/nome-do-bug
     - improvement/nome-da-melhoria

3. **Branches de hotfix:**
   - Para correções urgentes na produção, utilize o prefixo hotfix/.

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
   - Atualize a branch com as alterações mais recentes de main.
   - Resolva conflitos antes de enviar o PR.

2. **Descrição do PR:**
   - Inclua uma descrição clara das mudanças implementadas.
   - Referencie issues relacionadas (ex.: "Resolve #123").

### Organização do Repositório
- **Código-fonte:**
  - Todo o código relacionado ao sistema ficará na pasta src/.
  
- **Documentação:**
  - Documentação geral e técnica ficará na pasta docs/.

- **Outros arquivos importantes:**
  - Configurações, scripts ou assets adicionais serão organizados conforme necessário em subpastas.

---

## Estrutura de Pastas do Projeto
plaintext
/
├── docs/               # Documentação do projeto
├── src/                # Código-fonte
├── tests/              # Testes automatizados
├── .gitignore          # Arquivo de configuração do Git
├── README.md           # Documentação inicial
├── LICENSE             # Licença do Repositório

---

## Licença

Este projeto está licenciado sob a **MIT License**.

---

> Inspirado por projetos como [Bootstrap](https://github.com/twbs/bootstrap) e [AMP](https://github.com/amphp/amp).
