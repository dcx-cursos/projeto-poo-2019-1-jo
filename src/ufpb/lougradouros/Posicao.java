package ufpb.lougradouros;

import ufpb.jogo.JogoFacade;

//MUDAR NOME DA INTERFACE SEGUNDO CLEBSON
public interface Posicao {

	public void evento(JogoFacade jogo);
	public int getNumeroDePosicao();
	public String getTipo();


}
