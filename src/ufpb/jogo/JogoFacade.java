package ufpb.jogo;

import java.util.LinkedList;
import java.util.Scanner;

import ufpb.cartas.SorteOuReves;
import ufpb.exceptions.CorValidaException;
import ufpb.exceptions.ExisteJogadorComEstaCorException;
import ufpb.exceptions.ValorInvalidoException;
import ufpb.lougradouros.Posicao;
import ufpb.opcoes.*;

public class JogoFacade {
	protected static final Scanner in = new Scanner(System.in);
	protected LinkedList<Jogador> listaJogadores;
	protected Dado dado = new Dado();
	protected Tabuleiro tabuleiro = new Tabuleiro();
	private JogoFactory fabrica;

	
	public JogoFacade() {
		listaJogadores = new LinkedList<Jogador>();
	}

	public String input() {
		return in.nextLine().toLowerCase();
	}

	public int inputInt() {
		return Integer.parseInt(in.nextLine());
	}

	public int getNumeroDeJogadores() {
		return this.listaJogadores.size();
	}

	public void addJogador(Jogador e) {
		this.listaJogadores.add(e);
	}

	public void pollJogador() {
		this.listaJogadores.add(this.listaJogadores.pollFirst());
	}

	public void removeJogador() {
		this.listaJogadores.remove(this.JogadorAtual());
	}

	public int lancaDados() {
		return (this.dado.lancaDado());
	}

	public boolean verificarSeTaNaPrisao() {
		return this.tabuleiro.getPosicoeDoTabuleiro(this.JogadorAtual().getPosicao()).getTipo().equals("Prisão");
	}

	/**
	 * This method checks if there is any other player using the color passed as a
	 * parameter.
	 * 
	 * @param cor
	 * @throws ExisteJogadorComEstaCorException
	 * @author Amanda
	 */

	public void verificaSeExisteJogadorComEstaCor(String cor) throws ExisteJogadorComEstaCorException {
		for (Jogador j : this.listaJogadores) {
			if (j.getCor().equals(cor)) {
				throw new ExisteJogadorComEstaCorException(
						"Já existe um jogador utilizando esta cor. Tente novamente!");
			}
		}
	}

	
	
	/**
	 * @param String cor
	 * @throws CorValidaException
	 * @return true if the color passed as a parameter is within expected colors
	 * @author Amanda
	 */
	public boolean verificaSeAhCorEhValida(String cor) throws CorValidaException {
		if (cor.equalsIgnoreCase("preto") || cor.equalsIgnoreCase("branco") || cor.equalsIgnoreCase("vermelho")
				|| cor.equals("verde") || cor.equalsIgnoreCase("azul") || cor.equalsIgnoreCase("amarelo")
				|| cor.equalsIgnoreCase("laranja") || cor.equals("rosa")) {
			return true;
		}
		throw new CorValidaException("Esta cor não é válida. Tente novamente uma cor disponível!");
	}

	public Jogador JogadorAtual() {
		return this.listaJogadores.getFirst();
	}

	public void chamarEvento() {
		this.tabuleiro.getPosicoeDoTabuleiro(this.JogadorAtual().getPosicao()).evento(this);

	}

	public Posicao getPosicaoAtual() {
		return this.tabuleiro.getPosicoeDoTabuleiro(this.JogadorAtual().getPosicao());
	}

	public SorteOuReves getCarta() {
		return this.tabuleiro.getSorteOuReves();
	}

	public void verificaNumeroJogadores(int numero) throws ValorInvalidoException {
		if ((numero > 8 || numero < 2)) {
			throw new ValorInvalidoException("Número de jogadores inválidos!\n");
		}
	}

	public void passarAVez() {
		this.listaJogadores.add(this.listaJogadores.pollFirst());
	}
	
	public void setPrisao() {
		this.fabrica = new JogoFactoryPrisao();
	}
	public void setFabrica() {
		this.fabrica = new JogoFactory();
	}
	public JogoFactory getFabrica() {
		return this.fabrica;
	}

}
