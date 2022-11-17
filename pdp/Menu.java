import java.util.Scanner;
public class Menu {
    int col = 9;
    int row = 9;
    int minas = 10;
    char[][] campo;

    Scanner sc = new Scanner(System.in);
    Jogo jogo = new Jogo();
    public void menu() {
        System.out.println("1 - Iniciar");
        System.out.println("2 - Configuração");
        System.out.println("3 - Ajuda");
        System.out.println("4 - Sair");
        int opcao = sc.nextInt();
        switch (opcao) {
            case 1:
                jogo.jogo();
            case 2:
                configuracao();
                break;
            case 3:
                ajuda();
                break;
            case 4:
                System.out.println("Até mais, obrigado por jogar Campo Minado.");
                break;
            default:
                System.out.println("Comando inválido.");
                menu();
        }
    }
    public void configuracao() {
        System.out.println("Qual dificuldade?");
        System.out.println("1 - Fácil");
        System.out.println("2 - Médio");
        System.out.println("3 - Difícil");
        int dificuldade = sc.nextInt();
        switch (dificuldade) {
            case 1:
                col = 9;
                row = 9;
                minas = 10;
                break;
            case 2:
                col = 16;
                row = 16;
                minas = 40;
                break;
            case 3:
                col = 30;
                row = 16;
                minas = 99;
                break;
            default:
                System.out.println("Comando inválido.");
                configuracao();
        }
        menu();  
    }
    public void ajuda() {
        System.out.println("Campo minado é um popular jogo de computador para"
                + "um jogador. Foi inventado por Robert Donner em 1989 e tem "
                + "como objectivo revelar um campo de minas sem que alguma seja "
                + "detonada.");
        System.out.println("A área de jogo consiste num campo de quadrados "
                + "retangular. Cada quadrado pode ser revelado clicando sobre "
                + "ele, e se o quadrado clicado contiver uma mina, então o jogo "
                + "acaba. Se, por outro lado, o quadrado não contiver uma mina, "
                + "uma de duas coisas poderá acontecer:");
        System.out.println("Um número aparece, "
                + "indicando a quantidade de quadrados adjacentes que contêm "
                + "minas;");
        System.out.println("Nenhum número aparece. Neste caso, o jogo revela "
                + "automaticamente os quadrados que se encontram adjacentes ao "
                + "quadrado vazio, já que não podem conter minas;");
        System.out.println("O jogo é ganho quando todos os quadrados que não "
                + "têm minas são revelados.");
        System.out.println("Entre com um inteiro para voltar: ");
        sc.nextInt();
        menu();
    }
}
