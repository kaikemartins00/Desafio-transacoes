# Transação API

API REST desenvolvida com Spring Boot para registrar transações e calcular estatísticas sobre elas em um intervalo de tempo.

Os dados são armazenados **em memória**, ou seja, são perdidos ao reiniciar a aplicação.

## Tecnologias

- Java 21+
- Spring Boot 4.1.1
- Bean Validation
- Lombok
- Swagger / OpenAPI

## Como executar

```bash
git clone <url-do-repositorio>
cd transacao-api
./mvnw spring-boot:run
```

A aplicação sobe em `http://localhost:8080`.

Documentação interativa (Swagger): `http://localhost:8080/swagger-ui/index.html`

## Endpoints

### Criar transação

`POST /transacao`

```json
{
  "valor": 123.45,
  "dataHora": "2026-10-22T12:00:00.000-03:00"
}
```

| Status | Descrição |
|--------|-----------|
| 201 | Transação criada com sucesso |
| 422 | Campos inválidos (nulos, valor negativo ou data no futuro) |
| 400 | JSON malformado ou tipos incorretos |

### Deletar transações

`DELETE /transacao`

| Status | Descrição |
|--------|-----------|
| 200 | Todas as transações foram removidas |

### Estatísticas

`GET /estatistica?tempoBusca=60`

Retorna as estatísticas das transações realizadas nos últimos `tempoBusca` segundos (padrão: 60).

```json
{
  "count": 10,
  "sum": 1234.56,
  "avg": 123.456,
  "min": 12.34,
  "max": 456.78
}
```

Quando não há transações no intervalo, todos os campos retornam `0`.

## Regras de validação

- `valor` é obrigatório e deve ser maior ou igual a zero.
- `dataHora` é obrigatória e não pode estar no futuro.

## Estrutura do projeto

```
src/main/java/com/kaikemartins/transacao_api
├── business/services      # Regras de negócio
├── controller             # Endpoints REST
│   └── dtos               # Objetos de requisição e resposta
└── infrastructure
    └── exceptions         # Tratamento global de erros
```

## Autor

Kaike Martins
