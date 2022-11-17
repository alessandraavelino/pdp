public class Validacao {
    int col = 9;
    int row = 9;
    int minas = 10;
    char[][] campo;
    

    public boolean voceGanhou(char[][] novoCampo) {
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
    
    public boolean validaCoordenada(int y, int x) {
        return y >= 0 && y < row && x >= 0 && x < col;
    }

    

    
    
}
