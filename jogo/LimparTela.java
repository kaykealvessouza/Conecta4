package jogo;
public class LimparTela {
    public void flush() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}