package ufpb.cartas;

import ufpb.jogo.Jogador;


public class SorteOuReves {
	protected String descricao;
	protected int valor;
	
	public SorteOuReves(String descricao, String valor) {
		this.descricao = descricao;
		this.valor = Integer.parseInt(valor);
	}
	
	public void acao(Jogador j) {
		System.out.println(this.descricao+"\n");
	}
}
