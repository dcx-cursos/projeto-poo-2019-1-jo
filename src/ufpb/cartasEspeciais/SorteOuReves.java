package ufpb.cartasEspeciais;

import ufpb.jogo.Jogador;
import ufpb.lougradouros.Posicao;

public class SorteOuReves implements Posicao {
	private int posicaoNoTabuleiro;
	/**
	 * Constructor from class SorteOuReves, enables initialization of position on the board attributes. 
	 * @author Joyce
	 * @param int posicaoNoTabuleiro - the player's position on the board
	  */
	public SorteOuReves(int posicao) {
		this.posicaoNoTabuleiro = posicao;
		
	}

	@Override
	public int getNumeroDePosicao() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public String toString() {
		return this.posicaoNoTabuleiro+" Sorte ou Reves";
	}

	@Override
	public void evento(Jogador j) {
		// TODO Auto-generated method stub
		
	}


}
