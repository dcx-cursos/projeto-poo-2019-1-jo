package ufpb.tests;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import ufpb.exceptions.CorValidaException;
import ufpb.jogo.Jogador;
import ufpb.jogo.JogoFacade;

class JogoFacadeTest {

	private JogoFacade jogo;

	@Mock
	Mock jogoT;

	/**
	 * methods test
	 * 
	 * @author joana
	 * 
	 */
	@BeforeEach
	public void setUp() {
		this.jogo = JogoFacade.getInstance();
		for (int i = 0; i < 8; i++) {
			jogo.addJogador(new Jogador("Joana", "Preto"));
		}
	}
	
	@AfterEach
	public void setDown() {
		this.jogo.reset();
	}

	/**
	 * TESTANDO A REMOÇÃO DE JOGADOR
	 * 
	 * @author joana
	 * 
	 */
	@Test
	void testRemoveJogador() {
		jogo.removeJogador();
		assertEquals(7, this.jogo.getNumeroDeJogadores(), "Removendo 1 jogador");
		jogo.removeJogador();
		assertEquals(6, this.jogo.getNumeroDeJogadores(), "Removendo 2 jogadores");
		jogo.removeJogador();
		assertEquals(5, this.jogo.getNumeroDeJogadores(), "Removendo 3 jogadores");
		jogo.removeJogador();
		assertEquals(4, this.jogo.getNumeroDeJogadores(), "Removendo 4 jogadores");
		jogo.removeJogador();
		assertEquals(3, this.jogo.getNumeroDeJogadores(), "Removendo 5 jogadores");
		jogo.removeJogador();
		assertEquals(2, this.jogo.getNumeroDeJogadores(), "Removendo 6 jogadores");
		jogo.removeJogador();
		assertEquals(1, this.jogo.getNumeroDeJogadores(), "Removendo 7 jogadores");
		jogo.removeJogador();
		assertEquals(0, this.jogo.getNumeroDeJogadores(), "Removendo 8 jogadores");

	}

	/**
	 * methods TESTA ADICIONAR JOGADORES
	 * 
	 * @author joana
	 * @return nome
	 */
	@Test
	void testAddJogador() {
		jogo.addJogador(new Jogador("Joana", "Azul"));
		assertEquals(9, this.jogo.getNumeroDeJogadores(), "Adicionando um jogador");

	}

	/**
	 * methods TESTA VERIFICA SE ESTÁ NA PRISÃO
	 * 
	 * @author joana
	 * 
	 */
	@Test
	void testVerificaSeTaNaPrisao() {
		this.jogo.JogadorAtual().jogada(10, 0, jogo);
		assertTrue(this.jogo.verificarSeTaNaPrisao(), "Verifica se está na prisão");
	}
	
	/**
	 * @author joana
	 * 
	 */
	@Test
	void testVerificaSeExisteJogadorComEstaCor() {
		try {
			assertTrue(this.jogo.verificaSeAhCorEhValida("branco"));
			assertTrue(this.jogo.verificaSeAhCorEhValida("preto"));
			assertTrue(this.jogo.verificaSeAhCorEhValida("azul"));
			assertTrue(this.jogo.verificaSeAhCorEhValida("rosa"));
			assertTrue(this.jogo.verificaSeAhCorEhValida("amarelo"));
			assertTrue(this.jogo.verificaSeAhCorEhValida("laranja"));
			assertTrue(this.jogo.verificaSeAhCorEhValida("vermelho"));
			assertTrue(this.jogo.verificaSeAhCorEhValida("verde"));
		} catch (CorValidaException e) {
			fail("Falhou");

		}
	}

}
