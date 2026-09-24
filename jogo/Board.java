package jogo;
public class Board {

    public void criarBoard(char[][] board){//Cria o board inicial -> Tudo branco Vazio sem peças
        for(int i = 0; i < 6; i++){ //Linha
            for(int j = 0; j < 7; j++){//Coluna
                board[i][j] = 'B';//Coloca B de branco em tudo
            }
        }
    }

    public void imprimirBoard(char[][] board){


        for(int i = 0; i < 6; i++){ //Linha
            System.out.print((i + 1) + " ");
            for(int j = 0; j < 7; j++){//Coluna
                System.out.print("| ");
                System.out.print(board[i][j]);//imprime dentro de uma caixinha |x| |y|
                System.out.print(" | ");
            }
            System.out.println();
        }

        System.out.printf("%-2d| ", 0);//Fazendo um espaçamento do 0 pra alinhas os números da coluna

        for(int i = 1; i <= 7; i++){
            System.out.printf("%-6d", (i)); //Imprimir números das colunas
        }

        System.out.println("\n");
    }
}
