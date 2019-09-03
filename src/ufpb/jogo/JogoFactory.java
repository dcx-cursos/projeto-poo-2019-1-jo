package ufpb.jogo;

import ufpb.opcoes.Erro;
import ufpb.opcoes.Jogar;
import ufpb.opcoes.Opcao;
import ufpb.opcoes.Sair;
import ufpb.opcoes.Status;

public class JogoFactory {
	protected Opcao op;

	public void escolheOpcao(String opcao, JogoFacade jogo) {
		switch (opcao) {
		case "jogar":
			setOpcaoJogar();
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
	
	public void setOpcaoJogar() {
		this.op = new Jogar();
	}

	public void setOpcaoStatus() {
		this.op = new Status();
	}

	public void setOpcaoSair() {
		this.op = new Sair();
	}
	
	protected void setOpcaoErro() {
		this.op = new Erro();
	}

	public boolean executarOpcao(JogoFacade jogo) {
		return this.op.fazerOP(jogo);
	}
}
