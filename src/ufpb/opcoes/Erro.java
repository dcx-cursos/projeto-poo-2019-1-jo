package ufpb.opcoes;

import ufpb.jogo.JogoFacade;

public class Erro implements Opcao{
	
	/**
	 * Methods
	 * 
	 * @author Clebson
	 * @param jogo JogoFacade
	 * @return false
	 */
	@Override
	public boolean fazerOP(JogoFacade jogo) {
		
		return false;
	}

}
