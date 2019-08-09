package ufpb.lougradouros;

public class ParadaLivre implements Posicao {

	private int posicao;

	public ParadaLivre(int posicao) {
		this.posicao = posicao;
	}

	@Override
	public int getNumeroDePosicao() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String toString() {
		return this.posicao+ "- Parada Livre \n Nada Aconteceu.";
	}

}
