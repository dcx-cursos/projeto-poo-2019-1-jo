package ufpb.recuperaDados;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import ufpb.cartas.*;

public class RecuperaDadosDoTXT {

	public List<String> recuperaTextoDeArquivo(String nomeArquivo) throws IOException {
		BufferedReader leitor = null;
		List<String> textoLido = new ArrayList<String>();
		try {
			leitor = new BufferedReader(new FileReader(nomeArquivo));
			String texto = null;
			do {
				texto = leitor.readLine();

				if (texto != null) {
					textoLido.add(texto);
				}
			} while (texto != null);
		} finally {
			if (leitor != null) {
				leitor.close();
			}
		}
		return textoLido;
	}

	public LinkedList<SorteOuReves> recuperaCartas(String nomeArquivo) throws IOException {
		BufferedReader leitor = null;
		List<SorteOuReves> cartas = new LinkedList<SorteOuReves>();
		try {
			leitor = new BufferedReader(new FileReader(nomeArquivo));
			String texto = null;
			do {
				texto = leitor.readLine();
				if (texto != null) {
					String[] atributos = texto.split("%");
					if (atributos[1].equals("pague")) {
						cartas.add(new Pague(atributos[0], atributos[2]));
					} else if (atributos[1].equals("presente")) {
						cartas.add(new Presente(atributos[0], atributos[2]));
					} else if (atributos[1].equals("receba")) {
						cartas.add(new Receba(atributos[0], atributos[2]));

					} else if (atributos[1].equals("seLivraDaprisao")) {
						cartas.add(new HabeasCorpus(atributos[0], atributos[2]));

					} else if (atributos[1].equals("vaiParaPrisao")) {
						cartas.add(new VaPrisao(atributos[0], atributos[2]));

					}
				}
			} while (texto != null);
		} finally {
			if (leitor != null) {
				leitor.close();
			}
		}

		return (LinkedList<SorteOuReves>) cartas;
	}

}
