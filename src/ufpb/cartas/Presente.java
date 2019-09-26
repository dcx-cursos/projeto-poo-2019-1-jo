package ufpb.cartas;

import ufpb.jogo.JogoFacade;

public class Presente extends SorteOuReves {

	public Presente(String descricao, String valor) {
		super(descricao, valor);
	}

	@Override
	public void acao(JogoFacade j) {
		System.out.println(this.descricao);
		j.JogadorAtual().receber(valor*(j.getNumeroDeJogadores()-1));
	}

}
