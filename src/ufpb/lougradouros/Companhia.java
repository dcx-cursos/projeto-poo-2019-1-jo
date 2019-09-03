package ufpb.lougradouros;

import ufpb.jogo.Jogador;
import ufpb.jogo.JogoFacade;

public class Companhia implements Titulo, Posicao {

	private int numeroDePosicao;
	private String nomeDaCompanhia;
	private int precoDaPropriedade;
	private Jogador dono;
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
		this.numeroDePosicao = numeroDePosicao;
		this.nomeDaCompanhia = nomeDaCompanhia;
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
	public void evento(JogoFacade jogo) {
		if (this.dono == null) {
			System.out.println("O titulo de propriedade " + this.nomeDaCompanhia + " está disponivel por $"
					+ this.precoDaPropriedade);
			System.out.println(jogo.JogadorAtual().getNome() + " possui $" + jogo.JogadorAtual().getSaldo());
			System.out.print("Deseja comprar " + this.nomeDaCompanhia + "?(Sim/nao)");
			String escolha = jogo.input();
			if (escolha.equalsIgnoreCase("sim")) {
				jogo.JogadorAtual().comprarTitulo(this.precoDaPropriedade, this);
				this.dono = jogo.JogadorAtual();
			}
			else if(!escolha.equalsIgnoreCase("nao")) {
				//Trocar para uma exceção
				System.out.println("Opção não permetida");
				evento(jogo);
			}
		} else {
			if (!this.dono.equals(jogo.JogadorAtual())) {
				int sumDados = jogo.getUltimosDados()[0]+jogo.getUltimosDados()[1];
				int totalAhPagar = this.multiplicador*sumDados;
				jogo.JogadorAtual().pagar(this.dono, totalAhPagar);
				System.out.println("Pagou $" + totalAhPagar + " ao jogador " + this.dono);
			}
		}
	}
	
	@Override
	public void venderAoBanco(Jogador j) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String mostrarTitulo() {
		return "["+this.nomeDaCompanhia+"] multiplicador de "+this.multiplicador;
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

}
