package ufpb.cartas;

import ufpb.jogo.Jogador;

public class HabeasCorpus extends SorteOuReves{

	public HabeasCorpus(String descricao, String valor) {
		super(descricao, valor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void acao(Jogador j) {
		// TODO Auto-generated method stub
		j.addCarta();
		System.out.println(this.descricao);
		
	}

}
