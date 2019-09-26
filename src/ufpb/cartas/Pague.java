package ufpb.cartas;

import ufpb.jogo.JogoFacade;

public class Pague extends SorteOuReves{

	public Pague(String descricao, String valor) {
		super(descricao, valor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void acao(JogoFacade j) {
		// TODO Auto-generated method stub
		j.JogadorAtual().pagar(valor,j);
		System.out.println(this.descricao+"\n"+"Você pagou "+this.valor);
	}

}
