package ufpb.opcoes;

import ufpb.jogo.JogoFacade;

/**
 * <p>
 * Represents class that the player throws the dices.
 * </p>
 *
 */
public class Jogar implements Opcao {

	protected int dado1;
	protected int dado2;

	/**
	 * <p>
	 * When the player throws the dices.
	 * </p>
	 * 
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

		sumDados(jogo);
		return true;

	}

	/**
	 * <p>
	 * Add up the dices' values.
	 * </p>
	 * 
	 * @param jogo JogoFacade
	 */
	public void sumDados(JogoFacade jogo) {
		jogo.JogadorAtual().jogada(this.dado1, this.dado2, jogo);
		jogo.chamarEvento();

	}

}
