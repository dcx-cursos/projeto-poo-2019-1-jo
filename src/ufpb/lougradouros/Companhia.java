package ufpb.lougradouros;

import ufpb.jogo.Jogador;
import ufpb.jogo.JogoFacade;

public class Companhia extends TituloFactory implements  Posicao {

	private int multiplicador;

	/**
	 * Constructor from class Companhia, enables initialization of position number, company name, property price, the owner and multiplier attributes. 
	 * @author Amanda
	 * @param int numeroDePosicao - position name
	 * @param String nomeDaCompanhia - company name
	 * @param int precoDaPropriedade - property price
	 * @param Jogador dono - company's owner
	 * @param int multiplicador - the rent multiplier
	  */
	public Companhia(int numeroDePosicao, String nomeDaCompanhia, int precoDaPropriedade, int multiplicadoor) {
		this.posicao = numeroDePosicao;
		this.nomeDoTitulo = nomeDaCompanhia;
		this.precoDaPropriedade = precoDaPropriedade;
		this.dono = null;
		this.multiplicador = multiplicadoor;
	}

	/**
	 * Method that enables the access to the position number. 
	 * @author Amanda
	 * @return int - the position number
	 * */
	@Override
	public int getNumeroDePosicao() {
		return this.posicao;
	}
	
	/**
	 * @author Amanda
	 * @return String - the position number and the company name
	 */
	@Override
	public String toString() {
		return this.posicao+" - "+ this.nomeDoTitulo;
	}

	@Override
	public String mostrarTitulo() {
		return "["+this.nomeDoTitulo+"] multiplicador de "+this.multiplicador;
	}

	@Override
	public String getTipo() {
		return "Companhia";
	}

	public int getMultiplicador() {
		return this.multiplicador;
	}
	
	public int getPrecoDaPropriedade() {
		return this.precoDaPropriedade;
	}

	@Override
	public void factoryMethod(JogoFacade jogo) {
		int sumDados = jogo.getUltimosDados()[0]+jogo.getUltimosDados()[1];
		int totalAhPagar = this.multiplicador*sumDados;
		jogo.JogadorAtual().pagar(this.dono, totalAhPagar);
		System.out.println("Pagou $" + totalAhPagar + " ao jogador " + this.dono);		
	}

}
