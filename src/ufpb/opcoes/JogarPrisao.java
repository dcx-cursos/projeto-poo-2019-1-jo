package ufpb.opcoes;

import ufpb.jogo.JogoFacade;

public class JogarPrisao extends Jogar {
	public void sumDados(JogoFacade jogo) {
		if (this.dado1 == this.dado2) {
			System.out.println("Tirou dados iguais!");
			jogo.setFabrica();
			int novoDado = jogo.lancaDados();
			int novoDado2 = jogo.lancaDados();
			jogo.JogadorAtual().avancarCasas(novoDado+novoDado2);
			System.out.println(jogo.JogadorAtual() + "tirou " +novoDado + ","+novoDado2 + "e o peão avançou "+jogo.getPosicaoAtual());
			jogo.getPosicaoAtual().evento(jogo);
		} else {
			System.out.print("Dados não são iguais!");
		}
	}
}
