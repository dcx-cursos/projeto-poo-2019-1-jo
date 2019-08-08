package ufpb.banco;

import java.util.Scanner;

public class Jogador {
	private String nome;
	private String cor;
	private static final Scanner input = new Scanner(System.in);

	
	public Jogador(String nome, String cor) {
		this.nome = nome;
		this.cor = cor;
	}

	public String getNome() {
		return nome;
	}

	public String getCor() {
		return cor;
	}
	public void jogada(){
		System.out.println("A jogada de "+this.nome+"("+this.cor+") começou:");
		System.out.println("Comandos disponíveis: [jogar][sair]/n Entre com um comando:" );
		String opcao = input.nextLine();
		switch (opcao) {
			case "jogar":
				//algumacoisa.jogar();break;
			case "sair":
				System.out.println("sim/nao");
				String sair = input.nextLine();
				if(sair.equals("sim") || sair.equals("s")) {
					System.out.println("Jogo encerrado.");
					System.exit(0);
				}
				this.jogada();
				break;
		}
	}
	
	
}