package ufpb.opcoes;

import ufpb.jogo.JogoFacade;

public class Pagar implements Opcao {

	@Override
	public boolean fazerOP(JogoFacade jogo) {
		jogo.JogadorAtual();
		jogo.JogadorAtual().pagar(50);
		int novoDado = jogo.lancaDados();
		int novoDado2 = jogo.lancaDados();
		jogo.JogadorAtual().avancarCasas(novoDado+novoDado2);
		System.out.println(jogo.JogadorAtual() + "tirou " +novoDado + ","+novoDado2 + "e o peão avançou "+jogo.getPosicaoAtual());
		jogo.getPosicaoAtual().evento(jogo);
		return true;
	}

}
