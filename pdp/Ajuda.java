import java.util.Scanner;

public class Ajuda {
    static Scanner sc = new Scanner(System.in);
    
    public static void ajuda() {
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
        Menu.menu();
    }
}