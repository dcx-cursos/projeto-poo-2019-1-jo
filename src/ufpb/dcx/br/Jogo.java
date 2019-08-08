package ufpb.dcx.br;

import java.util.Scanner;

public class Jogo {

	private ListJogadores listaDeJogadores;
	private static final Scanner input = new Scanner(System.in);

	
	public Jogo() {
		this.listaDeJogadores = new ListJogadores(); 
	}
	
	public void cadastraJogador(Jogador j) throws JogadorJaExisteException {
		if (verificaDisponibilidadeDaCor(j.getCor()) == false)
			listaDeJogadores.adicionarNoFim(j);
		else
			throw new JogadorJaExisteException("Esta cor de peao ja foi escolhida. Tente novamente!");
	}

	public boolean verificaDisponibilidadeDaCor(String cor) {
		try {
			this.listaDeJogadores.procuraJogadorNaListaDeJogadores(cor);
			return true;
		} catch (JogadorNaoExisteException e) {
			return false;
		}
	}

	public void iniciaJogo() {
		System.out.print("Digite o numero de jogadores [2-8]: ");
		int numeroDeJogadores = Integer.parseInt(input.nextLine());
		int cont = 1;
		while (numeroDeJogadores != 0) {
			System.out.println("Digite o nome do jogador " + cont + ":");
			String nomeDoJogador = input.nextLine().toLowerCase();
			System.out.print("Escolha a cor do peao do jogador " + cont + " entre as opcoes seguintes: "
					+ "[preto][branco][vermelho][verde][azul][amarelo][laranja]" + "rosa]\n:");
			String corDoPeaoDoJogador = input.nextLine().toLowerCase();
			try {
				cadastraJogador(new Jogador(nomeDoJogador, corDoPeaoDoJogador));
				numeroDeJogadores--;
				cont ++;
			} catch (JogadorJaExisteException c) {
				System.out.println(c.getMessage());
			}
		}

		System.out.println("O Banco Imobiliario vai comecar. Aproveite!");
	}

}
