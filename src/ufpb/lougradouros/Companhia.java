package ufpb.lougradouros;

import ufpb.banco.Titulo;
import ufpb.jogo.Jogador;

public class Companhia implements Titulo, Posicao {

	private int numeroDePosicao;
	private String nomeDaCompanhia;
	private int precoDaPropriedade;
	private String dono;
	private int multiplicadoor;

	public Companhia(int numeroDePosicao, String nomeDaCompanhia, int precoDaPropriedade, String dono, int multiplicadoor) {
		this.numeroDePosicao = numeroDePosicao;
		this.nomeDaCompanhia = nomeDaCompanhia;
		this.precoDaPropriedade = precoDaPropriedade;
		this.dono = dono;
		this.multiplicadoor = multiplicadoor;
	}

	@Override
	public int getNumeroDePosicao() {
		return this.numeroDePosicao;
	}


}
