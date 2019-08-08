package ufpb.banco;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Jogo {
	private static final Scanner input = new Scanner(System.in);
	private int numeroDeJogadores;
	private ListJogadores jogadores;
	
	public Jogo() {
		jogadores = new ListJogadores();
	}
	
	public void iniciarJogo() {
		nJogadores();
		criarJogadores();
		System.out.println("O Banco Imobiliario vai comecar. Aproveite!");

	}
	
	private void nJogadores() {
		System.out.println("Digite o numero de jogadores [2 - 8]: ");
		int numero = Integer.parseInt(input.nextLine());
		if(numero > 8 || numero < 2) {
			nJogadores();
		}else {
			this.numeroDeJogadores = numero;	
		}
	}
	
	private void criarJogadores() {
		int cont = 0;
		while(cont < numeroDeJogadores) {
			System.out.println("Digite o nome do jogador"+(cont+1)+":");
			String nome = input.nextLine();
			System.out.println("Digite a cor:");
			String cor = input.nextLine();			
			try {
				this.jogadores.adicionarNoFim(new Jogador(nome,cor));
				cont += 1;
			} catch (corJaUsadaException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	

}
