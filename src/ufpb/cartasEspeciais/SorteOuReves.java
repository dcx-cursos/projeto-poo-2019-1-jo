package ufpb.cartasEspeciais;

import ufpb.jogo.Jogador;
import ufpb.lougradouros.Posicao;

public class SorteOuReves implements Posicao {
	private int posicaoNoTabuleiro;
	
	public SorteOuReves(int posicao) {
		this.posicaoNoTabuleiro = posicao;
		
	}

	@Override
	public int getNumeroDePosicao() {
		// TODO Auto-generated method stub
		return 0;
	}


}
