package ufpb.jogo;

import ufpb.exceptions.CorValidaException;
import ufpb.exceptions.ExisteJogadorComEstaCorException;
import ufpb.exceptions.ValorInvalidoException;

/**
 * <h1>ENTRADA ACEITAR APENAS NÚMEROS INTEIROS SEM DÃ� ERRO</h1> //ENTRADA DE
 * CORES SO ACEITAR O NOME DAS CORES CORRETAS
 */

public class Jogo {
	protected JogoFacade jogo;
	private int idJogador = 1;
	private int numeroDeJogadores;
	
	
	/**
	 * Class that has the methods to starts and ends and other objects that make up
	 * the game.
	 * 
	 * @author Clebson
	 */
	public Jogo() {
		this.jogo = new JogoFacade();
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
			numero = jogo.inputInt();
			this.jogo.verificaNumeroJogadores(numero);
			this.numeroDeJogadores = numero;
		} catch (NumberFormatException e) {
			System.err.print("O valor deve ser um inteiro!\n");
			nJogadores();
		}catch (ValorInvalidoException e) {
			System.err.print("Número de jogadores inválidos!");
			nJogadores();
		}
		
	}

	/**
	 * methods
	 * 
	 * @author joana
	 * @return nome
	 */
	private String escolheNomeJogador() {
		System.out.print("Digite o nome do jogador " + (this.idJogador) + ": ");
		return jogo.input();
	}

	/**
	 * methods
	 * 
	 * @author joana
	 * @return cor
	 */
	private String escolheCorPeao() {
		System.out.print("Escolha a cor do peão do jogador " + (this.idJogador) + " entre as opções seguintes: [preto][branco][vermelho][verde][azul][amarelo][laranja][rosa]:");
		String cor = jogo.input();
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
	 * Method that shows the options available to the player.
	 * 
	 * @author Joyce
	 * @param j Jogador
	 */
	private void opcoes(Jogador j) {
		if(jogo.verificarSeTaNaPrisao()) {
			opcoesPrisao();
		}else {
			opcoesNormal();
		}
		String opcao = jogo.input();
		jogo.getFabrica().escolheOpcao(opcao,this.jogo);
		boolean jogar = jogo.getFabrica().executarOpcao(this.jogo);
		if((jogar==false ) || (!(opcao.equals("jogar") | opcao.equals("carta") | opcao.equals("pagar")))) {
			opcoes(j);
		}
	}
	private void opcoesNormal() {
		System.out.print("Comandos disponíveis:[jogar][status][sair]\nEntre com um comando: ");
	}
	
	private void opcoesPrisao() {
		System.out.print("Comandos disponíveis:[pagar][cartas][jogar][status][sair]\nEntre com um comando: ");
	}
	
	/**
	 * The match
	 * 
	 * @author Joyce
	 */
	private void partida() {
		if(jogo.verificarSeTaNaPrisao()) {
			jogo.setPrisao();
		}else {
			jogo.setFabrica();
		}
		System.out.println("A jogada de " + jogo.JogadorAtual().toString() + "começou:");
		opcoes(jogo.JogadorAtual());
		this.jogo.pollJogador();
		partida();
	}
	

}
