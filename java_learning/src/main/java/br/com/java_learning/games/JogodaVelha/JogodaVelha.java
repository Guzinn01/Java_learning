package br.com.java_learning.games.JogodaVelha;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class JogodaVelha {

    private Tabuleiro tabuleiro;
    private char jogadorAtual;
    private Scanner scanner;
    private final Random random = new Random();
    private final boolean contraMaquina; // Nova variável para guardar o modo de jogo

    // O construtor agora recebe o modo de jogo
    public JogodaVelha(Scanner scanner, boolean contraMaquina) {
        this.scanner = scanner;
        this.contraMaquina = contraMaquina; // Armazena o modo
        this.tabuleiro = new Tabuleiro();
        this.jogadorAtual = 'X';
    }

    public void jogar() {
        String titulo = contraMaquina ? "(Você 'X' vs. Máquina 'O')" : "(Jogador 'X' vs. Jogador 'O')";
        System.out.println("--- Início do Jogo da Velha " + titulo + " ---");
        boolean jogoAtivo = true;

        while (jogoAtivo) {
            tabuleiro.imprimirTabuleiro();

            // --- LÓGICA PRINCIPAL ATUALIZADA ---
            // Se for modo contra máquina E a vez for do jogador 'O', a máquina joga
            if (contraMaquina && jogadorAtual == 'O') {
                jogadaDaMaquina();
            } else {
                // Caso contrário (é a vez do 'X' ou modo PvsP), um humano joga
                processarJogada();
            }

            if (tabuleiro.verificarVitoria(jogadorAtual)) {
                tabuleiro.imprimirTabuleiro();
                System.out.println("O jogador '" + jogadorAtual + "' venceu!");
                jogoAtivo = false;
            } else if (tabuleiro.isCheio()) {
                tabuleiro.imprimirTabuleiro();
                System.out.println("O jogo empatou!");
                jogoAtivo = false;
            } else {
                trocarJogador();
            }
        }
    }

    private void jogadaDaMaquina() {
        System.out.println("Vez da Máquina ('O')...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) { /* Ignora */ }

        List<int[]> jogadasPossiveis = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tabuleiro.isJogadaValida(i, j)) {
                    jogadasPossiveis.add(new int[]{i, j});
                }
            }
        }

        int[] jogadaEscolhida = jogadasPossiveis.get(random.nextInt(jogadasPossiveis.size()));
        int linha = jogadaEscolhida[0];
        int coluna = jogadaEscolhida[1];

        tabuleiro.fazerJogada(linha, coluna, jogadorAtual);
        System.out.println("A Máquina jogou na linha " + (linha + 1) + ", coluna " + (coluna + 1));
    }

    private void processarJogada() {
        int linha, coluna;
        while (true) {
            try {
                // A mensagem agora é genérica para o jogador da vez
                System.out.print("Jogador '" + jogadorAtual + "', digite a linha (1-3): ");
                linha = scanner.nextInt() - 1;
                System.out.print("Jogador '" + jogadorAtual + "', digite a coluna (1-3): ");
                coluna = scanner.nextInt() - 1;
                scanner.nextLine();

                if (tabuleiro.isJogadaValida(linha, coluna)) {
                    tabuleiro.fazerJogada(linha, coluna, jogadorAtual);
                    break;
                } else {
                    System.out.println("Jogada inválida. Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                scanner.nextLine();
            }
        }
    }

    private void trocarJogador() {
        jogadorAtual = (jogadorAtual == 'X') ? 'O' : 'X';
    }
}