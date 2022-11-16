import java.util.Scanner;

public class Configuracoes {
    static int col = 9;
    static int row = 9;
    static int minas = 10;
    static char[][] campo;
    static Scanner sc = new Scanner(System.in);     


    public static void configuracao() {
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
        Menu.menu();
    }
    
}
