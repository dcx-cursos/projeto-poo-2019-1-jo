package ufpb.cartas;

import ufpb.jogo.JogoFacade;

public class CartaLancarDados extends SorteOuReves {
	
	/**
	 * 
	 * @author Joyce
	 * @param descricao String, valor String
	 */
	public CartaLancarDados(String descricao, String valor) {
		super(descricao, valor);
	}
	/**
	 * 
	 * @author Joyce
	 * @param j JogoFacade
	 */
	@Override
	public void acao(JogoFacade j) {
		j.JogadorAtual().jogada(j.lancaDados(), j.lancaDados(), j);
	}
	
	
}
