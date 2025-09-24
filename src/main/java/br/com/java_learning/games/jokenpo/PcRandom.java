package br.com.java_learning.games.jokenpo;

import java.util.Random;

public class PcRandom {

    public PedraPapelTesoura gerarJogada() {

        PedraPapelTesoura[] jogadaPossiveis = PedraPapelTesoura.values();

        Random random = new Random();

        int indiceAleatorio = random.nextInt(jogadaPossiveis.length);

        return jogadaPossiveis[indiceAleatorio];
    }

}
