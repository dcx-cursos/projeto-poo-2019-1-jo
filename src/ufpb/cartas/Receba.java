package ufpb.cartas;

import ufpb.jogo.JogoFacade;

public class Receba extends SorteOuReves {
	
	
	public Receba(String descricao, String valor) {
		super(descricao, valor);
	}

	@Override
	public void acao(JogoFacade j) {
		System.out.println(this.descricao+"\n Você recebeu "+this.valor+" do banco.");
		j.JogadorAtual().receber(this.valor);
	}

}
