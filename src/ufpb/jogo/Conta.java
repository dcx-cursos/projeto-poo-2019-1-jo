package ufpb.jogo;

import ufpb.exceptions.LimiteExcedidoException;
import ufpb.exceptions.ValorInvalidoException;

public class Conta {
	private int saldo;

	/**
	 * The account
	 */
	public Conta() {
		this.saldo = 1500;
	}

<<<<<<< HEAD
	/**
	 * Method that enables the access to account balance attribute
	 * 
	 * @author Joana
	 * @return int - account balance attribute value
	 */
	public int getSaldo() {
=======
	public double getSaldo() {
>>>>>>> f4a56500a3215b22a817e55016611274b1797675
		return this.saldo;
	}
	

	@Override
	public String toString() {
		return "Possui: " + this.saldo;
	}

	// OS VALORES TEM QUE SER POSITIVOS
	public void deposita(double valor) throws ValorInvalidoException{		
		if (valor <= 0) {
			throw new ValorInvalidoException("Valor inválido");
		}
		this.saldo += valor;

	}

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
