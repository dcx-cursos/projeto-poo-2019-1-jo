package ufpb.opcoes;

import ufpb.jogo.JogoFacade;

public class JogarPrisao extends Jogar {
	public void sumDados(JogoFacade jogo, int dados) {
		if(this.dado1 == this.dado2) {
			jogo = new JogoFacade();
		}
	}
}
