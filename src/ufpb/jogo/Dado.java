package ufpb.jogo;

import java.util.Random;

public class Dado {
	public int lancaDado() {
		Random aleatorio = new Random();
		int valor = aleatorio.nextInt(6)+1;		
		return valor;
	}

}
