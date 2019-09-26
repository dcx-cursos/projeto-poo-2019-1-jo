package ufpb.cartas;

import ufpb.jogo.JogoFacade;


public abstract class SorteOuReves {
	protected String descricao;
	protected int valor;
	
	/**
	 * Methods
	 * 
	 * @author Clebson
	 * @param descricao String, valor String
	 */
	public SorteOuReves(String descricao, String valor) {
		this.descricao = descricao;
		this.valor = Integer.parseInt(valor);
	}
	
	/**
	 * Methods
	 * 
	 * @author Clebson
	 * @param j JogoFacade
	 */
	public abstract void acao(JogoFacade j);
}
