package ufpb.cartas;

import ufpb.jogo.JogoFacade;

public class HabeasCorpus extends SorteOuReves{

	public HabeasCorpus(String descricao, String valor) {
		super(descricao, valor);
	}

	@Override
	public void acao(JogoFacade j) {
		j.JogadorAtual().addCarta();
		System.out.println(this.descricao);	
	}

}
