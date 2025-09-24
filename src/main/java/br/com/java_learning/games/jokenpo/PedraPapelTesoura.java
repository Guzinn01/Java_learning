package br.com.java_learning.games.jokenpo;

public enum PedraPapelTesoura {
    PEDRA,
    PAPEL,
    TESOURA;

    /**
     * Verifica se a jogada atual vence a jogada do oponente.
     * @param oponente A jogada feita pelo outro jogador.
     * @return true se esta jogada vencer, false caso contrário.
     */public boolean venceDe(PedraPapelTesoura oponente) {
         if (this == oponente) {
             return false; // Não pode vencer de si mesmo (empate)
         }

         return (this == PEDRA && oponente == TESOURA) ||
                 (this == TESOURA && oponente == PAPEL) ||
                 (this == PAPEL && oponente == PEDRA);
    }
}
