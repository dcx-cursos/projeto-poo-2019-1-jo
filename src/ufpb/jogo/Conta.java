package ufpb.jogo;

import ufpb.exceptions.LimiteExcedidoException;
import ufpb.exceptions.ValorInvalidoException;

public class Conta {
	private int saldo;

	public Conta() {
		this.saldo = 1500;
	}

	public int getSaldo() {
		return this.saldo;
	}
	

	@Override
	public String toString() {
		return "Possui: " + this.saldo;
	}
	
	/**
	 * Methods 
	 * @author joana
	 * @param valor
	 * @throws ValorInvalidoException
	 */

	// OS VALORES TEM QUE SER POSITIVOS
	public void deposita(double valor) throws ValorInvalidoException{		
		if (valor <= 0) {
			throw new ValorInvalidoException("Valor inválido");
		}
		this.saldo += valor;

	}
	/**
	 * Methods 
	 * @author joana
	 * @param valor
	 * @throws ValorInvalidoException, LimiteExcedidoException
	 */

	// PARA DEBITAR O VALOR TEM QUE SER MENOR OU IGUAL AO SALDO
	// VALORES TEM QUE SER POSITIVOS
	public void debita(double valor) throws ValorInvalidoException, LimiteExcedidoException {
		if (valor <= 0) {
			throw new ValorInvalidoException("Valor Inválido!");

		} else if (valor > this.saldo) {
			throw new LimiteExcedidoException("Saldo Insuficiente!");
		}
		this.saldo -= valor;

	}
	}
