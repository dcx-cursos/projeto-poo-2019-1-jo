package ufpb.lougradouros;

import ufpb.jogo.JogoFacade;
import ufpb.lougradouros.Posicao;

public class PosicaoSorteOuReves implements Posicao {
	private int posicaoNoTabuleiro;
	
	/**
	 * Constructor from class SorteOuReves, enables initialization of position on the board attributes. 
	 * @author Joyce
	 * @param posicao 
	 * @param int posicaoNoTabuleiro - the player's position on the board
	  */
	public PosicaoSorteOuReves(int posicao) {
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
	public void evento(JogoFacade jogo) {
		jogo.getCarta().acao(jogo.JogadorAtual());
	}

	@Override
	public String getTipo() {
		// TODO Auto-generated method stub
		return "Sorte ou reves";
	}


}
