import java.util.Scanner;

public class Menu {

    static Scanner sc = new Scanner(System.in);
    
    public static void menu() {
        System.out.println("1 - Iniciar");
        System.out.println("2 - Configuração");
        System.out.println("3 - Ajuda");
        System.out.println("4 - Sair");
        int opcao = sc.nextInt();
        switch (opcao) {
            case 1:
                Jogo.jogo();
                break;
            case 2:
                Configuracoes.configuracao();
                break;
            case 3:
                Ajuda.ajuda();
                break;
            case 4:
                System.out.println("Até mais, obrigado por jogar Campo Minado.");
                break;
            default:
                System.out.println("Comando inválido.");
                menu();
        }
    }
}
