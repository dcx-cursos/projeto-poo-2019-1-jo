package ufpb.jogo;

import java.util.LinkedList;
import java.util.Scanner;

import ufpb.exceptions.CorValidaException;
import ufpb.exceptions.ExisteJogadorComEstaCorException;

/**
 * <h1>ENTRADA ACEITAR APENAS NÚMEROS INTEIROS SEM DÃ� ERRO</h1> //ENTRADA DE
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
		System.out.print("Digite o número de jogadores [2 - 8]: ");
		int numero = 0;
		try {
			numero = Integer.parseInt(input.nextLine());
		} catch (NumberFormatException e) {
			System.err.print("O valor deve ser um inteiro!\n");
		}
		if (numero > 8 || numero < 2) {
			nJogadores();
		} else {
			this.numeroDeJogadores = numero;
		}
	}
	/**
	 * metodo
	 * @author joana
	 * @return nome 
	 * */
	private String escolheNomeJogador() {
		System.out.print("Digite o nome do jogador " + (this.jogadorAtual + 1) + ": ");
		String nome = input.nextLine().toLowerCase();
		return nome;

	}
	/**
	 * metodo
	 * @author joana
	 * @return cor 
	 * */
	private String escolheCorPeao() {
		System.out.print("Escolha a cor do peão do jogador " + (this.jogadorAtual + 1) + " entre as opções seguintes:"
				+ "[preto][branco][vermelho][verde][azul][amarelo][laranja][rosa]" + "\n:");
		String cor = input.nextLine();
		return cor;

	}

	/**
	 * Method that creates the player(name and color pawn/)
	 * 
	 * @author Clebson
	 */
	public void criarJogadores() {
		for (int i = 0; i < this.numeroDeJogadores; i++) {
			String nome = escolheNomeJogador();
			boolean parar = false;
			while (parar != true) {
				String cor = escolheCorPeao();
				try {
					verificaSeAhCorEhValida(cor);
					verificaSeExisteJogadorComEstaCor(cor);
					this.listaJogadores.add(new Jogador(nome, cor));
					this.jogadorAtual += 1;
					parar = true;
				} catch (ExisteJogadorComEstaCorException e) {
					System.err.println("Já existe jogador com a cor escolhida, tente novamente!");
				} catch (CorValidaException e) {
					System.err.println("Cor Inválida, tente novamente!");
				}
			}
		}
	}

	/**
	 * This method checks if there is any other player using the color passed as a
	 * parameter.
	 * 
	 * @param cor
	 * @throws ExisteJogadorComEstaCorException
	 * @author Amanda Azevedo
	 */
	private void verificaSeExisteJogadorComEstaCor(String cor) throws ExisteJogadorComEstaCorException {
		for (Jogador j : this.listaJogadores) {
			if (j.getCor().equals(cor)) {
				throw new ExisteJogadorComEstaCorException(
						"Já existe um jogador utilizando esta cor. Tente novamente!");
			}
		}
	}

	/**
	 * @param String cor
	 * @return true if the color passed as a parameter is within expected colors
	 * @throws CorValidaException
	 * @author Amanda Azevedo
	 */
	private boolean verificaSeAhCorEhValida(String cor) throws CorValidaException {
		if (cor.equals("preto") || cor.equals("branco") || cor.equals("vermelho") || cor.equals("verde")
				|| cor.equals("azul") || cor.equals("amarelo") || cor.equals("laranja") || cor.equals("rosa")) {
			return true;
		}
		throw new CorValidaException("Esta cor não é válida. Tente novamente uma cor disponível!");
	}

	/**
	 * Method that shows the options available to the player.
	 * 
	 * @author Joyce
	 * @param j Jogador
	 */
	private void opcoes(Jogador j) {
		System.out.print("Comandos disponíveis: [jogar][status][sair]\nEntre com um comando: ");
		String opcao = input.nextLine().toLowerCase();
		switch (opcao) {
		case "jogar":
			j.jogada(this.dado, this.tabuleiro);
			break;
		case "status":
			j.status(this.tabuleiro);

			this.opcoes(j);
			break;
		case "sair":
			System.out.print("Você realmente quer sair (Sim/Nao)? ");
			String sair = input.nextLine().toLowerCase();
			if (sair.startsWith("s")) {
				if (this.numeroDeJogadores > 2) {
					this.numeroDeJogadores -= 1;
					listaJogadores.remove(this.jogadorAtual);
					partida();
					break;
				} else {
					System.out.println("Jogo encerrado.");
					System.exit(0);
				}
			}
		default:
			opcoes(j);

		}
	}

	/**
	 * The match
	 * 
	 * @author Joyce
	 */
	private void partida() {
		// To-do
		// Chama as opÃ§Ãµes do jogador e depois troca o jogador atual
		while (this.jogadorAtual < this.numeroDeJogadores) {
			Jogador jAtual = this.listaJogadores.get(jogadorAtual);
			System.out.println("A jogada de " + jAtual.toString() + "comeÃ§ou:");
			opcoes(listaJogadores.get(this.jogadorAtual));
			tabuleiro.getPosicoeDoTabuleiro(jAtual.getPosicao()).evento(jAtual);
			jogadorAtual += 1;
		}
		this.jogadorAtual = 0;
		partida();

	}

}
