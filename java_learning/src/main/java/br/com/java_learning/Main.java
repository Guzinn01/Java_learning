package br.com.java_learning;

import br.com.java_learning.games.jokenpo.JokenpoGame;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean sair = false;

        while (!sair) {
            System.out.println("\n---MENU DE JOGOS---");
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Jogar Jokenpo");
            System.out.println("2 - Jogar Jogo da Velha");
            System.out.println("3 - Sair");
            System.out.print("Digite sua escolha: ");


            String escolha = scanner.nextLine();

            switch (escolha) {
                case "1":
                    // Crie o jogo e passe o scanner para ele
                    JokenpoGame jokenpo = new JokenpoGame(scanner);
                    jokenpo.jogar();
                    break;
                case "2":
                    // Futuramente
                    System.out.println("Jogo da Velha ainda não implementado.");
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
        // final do programa
        scanner.close();
    }
}