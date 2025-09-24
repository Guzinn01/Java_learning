package br.com.java_learning;

import br.com.java_learning.games.JogodaVelha.JogodaVelha;
import br.com.java_learning.games.jokenpo.JokenpoGame;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean sair = false;

        while (!sair) {
            System.out.println("\n---MENU DE JOGOS---");
            System.out.println("1 - Jogar Jokenpo");
            System.out.println("2 - Jogar Jogo da Velha");
            System.out.println("3 - Sair");
            System.out.print("Digite sua escolha: ");

            String escolha = scanner.nextLine();

            switch (escolha) {
                case "1":
                    JokenpoGame jokenpo = new JokenpoGame(scanner);
                    jokenpo.jogar();
                    break;
                case "2":
                    // --- Início da Lógica do Sub-menu ---
                    escolherModoJogoDaVelha(scanner);
                    break;
                case "3":
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
        System.out.println("Obrigado por jogar!");
        scanner.close();
    }

    // --- NOVO MÉTODO PARA O SUB-MENU ---
    private static void escolherModoJogoDaVelha(Scanner scanner) {
        while (true) {
            System.out.println("\n--- Jogo da Velha: Modo de Jogo ---");
            System.out.println("1 - Jogador vs Jogador");
            System.out.println("2 - Jogador vs Máquina");
            System.out.println("3 - Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            String modo = scanner.nextLine();

            JogodaVelha jogoDaVelha;
            switch (modo) {
                case "1":
                    // Inicia o jogo no modo Jogador vs Jogador
                    jogoDaVelha = new JogodaVelha(scanner, false); // false = não é contra a máquina
                    jogoDaVelha.jogar();
                    return; // Retorna para o menu principal após o jogo
                case "2":
                    // Inicia o jogo no modo Jogador vs Máquina
                    jogoDaVelha = new JogodaVelha(scanner, true); // true = é contra a máquina
                    jogoDaVelha.jogar();
                    return; // Retorna para o menu principal após o jogo
                case "3":
                    return; // Simplesmente volta
                default:
                    System.out.println("Opção inválida, tente novamente.");
                    break;
            }
        }
    }
}