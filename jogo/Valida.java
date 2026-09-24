package jogo;
public class Valida {

    public int achaLinhaLivre(char[][] board, int coluna){//Método pra achar a última linha possível de jogar a bolinha
        //Recebe o board e valida os lugares da coluna escolhida

        if(coluna < 0 || coluna > 6){//Ve se ta dentro dos limites de coluna
            return -2; // coluna inexistente -> -2 é só pra rastrear o erro
        }

        for(int i = 5; i >= 0; i--){
            if(board[i][coluna] == 'B'){//Achou um linha mais embaixo branca nessa coluna
                return i;//retorna linha
            }
        }
        //Não achou nada, não retorna linha, e sim -1
        return -1; // Código da coluna cheia
        }

        public boolean checarEmpate(char[][] board){//Recebe o board como está
            for(int coluna = 0; coluna < 7; coluna++){//Verifica todas 7 colunas
                if(board[0][coluna] == 'B'){//da linha 1 que é o topo
                    return false;//Encontrou B em alguma delas, logo tem jogada
                }
            }

            return true; //Não encontrou nenhum B, empate
        }


        public boolean checarVitoria(char[][] board, char cor){//Método principal que verifica todos os eixos
            return checarHorizontal(board, cor) || checarVertical(board, cor)//ve se tem true
                || checarDiagonal1(board, cor) || checarDiagonal2(board, cor);//em algum deles
        }//Detecta se tem vitória horizontal, se tiver true, para ali e nem faz o resto, se não
        //Vai verificar os outros, caso todos estejam false, retorna false = sem vitória

        private boolean checarHorizontal(char[][] board, char cor){

            int contadordaVitória = 0; //Precisa chegar em 4 pra ganhar

            // percorre linhas -
            for(int linha = 0; linha < 6; linha++){ //Linha
                //na linha 0 vai ver todas as colunas
                //ou seja vai procurar linha por linha
                for(int coluna = 0; coluna < 7; coluna++){//Coluna
                    if(board[linha][coluna] == cor){
                        contadordaVitória++;//Achou igual a cor conta 1
                    } else{
                        contadordaVitória = 0;//Achou diferente reseta
                    }

                    if(contadordaVitória == 4){//Se contou 4 vezes seguidas
                        return true;//retorna true, porque teve vitória
                    }
                }

                contadordaVitória = 0; //Saiu da linha sem ganhar reseta contador da vitória
            }

            return false;//Saiu sem ter 4 em sequência sem vitória
        }

        private boolean checarVertical(char[][] board, char cor){
            // percorre colunas |
            int contadordaVitória = 0; //Precisa chegar em 4 pra ganhar

            // percorre coluna -
            for(int coluna = 0; coluna < 7; coluna++){ //coluna
                //na coluna 0 vai ver todas as linhas
                //ou seja vai procurar coluna por coluna
                for(int linha = 0; linha < 6; linha++){//Linha
                    if(board[linha][coluna] == cor){
                        contadordaVitória++;//Achou igual a cor conta 1
                    } else{
                        contadordaVitória = 0;//Achou diferente reseta
                    }

                    if(contadordaVitória == 4){//Se contou 4 vezes seguidas
                        return true;//retorna true, porque teve vitória
                    }
                }
                contadordaVitória = 0; //Saiu da linha sem ganhar reseta contador da vitória
            }

            return false;
        }

        private boolean checarDiagonal1(char[][] board, char cor){
            // diagonal principal \

            int contadordaVitória = 0; //Precisa chegar em 4 pra ganhar

            int coluna = 0;
            int linha = 0;
            int contador = 4;

            for (int i = 2; i >= 0; i--) {//Faz a lógica espelhada
                linha = i;

                for (int j = 0; j < contador; j++) {

                    if(board[linha][coluna] == cor){
                        contadordaVitória++;//Achou igual a cor conta 1
                    } else{
                        contadordaVitória = 0;//Achou diferente reseta
                    }

                    if(contadordaVitória == 4){//Se contou 4 vezes seguidas
                        return true;//retorna true, porque teve vitória
                    }

                    coluna++;
                    linha++;
                }

                contadordaVitória = 0;
                coluna = 0;
                contador++;
            }

            contador = 4;

            for (int i = 3; i > 0; i--) {//Faz a lógica espelhada para a outra metade
                coluna = i;
                linha = 0;

                for (int j = 0; j < contador; j++) {

                    if(board[linha][coluna] == cor){
                        contadordaVitória++;//Achou igual a cor conta 1
                    } else{
                        contadordaVitória = 0;//Achou diferente reseta
                    }

                    if(contadordaVitória == 4){//Se contou 4 vezes seguidas
                        return true;//retorna true, porque teve vitória
                    }

                    contadordaVitória = 0;
                    coluna++;
                    linha++;
                }

                contador++;
            }

            return false;
        }

        private boolean checarDiagonal2(char[][] board, char cor){
            // diagonal secundária /
            int contadordaVitória = 0; //Precisa chegar em 4 pra ganhar

            int coluna = 0;
            int linha = 0;

            for (int i = 3; i < 6; i++) {//Faz a lógica
                linha = i;//Reduzi apenas o i para 3 para verificar apenas diagoneis que tem 4 ou mais elementos

                for (int j = 0; j <= i; j++) {

                    if(board[linha][coluna] == cor){
                        contadordaVitória++;//Achou igual a cor conta 1
                    } else{
                        contadordaVitória = 0;//Achou diferente reseta
                    }

                    if(contadordaVitória == 4){//Se contou 4 vezes seguidas
                        return true;//retorna true, porque teve vitória
                    }

                    coluna++;
                    linha--;
                }
                contadordaVitória = 0;
                coluna = 0;
            }

            coluna = 6; //Coluna máxima = 7
            linha = 5; //Linha máxima = 6

            for (int i = 2; i >= 0; i--) {//Mesma lógica ao contrário
                linha = i; //Reduzi apenas o i para 2 para verificar apenas diagoneis que tem 4 ou mais elementos

                for (int j = 6; j > i; j--) {
                    if(board[linha][coluna] == cor){
                        contadordaVitória++;//Achou igual a cor conta 1
                    } else{
                        contadordaVitória = 0;//Achou diferente reseta
                    }

                    if(contadordaVitória == 4){//Se contou 4 vezes seguidas
                        return true;//retorna true, porque teve vitória
                    }

                    coluna--;
                    linha++;
                }

                contadordaVitória = 0;
                coluna = 6;
            }

            return false;
        }
}