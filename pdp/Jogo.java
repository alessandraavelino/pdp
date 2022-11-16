import java.util.Scanner;
import java.util.Random;

public class Jogo {
    static int col = 9;
    static int row = 9;
    static int minas = 10;
    static char[][] campo;
    static Scanner sc = new Scanner(System.in);
    
    public static void jogo() {
        char[][] novoCampo = new char[row][col];
        iniciaCampo(novoCampo);
        Campo.desenhaCampo(novoCampo);
        System.out.println("Digite as coordenadas que você gostaria de testar: (x y)");
        int x = sc.nextInt();
        int y = sc.nextInt();
        //verifica se a coordenada é válida
        while (!validaCoordenada(y, x)) {
            System.out.println("Coordenadas incorretas!");
            System.out.println("Digite as coordenadas que você gostaria de testar: (x y)");
            x = sc.nextInt();
            y = sc.nextInt();
        }
        //faz a validação para ter certeza que o jogador não comece o jogo perdendo
        do {
            inicio();
        } while (temMina(y, x) == 1);
        do {
            if (campo[y][x] == '-') {
                temVazio(y, x, novoCampo);
            }
            novoCampo[y][x] = campo[y][x];
            if (voceGanhou(novoCampo)) {
                break;
            }
            Campo.desenhaCampo(novoCampo);
            System.out.println("Digite as coordenadas que você gostaria de testar: (x y)");
            x = sc.nextInt();
            y = sc.nextInt();
            //verifica se a coordenada é válida ou se já foi utilizada
            while (!validaCoordenada(y, x) || novoCampo[y][x] != ' ') {
                System.out.println("Coordenadas incorretas!");
                System.out.println("Digite as coordenadas que você gostaria de testar: (x y)");
                x = sc.nextInt();
                y = sc.nextInt();
            }
        } while (temMina(y, x) == 0);
        Campo.desenhaCampo(campo);
        if (temMina(y, x) == 1) {
            System.out.println("Você morreu!");
        } else {
            System.out.println("Parabéns, você ganhou!");
        }
        System.out.println("Entre com um inteiro para voltar: ");
        sc.nextInt();
        System.out.print("\n");
        Menu.menu();
    }

    public static void inicio() {
        campo = new char[row][col];
        //inicia o campo com espaços em branco
        for (int y = 0; y < row; y++) {
            for (int x = 0; x < col; x++) {
                campo[y][x] = '-';
            }
        }
        //coloca as bombas
        Campo.colocarBomba();
        //coloca as dicas/números
    }

    //inicia o campo com espaços em branco
    public static void iniciaCampo(char[][] a) {
        for (int y = 0; y < row; y++) {
            for (int x = 0; x < col; x++) {
                a[y][x] = ' ';
            }
        }
    }

    //checa quantas minas tem ao redor
    public static char quantasMinas(int y, int x) {
        int contMinas = 0;
        contMinas += temMina(y - 1, x - 1);  // noroeste
        contMinas += temMina(y - 1, x);      // norte
        contMinas += temMina(y - 1, x + 1);  // nordeste
        contMinas += temMina(y, x - 1);      // oeste
        contMinas += temMina(y, x + 1);      // leste
        contMinas += temMina(y + 1, x - 1);  // sudoeste
        contMinas += temMina(y + 1, x);      // sul
        contMinas += temMina(y + 1, x + 1);  // sudeste
        if (contMinas > 0) {
            return (char) (contMinas + 48);
        } else {
            return '-';
        }
    }

    public static void temVazio(int y, int x, char[][] novoCampo) {
        //aqui aplicamos uma variante do algoritmo recursivo de flood fill
        //onde estiver vazio ele irá completar dentro da matriz se estiver próximo
        if (campo[y][x] != '-') {
            novoCampo[y][x] = campo[y][x];
            return;
        } else if (novoCampo[y][x] == '-') {
            return;
        } else {
            novoCampo[y][x] = '-';
        }
        if (y + 1 < row) {
            temVazio(y + 1, x, novoCampo);
        }
        if (y - 1 >= 0) {
            temVazio(y - 1, x, novoCampo);
        }
        if (x + 1 < col) {
            temVazio(y, x + 1, novoCampo);
        }
        if (x - 1 >= 0) {
            temVazio(y, x - 1, novoCampo);
        }
    }

    //checa se tem mina no local
    public static int temMina(int y, int x) {
        if (y >= 0 && y < row && x >= 0 && x < col) {
            if (campo[y][x] == '*') {
                return 1;
            } else {
                return 0;
            }
        } else {
            return 0;
        }
    }

    //imprime o campo no console
    

    //checa se a coordenada é válida para evitar array out of boundaries
    public static boolean validaCoordenada(int y, int x) {
        return y >= 0 && y < row && x >= 0 && x < col;
    }

    //checa se o número de casas em branco são iguais ao número de minas
    //se for, então você ganhou o jogo
    public static boolean voceGanhou(char[][] novoCampo) {
        int cont = 0;
        for (int y = 0; y < row; y++) {
            for (int x = 0; x < col; x++) {
                if (novoCampo[y][x] == ' ') {
                    cont++;
                }
            }
        }
        return cont == minas;
    }


}