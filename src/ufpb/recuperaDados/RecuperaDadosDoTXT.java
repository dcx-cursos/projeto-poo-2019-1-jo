package ufpb.recuperaDados;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

}
