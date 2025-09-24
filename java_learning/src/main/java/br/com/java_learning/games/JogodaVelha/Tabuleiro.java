package br.com.java_learning.games.JogodaVelha;

public class Tabuleiro {

    private char[][] tabuleiro;

    public Tabuleiro() {
        tabuleiro = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tabuleiro[i][j] = ' ';
            }
        }
    }

    public void imprimirTabuleiro() {
        System.out.println();
        for (int i = 0; i < 3; i++) {
            System.out.print(" " + tabuleiro[i][0] + " | " + tabuleiro[i][1] + " | " + tabuleiro[i][2]);
            if (i < 2) {
                System.out.println("\n-----------");
            }
        }
        System.out.println("\n");
    }

    // --- MÉTODO IMPLEMENTADO ---
    public boolean isJogadaValida(int linha, int coluna) {
        if (linha < 0 || linha >= 3 || coluna < 0 || coluna >= 3) {
            return false;
        }
        if (tabuleiro[linha][coluna] != ' ') {
            return false;
        }
        return true;
    }

    public boolean verificarVitoria(char jogador) {
        // 1. Checar as 3 linhas
        for (int i = 0; i < 3; i++) {
            if (tabuleiro[i][0] == jogador && tabuleiro[i][1] == jogador && tabuleiro[i][2] == jogador) {
                return true; // Vitória na linha i
            }
        }

        // 2. Checar as 3 colunas
        for (int j = 0; j < 3; j++) {
            if (tabuleiro[0][j] == jogador && tabuleiro[1][j] == jogador && tabuleiro[2][j] == jogador) {
                return true; // Vitória na coluna j
            }
        }

        // 3. Checar as 2 diagonais
        // Diagonal principal (canto superior esquerdo para inferior direito)
        if (tabuleiro[0][0] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][2] == jogador) {
            return true;
        }
        // Diagonal secundária (canto superior direito para inferior esquerdo)
        if (tabuleiro[0][2] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][0] == jogador) {
            return true;
        }

        // Se nenhuma das condições acima for atendida, não há vencedor ainda
        return false;
    }

    // Método para verificar se o tabuleiro está cheio (resultando em empate)
    public boolean isCheio() {
        // Percorre todas as casas do tabuleiro
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                // Se encontrar qualquer casa vazia, o tabuleiro NÃO está cheio
                if (tabuleiro[i][j] == ' ') {
                    return false;
                }
            }
        }
        // Se o loop terminar e não encontrar nenhuma casa vazia, o tabuleiro ESTÁ cheio
        return true;
    }

    public void fazerJogada(int linha, int coluna, char jogador) {
        // Este método assume que a jogada já foi validada pelo isJogadaValida
        tabuleiro[linha][coluna] = jogador;
    }
}