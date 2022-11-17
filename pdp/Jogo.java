import java.util.Scanner;

public class Jogo {
    int col = 9;
    int row = 9;
    int minas = 10;
    char[][] campo;
    Scanner sc = new Scanner(System.in);

    Validacao validacao = new Validacao();
    
    Campo tabuleiro = new Campo();
    //começa o jogo
    public void jogo() {
        char[][] novoCampo = new char[row][col];
        tabuleiro.iniciaCampo(novoCampo);
        tabuleiro.desenhaCampo(novoCampo);
        System.out.println("Digite as coordenadas que você gostaria de testar: (x y)");
        int x = sc.nextInt();
        int y = sc.nextInt();
        //verifica se a coordenada é válida
        while (!validacao.validaCoordenada(y, x)) {
            System.out.println("Coordenadas incorretas!");
            System.out.println("Digite as coordenadas que você gostaria de testar: (x y)");
            x = sc.nextInt();
            y = sc.nextInt();
        }
        //faz a validação para ter certeza que o jogador não comece o jogo perdendo
        do {
            tabuleiro.inicio();
        } while (tabuleiro.temMina(y, x) == 1);
        do {
            if (tabuleiro.campo[y][x] == '-') {
                tabuleiro.temVazio(y, x, novoCampo);
            }
            novoCampo[y][x] = tabuleiro.campo[y][x];
            if (validacao.voceGanhou(novoCampo)) {
                break;
            }
            tabuleiro.desenhaCampo(novoCampo);
            System.out.println("Digite as coordenadas que você gostaria de testar: (x y)");
            x = sc.nextInt();
            y = sc.nextInt();

            //verifica se a coordenada é válida ou se já foi utilizada
            while (!validacao.validaCoordenada(y, x) || novoCampo[y][x] != ' ') {
                System.out.println("Coordenadas incorretas!");
                System.out.println("Digite as coordenadas que você gostaria de testar: (x y)");
                x = sc.nextInt();
                y = sc.nextInt();
            }
        } while (tabuleiro.temMina(y, x) == 0);
        tabuleiro.desenhaCampo(tabuleiro.campo);
        if (tabuleiro.temMina(y, x) == 1) {
            System.out.println("Você morreu!");
        } else {
            System.out.println("Parabéns, você ganhou!");
        }
        System.out.println("Entre com um inteiro para voltar: ");
        sc.nextInt();
        System.out.print("\n");
    }

    
 
}