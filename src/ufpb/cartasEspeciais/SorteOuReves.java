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

	/**
	 * Method that enables the access to number positon attribute
	 * @author Joyce
	 * @return int - number position attribute value
	 */
	@Override
	public int getNumeroDePosicao() {
		// TODO Auto-generated method stub
		return 0;
	}


}
