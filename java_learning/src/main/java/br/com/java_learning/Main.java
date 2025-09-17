package br.com.java_learning;

import br.com.java_learning.games.jokenpo.JokenpoGame;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n---MENU DE JOGOS---");
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Jogar Jokenpo");
            System.out.println("2 - Jogar Jogo da Velha");
            System.out.println("3 - sair");
            System.out.print("Digite sua escolha: ");

            String opcao = scanner.nextLine();

            switch (opcao){
                case "1":
                    System.out.println("Iniciando Jokenpo...");
                    JokenpoGame jokenpo = new JokenpoGame();
                    jokenpo.jogar();
                    break;

                case "2":
                    System.out.println("Jogo da Velha não implementado ainda.");
                    break;

                case "0":
                    System.out.println("Fim do Jogo...");
                    scanner.close();
                    return;

                default:

                    System.out.println("Opção invalida! Porfavor, tente novamente");
                    break;
            }
        }



    }
}