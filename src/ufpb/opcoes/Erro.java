package ufpb.opcoes;

import ufpb.jogo.JogoFacade;

public class Erro implements Opcao{

	@Override
	public boolean fazerOP(JogoFacade jogo) {
		
		return false;
	}

}
