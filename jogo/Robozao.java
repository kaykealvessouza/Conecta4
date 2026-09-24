package jogo;
import java.util.Random;

public class Robozao {

    Random random = new Random();
    Valida validaJogada = new Valida();

    public char corRobo(char corJogador){
        if (corJogador == 'V'){//Definie cor do robo
            return 'A';
        }else{
            return 'V';//Oposta da cor do jogador - logicamente
        }
    }

    public int jogadaIA(char[][] board, char corRobo){
        //Inteligência extremamente avançada do B.A.
        //Possui essa rede neural avançada que exige muito processamento para escolher sabiamente
        //sua tomada de decisão = aleatório

        int linha;
        int coluna;

        do{
            coluna = random.nextInt(7);
            linha = validaJogada.achaLinhaLivre(board, coluna);//Se não achar coluna vazia, lina -1
            //Repete e Sortea outra coluna
        }while(linha < 0);

        board[linha][coluna] = corRobo;

        return coluna + 1;//Aumenta em um a coluna pra exibir pro jogador
    }
}
