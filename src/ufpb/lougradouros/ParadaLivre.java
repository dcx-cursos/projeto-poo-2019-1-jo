package ufpb.lougradouros;

import ufpb.jogo.JogoFacade;

public class ParadaLivre implements Posicao {

	private int posicao;
	/**
	 * Constructor from class ParadaLivre, enables initialization of position attribute. 
	 *@author Joyce
	 *@param int posicao - the position
	 **/
	public ParadaLivre(int posicao) {
		this.posicao = posicao;
	}

	/**
	 * Method that enables the access to position number attribute. 
	 * @author Joyce
	 * @return int - position number attribute value
	 */
	@Override
	public int getNumeroDePosicao() {
		// TODO Auto-generated method stub
		return this.posicao;
	}
	
	/**
	 * @author Joyce
	 * @return String - the position
	 */
	@Override
	public String toString() {
		return this.posicao+ "- Parada Livre";
	}
	@Override
	public void evento(JogoFacade jogo) {
		System.out.println("Nada Aconteceu.");
	}

	@Override
	public String getTipo() {
		// TODO Auto-generated method stub
		return "Parada Livre";
	}

}
