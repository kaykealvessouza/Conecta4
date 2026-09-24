package testes;
public class DebugandoVisualmente {
    //No teste coloquei a lógica do for só que imprimindo V
    //Debuguei pra ver se estava fazendo em diagonal e estava, tudo certo

    private void diagonal2(){
        char[][] board = new char[6][7];

        for (int i = 0; i < 6; i++) { // Linha
            for (int j = 0; j < 7; j++) {// Coluna
                board[i][j] = 'B';// Coloca B de branco em tudo
            }//Pra criar o visual do board de exemplo
        }

        int coluna = 0;
        int linha = 0;

        for (int i = 3; i < 6; i++) {//Faz a lógica
            linha = i;//Reduzi apenas o i para 3 para verificar apenas diagoneis que tem 4 ou mais elementos

            for (int j = 0; j <= i; j++) {

                board[linha][coluna] = 'V'; //Colocar f9 aqui
                coluna++;
                linha--;

                for (int m = 0; m < 6; m++) {//Imprime o tabuleiro depois de cada inserção para debugar
                    System.out.print((m + 1) + " ");
                    for (int n = 0; n < 7; n++) {
                        System.out.print("| ");
                        System.out.print(board[m][n]);
                        System.out.print(" | ");
                    }
                    System.out.println();
                }

                System.out.printf("%-2d| ", 0);

                for (int b = 1; b <= 7; b++) {
                    System.out.printf("%-6d", (b));
                }

                System.out.println("\n");
            }

            coluna = 0;
        }

        //Fazendo esse debug percebi que ele preenchia só até a métade
        //Tentei aumentar mas não conseguia, ai fiz o mesmo for invertido
        //Para preencher assim / só que começando pelo 6.7 e vindo da direita pra esquerda

        coluna = 6; //Coluna máxima = 7
        linha = 5; //Linha máxima = 6

        for (int i = 2; i >= 0; i--) {//Mesma lógica ao contrário
            linha = i; //Reduzi apenas o i para 2 para verificar apenas diagoneis que tem 4 ou mais elementos

            for (int j = 6; j > i; j--) {

                board[linha][coluna] = 'V';//Colocar f9 aqui e debuggar
                coluna--;
                linha++;

                for (int m = 0; m < 6; m++) {
                    System.out.print((m + 1) + " ");
                    for (int n = 0; n < 7; n++) {
                        System.out.print("| ");
                        System.out.print(board[m][n]);
                        System.out.print(" | ");
                    }
                    System.out.println();
                }

                System.out.printf("%-2d| ", 0);

                for (int b = 1; b <= 7; b++) {
                    System.out.printf("%-6d", (b));
                }

                System.out.println("\n");
            }

            coluna = 6;
        }
    }

    private void diagonal1(){
        char[][] board = new char[6][7];

        for (int i = 0; i < 6; i++) { // Linha
            for (int j = 0; j < 7; j++) {// Coluna
                board[i][j] = 'B';// Coloca B de branco em tudo
            }//Pra criar o visual do board de exemplo
        }

        int coluna = 0;
        int linha = 5;
        int contador = 4;

        for (int i = 2; i >= 0; i--) {//Faz a lógica espelhada
            linha = i;

            for (int j = 0; j < contador; j++) {

                board[linha][coluna] = 'V'; //Colocar f9 aqui
                coluna++;
                linha++;

                for (int m = 0; m < 6; m++) {//Imprime o tabuleiro depois de cada inserção para debugar
                    System.out.print((m + 1) + " ");
                    for (int n = 0; n < 7; n++) {
                        System.out.print("| ");
                        System.out.print(board[m][n]);
                        System.out.print(" | ");
                    }
                    System.out.println();
                }

                System.out.printf("%-2d| ", 0);

                for (int b = 1; b <= 7; b++) {
                    System.out.printf("%-6d", (b));
                }

                System.out.println("\n");
            }

            coluna = 0;
            contador++;
        }

        contador = 4;

        for (int i = 3; i > 0; i--) {//Faz a lógica espelhada para a outra metade
            coluna = i;
            linha = 0;

            for (int j = 0; j < contador; j++) {

                board[linha][coluna] = 'V'; //Colocar f9 aqui
                coluna++;
                linha++;

                for (int m = 0; m < 6; m++) {//Imprime o tabuleiro depois de cada inserção para debugar
                    System.out.print((m + 1) + " ");
                    for (int n = 0; n < 7; n++) {
                        System.out.print("| ");
                        System.out.print(board[m][n]);
                        System.out.print(" | ");
                    }
                    System.out.println();
                }

                System.out.printf("%-2d| ", 0);

                for (int b = 1; b <= 7; b++) {
                    System.out.printf("%-6d", (b));
                }

                System.out.println("\n");
            }

            contador++;
        }
    }


    public static void main(String[] args) {
        DebugandoVisualmente testar = new DebugandoVisualmente();

        testar.diagonal1();

        testar.diagonal2();

    }
}
