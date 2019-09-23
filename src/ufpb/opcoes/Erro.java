package ufpb.opcoes;

import ufpb.jogo.JogoFacade;

/**
 * <p>
 * </p>
 *
 */
public class Erro implements Opcao {

	/**
	 * <p>
	 * </p>
	 * Methods
	 * 
	 * @param jogo JogoFacade
	 * @return false
	 */
	@Override
	public boolean fazerOP(JogoFacade jogo) {

		return false;
	}

}
