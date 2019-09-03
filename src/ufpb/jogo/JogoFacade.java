package ufpb.jogo;

import java.util.LinkedList;
import java.util.Scanner;

import ufpb.cartas.SorteOuReves;
import ufpb.exceptions.CorValidaException;
import ufpb.exceptions.ExisteJogadorComEstaCorException;
import ufpb.lougradouros.Posicao;
import ufpb.lougradouros.Prisao;
import ufpb.opcoes.*;

public class JogoFacade {
	private static final Scanner in = new Scanner(System.in);
	private LinkedList<Jogador> listaJogadores;
	private Dado dado = new Dado();
	private Tabuleiro tabuleiro = new Tabuleiro();
	protected Opcao op;

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

	public void setOpcaoJogar() {
		this.op = new Jogar();
	}

	public void setOpcaoStatus() {
		this.op = new Status();
	}

	public void setOpcaoSair() {
		this.op = new Sair();
	}
	
	public boolean verificarSeTaNaPrisao() {
		return this.tabuleiro.getPosicoeDoTabuleiro(this.JogadorAtual().getPosicao()).getTipo().equals("Prisão");
	}  

	protected void setOpcaoErro() {
		this.op = new Erro();
	}

	public boolean executarOpcao() {
		return this.op.fazerOP(this);
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

	public void escolheOpcao(String opcao) {
		switch (opcao) {
		case "jogar":
			setOpcaoJogar();
			break;
		case "status":
			setOpcaoStatus();
			break;
		case "sair":
			System.out.println("Você realmente quer sair (Sim/Não)?");
			String escolha = this.input();
			if(escolha.equalsIgnoreCase("sim"))
			{
				setOpcaoSair();
			}
			break;
		default:
			setOpcaoErro();
		}
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
	

}
