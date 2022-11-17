import java.util.Random;
import java.util.Scanner;

public class Campo {
    int col = 9;
    int row = 9;
    int minas = 10;
    char[][] campo;
    Scanner sc = new Scanner(System.in);
    public void inicio() {
        campo = new char[row][col];
        //inicia o campo com espaços em branco
        for (int y = 0; y < row; y++) {
            for (int x = 0; x < col; x++) {
                campo[y][x] = '-';
            }
        }
        //coloca as bombas
        int contMinas = 0;
        Random random = new Random();
        while (contMinas < minas) {
            int x = random.nextInt(col); // gera um número entre 0 e col - 1
            int y = random.nextInt(row); // gera um número entre 0 e row - 1
            // não se pode colocar 2 minas no mesmo lugar
            if (campo[y][x] != '*') {
                campo[y][x] = '*';
                contMinas++;
            }
        }
        //coloca as dicas/números
        for (int y = 0; y < row; y++) {
            for (int x = 0; x < col; x++) {
                if (campo[y][x] != '*') {
                    campo[y][x] = quantasMinas(y, x);
                }
            }
        }
    }

    //inicia o campo com espaços em branco
    public void iniciaCampo(char[][] a) {
        for (int y = 0; y < row; y++) {
            for (int x = 0; x < col; x++) {
                a[y][x] = ' ';
            }
        }
    }

    //checa quantas minas tem ao redor
    public char quantasMinas(int y, int x) {
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

    public void temVazio(int y, int x, char[][] novoCampo) {
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
    public int temMina(int y, int x) {
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
    public void desenhaCampo(char[][] a) {
        System.out.printf("    ");
        for (int x = 0; x < col; x++) {
            System.out.printf("%4d", x);
        }
        System.out.print("\n");
        for (int y = 0; y < row; y++) {
            System.out.printf("%4d", y);
            for (int x = 0; x < col; x++) {
                System.out.printf("%4c", a[y][x]);
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    //checa se a coordenada é válida para evitar array out of boundaries
    

    //checa se o número de casas em branco são iguais ao número de minas
    //se for, então você ganhou o jogo
    
    
}
