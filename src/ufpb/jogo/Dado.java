package ufpb.jogo;

import java.util.Random;

/**
 * Roll the dice
 * @author Joana
 * @return an integer value from 1 to 6. 
 */
public class Dado {
	public int lancaDado() {
		Random aleatorio = new Random();
		int valor = aleatorio.nextInt(6)+1;		
		return valor;
	}

}
