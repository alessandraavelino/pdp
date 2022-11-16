import java.util.Random;

public class Campo {
    static int col = 9;
    static int row = 9;
    static int minas = 10;
    static char[][] campo;

    public static void desenhaCampo(char[][] a) {
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

    public static void colocarBomba(){
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
            }{

        }
    }
}
