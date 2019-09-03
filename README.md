


# Relatório e Manual do Jogo Banco Imobiliário

  

Este repositório é destinado ao trabalho da disciplina de Programação Orientada a Objeto (POO), que é ministrada pelo professor Fábio Morais, no campus IV da Universidade Federal da Paraíba (UFPB). O responsável por este trabalho é o grupo 2, que é composto por: Amanda Azevedo, Clebson Fonseca, Joana Darck e Joyce Sousa. 

  


## 1. Introdução

### 1.1. Objetivos

O seguinte relatório apresenta projeto de Banco Imobiliário, que foi definido, pelo professor Fábio Morais, como terceira nota da disciplina de Programação Orientada a Objetos. Assim como, o relato do processo de desenvolvimento, as funcionalidades, as tecnologias usadas e a implementação, que foi efetuada para a primeira entrega deste projeto.

  

### 1.2. Tecnologias

As tecnologias usadas para a conclusão desta primeira entrega foi, a linguagem de programação Java8, a IDE (Integrated Development Environment) “Eclipse Java 2019-06” para desenvolvimento do projeto. Utilizamos o GitHub, para armazenamento e versionamento do código. Além disso utilizamos a framework de testes, JUnit5 e para criação do diagrama de classes em UML (Unified Modeling Language), utilizamos o “Astah UML”.

  

### 1.3. Entregas e Datas
As datas de entrega deste projeto está seguindo o calendário estabelecido pelo professor Fábio, sendo assim, conseguimos entregar a primeira versão dia 12 de agosto de 2019 e a segunda entrega foi feita dia 02 de setembro de 2019.

  

## 2. Desenvolvimento

### 2.1. Metodologia

Primeiramente optamos por pensar em como seriam estruturadas as classes, as interfaces e métodos, por isso desenvolvemos uma primeira versão da UML e a partir disso começamos a implementar o que foi pensado. Em seguida começamos a fazer a documentação, os testes e por fim, o relatório.
<br/>
Para segunda entrega foi desenvolvido os testes da primeira entrega, que ficaram faltando, e em seguida implementamos os Stories 5, Sorte ou Revés, 6, Prisão e 7, Companhias. Simultâneo a isso foram desenvolvidos os testes do código que estava sendo implementado e os mocks. Posteriormente documentamos o código, aprimoramos a segunda versão da UML e redigimos o relatório.
  

### 2.2. Funcionalidades disponíveis

<p>Até o momento, o Banco Imobiliário possui as funcionalidades que foram descritas nas Users Stories de número 1 a 7, criando um novo jogador, jogada no Banco Imobiliário, status e compra de títulos de propriedades. Sendo assim, o banco imobiliário descrito neste relatório possui as funcionalidades de cadastrar novos jogadores (dentro do intervalo de 2 à 8 jogadores), iniciar o jogo, jogar dados, avançar os peões dos jogadores no tabuleiro, sair do jogo, ver o status do jogador no jogo, e por fim possibilitar a compra de uma companhia ou propriedade do banco no jogo de maneira incompleta.</p>
<p>A partir do story 5 foi implementado as funcionalidades das cartas de sorte ou reves, prisão e companhias. Agora o jogador ao cair em uma posição de sorte ou reves puxa uma carta, essa carta pode ser do tipo, pague,receba,presente,vá para prisão e se livre da prisão. Ao ir para prisão, na proxima jogada o jogador terá as seguintes opções: Pagar, Carta, uma implementação diferente de jogar além das opções que teria normalmente no inicio da jogada. Agora também está disponivel as funcionalidades da companhia, se a companhia não tiver dono ela pode ser comprada, se tiver você deve pagar uma taxa para o dono, tal taxa é calculada por um multiplicador * os numeros tirado nos dados. Além disso na segunda entrega também foi implementado o uso de regex para tratamento de entradas.</p>


### 2.3. Padrões de projeto implementados
Foram implementados os seguintes padrões: 
<ul>
  <li>Facade</li>
  <li>Factory</li>
  <li>Strategy</li>
</ul>  
<h5>Como foram utilizados:</h5>
<ol> 
 <li> O padrão facade foi utilizado como uma fachada de comunicação da logica do banco imobiliario com a parte visivel para o jogador.</li>
 <li> O padrão factory foi utilizado para tratar as opções dos jogadores, quando se está na prisão, uma serie de opções está disponivel e quando não está as opções normais são usadas. Também foi usado na implementação de titulos que tinham um evento muito parecido.</li>
 <li>O padrão Strategy foi utilizado para em tempo de execução fosse feito um evento/ação do baralho/tabuleiro.</li> 
</ol>

## 3. Diagrama de classes

![enter image description here](https://raw.githubusercontent.com/dcx-cursos/projeto-poo-2019-1-jo/entrega2/diagrama-de-classes/uml-projeto-banco-imobiliario.gif)

## 4. Testes
Utilizamos o framework de testes, JUnit5 juntamente com o Mockito com a finalidade de simulação de algumas classes, assim testando algumas funcionalidades. Até o momento está implementado os testes das classes Jogador, Conta e JogoFacade.
<br/>
Na classe ContaTest, está testando o saldo após ser depositado ou debitado um certo valor. Na JogadorTest, vai testar quando jogador lança os dados e vai para a posição certa. A classe JogoFacadeTest tem testes para remover e adicionar um jogador verificar se o jogador está na prisão e para verificar se a cor escolhida é válida.
## 5. [Link para o relatório](https://github.com/dcx-cursos/projeto-poo-2019-1-jo/tree/entrega2/relatorio)

## 6. Para rodar o jogo, por favor, clone o projeto, abra a sua workspace na pasta "projeto-poo-2019-1-jo" e abra o projeto no diretório src
