package ufpb.jogo;

import java.util.Random;

public class Dado {
	
	/**
	 * Roll the dice
	 * @author Joana
	 * @return an integer value from 1 to 6. 
	 */
	public int lancaDado() {
		Random aleatorio = new Random();
		int valor = aleatorio.nextInt(6)+1;		
		return valor;
	}

}
