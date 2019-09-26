package ufpb.tests;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import ufpb.jogo.*;



class JogadorTest {
	
	
	@Mock
	JogoFacade jogo = null;
	Jogador j;
	
	@BeforeEach
	public void inicializa() {
		MockitoAnnotations.initMocks(this);		
		j = new Jogador("Joana","rosa");
	}
 
	/**
	 * Method Test
	 * @author Joana
	 */	
	@Test
	void testJogadorLancaDado() {
		Mockito.when(jogo.JogadorAtual()).thenReturn(j); 
		j.jogada(5,5,jogo);
		assertEquals(10, j.getPosicao());
	}
	
	
}
