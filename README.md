Sistema Academia

Descrição do Projeto

O Sistema Academia é um sistema desenvolvido para gerenciar informações e processos relacionados a uma academia. Ele permite o gerenciamento de alunos, instrutores, fichas de treino e outros recursos essenciais para o funcionamento de uma academia.

Funcionalidades principais:

CRUD de alunos e instrutores.

Criação e gerenciamento de fichas de treino.

Integração entre as entidades principais do sistema.

Tecnologias Utilizadas

Linguagem de Programação

Java: Versão 17 (ou superior).

Frontend

HTML, CSS e JavaScript: Para construção da interface do usuário.

Frameworks e Bibliotecas

Spring Boot: Versão 3.1.0 (ou superior) – para construção do backend.

Spring Data JPA – para interação com o banco de dados.

Spring Security – para autenticação e segurança.

Banco de Dados

H2 Database: Banco de dados em memória para testes.

Servidor de Desenvolvimento

Apache Tomcat (embutido no Spring Boot): Versão 10.

Ferramentas e Tecnologias Adicionais

Maven: Gerenciador de dependências.

Thymeleaf: Para renderização de templates no frontend.

Instalação e Execução

Clone o repositório:

git clone https://github.com/usuario/SistemaAcademia.git

Navegue até a pasta do projeto:

cd SistemaAcademia

Configure o arquivo application.properties para o uso do banco de dados H2:

No arquivo src/main/resources/application.properties, certifique-se de que as seguintes configurações estão presentes:

spring.datasource.url=jdbc:h2:mem:sistema_academia
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

Compile e execute o projeto com o Maven:

mvn spring-boot:run

Acesse o sistema através do navegador em http://localhost:8080.

Para acessar o banco de dados H2:

http://localhost:8080/h2-console
Utilize as credenciais configuradas no application.properties.

Para rodar o frontend, baixe e instale o Live Server como extensão no VS Code (ou similar) e inicie o servidor na porta 5500. O frontend estará acessível em http://127.0.0.1:5500.

Estrutura do Projeto

Pacotes Principais

Model: Contém as classes que representam as entidades do sistema (por exemplo, Aluno, Instrutor).

Repository: Contém interfaces para interação com o banco de dados.

Service: Contém a lógica de negócio do sistema.

Controller: Contém os controladores REST para cada entidade do sistema.

Estrutura de Pastas do Projeto

/
├── docs/               # Documentação do projeto
├── src/                # Código-fonte
├── tests/              # Testes automatizados
├── .gitignore          # Arquivo de configuração do Git
├── README.md           # Documentação inicial
├── LICENSE             # Licença do Repositório     

Contribuição

Contribuições são bem-vindas! Para contribuir, siga os passos abaixo:

Fork este repositório.

Crie uma branch com sua funcionalidade:

git checkout -b MinhaFuncionalidade

Realize as alterações e faça commit:

git commit -m "Adiciona nova funcionalidade"

Envie suas alterações:

git push origin MinhaFuncionalidade

Abra um Pull Request para revisão.

Regras de Uso do Git

Estrutura de Branches

Branch principal:

A branch principal do projeto é main. Deve conter apenas código estável e testado.

Branches de desenvolvimento:

Crie branches para novas funcionalidades, correções de bugs ou melhorias. Use a convenção:

feature/nome-da-funcionalidade

fix/nome-do-bug

improvement/nome-da-melhoria

Branches de hotfix:

Para correções urgentes na produção, utilize o prefixo hotfix/.

Regras de Commits

Estrutura de mensagens de commit:

Linha 1: Resumo (50 caracteres ou menos).

Linha 2: (em branco)

Linha 3+: Detalhes (se necessário, explicando o que foi feito e por quê).

Boas práticas:

Use verbos no imperativo (ex.: "Adiciona funcionalidade de login").

Seja claro e objetivo.

Fluxo de Pull Requests

Antes de criar um Pull Request:

Certifique-se de que o código está funcional e testado.

Atualize a branch com as alterações mais recentes de main.

Resolva conflitos antes de enviar o PR.

Descrição do PR:

Inclua uma descrição clara das mudanças implementadas.

Referencie issues relacionadas (ex.: "Resolve #123").

Licença

Este projeto está licenciado sob a MIT License.

Inspirado por projetos como Bootstrap e AMP.
