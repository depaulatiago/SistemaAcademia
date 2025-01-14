# Boas Práticas de Codificação para o SistemaAcademia

Para garantir a legibilidade, manutenção e qualidade do código do SistemaAcademia, todo o grupo deverá seguir as boas práticas descritas abaixo durante o desenvolvimento do projeto.

## 1. Adotar um Padrão de Notação de Código
- Utilizar o padrão **camelCase** para nomear variáveis, funções e atributos (ex.: `minhaVariavel`, `calculaValor`).
- Classes devem ser nomeadas em **PascalCase** (ex.: `MinhaClasse`).
- Constantes devem ser escritas em **UPPER_SNAKE_CASE** (ex.: `TAMANHO_MAXIMO`).

## 2. Documentar o Código
- Adicionar documentação em **cabeçalho de métodos**:
  ```python
  def calcula_valor(produto, quantidade):
      """
      Calcula o valor total do pedido.

      Args:
          produto (str): Nome do produto.
          quantidade (int): Quantidade comprada.

      Returns:
          float: Valor total do pedido.
      """
      return preco * quantidade
  ```
- Comentar apenas trechos de código complexos e evitar redundância:
  ```python
  # Método que busca usuários por ID no banco de dados
  usuario = busca_usuario_por_id(id_usuario)
  ```

## 3. Aplicar os Princípios SOLID
- **S**ingle Responsibility Principle (Princípio da Responsabilidade Única): Cada classe ou método deve ter apenas uma responsabilidade.
- **O**pen/Closed Principle (Princípio Aberto/Fechado): Classes, métodos e módulos devem ser abertos para extensão, mas fechados para modificação.
- **L**iskov Substitution Principle (Princípio da Substituição de Liskov): Subclasses devem poder substituir suas classes bases sem quebrar o sistema.

## 4. Aplicar os Conceitos do CLEAN CODE
- **Nomes significativos:**
  - Variáveis, funções e classes devem ter nomes que indiquem claramente sua função (ex.: `calcula_valor_total` em vez de `calc_val`).
- **Tamanho de funções:**
  - Evitar funções muito grandes; divida funções maiores em sub-funções menores com nomes claros.
- **Evitar código duplicado:**
  - Sempre que possível, reutilize funções ou métodos existentes.

## 5. Seguir a Estrutura de Pastas e Arquivos
- Organizar o código de maneira hierárquica e modular:
  ```plaintext
  src/
  ├── controllers/    # Lógica de negócio e controle
  ├── models/         # Modelos e estruturas de dados
  ├── views/          # Interfaces ou representações de saída
  ├── services/       # Serviços auxiliares
  └── utils/          # Funções utilitárias
  ```

## 6. Realizar Testes Automatizados
- Todo novo método ou funcionalidade deve vir acompanhado de testes automatizados.
- Organize os testes na pasta `tests/`.
- Siga a convenção de nomear arquivos de teste com o prefixo `test_` (ex.: `test_calcula_valor.py`).
- Utilize frameworks de teste adequados, como **Pytest** ou **JUnit**, dependendo da linguagem utilizada.

---
