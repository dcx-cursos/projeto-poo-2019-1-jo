package ufpb.lougradouros;

import ufpb.jogo.JogoFacade;

/**
 * <p>
 * Represents the land.
 * </p>
 *
 */
public class Terreno extends TituloFactory implements Posicao {

	private int aluguel;
	private int aluguelComUmaCasa;
	private int aluguelComDuasCasa;
	private int aluguelComTresCasa;
	private int aluguelComQuatroCasa;
	private int aluguelComHotel;
	private int precoDaCasa;
	private String cor;

	/**
	 * <p>
	 * Constructor from class Terreno, enables initialization of position number,
	 * land name, property price, rent, rent with one house, rent with two
	 * houses,rent with three houses, rent with four houses, rent with a hotel, the
	 * owner and color attributes.
	 * </p>
	 * 
	 * @param int     numeroDePosicao - position name
	 * @param String  nomeDaCompanhia - company name
	 * @param int     precoDaPropriedade - property price
	 * @param int     aluguel - rent
	 * @param int     aluguelComUmaCasa - rent with one house
	 * @param int     aluguelComDuasCasas - rent with two houses
	 * @param int     aluguelComTresCasas - rent with three houses
	 * @param int     aluguelComQuatroCasas - rent with four houses
	 * @param int     aluguelComHotel - rent with a hotel
	 * @param Jogador dono - company's owner
	 * @param String  color - the color of the land is on the board
	 */
	public Terreno(int numeroDePosicao, String nomeDoTerreno, int precoDaPropriedade, int aluguel,
			int aluguelComUmaCasa, int aluguelComDuasCasas, int aluguelComTresCasas, int aluguelComQuatroCasas,
			int aluguelComHotel, int precoDaCasa, String cor) {
		this.posicao = numeroDePosicao;
		this.nomeDoTitulo = nomeDoTerreno;
		this.precoDaPropriedade = precoDaPropriedade;
		this.aluguel = aluguel;
		this.aluguelComUmaCasa = aluguelComUmaCasa;
		this.aluguelComDuasCasa = aluguelComDuasCasas;
		this.aluguelComTresCasa = aluguelComTresCasas;
		this.aluguelComQuatroCasa = aluguelComQuatroCasas;
		this.aluguelComHotel = aluguelComHotel;
		this.precoDaCasa = precoDaCasa;
		this.cor = cor;
		this.dono = null;
	}

	/**
	 * <p>
	 * </p>
	 */
	@Override
	public void factoryMethod(JogoFacade jogo) {
		jogo.JogadorAtual().pagar(this.dono, this.aluguel);
		System.out.println("Pagou $" + this.aluguel + " ao jogador " + this.dono);
	}

	/**
	 * <p>
	 * Shows the player's titles.
	 * </p>
	 **/
	@Override
	public String mostrarTitulo() {
		return "[" + this.nomeDoTitulo + "] propriedade " + this.cor + " aluguel " + this.aluguel;
	}

	@Override
	public int getNumeroDePosicao() {
		return this.posicao;
	}

	@Override
	public String toString() {
		return this.posicao + " - " + this.nomeDoTitulo;
	}

	@Override
	public String getTipo() {
		return "Terreno";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Terreno other = (Terreno) obj;
		if (aluguel != other.aluguel)
			return false;
		if (aluguelComDuasCasa != other.aluguelComDuasCasa)
			return false;
		if (aluguelComHotel != other.aluguelComHotel)
			return false;
		if (aluguelComQuatroCasa != other.aluguelComQuatroCasa)
			return false;
		if (aluguelComTresCasa != other.aluguelComTresCasa)
			return false;
		if (aluguelComUmaCasa != other.aluguelComUmaCasa)
			return false;
		if (cor == null) {
			if (other.cor != null)
				return false;
		} else if (!cor.equals(other.cor))
			return false;
		if (precoDaCasa != other.precoDaCasa)
			return false;
		return true;
	}
}
