package ufpb.jogo;

import ufpb.exceptions.ValorInvalidoException;

public class Conta {
	private int saldo;

	public Conta() {
		this.saldo = 0;
	}

	public void receber(int valor) throws ValorInvalidoException {
		if (valor <= 0) {
			throw new ValorInvalidoException("Valor negativo");
		}
		this.saldo += valor;
	}

	public void pagar(int valor) throws ValorInvalidoException {
		if (valor <= 0) {
			throw new ValorInvalidoException("Valor negativo");
		}
		this.saldo -= valor;
	}
	
	public int getSaldo() {
		return this.saldo;
	}
}
