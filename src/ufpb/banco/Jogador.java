package ufpb.banco;

import java.util.Scanner;

public class Jogador {
	private String nome;
	private String cor;

	public Jogador(String nome, String cor) {
		this.nome = nome;
		this.cor = cor;
	}

	public String getNome() {
		return nome;
	}

	public String getCor() {
		return cor;
	}

	@Override
	public String toString() {
		return "O Jogador" + this.nome + "(" + this.cor + ")";
	}

	// JOGADOR USA DADO, PORTANTO, DADO É UM PARAMETRO DO METODO JOGADA
	public void jogada(Dado d) {
		int dado1 = d.lancaDado();
		int dado2 = d.lancaDado();
		System.out.println(this.toString() + "tirou" + dado1 + "," + dado2 + " e o peão avançou");
	}

	public void status() {
		// to do
	}

	public void sair() {
		System.exit(0);
	}

}