package ufpb.lougradouros;

import ufpb.jogo.JogoFacade;

public class PontoDePartida implements Posicao {
	private int posicao;

	/**
	 * Constructor from class PontoDePartida, enables initialization of position attribute. 
	 *@author Clebson
	 *@param int posicao - the position
	 **/
	public PontoDePartida(int posicao) {
		this.posicao = posicao;
	}

	/**
	 * Method that enables the access to position number attribute. 
	 * @author Clebson
	 * @return int - position number attribute value
	 */
	@Override
	public int getNumeroDePosicao() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public String toString() {
		return this.posicao+" - Ponto de partida";  
	}

	@Override
	public void evento(JogoFacade jogo) {
		System.out.println("Nada aconteceu"+jogo.JogadorAtual().getNome());
	}

	@Override
	public String getTipo() {
		return "Ponto de partida ";
	}
	
}
