package ufpb.jogo;

import java.util.LinkedList;

import ufpb.exceptions.ValorInvalidoException;
import ufpb.lougradouros.Terreno;
import ufpb.lougradouros.Titulo;

/**
 * Representing the player
 * @author Joana
  */
public class Jogador {
	private String nome;
	private String cor;
	private int posicao;
	private Conta conta;
	private LinkedList<Titulo> titulos;

	/**
	 * Constructor from class Jogador, enables initialization of name and color attributes. 
	 * @author Joana 
	 * @param String nome - player's name
	 * @param String cor - player's pawn color
	 * @param int posicao - the player's position
	  */
	public Jogador(String nome, String cor) {
		this.nome = nome;
		this.cor = cor;
		this.titulos = new LinkedList<Titulo>();
		this.conta = new Conta();
	}

	/**
	 * Method that enables the access to name attribute. 
	 * @author Joana
	 * @return String - name attribute value
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * Method that enables the access to color attribute
	 * @author Joana
	 * @return String - color attribute value
	 */
	public String getCor() {
		return this.cor;
	}
	
	/**
	 * Method that enables the access to positon attribute
	 * @author Joana
	 * @return int - position attribute value
	 */
	public int getPosicao() {
		return this.posicao;
	}

	/**
	 * Metodo para jogador comprar terreno
	 * @param valor
	 * @param t
	 * @throws ValorInvalidoException
	 */
	
	public void comprarTerreno(int valor, Terreno t) throws ValorInvalidoException {
		this.conta.pagar(valor);
		this.titulos.add(t);
	}
	
	/**
	 * @author Joana
	 * @return String - the player's name and pawn color
	 */
	@Override
	public String toString() {
		return this.nome + "(" + this.cor + ")";
	}

	/**
	 * Jogada
	 *
	 * @param d Dado utilizado no jogo
	 * @param t Tabuleiro utilizado no jogo
	 * 
	 */
	// JOGADOR USA DADO, PORTANTO, DADO É UM PARAMETRO DO METODO JOGADA
	public void jogada(Dado d, Tabuleiro t) {
		int dado1 = d.lancaDado();
		int dado2 = d.lancaDado();
		this.posicao += dado1 + dado2;
		if (this.posicao > 39) {
			this.posicao -= 39;
		}
		System.out.println(this.toString() + "tirou " + dado1 + "," + dado2 + " e o peão avançou "+ t.getPosicoeDoTabuleiro(this.getPosicao()));
	}

	public void status(Tabuleiro t) {
		System.out.println("O status de"+this.toString()+" é o seguinte:");
		System.out.println("Situado na posição "+t.getPosicoeDoTabuleiro(this.getPosicao()));
		System.out.println("Titulos:");
		for(Titulo c: titulos) {
			System.out.println(c);
		}
	}

	public void sair() {
		System.exit(0);
	}

}