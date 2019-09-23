package ufpb.jogo;

import java.util.LinkedList;
import java.util.Scanner;

import ufpb.cartas.SorteOuReves;
import ufpb.exceptions.CorValidaException;
import ufpb.exceptions.ExisteJogadorComEstaCorException;
import ufpb.exceptions.ValorInvalidoException;
import ufpb.lougradouros.Posicao;

public class JogoFacade {
	protected static final Scanner in = new Scanner(System.in);
	protected LinkedList<Jogador> listaJogadores;
	protected Dado dado = new Dado();
	protected Tabuleiro tabuleiro = new Tabuleiro();
	private JogoFactory fabrica;
	private int[] ultimosDados;
	private static JogoFacade instance = null;
	
	/**
	 * 
	 * @author Clebson
	 */
	private JogoFacade() {
		listaJogadores = new LinkedList<Jogador>();
		ultimosDados = new int[2];
	}

	public static JogoFacade getInstance() {
		if(instance==null) {
			instance = new JogoFacade();
		}return instance;
	}
	
	public void reset() {
		instance = null;
	}
	
	/**
	 * 
	 * @author Joyce
	 */
	public String input(    ) {
		return in.nextLine();
	}

	/**
	 * 
	 * @author Joyce
	 */
	public int inputInt() {
		String resultado = in.nextLine();
		return Integer.parseInt(resultado.replaceAll("^[\\s+]|[\\s+]$", ""));
	}

	/**
	 * 
	 * @author Clebson
	 */
	public int getNumeroDeJogadores() {
		return this.listaJogadores.size();
	}

	/**
	 * 
	 * @author Clebson
	 */
	public void addJogador(Jogador e) {
		this.listaJogadores.add(e);
	}

	/**
	 * 
	 * @author Clebson
	 */
	public void pollJogador() {
		this.listaJogadores.add(this.listaJogadores.pollFirst());
	}

	/**
	 * 
	 * @author Clebson
	 */
	public void removeJogador() {
		this.listaJogadores.remove(this.JogadorAtual());
	}

	/**
	 * 
	 * @author joana
	 */
	public int lancaDados() {
		return (this.dado.lancaDado());
	}

	/**
	 * 
	 * @author Clebson
	 */
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

	/**
	 * 
	 * @author Joyce
	 */
	public Jogador JogadorAtual() {
		return this.listaJogadores.getFirst();
	}

	/**
	 * 
	 * @author Clebson
	 */
	public void chamarEvento() {
		this.tabuleiro.getPosicoeDoTabuleiro(this.JogadorAtual().getPosicao()).evento(this);

	}

	/**
	 * 
	 * @author Clebson
	 */
	public Posicao getPosicaoAtual() {
		return this.tabuleiro.getPosicoeDoTabuleiro(this.JogadorAtual().getPosicao());
	}

	/**
	 * 
	 * @author Joyce
	 */
	public SorteOuReves getCarta() {
		return this.tabuleiro.getSorteOuReves();
	}

	/**
	 * 
	 * @author Joana
	 */
	public void verificaNumeroJogadores(int numero) throws ValorInvalidoException {
		if ((numero > 8 || numero < 2)) {
			throw new ValorInvalidoException("Número de jogadores inválidos!\n");
		}
	}

	/**
	 * 
	 * @author Clebson
	 */
	public void passarAVez() {
		this.listaJogadores.add(this.listaJogadores.pollFirst());
	}

	/**
	 * 
	 * @author Clebson
	 */
	public void setPrisao() {
		this.fabrica = new JogoFactoryPrisao();
	}

	/**
	 * 
	 * @author Clebson
	 */
	public void setFabrica() {
		this.fabrica = new JogoFactory();
	}

	/**
	 * 
	 * @author Clebson
	 */
	public JogoFactory getFabrica() {
		return this.fabrica;
	}

	/**
	 * 
	 * @author Joyce
	 */
	public int[] getUltimosDados() {
		return ultimosDados;
	}

	/**
	 * 
	 * @author Joyce
	 */
	public void setUltimosDados(int[] ultimosDados) {
		this.ultimosDados = ultimosDados;
	}

	/**
	 * 
	 * @author Clebson
	 */
	public boolean simOuNao(String msg) throws ValorInvalidoException {
		System.out.print(msg + "\nSim/Não");
		String escolha = this.input();
		if (escolha.matches("[\t\n\r\f]*[Ss]+[ \t\n\r\f]*[Ii]*[ \t\n\r\f]*[Mm]*[ \t\n\r\f]*")) {
			return true;
		} else if (!(escolha.matches("[Nn]+[ÃãAa]*[Oo]*"))) {
			throw new ValorInvalidoException("Opção não permitida");
		}
		return false;
	}

}
