package ufpb.opcoes;

import ufpb.jogo.JogoFacade;

public class JogarPrisao extends Jogar {
	public void sumDados(JogoFacade jogo) {
		if (this.dado1 == this.dado2) {
			System.out.println("Tirou dados iguais!");
			jogo.setFabrica();
			int novoDado = jogo.lancaDados();
			int novoDado2 = jogo.lancaDados();
			jogo.JogadorAtual().jogada(novoDado,novoDado2,jogo);
			jogo.getPosicaoAtual().evento(jogo);
		} else {
			System.out.print("Dados não são iguais!");
		}
	}
}
