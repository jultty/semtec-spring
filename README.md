# semtec API

[![Codefresh build status](https://g.codefresh.io/api/badges/pipeline/jultty_marketplace/semtec-api%2Fsemtec-pipeline?type=cf-2&key=eyJhbGciOiJIUzI1NiJ9.NjIxZjc2OGMyYzA5NTFkMzA1ZWJiZTJm.4uGYdVoYyeg7gS49SbXs4PDO9yITBrxCqcZ41dkFPXw)](https://hub.docker.com/r/jultty/semtec-api/tags)
[![Heroku](https://pyheroku-badge.herokuapp.com/?app=semtec&style=flat&path=/api/v1/termo)](https://semtec.herokuapp.com/)
[![Actions Status](https://github.com/jultty/semtec-api/actions/workflows/maven.yml/badge.svg)](https://github.com/jultty/semtec-api/actions/workflows/maven.yml)
[![Libraries.io dependency status for GitHub repo](https://img.shields.io/librariesio/github/jultty/semtec-api)](https://libraries.io/github/jultty/semtec-api)

[![Snyk Vulnerabilities for GitHub Repo](https://img.shields.io/snyk/vulnerabilities/github/jultty/semtec-api)](https://snyk.io/test/github/jultty/semtec-api)
[![LGTM Alerts](https://img.shields.io/lgtm/alerts/github/jultty/semtec-api?label=alerts&logo=lgtm)](https://lgtm.com/projects/g/jultty/semtec-api/?mode=list)
[![LGTM Grade](https://img.shields.io/lgtm/grade/java/github/jultty/semtec-api?label=java&logo=lgtm)](https://lgtm.com/projects/g/jultty/semtec-api/context:java)
[![CodeFactor](https://www.codefactor.io/repository/github/jultty/semtec-api/badge)](https://www.codefactor.io/repository/github/jultty/semtec-api)

Guarda, manipula e retorna significados de termos técnicos em notação JSON.

Se deseja ler as definições, veja a [página web](https://semtec.netlify.app)
com a mesma base de dados.

## Domínio

Cataloga e associa termos técnicos. As entradas são armazenadas
e disponibilizadas para consulta de forma serializada.

É capaz de servir páginas HTML e de exibir, atualizar
e apagar entradas via requisições HTTP.

## Exemplos

Cria uma nova entrada:
```bash
curl -X POST localhost:8080/api/v1/termo -H 'Content-type:application/json' -d '{"termo": "interface", "significado": "media as trocas de informação entre componentes de um sistema"}'
```

Consulta uma entrada pelo ID:
```bash
curl -X GET localhost:8080/api/v1/termo/ID
```

Substitua "ID" pelo número do termo. 
Novos termos são inseridos a partir do ID 1.

Outras requisições: `PUT`, `DELETE`.

Para formatar a saída:
```bash
curl -X GET localhost:8080/api/v1/termo/ID | json_pp
```

ou com jq:

```bash
curl -X GET localhost:8080/api/v1/termo/ID | jq -C "."
```

O argumento `-C` torna a saída colorida.

## Especificação
### Estrutura de dados

```json
{
  "id": 1,
  "termo": "teste",
  "significado": "processo controlado e previsível voltado à observação, sem expectativa de sucesso",
  "resumo": "teste: processo controlado e previsível voltado à observação, sem expectativa de sucesso",
  "pagina": "https://semtec.netlify.app/termo/teste",
  "tag": "teste",
  "paginaTag": "https://semtec.netlify.app/tag/teste",
  "front_URL": "https://semtec.netlify.app/",
  "_links": {
    "self": {
      "href": "http://localhost:8080/api/v1/termo/1"
    },
    "termos": {
      "href": "http://localhost:8080/api/v1/termo"
    }
  }
}
```