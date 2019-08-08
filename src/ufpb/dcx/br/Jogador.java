package ufpb.dcx.br;

/**
 * Classe que representa um jogador
 * @author Amanda.Azevedo
 *
 */

public class Jogador {

	private String nome;
	private String cor;

	
	/**
	 * Construtor da classe Jogador, possibilita a inicializa��o dos atributos nome e cor. 
	 * @author Amanda Azevedo
	 * @param String nome - nome do jogador
	 * @param String cor - cor do peao do jogador
	  */
	public Jogador(String nome, String cor) {
		this.nome = nome;
		this.cor = cor;
	}
	
	
	/**
	 * M�todo que possibilita o acesso ao atributo nome.
	 * @author Amanda
	 * @return String - valor do atributo nome
	 */
	public String getNome() {
		return nome;
	}


	/**
	 * M�todo que possibilita o acesso ao atributo cor.
	 * @author Amanda
	 * @return String - valor do atributo cor
	 */
	public String getCor() {
		return cor;
	}


	/**
	 * 
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cor == null) ? 0 : cor.hashCode());
		return result;
	}

	/**
	 * 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jogador other = (Jogador) obj;
		if (cor == null) {
			if (other.cor != null)
				return false;
		} else if (!cor.equals(other.cor))
			return false;
		return true;
	}

}
