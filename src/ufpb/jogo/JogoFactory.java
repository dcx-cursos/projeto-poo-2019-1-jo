package ufpb.jogo;

import ufpb.exceptions.ValorInvalidoException;
import ufpb.opcoes.Erro;
import ufpb.opcoes.Jogar;
import ufpb.opcoes.Opcao;
import ufpb.opcoes.Sair;
import ufpb.opcoes.Status;

public class JogoFactory {
	protected Opcao op;

	/**
	 * 
	 * @author Clebson
	 */
	public boolean escolheOpcao(String opcao, JogoFacade jogo) {
		switch (opcao) {
		case "jogar":
			setOpcaoJogar();
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
					return true;
				}
				return false;

			} catch (ValorInvalidoException e) {
				System.err.println(e.getMessage());
				escolheOpcao(opcao, jogo);
			}
			break;
		default:
			setOpcaoErro();
		}
		return true;
	}

	/**
	 * 
	 * @author Joana
	 */
	public void setOpcaoJogar() {
		this.op = new Jogar();
	}

	/**
	 * 
	 * @author Joyce
	 */
	public void setOpcaoStatus() {
		this.op = new Status();
	}

	/**
	 * 
	 * @author Clebson
	 */
	public void setOpcaoSair() {
		this.op = new Sair();
	}

	/**
	 * 
	 * @author Amanda
	 */
	protected void setOpcaoErro() {
		this.op = new Erro();
	}

	/**
	 * 
	 * @author Clebson
	 */
	public boolean executarOpcao(JogoFacade jogo) {
		return this.op.fazerOP(jogo);
	}
}
