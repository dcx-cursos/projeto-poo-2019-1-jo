package ufpb.opcoes;

import ufpb.jogo.JogoFacade;

public class Sair implements Opcao {

	@Override
	public boolean fazerOP(JogoFacade jogo) {
		if(jogo.getNumeroDeJogadores() > 2) {
			jogo.removeJogador();
		}else {
			System.out.println("B");
			System.exit(0);
		}
		return false;
	}

}
