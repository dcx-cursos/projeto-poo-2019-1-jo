package ufpb.lougradouros;

import ufpb.jogo.JogoFacade;

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
		return this.posicao;
	}

	@Override
	public void evento(JogoFacade jogo) {
		System.out.println("Você pagou 200");
		jogo.JogadorAtual().pagar(200,jogo);
	}

	@Override
	public String getTipo() {
		return "Imposto de renda";
	}
	
	public String toString() {
		return this.posicao + " - Imposto de Renda";
	}
}
