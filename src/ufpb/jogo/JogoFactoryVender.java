package ufpb.jogo;

import ufpb.exceptions.ValorInvalidoException;
import ufpb.opcoes.JogarPrisao;
import ufpb.opcoes.Vender;

public class JogoFactoryVender extends JogoFactory{
	
	/**
	 * Shows the options of facade of the game when the player is in prison.
	 * @param
	 * @param
	 * @return
	 */
	public boolean escolheOpcao(String opcao, JogoFacade jogo) {
		switch (opcao) {
		case "jogar":
			setOpcaoJogar();
			break;
		case "vender":
			setOpcaoVender();
			break;
		case "status":
			setOpcaoStatus();
			break;
		case "sair":
			boolean escolha;
			try {
				escolha = jogo.simOuNao("Você realmente quer sair");
				if (escolha) {
					setOpcaoSair();
				}
			} catch (ValorInvalidoException e) {
				System.err.println(e.getMessage());
				escolheOpcao(opcao, jogo);
				return false;
			}
			break;
		default:
			setOpcaoErro();
			return false;
		}
		return true;
	}

	private void setOpcaoVender() {
		this.op = new Vender();
		
	}

	/**
	 * <p>
	 * Sets the option "Play(Jogar)".
	 * </p>
	 */
	@Override
	public void setOpcaoJogar() {
		this.op = new JogarPrisao();
	}

}
