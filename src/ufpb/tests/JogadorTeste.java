package ufpb.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import ufpb.jogo.*;
import ufpb.lougradouros.Prisao;

public class JogadorTeste {

	@Mock
	JogoFacade jogo = null;
	Jogador j;

	@Before
	public void inicializa() {
		MockitoAnnotations.initMocks(this);
		j = new Jogador("Joana", "rosa");
	}

	@After
	public void setDown() {
		j = new Jogador("Joana", "rosa");
	}

	@Test
	public void testJogadorLancaDado() {
		Mockito.when(jogo.JogadorAtual()).thenReturn(j);
		j.jogada(5, 5, jogo);
		System.out.println(j.getPosicao());
		assertEquals(10, j.getPosicao());
	}

	@Test
	public void testJogadorEvento() {
		jogo.addJogador(new Jogador("a", "b"));
		jogo.addJogador(new Jogador("B", "c"));
		Mockito.when(jogo.getPosicaoAtual()).thenReturn(new Prisao(0, null));
		jogo.getPosicaoAtual().evento(jogo);
		System.out.println(jogo.JogadorAtual());
	}
}
