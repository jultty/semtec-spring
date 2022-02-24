# semtec API

[![Heroku](http://heroku-badge.herokuapp.com/?app=semtec&root=api/v1/termo)](https://semtec.herokuapp.com/)
[![Libraries.io dependency status for GitHub repo](https://img.shields.io/librariesio/github/jultty/semtec-api)](https://libraries.io/github/jultty/semtec-api)
[![Snyk Vulnerabilities for GitHub Repo](https://img.shields.io/snyk/vulnerabilities/github/jultty/semtec-api)](https://snyk.statuspage.io/)
[![CodeFactor](https://www.codefactor.io/repository/github/jultty/semtec-api/badge)](https://www.codefactor.io/repository/github/jultty/semtec-api)

Guarda, manipula e retorna significados de termos técnicos em notação JSON.

Se deseja ler as definições, veja a [página Jekyll](https://jultty.github.io)
com a mesma base de dados.

## Domínio

Cataloga e associa termos técnicos. As entradas são armazenadas
e disponibilizadas para consulta de forma serializada.

É capaz de servir páginas HTML e de exibir, atualizar
e apagar entradas via requisições HTTP.

## Especificação

* **termo**
    * **termo** - nome principal, usado em títulos
    * **significados**
    	* **resumo** - descrição curta
    	* **corpo** - corpo da descrição
    	* **origem** - origem etimológica ou histórica
    	* **traduções**
    		* **tradução** - termo equivalente
    		* **idioma** - 
    		* **detalhes** - corpo da tradução
    * **tags** - título (obrigatório)
    	* **tag** - nome curto da tag
    	* **prioridade** - 1 a 99, números menores indicam maior prioridade

### Notação JSON

```json
{
  "termo": "",
  "significados": [
    {
      "resumo": "",
      "corpo": "",
      "origem": "",
      "traduções": [
        {
          "tradução": "",
          "idioma": "",
          "detalhes": ""
        }
      ]
    }
  ],
  "tags": [
    {
      "tag": "",
      "prioridade": ""
    }
  ]
}
```

### Exemplos

Implementação atual:

Cria uma nova entrada:
```bash
curl -X POST localhost:8080/api/v1/termo -H 'Content-type:application/json' -d '{"termo": "interface", "significado": "media as trocas de informação entre componentes de um sistema"}'
```

Consulta uma entrada pelo ID:
```bash
curl -X GET localhost:8080/api/v1/termo/ID
```

Substitua o ID pelo número do termo. 
Novos termos são inseridos a partir do ID 1.
