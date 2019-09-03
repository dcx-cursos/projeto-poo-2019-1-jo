package ufpb.opcoes;

import ufpb.jogo.JogoFacade;

public class Carta implements Opcao {

	@Override
	public boolean fazerOP(JogoFacade jogo) {
		// TODO Auto-generated method stub
		if(jogo.JogadorAtual().temCarta()) {
			jogo.JogadorAtual().removeCarta();
			System.out.println(jogo.JogadorAtual()+" usou carta para sair da prisão");
			return true;
		}
		System.out.println("Não tem carta de Habeas corpus");
		return false;
	}

}
