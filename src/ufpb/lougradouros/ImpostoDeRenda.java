package ufpb.lougradouros;

import ufpb.jogo.Jogador;

public class ImpostoDeRenda implements Posicao {

	private int posicao;
	/**
	 * Constructor from class ImpostoDeRenda, enables initialization of position attribute. 
	 *@author Amanda
	 *@param int posicao - the position
	 **/
	public ImpostoDeRenda(int posicao) {
		this.posicao = posicao;
	}

	/**
	 * Method that enables the access to position number attribute. 
	 * @author Amanda
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
