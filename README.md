
## DESAFIO: CRUD Completo de Cliente

#### Este é um desafio do módulo de API REST, camadas, CRUD, exceções e validações do curso Java Spring Professional - devsuperior.

O projeto deverá estar com um ambiente de testes configurado acessando o banco de dados H2, deverá usar
Maven como gerenciador de dependência, e Java como linguagem.

Um cliente possui nome, CPF, renda, data de nascimento, e quantidade de filhos. A especificação da entidade Client é mostrada a seguir:

![Class](/src/main/resources/img/Class.png)

## Endpoints

### * Busca de cliente por id
```http
  GET http://localhost:8080/api/v1/clients/{id}
```
| Parâmetro   | Tipo       |Descrição|
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `Long` | **Obrigatório**. ID do cliente |

### * Busca paginada de clientes
```http
  GET http://localhost:8080/api/v1/clients?page=0&size=6&sort=name
```
| Parâmetro   | Tipo       |Descrição|
| :---------- | :--------- | :------------------------------------------ |

### * Inserção de novo cliente
```http
  POST http://localhost:8080/api/v1/clients
```
| Parâmetro   | Tipo       |Descrição|
| :---------- | :--------- | :------------------------------------------ |
| `name`      | `String` | **Obrigatório**. O nome do cliente |
| `cpf`      | `String` | **Obrigatório**. O cpf do cliente |
| `income`    | `Double` | **Obrigatório**. A renda do cliente |
| `birthDate` | `LocalDate` | **Obrigatório**. Data de nascimento |
| `children` | `Integer` | **Obrigatório**. Quantidade de filhos |

### * Atualizaçao de cliente
```http
  PUT http://localhost:8080/api/v1/clients/{id}
```
| Parâmetro   | Tipo       |Descrição|
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `Long` | **Obrigatório**. ID do cliente  |
| `name`      | `String` | **Obrigatório**. Nome do cliente |
| `cpf`      | `String` | **Obrigatório**. CPF do cliente |
| `income`    | `Double` | **Obrigatório**. Renda do cliente |
| `birthDate` | `LocalDate` | **Obrigatório**. Data de nascimento |
| `children` | `Integer` | **Obrigatório**. Quantidade de filhos |


### * Deleção de cliente
```http
  GET http://localhost:8080/api/v1/{id}
```
| Parâmetro   | Tipo       |Descrição|
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `Long` | **Obrigatório**. ID do cliente |

## Requisitos
- Seed de pelo menos 10 clientes
- Tratar exceções:
    - id não encontrado (retorno 404)
    - Erro de validação (retorno 422), mensagens customizadas para cada campo inválido.
    - Regras:
        - Nome não pode ser vazio;
        - Data nascimento não pode ser futura (@PastOrPresente)

## Checklist
  1. Busca por id retorna cliente existente
  2. Busca por id retorna 404 para cliente inexistente
  3. Busca paginada retorna listagem paginada corretamente
  4. Inserção de cliente insere cliente com dados válidos
  5. Inserção de cliente retorna 422 e mensagens customizadas com dados inválidos
  6. Atualização de cliente atualiza cliente com dados válidos
  7. Atualização de cliente retorna 404 para cliente inexistente
  8. Atualização de cliente retorna 422 e mensagens customizadas com dados inválidos
  9. Deleção de cliente deleta cliente existente
  10. Deleção de cliente retorna 404 para cliente inexistente
    