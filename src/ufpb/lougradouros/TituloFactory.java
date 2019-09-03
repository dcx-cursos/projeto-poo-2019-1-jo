package ufpb.lougradouros;

import ufpb.exceptions.ValorInvalidoException;
import ufpb.jogo.Jogador;
import ufpb.jogo.JogoFacade;

public abstract class TituloFactory {
	protected Jogador dono;
	protected String nomeDoTitulo;
	protected int posicao;
	protected int precoDaPropriedade;
	
	
	public void evento(JogoFacade jogo) {
		if (this.dono == null) {
			System.out.println("O titulo de propriedade " + this.nomeDoTitulo + " está disponivel por $"
					+ this.precoDaPropriedade);
			System.out.println(jogo.JogadorAtual().getNome() + " possui $" + jogo.JogadorAtual().getSaldo());
			boolean escolha;
			try {
				escolha = jogo.simOuNao(("Deseja comprar " + this.nomeDoTitulo + "?"));
				if (escolha) {
					jogo.JogadorAtual().comprarTitulo(this.precoDaPropriedade, this);
					this.dono = jogo.JogadorAtual();
				}
			} catch (ValorInvalidoException e) {
				System.err.print(e.getMessage()+"\n");
				evento(jogo);

			}
			
		} else {
			if (!this.dono.equals(jogo.JogadorAtual())) {
				factoryMethod(jogo);
			}
		}
	}


	public abstract void factoryMethod(JogoFacade jogo);
	public abstract String getTipo();
	public abstract String mostrarTitulo();
	
	public void venderAoBanco(Jogador j) {
		this.dono = null;
		j.receber(this.precoDaPropriedade);
		j.removeTitulo(this);		
	}
}
