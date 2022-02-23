# semtec API

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


