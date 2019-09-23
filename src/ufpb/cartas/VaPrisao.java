package ufpb.cartas;

import ufpb.jogo.JogoFacade;

public class VaPrisao extends SorteOuReves {

	public VaPrisao(String descricao, String valor) {
		super(descricao, valor);
	}
	/**
	 * Methods
	 * 
	 * @author Clebson
	 * 
	 */
	@Override
	public void acao(JogoFacade j) {
		System.out.println(this.descricao);
		j.JogadorAtual().vaiParaPrisao();
	}

}
