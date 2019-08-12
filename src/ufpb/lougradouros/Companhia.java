package ufpb.lougradouros;

import ufpb.jogo.Jogador;

public class Companhia implements Titulo, Posicao {

	private int numeroDePosicao;
	private String nomeDaCompanhia;
	private int precoDaPropriedade;
	private String dono;
	private int multiplicador;

	/**
	 * Constructor from class Companhia, enables initialization of position number, company name, property price, the owner and multiplier attributes. 
	 * @author Amanda
	 * @param int numeroDePosicao - position name
	 * @param String nomeDaCompanhia - company name
	 * @param int precoDaPropriedade - property price
	 * @param String dono - company's owner
	 * @param int multiplicador - the rent multiplier
	  */
	public Companhia(int numeroDePosicao, String nomeDaCompanhia, int precoDaPropriedade, String dono, int multiplicadoor) {
		this.numeroDePosicao = numeroDePosicao;
		this.nomeDaCompanhia = nomeDaCompanhia;
		this.precoDaPropriedade = precoDaPropriedade;
		this.dono = dono;
		this.multiplicador = multiplicadoor;
	}

	/**
	 * Method that enables the access to the position number. 
	 * @author Amanda
	 * @return int - the position number
	 * */
	@Override
	public int getNumeroDePosicao() {
		return this.numeroDePosicao;
	}
	
	/**
	 * @author Amanda
	 * @return String - the position number and the company name
	 */
	@Override
	public String toString() {
		return this.numeroDePosicao+" - "+ this.nomeDaCompanhia;
	}

	@Override
	public void evento(Jogador j) {
		// TODO Auto-generated method stub

	}

	@Override
	public void venderAoBanco(Jogador j) {
		// TODO Auto-generated method stub
		
	}


}
