package ufpb.cartas;

import ufpb.jogo.Jogador;
import ufpb.jogo.JogoFacade;

public class Receba extends SorteOuReves {
	
	
	public Receba(String descricao, String valor) {
		super(descricao, valor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void acao(Jogador j) {
		// TODO Auto-generated method stub
		System.out.println(this.descricao+"\n Você recebeu "+this.valor+" do banco.");
		j.receber(this.valor);
	}

}
