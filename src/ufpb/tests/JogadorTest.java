package ufpb.tests;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import ufpb.jogo.*;
import ufpb.lougradouros.Prisao;


class JogadorTest {
	
	
	@Mock
	JogoFacade jogo = null;
	Jogador j;

	@BeforeEach
	public void inicializa() {
		MockitoAnnotations.initMocks(this);		
		j = new Jogador("Joana","rosa");
	}
 
		
	@Test
	void testJogadorLancaDado() {
		Mockito.when(jogo.JogadorAtual()).thenReturn(j); 
		j.jogada(5,5,jogo);
		assertEquals(10, j.getPosicao());
	}
	
	@Test 
	void testJogadorEvento() {
		jogo.addJogador(new Jogador("a","b"));
		jogo.addJogador(new Jogador("B","c"));
		Mockito.when(jogo.getPosicaoAtual()).thenReturn(new Prisao(0,null)); 
		jogo.getPosicaoAtual().evento(jogo);
		System.out.println(jogo.JogadorAtual());		
	}
}
