package ufpb.banco;

/**
 * Representing the player
 * @author Joana
  */
public class Jogador {
	private String nome;
	private String cor;

	/**
	 * Constructor from class Jogador, enables initialization of name and color attributes. 
	 * @author Joana 
	 * @param String nome - player's name
	 * @param String cor - player's pawn color
	  */
	public Jogador(String nome, String cor) {
		this.nome = nome;
		this.cor = cor;
	}

	/**
	 * Method that enables the access to name attribute. 
	 * @author Joana
	 * @return String - name attribute value
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Method that enables the access to color attribute
	 * @author Joana
	 * @return String - color attribute value
	 */
	public String getCor() {
		return cor;
	}

	/**
	 * @author Joana
	 * @return String - the player's name and pawn color
	 */
	@Override
	public String toString() {
		return "O Jogador" + this.nome + "(" + this.cor + ")";
	}

	// JOGADOR USA DADO, PORTANTO, DADO É UM PARAMETRO DO METODO JOGADA
	public void jogada(Dado d) {
		int dado1 = d.lancaDado();
		int dado2 = d.lancaDado();
		System.out.println(this.toString() + "tirou" + dado1 + "," + dado2 + " e o peão avançou");
	}

	public void status() {
		// to do
	}

	public void sair() {
		System.exit(0);
	}

}