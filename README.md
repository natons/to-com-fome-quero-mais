# EP2 - OO (UnB - Gama)

Este projeto consiste em uma aplicação desktop para um restaurante, utilizando a técnologia Java FX.

* Mais detalhes na wiki [home](https://gitlab.com/OOFGA-2016-1/EP2/wikis/home)

### Pré-Requisitos

* 1 - Ter um banco de dados em sua máquina (MySQLServer)
* 2 - Possuir uma conexão com usuário "root" senha "root" (Caso seja diferente, deve-se atualizar no programa o arquivo persistence.xml, com o usuário e senha de seu banco de dados)
* 3 - Criar um banco com o seguinte nome __bdToComFome__

### Como Compilar e Executar

Para compilar e executar o projeto é necessário:

* Fazer um clone do [repositório](https://gitlab.com/natons/EP2/tree/master)
* Executar a classe MainScreen
* Ou gerar .jar e executá-lo

### Entradas do usuário
A interface é intuitiva, informando como deve ser preenchido cada tempo. É necessário que se digite valores
coerentes com o que é pedido (por exemplo, não digite valores inteiros onde se pede string).

### Primeira execução
É obrigatório como primeiro passo, executar o aplicativo, e logar-se com login: "admin" e senha: "admin", para que o banco seja criado.
Na primeira execução o banco não terá nenhum registro, para isso execute o __script.sql__ presente na pasta __src__, caso queira
empregados, produtos e pedidos cadastrados. Outra opção é entrar com o login: "admin" e senha: "admin", e na tela do Administrador,
realizar os devidos cadastros que se deseja.
Obs: __é obrigatório a criação de um empregado, para que se possa entrar no sistema, se isto não for feito por meio da tela do
administrador, use login: "teste" e senha: "123" (este empregado default é criado na execução do script.sql).__

### Diagrama para melhor representação do Sistema
<img src="https://gitlab.com/natons/EP2/tree/master/doc/diagram.jpg" alt="">