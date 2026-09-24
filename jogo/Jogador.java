package jogo;

import java.util.Random;
import java.util.Scanner;

public class Jogador {


    private Valida validaJogada;//Chamando o método que valida a jogada e coloca bolinhas


    public Jogador(){//Construtor
        validaJogada = new Valida();
    }

    Random random = new Random();
    Scanner scan = new Scanner(System.in);

    public char corJogador(){//Define só a cor do jogador
        
        System.out.print("Qual Cor você quer ser? V - Vermelho | A - Azul -> ");
        char cor = scan.next().charAt(0);

        while(cor != 'A' && cor != 'V' && cor != 'a' && cor != 'v'){
            System.out.println("\nCor inválida, digite V ou A!");
            cor = scan.next().charAt(0);
        };

        cor = Character.toUpperCase(cor);//Deixa o char maiúsculo

        return cor;
    }

    public void exibeCores(char corJogador){
        if (corJogador == 'V'){//Definie cor do robo

            System.out.println("\nSua cor é Vermelho!");//Fala as cores
            System.out.println("E a de seu pior inimigo é Azul!");
        }else{
            System.out.println("Sua cor é Azul!");//Fala as cores
            System.out.println("E a de seu pior inimigo é Vermelho!");
        }
    }

    public void jogadaJogador(char[][] board, char corJogador){

        int linha;
        int coluna;

        do{
            System.out.print("\nEscolha a coluna na qual deseja colocar uma bolinha -> ");

            while (!scan.hasNextInt()) {//Ve se realmente é um int
                System.out.print("\nValor inválido! Digite um número: ");
                scan.next(); // descarta a entrada errada
            }

            coluna = scan.nextInt();//Pega o int colocado
            coluna --;//Diminui 1 porque o user ve 1 a 7 mas o certo é 0 a 6

            linha = validaJogada.achaLinhaLivre(board, coluna);

            if(linha == -2){
                System.out.println("Coluna inválida!");
            }

            if(linha == -1){
                System.out.println("Coluna cheia!");
            }
        }while(linha < 0);

        board[linha][coluna] = corJogador;
    }

    
    public boolean jogarDenovo(){
        System.out.print("Deseja Jogar Novamente? [S|N] -> ");
        char escolha = scan.next().charAt(0);
        escolha = Character.toUpperCase(escolha);//Deixa o char maiúsculo

        while (escolha != 'S' && escolha != 'N'){
            System.out.println("Não entendi [S] de Sim!! ou [N] de Não!!");
            escolha = scan.next().charAt(0);
            escolha = Character.toUpperCase(escolha);
        }

        if (escolha == 'S'){
            return true;
        } else{
            System.out.println("OK então fim de jogo! GG até a próxima!");
            return false;
        }
    }

    public boolean irPrimeiro(){
        //Definir quem vai primeiro
        System.out.print("Quer escolher começar? [S|N] \nSe não quiser iremos sortear!!! -> ");
        char escolha = scan.next().charAt(0);
            escolha = Character.toUpperCase(escolha);
        
            while (escolha != 'S' && escolha != 'N'){
            System.out.println("Não entendi [S] de Sim!! ou [N] de Não!!");
            escolha = scan.next().charAt(0);
            escolha = Character.toUpperCase(escolha);
        }

        if (escolha == 'S'){
            System.out.println("Ok então mimadinho, vai la primeiro! Tudo pela vantagem né!\n");
            return true;
        } else{
            System.out.println("OK então sortearemos! Boa Sorte!");
            
            return random.nextBoolean();
        }
    }
}
