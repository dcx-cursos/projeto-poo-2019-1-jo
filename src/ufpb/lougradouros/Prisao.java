 package ufpb.lougradouros;

public class Prisao implements Posicao {
	private int posicao;
	private String nome;

	/**
	 * Constructor from class Prisao, enables initialization of name and position attribute. 
	 *@author Clebson
	 *@param string nome - the name
	 *@param int posicao - the position
	 **/
	public Prisao(int posicao, String nome) {	
		this.nome = nome;
		this.posicao = posicao;
	}

	/**
	 * Method that enables the access to position number attribute. 
	 * @author Clebson
	 * @return int - position number attribute value
	 */
	@Override
	public int getNumeroDePosicao() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/**
	 * @author Clebson
	 * @return String - the position
	 */
	@Override
	public String toString() {
		return this.posicao+" - Prisão \n Nada Aconteceu.";
	}
}

