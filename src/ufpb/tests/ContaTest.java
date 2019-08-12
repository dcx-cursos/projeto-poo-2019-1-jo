package ufpb.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ufpb.exceptions.LimiteExcedidoException;
import ufpb.exceptions.ValorInvalidoException;
import ufpb.jogo.Conta;

class ContaTest {
	private Conta conta;
	
	@BeforeEach
	public void setUp() {
		this.conta = new Conta();
	}
	
	@Test
	void testDepositar() {
		assertEquals(1500,this.conta.getSaldo(),"Teste saldo inicial");
		try {
			this.conta.deposita(100);
		} catch (ValorInvalidoException e) {
			fail("Deveria ter dado certo");
		}
		assertEquals(1600,this.conta.getSaldo(),"Testando saldo apos depositar");
		try {
			this.conta.deposita(-100);
			fail("Deveria lançar exceção");
		} catch (ValorInvalidoException e) {}
		assertEquals(1600,this.conta.getSaldo(),"Testando saldo apos exceção");
	}
	
	@Test
	void testDebitar() {
		assertEquals(1500,this.conta.getSaldo(),"Teste saldo inicial");
		try {
			this.conta.debita(1800);
			fail("Cadê a exceção?");
		} catch (ValorInvalidoException e) {
			// TODO Auto-generated catch block
			fail("Exceção errada");
		} catch (LimiteExcedidoException e) {
		}	
		assertEquals(1500,this.conta.getSaldo(),"Teste depois do thwros");			
		try {
			this.conta.debita(100);
		} catch (ValorInvalidoException | LimiteExcedidoException e) {
			// TODO Auto-generated catch block
			fail("Não era pra lançar exceção");
		}
		assertEquals(1400,this.conta.getSaldo(),"Teste depois de debitar 100");
		try {
			this.conta.debita(-100);
			fail("Era pra lançar exceção");

		} catch (ValorInvalidoException e) {
			// TODO Auto-generated catch block
		} catch (LimiteExcedidoException e) {
			fail("Exceção errada");

		}	
	}	

}
