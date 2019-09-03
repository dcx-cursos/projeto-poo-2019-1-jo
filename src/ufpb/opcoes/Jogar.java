package ufpb.opcoes;

import ufpb.jogo.JogoFacade;

public class Jogar implements Opcao {
	protected int dado1;
	protected int dado2;

	/**
	 *
	 * @author Clebson
	 * @param jogo
	 */
	@Override
	public boolean fazerOP(JogoFacade jogo) {
		this.dado1 = jogo.lancaDados();
		this.dado2 = jogo.lancaDados();

		int[] array = new int[2];
		array[0] = dado1;
		array[1] = dado2;
		jogo.setUltimosDados(array);

		/**
		 *
		 * @author Amanda
		 * @return true(boolean)
		 */
		sumDados(jogo);
		return true;

	}

	/**
	 * 
	 * @author Amanda
	 * @param jogo JogoFacade
	 */
	public void sumDados(JogoFacade jogo) {
		jogo.JogadorAtual().jogada(this.dado1, this.dado2, jogo);
		jogo.chamarEvento();

	}

}
