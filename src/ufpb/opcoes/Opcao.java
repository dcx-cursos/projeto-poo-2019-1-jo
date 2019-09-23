package ufpb.opcoes;

import ufpb.jogo.JogoFacade;

/**
 * <p>
 * Represents the interface Option(opcão).
 * </p>
 */
public interface Opcao {
	
	/**
	 * <p>
	 * </p>
	 * 
	 * @param jogo
	 * @return
	 */
	public boolean fazerOP(JogoFacade jogo);
}
