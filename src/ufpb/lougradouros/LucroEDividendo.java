package ufpb.lougradouros;

import ufpb.jogo.JogoFacade;

public class LucroEDividendo implements Posicao {

	private int posicao;
	/**
	 * Constructor from class LucroEDividendo, enables initialization of position attribute. 
	 *@author Joana
	 *@param int posicao - the position
	 **/
	public LucroEDividendo(int posicao) {
		this.posicao = posicao;
	}


	/**
	 * Method that enables the access to position number attribute. 
	 * @author Joana
	 * @return int - position number attribute value
	 */
	@Override
	public int getNumeroDePosicao() {
		return this.posicao;
	}
	
	@Override
	public void evento(JogoFacade jogo) {
		System.out.println("Você ganhou 200");
		jogo.JogadorAtual().receber(200);
	}


	@Override
	public String getTipo() {
		return "Lucro e dividendo";
	}

	public String toString() {
		return this.posicao + " - Lucros ou Dividendos";
	}
	
	
}
