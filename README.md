# 🎮 Conecta 4 — Java

Implementação de um **Conecta 4 em Java**, desenvolvido inicialmente como um exercício introdutório para praticar lógica de programação, métodos e estruturas de controle.

O projeto foi além do escopo inicial da atividade, utilizando uma organização baseada em **Programação Orientada a Objetos (POO)** e separação de responsabilidades entre as principais partes do jogo.

> Quem disse que trabalho introdutório de faculdade precisa ser chato ou básico? 👾

---

## 🕹️ Sobre o jogo

O projeto implementa uma partida de **Conecta 4 para um jogador contra o computador**.

O jogador escolhe sua cor e realiza suas jogadas selecionando uma das 7 colunas do tabuleiro. O objetivo é formar uma sequência de quatro peças da mesma cor na horizontal, vertical ou diagonal.

O adversário é controlado pelo `Robozao`, uma "B.A." (**Burrice Artificial**) que escolhe suas jogadas de maneira completamente aleatória.

Ou seja: não existe estratégia, previsão de jogadas ou algoritmo de tomada de decisão.

É literalmente:

```text
Robozao:
    escolher coluna aleatória
    ↓
    verificar se pode jogar
    ↓
    jogar
```

Se você perder para ele, o próprio jogo faz questão de lembrar disso. 😂

---

## 📁 Estrutura do Projeto

```text
.
├── Main.java
│
├── jogo/
│   ├── Board.java
│   ├── Conecta4.java
│   ├── Jogador.java
│   ├── LimparTela.java
│   ├── Robozao.java
│   └── Valida.java
│
└── testes/
    ├── DebugandoVisualmente.java
    └── TestandoLogica.java
```

### `Main.java`

É o ponto de entrada da aplicação.

Sua responsabilidade é apenas iniciar o jogo, chamando a execução da classe `Conecta4`.

A lógica da partida não fica concentrada no `Main`.

### `jogo/Conecta4.java`

Controla o fluxo principal da partida.

É responsável por coordenar:

* Inicialização do tabuleiro
* Definição das cores
* Turnos do jogador e do robô
* Verificação de vitória
* Verificação de empate
* Reinício das partidas
* Controle do número de rodadas

A classe utiliza os objetos das demais classes para executar cada etapa do jogo.

### `jogo/Board.java`

Responsável pela criação e exibição do tabuleiro.

Possui métodos para:

* Criar o tabuleiro vazio
* Imprimir o estado atual do tabuleiro no console

O tabuleiro possui **6 linhas e 7 colunas**, seguindo a estrutura tradicional do Conecta 4.

### `jogo/Jogador.java`

Responsável pela interação com o jogador.

Entre suas funções estão:

* Escolha da cor
* Entrada das jogadas
* Validação básica da entrada
* Solicitação de uma nova partida
* Sorteio de quem começa quando necessário

A classe utiliza `Scanner` para receber informações através do terminal.

### `jogo/Robozao.java`

Representa o adversário controlado pelo computador.

O `Robozao` escolhe aleatoriamente uma das 7 colunas e verifica se existe espaço disponível antes de realizar a jogada.

Não existe algoritmo estratégico ou análise do estado do tabuleiro.

**É aleatório mesmo.**

Por isso:

> **B.A. = Burrice Artificial**

O projeto também possui mensagens no console para provocar o jogador caso ele demore demais para vencer ou consiga perder para o robô.

### `jogo/Valida.java`

Centraliza as principais regras e validações do jogo.

É responsável por:

* Encontrar a linha disponível em uma coluna
* Detectar colunas inválidas
* Detectar colunas cheias
* Verificar empate
* Verificar condições de vitória

A vitória é verificada nos quatro possíveis eixos:

* Horizontal
* Vertical
* Diagonal `\`
* Diagonal `/`

A classe retorna os resultados das validações para que `Conecta4` possa controlar o fluxo da partida.

### `jogo/LimparTela.java`

Utilizada para organizar a apresentação inicial do jogo no terminal, criando o espaçamento necessário antes do início da partida.

---

## 🧪 Testes e Debug

Uma das partes do projeto foi separar a verificação da lógica do jogo da execução normal da partida.

Para isso foram criadas duas classes auxiliares dentro de `testes/`.

### `TestandoLogica.java`

Utilizada para testar diretamente a lógica de validação do jogo.

Isso permite montar estados específicos do tabuleiro e verificar se os métodos de `Valida` identificam corretamente:

* Vitórias horizontais
* Vitórias verticais
* Vitórias diagonais
* Empates
* Situações sem vitória

Dessa forma, não é necessário jogar uma partida inteira manualmente para reproduzir determinado cenário.

### `DebugandoVisualmente.java`

Utilizada durante o desenvolvimento para visualizar estados específicos do tabuleiro e auxiliar na investigação dos resultados das validações.

Essa abordagem ajudou principalmente na implementação e depuração das verificações diagonais, que possuem uma lógica mais trabalhosa devido às diferentes posições possíveis no tabuleiro.

---

## 🧠 Organização e POO

Embora o projeto tenha começado como uma atividade para praticar fundamentos de programação, a implementação foi estruturada de forma a separar responsabilidades.

De maneira simplificada:

```text
Main
  │
  ▼
Conecta4
  │
  ├── Board
  │     └── Tabuleiro
  │
  ├── Jogador
  │     └── Entrada do usuário
  │
  ├── Robozao
  │     └── Jogadas aleatórias
  │
  ├── Valida
  │     ├── Jogadas
  │     ├── Vitória
  │     └── Empate
  │
  └── LimparTela
        └── Organização do terminal
```

A ideia foi evitar concentrar toda a implementação no `Main` e distribuir as responsabilidades entre classes específicas.

Esse projeto serviu como uma introdução prática a conceitos que seriam aprofundados posteriormente na disciplina de **Programação Orientada a Objetos**.

---

## ⚙️ Tecnologias

* **Java**
* **JDK**
* Programação Orientada a Objetos
* `Scanner`
* `Random`
* Arrays bidimensionais
* Console / Terminal

---

## 🚀 Como executar

### Pré-requisito

É necessário possuir o **JDK (Java Development Kit)** instalado.

### Executando pela IDE

Abra o projeto em uma IDE compatível com Java e execute:

```text
Main.java
```

### Executando pelo terminal

A partir da pasta raiz do projeto:

```bash
javac Main.java jogo/*.java
```

Depois:

```bash
java Main
```

---

## 🎯 Objetivo do projeto

O projeto começou como uma atividade simples para praticar fundamentos de Java, mas foi utilizado como uma oportunidade para experimentar uma estrutura mais organizada e antecipar conceitos de POO.

Os principais objetivos foram:

* Praticar lógica de programação
* Reforçar fundamentos de Java
* Trabalhar com arrays bidimensionais
* Separar responsabilidades entre classes
* Isolar e testar regras do jogo
* Praticar debugging
* Ter um primeiro contato mais prático com organização orientada a objetos

O resultado é um projeto relativamente simples em escopo, mas que serviu como uma boa base para evoluir dos exercícios básicos de programação para uma estrutura mais próxima de uma aplicação real.

---

## 🤖 Sobre a B.A.

A inteligência artificial do projeto possui uma tecnologia extremamente avançada.

Ela faz:

```java
coluna = random.nextInt(7);
```

E funciona.

Às vezes.

Bom, pelo menos ela não cobra salário.

---

<p align="center">
🎮 Feito para praticar Java, lógica de programação e POO.
</p>
