package ufpb.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ufpb.cartas.HabeasCorpus;
import ufpb.cartas.Pague;
import ufpb.cartas.Presente;
import ufpb.cartas.Receba;
import ufpb.cartas.SorteOuReves;
import ufpb.cartas.VaPrisao;
import ufpb.jogo.Jogador;
import ufpb.jogo.JogoFacade;

public class CartasTest {

	private SorteOuReves carta;
	private Jogador jogador;
	private JogoFacade jogo;


	
	@Before
	public void setUp() {
		this.jogo = JogoFacade.getInstance();
		this.jogador = new Jogador("Joana", "azul");
		this.jogo.addJogador(new Jogador("Clebson","rosa"));
	}
	
	@After
	public void setDown() {
		this.jogo.reset();
	}

	@Test
	public void testHabeasCorpus() {
		this.carta = new HabeasCorpus("Descrição", "2");
		carta.acao(jogador);
		assertTrue("Testando", jogador.temCarta());
	}

	@Test
	public void testPague() {
		this.carta = new Pague("Descrição", "100");
		carta.acao(jogador);
		assertEquals("Testando Pague", 1400, jogador.getSaldo());
	}

	@Test
	public void testPresente() {
		this.carta = new Presente("Descrição", "50");
		carta.acao(jogador);
		assertEquals("Testando Presente com 2 jogadores na partida",1550,jogador.getSaldo());
	}
	
	@Test
	public void testReceba() {
		this.carta = new Receba("Descrição","50");
		carta.acao(jogador);
		assertEquals("Testando Recebendo de 1 jogador",1550,jogador.getSaldo());
	}
	
	@Test
	public void testVaPrisao() {
		this.carta = new VaPrisao("Descrição","0");
		carta.acao(jogador);
		assertTrue(jogo.verificarSeTaNaPrisao(jogador));

	}
	
	

}
