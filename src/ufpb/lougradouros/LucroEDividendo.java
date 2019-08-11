package ufpb.lougradouros;

import ufpb.jogo.Jogador;

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
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void evento(Jogador j) {
		// TODO Auto-generated method stub

	}

}
