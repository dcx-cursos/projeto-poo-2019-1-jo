package ufpb.opcoes;

import ufpb.jogo.JogoFacade;

public class Jogar implements Opcao {
	protected int dado1;
	protected int dado2;

	@Override
	public boolean fazerOP(JogoFacade jogo) {
		this.dado1 = jogo.lancaDados();
		this.dado2 = jogo.lancaDados();
		sumDados(jogo);
		return true;

	}

	public void sumDados(JogoFacade jogo) {
		jogo.JogadorAtual().avancarCasas(this.dado1 + this.dado2);
		System.out.println(jogo.JogadorAtual() + "tirou " + this.dado1 + "," + this.dado2 + " e o peão avançou "
				+ jogo.getPosicaoAtual());
		jogo.chamarEvento();
		
	}

}
