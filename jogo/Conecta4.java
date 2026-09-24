package jogo;
public class Conecta4 {

    private LimparTela flush;
    private Board boardObj; //Chamando as classes que uso
    private Valida valida; //Dando nomes a elas

    private Jogador player;
    private Robozao roboIA;

    private char[][] board = new char[6][7]; //Cria o vetor do Board e define os limite
    private char corJogador; //Cor do jogador
    private char corRobo; //Cor do robô

    private boolean jogar = true;
    private int rodada = 0;

    public Conecta4(){
        boardObj = new Board(); //Chamar as classes para chamar os métodos
        valida = new Valida(); //Assim é possível chamar método por método

        player = new Jogador(); //Métodos do jogador
        roboIA = new Robozao(); //Métodos da nossa B.A. Burrice Artificial

        flush = new LimparTela(); //Flushzinho bonito
    }

    public void Jogar(){

        flush.flush();

        corJogador = 'B'; //Cria jogador com uma cor "Branca" para inicializar a variável
        corRobo = 'B';// (Acabei de ver enquanto escrevia que não precisaria mas vou deixar por padrão)

        boardObj.criarBoard(board); //Chama os métodos para criar
        boardObj.imprimirBoard(board);//E imprimir o board

        corJogador = player.corJogador();//Chama o método pra definir e exibir a cor do jogador
        corRobo = roboIA.corRobo(corJogador);//e a cor do robo

        player.exibeCores(corJogador);

        do{

            rodada++;//Somas contador da rodada pra saber só

            player.jogadaJogador(board, corJogador);//Chama o método da jogada

            boardObj.imprimirBoard(board);//Imprime

            if(valida.checarVitoria(board, corJogador)){//Ve se tem vitória - se tiver imprime que jogador ganhou
                System.out.println("Parabéns parece que você derrotou o seu grande inimigo na rodada " + rodada);
                if(rodada <= 8){
                    System.out.println("E rápida assim, jogadas profissionais");
                } else if(rodada <= 14){
                    System.out.println("Ééé, demorou um pouco. Meio meh né");
                } else {
                    System.out.println("Caraca mas demorou hein. Tava tão difícil assim?");
                }

                System.out.println("\n");
                jogar = player.jogarDenovo();//Faz o método que pede se quer jogar de novo
                System.out.println("\n");//Caso ele queira, o jogar vai ser true

                if(jogar == true){//Se ele quer jogar denovo, jogar == true ent entra aqui
                    boardObj.criarBoard(board);//Reseta o board
                    System.out.println("NOVA RODADA!");
                    boardObj.imprimirBoard(board);//Imprime ele

                    corJogador = player.corJogador();//Chama o método pra definir denovoa cor do jogador e do robo
                    corRobo = roboIA.corRobo(corJogador);

                    player.exibeCores(corJogador);//exibe
                    rodada = 0;//volta rodada 0
                }
                continue;//Continua pra pular direto la pro while, pra não acontecer a jogada do robo
                //Não pode acontecer jogada do robo pq o player ganhou, logo cabo o jogo
            }

            System.out.println("Seu inimigo mortal escolheu sabiamente a coluna -> " + roboIA.jogadaIA(board, corRobo));
            boardObj.imprimirBoard(board);//Jogada do robo e imprime o board

            if(valida.checarVitoria(board, corRobo)){//valida se ele ganhou, se sim imprime que robo ganhou
                System.out.println("Não! Não acredito que você perdeu para uma Burrice Artificial na rodada " + rodada);
                if(rodada < 8){
                    System.out.println("E em menos de 8 jogadas??? Sabe que a B.A. joga aleatóriamente né? Manda um email pra procuramospessoascomQIbaixo@gmail.com");
                } else if(rodada <= 12){
                    System.out.println("Ééé, durou um pouco. Mas ainda é pior que perder para criança, sabe disso né?");
                } else {
                    System.out.println("E demorou ainda. Como que você conseguiu? Manda um email pra procuramospessoascomQIbaixo@gmail.com");
                }

                System.out.println("\n");
                jogar = player.jogarDenovo();//ve se o player quer jogar dnv e blablabla msm lógica
                System.out.println("\n");

                if(jogar == true){
                    boardObj.criarBoard(board);
                    System.out.println("NOVA RODADA!");
                    boardObj.imprimirBoard(board);

                    corJogador = player.corJogador();//Chama o método pra definir denovoa cor do jogador e do robo
                    corRobo = roboIA.corRobo(corJogador);

                    player.exibeCores(corJogador);
                    rodada = 0;
                }
                continue;//continua
            }

            if(valida.checarEmpate(board)){//Valida se tem empate, se tiver entra aqui
                System.out.println("Parece que Empatou na rodada " + rodada + "! Sem vitoriosos por enquanto!");

                jogar = player.jogarDenovo();//pede se quer jogar denovo e msm logica

                if(jogar == true){
                    boardObj.criarBoard(board);
                    System.out.println("NOVA RODADA!");
                    boardObj.imprimirBoard(board);

                    corJogador = player.corJogador();//Chama o método pra definir denovoa cor do jogador e do robo
                    corRobo = roboIA.corRobo(corJogador);

                    System.out.println("\n");

                    player.exibeCores(corJogador);
                    rodada = 0;
                }
            }
        }while(jogar);
    }
}
