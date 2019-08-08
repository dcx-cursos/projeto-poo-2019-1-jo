package ufpb.lougradouros;

import ufpb.banco.Titulo;
import ufpb.jogo.Jogador;

public class Companhia implements Titulo, Posicao {

	private int numeroDePosicao;
	private String nomeDaCompanhia;
	private int precoDaPropriedade;
	private String dono;
	private String cor;

	public Companhia(int numeroDePosicao, String nomeDaCompanhia, int precoDaPropriedade, String dono, String cor) {
		this.numeroDePosicao = numeroDePosicao;
		this.nomeDaCompanhia = nomeDaCompanhia;
		this.precoDaPropriedade = precoDaPropriedade;
		this.dono = dono;
		this.cor = cor;
	}

	@Override
	public int getNumeroDePosicao() {
		return this.numeroDePosicao;
	}

	@Override
	public String getNomeDaCompanhia() {
		return this.nomeDaCompanhia;
	}

	@Override
	public Jogador dono() {
		return this.dono();
	}

}
