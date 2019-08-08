package ufpb.jogo;

import ufpb.cartasEspeciais.SorteOuReves;
import ufpb.lougradouros.Companhia;
import ufpb.lougradouros.LucrosOuDividendos;
import ufpb.lougradouros.Posicao;
import ufpb.lougradouros.Terreno;

public class Tabuleiro {

	private Posicao[] posicoeDoTabuleiro;

	public Tabuleiro() {
		// add todas as posições
		this.posicoeDoTabuleiro = new Posicao[40];
		criaCasasNoTabuleiro();
	}

	public void criaCasasNoTabuleiro() {
		// 40 posições
		this.posicoeDoTabuleiro[0] = new Terreno(1, "Leblon", 100, 6, 30, 90, 270, 400, 500, "Banco", "Roxo");// Leblon
		this.posicoeDoTabuleiro[1] = new SorteOuReves();
		this.posicoeDoTabuleiro[2] = new Terreno(3, "Av. Presidente Vargas", 60, 2, 10, 30, 90, 160, 250, "Banco",
				"Roxo"); // Av.Presidente
		// Vargas
		this.posicoeDoTabuleiro[3] = new Terreno(4, "Av. Nossa Senhora de Copacabana", 60, 2, 10, 30, 90, 160, 250,
				"Banco", "Roxa"); // Av. Nossa Senhora de Copacabana
		this.posicoeDoTabuleiro[4] = new Companhia(5, "Companhia Ferroviária", 200, "Banco", "Branco");// Cia
																										// Ferroviária
		this.posicoeDoTabuleiro[5] = new Terreno(6, "Av. Brigadeiro Faria Lima", 240, 20, 100, 300, 750, 925, 1100,
				"Banco", "Ciano");// Av. Brigadeiro Faria Lima
		this.posicoeDoTabuleiro[6] = new Companhia(7, "Companhia de Viação", 200, "Banco", "Branco"); // Cia de Viação
		this.posicoeDoTabuleiro[7] = new Terreno(8, "Av. Rebouças", 220, 18, 90, 250, 700, 875, 1050, "Banco", "Ciano");// Av.
		// Rebouças
		this.posicoeDoTabuleiro[8] = new Terreno(9, "Av. 9 de Julho", 220, 18, 90, 250, 700, 875, 1050, "Banco",
				"Ciano");// Av.
							// 9
							// de
							// Julho
		this.posicoeDoTabuleiro[9] = new Prisao();
		this.posicoeDoTabuleiro[10] = new Terreno(11, "Av. Europa", 200, 16, 80, 220, 600, 800, 1000, "Banco", "Lilás");// Av.Europa
		this.posicoeDoTabuleiro[11] = new SorteOuReves();
		this.posicoeDoTabuleiro[12] = new Terreno(13, "Rua Augusta", 180, 14, 70, 200, 500, 750, 950, "Banco", "Lilás");// Rua
		// Augusta
		this.posicoeDoTabuleiro[13] = new Terreno(14, "Av. Pacaembu", 180, 14, 70, 200, 550, 750, 950, "Banco",
				"Lilás"); // Av.
							// Pacaembu
		this.posicoeDoTabuleiro[14] = new Companhia(15, "Companhia de Táxi", 150, "Banco", "Branco");// Cia Taxi
		this.posicoeDoTabuleiro[15] = new SorteOuReves();
		this.posicoeDoTabuleiro[16] = new Terreno(17, "Interlagos", 350, 35, 175, 500, 1100, 1300, 1500, "Banco",
				"Laranja");// Interlagos
		this.posicoeDoTabuleiro[17] = new LucrosOuDividendos();
		this.posicoeDoTabuleiro[18] = new Terreno(19, "Morumbi", 400, 50, 200, 600, 1400, 1700, 2000, "Banco",
				"Laranja");// Morumbi
		this.posicoeDoTabuleiro[19] = new ParadaLivre(); // OBSSSSSS
		this.posicoeDoTabuleiro[20] = new Terreno(21, "Flamengo", 120, 8, 40, 100, 300, 450, 600, "Banco", "Vermelho"); // Flamengo
		this.posicoeDoTabuleiro[21] = new SorteOuReves();
		this.posicoeDoTabuleiro[22] = new Terreno(23, "Botafogo", 100, 6, 30, 90, 270, 400, 500, "Banco", "Vermelho"); // Botafogo
		this.posicoeDoTabuleiro[23] = new ImpostoDeRenda();
		this.posicoeDoTabuleiro[24] = new Companhia(25, "Companhia de Navegação", 150, "Banco", "Branco");// Cia de
																											// Navegação
		this.posicoeDoTabuleiro[25] = new Terreno(26, "Av. Brasil", 160, 12, 60, 180, 500, 700, 900, "Banco",
				"Amarelo"); // Av.
							// Brasil
		this.posicoeDoTabuleiro[26] = new SorteOuReves();
		this.posicoeDoTabuleiro[27] = new Terreno(28, "Av.Paulista", 140, 10, 50, 150, 450, 625, 750, "Banco",
				"Amarelo"); // Av.
							// Paulista
		this.posicoeDoTabuleiro[28] = new Terreno(29, "Jardim Europa", 140, 12, 60, 180, 500, 700, 900, "Banco",
				"Amarelo"); // Jardim
							// Europa
		this.posicoeDoTabuleiro[29] = new Prisao();
		this.posicoeDoTabuleiro[30] = new Terreno(31, "Copacabana", 260, 22, 110, 330, 800, 975, 1150, "Banco",
				"Verde");// Copacabana
		this.posicoeDoTabuleiro[31] = new Companhia(32, "Companhia de Aviação", 200, "Banco", "Branco");// Cia de
																										// Aviação
		this.posicoeDoTabuleiro[32] = new Terreno(33, "Av. Vieira Souto", 320, 28, 150, 450, 1000, 1200, 1400, "Banco",
				"Verde");// Av. Vieira Souto
		this.posicoeDoTabuleiro[33] = new Terreno(34, "Av. Atlântica", 300, 26, 130, 390, 900, 1100, 1275, "Banco",
				"Verde"); // Av. Atlântica
		this.posicoeDoTabuleiro[34] = new Companhia(35, "Companhia de Táxi Aéreo", 200, "Banco", "Branco");// Cia de
																											// Taxi
																											// Aéreo
		this.posicoeDoTabuleiro[35] = new Terreno(36, "Ipanema", 300, 26, 130, 390, 900, 1100, 1275, "Banco", "Verde");// Ipanema
		this.posicoeDoTabuleiro[36] = new SorteOuReves();
		this.posicoeDoTabuleiro[37] = new Terreno(38, "Jardim Paulista", 280, 24, 120, 360, 850, 1025, 1200, "Banco",
				"Turquesa");// Jardim Paulista
		this.posicoeDoTabuleiro[38] = new Terreno(39, "Brooklin", 260, 22, 110, 330, 800, 975, 1150, "Banco",
				"Turquesa");// Brooklin
		this.posicoeDoTabuleiro[39] = new PontoDePartida();

	}

}
