package ufpb.lougradouros;

import ufpb.banco.Titulo;
import ufpb.jogo.Jogador;

public class Terreno implements Titulo, Posicao{
	
	private int numeroDePosicao;
	private String nomeDoTerreno;
	private int precoDaPropriedade;
	private int aluguel;
	private int aluguelComUmaCasa;
	private int aluguelComDuasCasa;
	private int aluguelComTresCasa;
	private int aluguelComQuatroCasa;
	private int aluguelComHotel;
	private String dono;
	private String cor;
	
	

	public Terreno(int numeroDePosicao, String nomeDoTerreno, int precoDaPropriedade, int aluguel,
			int aluguelComUmaCasa, int aluguelComDuasCasas, int aluguelComTresCasas, int aluguelComQuatroCasas,
			int aluguelComHotel, String dono, String cor) {
		this.numeroDePosicao = numeroDePosicao;
		this.nomeDoTerreno = nomeDoTerreno;
		this.precoDaPropriedade = precoDaPropriedade;
		this.aluguel = aluguel;
		this.aluguelComUmaCasa = aluguelComUmaCasa;
		this.aluguelComDuasCasa = aluguelComDuasCasas;
		this.aluguelComTresCasa = aluguelComTresCasas;
		this.aluguelComQuatroCasa = aluguelComQuatroCasas;
		this.aluguelComHotel = aluguelComHotel;
		this.dono = dono;
		this.cor = cor;
	}

	@Override
	public int getNumeroDePosicao() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getNomeDaCompanhia() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Jogador dono() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
	
	

}
