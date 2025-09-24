package br.com.java_learning.games.jokenpo;

import  java.util.Scanner;


public class JokenpoGame {
    private final PcRandom pcRandom = new PcRandom();
    private final Scanner scanner;
    private int vitoriasJogador = 0;
    private int vitoriasPC = 0;

    public JokenpoGame(Scanner scanner) {
        this.scanner = scanner; // Aqui você cumpre a promessa de inicializar a variável final
    }

    public void jogar(){
        System.out.println("-- Bem-vindo ao Jokenpo Game --");

        while(true){
            PedraPapelTesoura jogadaUsuario = obterJogadaUsuario();
            if (jogadaUsuario ==null){ // Usuario decidiu sair
                break;
            }

            PedraPapelTesoura jogadaPC = pcRandom.gerarJogada();
            System.out.println("O computador escolheu: " + jogadaPC);

            determinarVencedor(jogadaUsuario, jogadaPC);

            System.out.println("\n--- Placar ---");
            System.out.println("Você: " + vitoriasJogador + " | PC: " + vitoriasPC);
            System.out.println("----------------\n");
        }

        System.out.println("Fim do Jogo. Obrigado por jogar!");
    }


    private PedraPapelTesoura obterJogadaUsuario(){
        while (true){
            System.out.print("Faça sua jogada - \n" +
                    "(Pedra, Papel, Tesoura) ou digite 'Sair' para terminar: ");

            String entrada = scanner.nextLine().toUpperCase();

            if ("SAIR".equalsIgnoreCase(entrada)){
                return null;
            }

            try{
                return PedraPapelTesoura.valueOf(entrada);
            }catch(IllegalArgumentException e){
                System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }

    private void determinarVencedor(PedraPapelTesoura jogadaUsuario, PedraPapelTesoura jogadaPC){
        if (jogadaUsuario == jogadaPC){
            System.out.println("Resultado: Empate!");
        } else if (jogadaUsuario.venceDe(jogadaPC)) {
            System.out.println("Resultado: Você Ganhou!");
            vitoriasJogador++;

        }else {
            System.out.println("Resultado: Você Perdeu!");
            vitoriasPC++;
        }
    }
}
