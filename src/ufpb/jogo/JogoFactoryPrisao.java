package ufpb.jogo;

import ufpb.opcoes.Carta;
import ufpb.opcoes.JogarPrisao;

public class JogoFactoryPrisao extends JogoFactory {
	public void escolheOpcao(String opcao, JogoFacade jogo) {
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
			System.out.println("Você realmente quer sair (Sim/Não)?");
			String escolha = jogo.input();
			if(escolha.equalsIgnoreCase("sim"))
			{
				setOpcaoSair();
			}
			break;
		default:
			setOpcaoErro();
		}
	}
	
	@Override 
	public void setOpcaoJogar() {
		this.op = new JogarPrisao();
	}
	
	private void setOpcaoCarta() {
		this.op = new Carta();
		
	}

	private void setOpcaoPagar() {
		// TODO Auto-generated method stub
		
	}
}
