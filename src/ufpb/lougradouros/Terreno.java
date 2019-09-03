package ufpb.lougradouros;

import ufpb.exceptions.ValorInvalidoException;
import ufpb.jogo.Jogador;
import ufpb.jogo.JogoFacade;

public class Terreno extends TituloFactory implements  Posicao {

	private int aluguel;
	private int aluguelComUmaCasa;
	private int aluguelComDuasCasa;
	private int aluguelComTresCasa;
	private int aluguelComQuatroCasa;
	private int aluguelComHotel;
	private int precoDaCasa;
	private String cor;

	/**
	 * Constructor from class Terreno, enables initialization of position number,
	 * land name, property price, rent, rent with one house, rent with two
	 * houses,rent with three houses, rent with four houses, rent with a hotel, the
	 * owner and color attributes.
	 * 
	 * @author Amanda
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
	 * Method that enables the access to position number attribute.
	 * 
	 * @author Amanda
	 * @return int - position number attribute value
	 */
	@Override
	public int getNumeroDePosicao() {
		// TODO Auto-generated method stub
		return this.posicao;
	}

	/**
	 * @author Amanda
	 * @return String - the number position
	 */
	@Override
	public String toString() {
		return this.posicao + " - " + this.nomeDoTitulo;
	}

	/**
	 * @author
	 **/


	@Override
	public String mostrarTitulo() {
		return "[" + this.nomeDoTitulo + "] propriedade " + this.cor + " aluguel " + this.aluguel;
	}

	@Override
	public String getTipo() {
		return "Terreno";
	}

	@Override
	public void factoryMethod(JogoFacade jogo) {
		jogo.JogadorAtual().pagar(this.dono, this.aluguel);
		System.out.println("Pagou $" + this.aluguel + " ao jogador " + this.dono);		
	}

}
