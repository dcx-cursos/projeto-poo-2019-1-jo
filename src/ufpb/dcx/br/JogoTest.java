package ufpb.dcx.br;

/**
 * CLASSE TESTES DO JOGO
 * @author joana.darck
 *
 */

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import junit.framework.TestCase;

class JogoTest extends TestCase {	
	ListJogadores listaDeJogadores = new ListJogadores();
	Jogo testaJogo = new Jogo();	
	
	@Test (expected = JogadorJaExisteException.class)
	public void testCadastroJogador() {
		try {
		testaJogo.cadastraJogador(new Jogador("Joana","preto"));		
		testaJogo.cadastraJogador(new Jogador("Joana","branco"));
		testaJogo.cadastraJogador(new Jogador("Joana","vermelho"));
		testaJogo.cadastraJogador(new Jogador("Joana","verde"));
		testaJogo.cadastraJogador(new Jogador("Joana","azul"));
		testaJogo.cadastraJogador(new Jogador("Joana","amarelo"));
		testaJogo.cadastraJogador(new Jogador("Joana","laranja"));
		testaJogo.cadastraJogador(new Jogador("Joana","rosa"));
		}catch(JogadorJaExisteException e) {
			System.out.println(e.getMessage());
		}
		
		
	}

	
}
