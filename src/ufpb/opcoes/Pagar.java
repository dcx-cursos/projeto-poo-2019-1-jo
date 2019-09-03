package ufpb.opcoes;

import ufpb.jogo.JogoFacade;

public class Pagar implements Opcao {

	@Override
	public boolean fazerOP(JogoFacade jogo) {
		jogo.JogadorAtual();
		jogo.JogadorAtual().pagar(50);
		int novoDado = jogo.lancaDados();
		int novoDado2 = jogo.lancaDados();
		jogo.JogadorAtual().jogada(novoDado,novoDado2,jogo);
		jogo.getPosicaoAtual().evento(jogo);
		return true;
	}

}
