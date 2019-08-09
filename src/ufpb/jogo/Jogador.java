package ufpb.jogo;


public class Jogador {
	private String nome;
	private String cor;
	private int posicao;

	public Jogador(String nome, String cor) {
		this.nome = nome;
		this.cor = cor;
	}

	public String getNome() {
		return this.nome;
	}

	public String getCor() {
		return this.cor;
	}
	
	public int getPosicao() {
		return this.posicao;
	}

	@Override
	public String toString() {
		return this.nome + "(" + this.cor + ")";
	}

	// JOGADOR USA DADO, PORTANTO, DADO É UM PARAMETRO DO METODO JOGADA
	public void jogada(Dado d,Tabuleiro t) {
		int dado1 = d.lancaDado();
		int dado2 = d.lancaDado();
		this.posicao += dado1+dado2;
	
		
		System.out.println(this.toString() + "tirou " + dado1 + "," + dado2 + " e o peão avançou "+t.getPosicoeDoTabuleiro(this.getPosicao()));
	}

	public void status() {
		// to do
	}

	public void sair() {
		System.exit(0);
	}
	
	

}