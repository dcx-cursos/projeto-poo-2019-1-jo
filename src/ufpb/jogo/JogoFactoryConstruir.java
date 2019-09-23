package ufpb.jogo;

import ufpb.exceptions.ValorInvalidoException;
import ufpb.opcoes.Carta;
import ufpb.opcoes.ConstruirOP;
import ufpb.opcoes.JogarPrisao;
import ufpb.opcoes.Pagar;

/**
 * <p>
 * Represents the facade of the game when the player is in prison.
 * </p>
 * 
 *
 */
public class JogoFactoryConstruir extends JogoFactory {

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
		case "construir":
			setOpcaoConstruir();
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
		// TODO Auto-generated method stub
		
	}

	private void setOpcaoConstruir() {
		this.op = new ConstruirOP();
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
