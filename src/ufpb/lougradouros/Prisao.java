 package ufpb.lougradouros;

public class Prisao implements Posicao {
	private int posicao;
	private String nome;

	public Prisao(int posicao, String nome) {	
		this.nome = nome;
		this.posicao = posicao;
	}

	@Override
	public int getNumeroDePosicao() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public String toString() {
		return this.posicao+" - Prisão \n Nada Aconteceu.";
	}
}

