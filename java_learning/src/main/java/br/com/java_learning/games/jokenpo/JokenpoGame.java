package br.com.java_learning.games.jokenpo;

import  java.util.Scanner;


public class JokenpoGame {
    private final PcRandom pcRandom = new PcRandom();
    private final Scanner scanner = new Scanner(System.in);

    public void jogar() {
        System.out.println("-- Jokenpo Game --");

        PedraPapelTesoura jogadaPC = pcRandom.gerarJogada();

        System.out.print("Digite sua jogada  \n| Pedra | Papel | Tesoura | \nEscreva aqui:");
        String entradaUsuario = scanner.nextLine().toUpperCase();
        PedraPapelTesoura jogadaUsuario;


        try {
            jogadaUsuario = PedraPapelTesoura.valueOf(entradaUsuario);
        } catch (IllegalArgumentException e) {
            System.out.println("Opção invalida! Fim do jogo.");
            return;
        }

        System.out.println("O computador escolheu: " + jogadaPC);

        if (jogadaUsuario == jogadaPC) {
            System.out.println("Empate!");
        } else if ((jogadaUsuario == PedraPapelTesoura.PEDRA && jogadaPC == PedraPapelTesoura.TESOURA) ||
                (jogadaUsuario == PedraPapelTesoura.TESOURA && jogadaPC == PedraPapelTesoura.PAPEL) ||
                    (jogadaUsuario == PedraPapelTesoura.PAPEL && jogadaPC == PedraPapelTesoura.PEDRA)) {
            System.out.println("Você Ganhou !");
        } else {
            System.out.println("Você Perdeu !");
        }
    }

}
