package ufpb.jogo;

import ufpb.exceptions.ValorInvalidoException;
import ufpb.opcoes.Carta;
import ufpb.opcoes.JogarPrisao;
import ufpb.opcoes.Pagar;

public class JogoFactoryPrisao extends JogoFactory {
	public boolean escolheOpcao(String opcao, JogoFacade jogo) {
		switch (opcao) {
		case "jogar":
			setOpcaoJogar();
			break;
		case "pagar":
			setOpcaoPagar();
			break;
		case "carta":
			setOpcaoCarta();
			break;
		case "status":
			setOpcaoStatus();
			break;
		case "sair":
			boolean escolha;
			try {
				escolha = jogo.simOuNao("Você realmente quer sair");
				if(escolha)
				{
					setOpcaoSair();
				}
			} catch (ValorInvalidoException e) {
				System.err.println(e.getMessage());
				escolheOpcao(opcao,jogo);
				return false;
			}
			break;
		default:
			setOpcaoErro();
		}
		return true;
	}
	
	@Override 
	public void setOpcaoJogar() {
		this.op = new JogarPrisao();
	}
	
	private void setOpcaoCarta() {
		this.op = new Carta();
		
	}

	private void setOpcaoPagar() {
		this.op = new Pagar();
	}
}
