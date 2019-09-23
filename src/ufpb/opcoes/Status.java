package ufpb.opcoes;

import ufpb.jogo.JogoFacade;
import ufpb.lougradouros.TituloFactory;

/**
 * <p>
 * Represents the players' status.
 * </p>
 *
 */
public class Status implements Opcao {

	/**
	 * <p>
	 * Shows the player's current status.
	 * </p>
	 * Methods
	 * 
	 * @param jogo JogoFacade
	 * @return boolean
	 */
	@Override
	public boolean fazerOP(JogoFacade jogo) {
		System.out.println("O status de " + jogo.JogadorAtual() + " é o seguinte:");
		System.out.println("Situado na posição " + jogo.getPosicaoAtual());
		System.out.println("Titulos:");
		for (TituloFactory c : jogo.JogadorAtual().getTitulos()) {
			System.out.println(c);
		}
		return false;
	}

}
