package testes;
public class TestandoLogica {
    //Classe para teste para checar diagonal
    //Lógica criada:
    //Para validar diagonal percei que começa do 0.0 - pensando da esquerda pra direita de baixo pra cima /
    //depois vai 0.1 e 1.0, depois 2.0 1.1 0.2 e assim por diante
    //Logo pensei primeiro fazer uma lógica for que printasse essa sequência
    public static void main(String[] args) {
        int coluna = 0; //Fiz contadores isolados da coluna e linha
        int linha  = 0;

        for (int i = 0; i <= 5; i++) {//For pra quantidade máxima de linha que poderia passar
            linha = i; //definir a linha para ser igual o i, para sempre ir passando pra próxima
            for (int j = 0; j <= i; j++) {//definir quantas vez pra cima direita "/" irá ir
                System.out.println(linha + " | " +coluna);
                coluna++; //Aumenta coluna dentro dessa possibilidade
                linha--; //Diminui linha para fazer essa linha /
            }

            coluna = 0; //Reseta a coluna para começar da esquerda pra direita
            //Fazendo esse print fui testar o visual dele no teste
        }
    }
}
