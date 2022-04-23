---
short_name: exe
title: execução de código
desc: Um programa passa por várias fases desde a escrita do seu código fonte até que ele possa ser executado. 
---

A **execução** é uma etapa no *ciclo de vida* de um programa. Esse ciclo começa na concepção inicial do código, quando ele ainda não é executável.

Isso pode ser representado com um diagrama, um desenho ou mesmo uma lista simples de passos a serem realizados, por exemplo:

```
1. Recebe um número e um nome
2. Verifica se o número já está cadastrado
3. Se estiver, mostra o nome do contato
4. Se não estiver, salva um novo contato
```

O exemplo acima é uma descrição em *narrativa* de como poderia funcionar um aplicativo de agenda.

Pegando as instruções enumeradas, passa-se à fase de **codificação**, onde essas etapas são escritas de acordo com as regras de uma linguagem que possa ser compilada ou interpretada como código.

Abaixo você pode ver um exemplo de como realizar a mesma sequência acima usando a linguagem Python:

```

	# recebe um número e um nome

nome = input('Digite o nome do contato: ')
numero = input('Digite o número do celular: ')

	# verifica se o número já está cadastrado

if agenda.get(numero):

	# se estiver, mostra o nome do contato

    print(numero + ' já está cadastrado para ' + agenda[numero])

	# se não estiver, salva um novo contato

else:
    agenda[numero] = nome
    print(numero + ' cadastrado para ' + agenda[numero])

``` 

Uma vez que tenha sido codificado, ele está quase pronto para ser **executado**.

A forma como ele passará de código para um programa em execução depende da linguagem em que foi escrito e quais **dependências** ele possui.

Dependências são outros programas, bibliotecas de código e diferentes componentes necessários para a execução que podem não estar contidos na distribuição de um programa.

## Linguagens compiladas

Antes da execução, em algumas linguagens é preciso que os programas sejam **compilados** primeiro, e por isso elas são chamadas de *linguagens compiladas*, como Java ou C.

A compilação de um programa é a tradução do código escrito na linguagem de programação para a linguagem de máquina, também chamado "código binário".

É por isso que o código não-compilado é chamado de **código fonte**, porque ele serve como origem para gerar um arquivo executável daquele programa.

Quem realiza essa tradução é um programa chamado de **compilador**.

Uma vez compilado, ele está pronto para ser executado em qualquer sistema que dê suporte para seu tipo de arquivo, isto é, que possa satisfazer as suas **dependências**.

Um programa escrito na linguagem Java, por exemplo, pode ser executado em muitos dispositivos diferentes, mas é necessário que eles tenham um componente Java instalado. Se não tiverem, você terá que instalar ele primeiro e só então conseguirá executar aquele arquivo.

## Linguagens interpretadas

Outras linguagens como Python ou JavaScript não precisam ser compiladas antes da execução: elas podem ser executadas diretamente por um programa chamado **interpretador**.

Isso traz mais flexibilidade porque o código fonte não precisa ser traduzido para linguagem de máquina toda vez que precisar ser modificado.

Apesar de terem essa vantagem, isso não quer dizer que você não pode criar um programa executável com essas linguagens. Existem implementações tanto em Python quanto em JavaScript que permitem a criação de binários executáveis. 

No seu funcionamento interno, o interpretador também pode realizar operações parecidas com as do compilador, como a conversão para linguagem de máquina ou ainda uma linguagem intermediária.

A diferença está no fato de que ele é capaz de fazer isso sem precisar primeiro criar um arquivo executável completo para só então executá-lo.

Um exemplo prático dessa capacidade é que uma linguagem interpretada pode facilmente ser usada em uma [interface de linha de comando](/tags/ilc). Nesse tipo de implementação, você informa o código diretamente, até mesmo uma única linha, e ele já será executado.

Isso seria muito mais difícil em uma linguagem compilada como Java, onde todo código precisa estar dentro de uma estrutura maior.

Se está lendo isso em um computador, você pode apertar a tecla `F12` para abrir as ferramentas de desenvolvimento do seu navegador. Se clicar então na opção `Console`, na parte de baixo do console você encontrará uma área com um ou dois `>` onde é possível digitar texto. Essa é a **linha de comando** do seu navegador.

Tente digitar os comandos abaixo nela e veja o que acontece:

```
let mensagem = "Olá, console"
console.log(mensagem)
```

