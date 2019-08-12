package ufpb.jogo;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * <h1>ENTRADA ACEITAR APENAS NÚMEROS INTEIROS SEM DÁ ERRO</h1> //ENTRADA DE
 * CORES SO ACEITAR O NOME DAS CORES CORRETAS
 */

public class Jogo {
	private static final Scanner input = new Scanner(System.in);
	private int numeroDeJogadores;
	private LinkedList<Jogador> listaJogadores;
	private int jogadorAtual;
	private Dado dado = new Dado();
	private Tabuleiro tabuleiro = new Tabuleiro();

	/**
	 * Class that has the methods to starts and ends and other objects that make up
	 * the game.
	 * 
	 * @author Clebson
	 */
	public Jogo() {
		this.jogadorAtual = 0;
		listaJogadores = new LinkedList<Jogador>();
	}

	/**
	 * Starts the game
	 * 
	 * @author Clebson
	 */
	public void iniciarJogo() {
		nJogadores();
		criarJogadores();
		System.out.println("O Banco Imobiliario vai comecar. Aproveite!");
		partida();

	}

	/**
	 * Defines the number of players
	 * 
	 * @author Clebson
	 */
	private void nJogadores() {
		System.out.println("Digite o numero de jogadores [2 - 8]: ");
		int numero = Integer.parseInt(input.nextLine());
		if (numero > 8 || numero < 2) {
			nJogadores();
		} else {
			this.numeroDeJogadores = numero;
		}
	}

	/**
	 * Method that creates the player(name and color pawn/)
	 * 
	 * @author Clebson
	 */
	private void criarJogadores() {
		int cont = 0;
		while (cont < numeroDeJogadores) {
			System.out.println("Digite o nome do jogador" + (cont + 1) + ":");
			String nome = input.nextLine();
			System.out.println("Digite a cor:");
			String cor = input.nextLine();
			this.listaJogadores.add(new Jogador(nome, cor));
			cont += 1;
		}
	}

	/**
	 * Method that shows the options available to the player.
	 * 
	 * @author Joyce
	 * @param j Jogador
	 */
	private void opcoes(Jogador j) {
		System.out.println("Comandos disponíveis: [jogar][status][sair]\nEntre com um comando:");
		String opcao = input.nextLine();
		switch (opcao) {
		case "jogar":
			j.jogada(this.dado, this.tabuleiro);
			break;
		case "status":
			j.status(this.tabuleiro);

			this.opcoes(j);
			break;
		case "sair":
			System.out.println("sim/nao");
			String sair = input.nextLine();
			if (sair.equals("sim") || sair.equals("s")) {
				if (this.numeroDeJogadores > 2) {
					this.numeroDeJogadores -= 1;
					listaJogadores.remove(this.jogadorAtual);
					partida();
					break;
				} else {
					System.out.println("Jogo encerrado.");
					System.exit(0);
				}
			} else {
				opcoes(j);
				break;
			}

		}
	}

	/**
	 * The match
	 * 
	 * @author Joyce
	 */
	private void partida() {
		// To-do
		// Chama as opções do jogador e depois troca o jogador atual
		while (this.jogadorAtual < this.numeroDeJogadores) {
			Jogador jAtual = this.listaJogadores.get(jogadorAtual);
			System.out.println("A jogada de " + jAtual.toString() + "começou:");
			opcoes(listaJogadores.get(this.jogadorAtual));
			tabuleiro.getPosicoeDoTabuleiro(jAtual.getPosicao()).evento(jAtual);
			jogadorAtual += 1;
		}
		this.jogadorAtual = 0;
		partida();

	}

}
