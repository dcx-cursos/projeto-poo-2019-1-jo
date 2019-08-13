package ufpb.lougradouros;

import java.util.Scanner;

import ufpb.exceptions.LimiteExcedidoException;
import ufpb.exceptions.ValorInvalidoException;
import ufpb.jogo.Jogador;

public class Terreno implements Titulo, Posicao {

	private int numeroDePosicao;
	private String nomeDoTerreno;
	private int precoDaPropriedade;
	private int aluguel;
	private int aluguelComUmaCasa;
	private int aluguelComDuasCasa;
	private int aluguelComTresCasa;
	private int aluguelComQuatroCasa;
	private int aluguelComHotel;
	private int precoDaCasa;
	private String cor;
	private Jogador dono;

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
		this.numeroDePosicao = numeroDePosicao;
		this.nomeDoTerreno = nomeDoTerreno;
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
		return this.numeroDePosicao;
	}

	/**
	 * @author Amanda
	 * @return String - the number position
	 */
	@Override
	public String toString() {
		return this.numeroDePosicao + " - " + this.nomeDoTerreno;
	}

	/**
	 * @author
	 **/

	@Override
	public void evento(Jogador j) {
		if (this.dono == null) {
			Scanner e = new Scanner(System.in);
			System.out.println("O titulo de propriedade " + this.nomeDoTerreno + " está disponivel por $"
					+ this.precoDaPropriedade);
			System.out.println(j.getNome() + " possui $" + j.getSaldo());
			System.out.print("Deseja comprar " + this.nomeDoTerreno + "?(Sim/nao)");
			String escolha = e.nextLine().toLowerCase();
			if (escolha.equals("sim")) {
				j.comprarTerreno(this.precoDaPropriedade, this);
				this.dono = j;
			}
		} else {
			if (!this.dono.equals(j)) {
				j.pagar(this.dono, this.aluguel);
				System.out.println("Pagou $" + this.aluguel + " ao jogador " + this.dono);
			}
		}
	}

	@Override
	public void venderAoBanco(Jogador j) {
		this.dono = null;
		j.receber(this.precoDaPropriedade);
	}

	@Override
	public String mostrarTitulo() {
		return "["+this.nomeDoTerreno+"] propriedade "+this.cor+" aluguel "+this.aluguel;
	}
}
