package ufpb.jogo;

import ufpb.exceptions.CorValidaException;
import ufpb.exceptions.ExisteJogadorComEstaCorException;
import ufpb.exceptions.ValorInvalidoException;

/**
 * <p>
 * Representing the game.
 * In this class, the game will starts, define the numbers of players, choose the players' name and the pawn color,
 * show the options available for each player, and finally starts the match.
 * </p>
 */
public class Jogo {

	protected JogoFacade jogo;
	private int idJogador = 1;
	private int numeroDeJogadores;

	/**
	 * <p>
	 * Class that has the methods to starts and ends and other objects that make up
	 * the game.
	 * </p>
	 * .
	 * 
	 */
	public Jogo() {
		this.jogo = new JogoFacade();
	}

	/**
	 * <p>
	 * Starts the game.
	 * </p>
	 * 
	 */
	public void iniciarJogo() {
		nJogadores();
		criarJogadores();
		System.out.println("O Banco Imobiliario vai comecar. Aproveite!");
		partida();

	}

	/**
	 * <p>
	 * Defines the number of players.
	 * </p>
	 * 
	 */
	private void nJogadores() {
		System.out.print("Digite o número de jogadores [2 - 8]: ");
		int numero = 0;
		try {
			numero = jogo.inputInt();
			this.jogo.verificaNumeroJogadores(numero);
			this.numeroDeJogadores = numero;
		} catch (NumberFormatException e) {
			System.err.print("O valor deve ser um inteiro!\n");
			nJogadores();
		} catch (ValorInvalidoException e) {
			System.err.print("Número de jogadores inválidos!");
			nJogadores();
		}

	}

	/**
	 * <p>
	 * </p>
	 * method to choose the player's name.
	 * 
	 * @return nome
	 */
	private String escolheNomeJogador() {
		System.out.print("Digite o nome do jogador " + (this.idJogador) + ": ");
		String nome = jogo.input();
		if (!nome.matches("[a-zA-Z]+")) {
			System.err.println("Digite apenas letras.\nTente novamente");
			escolheNomeJogador();
		}
		return nome;

	}

	/**
	 * <p>
	 * Method to choose the player's pawn color
	 * </p>
	 * 
	 * @return cor
	 */
	private String escolheCorPeao() {
		System.out.print("Escolha a cor do peão do jogador " + (this.idJogador)
				+ " entre as opções seguintes: [preto][branco][vermelho][verde][azul][amarelo][laranja][rosa]:");
		String cor = jogo.input();
		return cor;
	}

	/**
	 * <p>
	 * Method that creates the player(name and color pawn/)
	 * </p>
	 * 
	 */
	public void criarJogadores() {
		for (int i = 0; i < this.numeroDeJogadores; i++) {
			String nome = escolheNomeJogador();
			boolean parar = false;
			while (parar != true) {
				String cor = escolheCorPeao();
				try {
					jogo.verificaSeAhCorEhValida(cor);
					jogo.verificaSeExisteJogadorComEstaCor(cor);
					jogo.addJogador(new Jogador(nome, cor));
					this.idJogador++;
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
	 * <p>
	 * Method that shows the options available to the player.
	 * </p>
	 * 
	 * @param j Jogador
	 */
	private void opcoes(Jogador j) {
		if (jogo.verificarSeTaNaPrisao()) {
			opcoesPrisao();
		} else {
			opcoesNormal();
		}
		String opcao = jogo.input();
		boolean deuCerto = jogo.getFabrica().escolheOpcao(opcao, this.jogo);
		boolean jogar = false;
		if (deuCerto) {
			jogar = jogo.getFabrica().executarOpcao(this.jogo);
		}
		if ((jogar == false) || (!(opcao.equals("jogar") | opcao.equals("carta") | opcao.equals("pagar")))) {
			opcoes(j);
		}
	}

	/**
	 * <p>
	 * Shows the options available for each player.
	 * </p>
	 * 
	 */
	private void opcoesNormal() {
		System.out.print("Comandos disponíveis:[jogar][status][sair]\nEntre com um comando: ");
	}

	/**
	 * <p>
	 * Shows the options available for the player who is in the prison.
	 * </p>
	 * 
	 */
	private void opcoesPrisao() {
		System.out.print("Comandos disponíveis:[pagar][cartas][jogar][status][sair]\nEntre com um comando: ");
	}

	/**
	 * <p>
	 * Starts the match.
	 * </p>
	 * 
	 */
	private void partida() {
		if (jogo.verificarSeTaNaPrisao()) {
			jogo.setPrisao();
		} else {
			jogo.setFabrica();
		}
		System.out.println("A jogada de " + jogo.JogadorAtual().toString() + "começou:");
		opcoes(jogo.JogadorAtual());
		this.jogo.pollJogador();
		partida();
	}

}
