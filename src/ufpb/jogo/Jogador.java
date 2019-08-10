package ufpb.jogo;


/**
 * Representing the player
 * @author Joana
  */
public class Jogador {
	private String nome;
	private String cor;
	private int posicao;

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
		this.posicao = 0;
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
	 * @author Joana
	 * @return String - the player's name and pawn color
	 */
	@Override
	public String toString() {
		return this.nome + "(" + this.cor + ")";
	}

	// JOGADOR USA DADO, PORTANTO, DADO � UM PARAMETRO DO METODO JOGADA
	public void jogada(Dado d,Tabuleiro t) {
		int dado1 = d.lancaDado();
		int dado2 = d.lancaDado();
		this.posicao += dado1+dado2;
	
		
		System.out.println(this.toString() + "tirou " + dado1 + "," + dado2 + " e o peão avançou "+t.getPosicoeDoTabuleiro(this.getPosicao()));
	}

	public void status() {
		// to do
	}

	public void sair() {
		System.exit(0);
	}
	
	

}