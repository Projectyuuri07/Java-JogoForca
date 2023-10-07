# Jogo da Forca em Java

Este é um simples jogo da forca implementado em Java, onde o jogador tenta adivinhar uma palavra oculta, uma letra de cada vez, com um limite de tentativas.

## Como Jogar

1. O programa escolhe aleatoriamente uma palavra a partir de uma lista de palavras pré-definidas.
2. O jogador tem 6 tentativas para adivinhar a palavra corretamente.
3. Uma representação da palavra é exibida com letras adivinhadas visíveis e underscores para as letras não adivinhadas.
4. O jogador insere uma letra como palpite.
5. Se a letra estiver na palavra, ela é revelada na representação da palavra.
6. O jogo continua até que o jogador ganhe (adivinhe a palavra corretamente) ou perca (exceda o limite de tentativas).

## Executando o Jogo

Para executar o jogo, certifique-se de ter o Java instalado no seu sistema. Você pode compilar e executar o código usando o comando `javac` e `java`, respectivamente.

```shell
javac Main.java
java Main

