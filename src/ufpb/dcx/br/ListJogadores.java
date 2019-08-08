package ufpb.dcx.br;

public class ListJogadores {
	private int tamanho;
	private No sentinela;

	public ListJogadores() {
		this.sentinela = new No();
		this.sentinela.proximo = this.sentinela;
		this.sentinela.anterior = this.sentinela;
	}

	public boolean isEmpty() {
		return this.tamanho == 0;
	}

	public int size() {
		return this.tamanho;
	}

	public void adicionarNoInicio(Jogador item) {
		No novoNo = new No(item);
		if (isEmpty()) {
			novoNo.anterior = this.sentinela;
			novoNo.proximo = this.sentinela;
			this.sentinela.proximo = novoNo;
			this.sentinela.anterior = novoNo;
		} else {
			novoNo.proximo = sentinela.proximo;
			novoNo.anterior = this.sentinela;
			this.sentinela.proximo.anterior = novoNo;
			this.sentinela.proximo = novoNo;
		}
		this.tamanho++;
	}

	public void adicionarNoFim(Jogador item) {
		No ultimo = sentinela.anterior;
		No x = new No(item);

		x.proximo = sentinela;
		x.anterior = ultimo;
		sentinela.anterior = x;
		ultimo.proximo = x;
		this.tamanho++;
	}

	public void removeElemento(Jogador jogador) {
		No x = this.sentinela.proximo;
		for (; x != this.sentinela; x = x.proximo) {
			if (x.jogador.equals(jogador)) {
				x.anterior.proximo = x.proximo;
				x.proximo.anterior = x.anterior;
				x = null;
				this.tamanho--;
				break;
			}
		}
	}

	public Jogador procuraJogadorNaListaDeJogadores(String cor) throws JogadorNaoExisteException {
		No x = this.sentinela.proximo;
		for (; x != this.sentinela; x = x.proximo) {
			if (x.jogador.getCor().equals(cor)) {
				return x.jogador;
			}
		}
		throw new JogadorNaoExisteException("O jogador da cor " + cor + " nao existe");
	}

	private class No {
		protected Jogador jogador;
		protected No proximo;
		protected No anterior;

		public No() {
			this.jogador = null;
			this.proximo = null;
			this.anterior = null;
		}

		public No(Jogador j) {
			this();
			this.jogador = j;
		}

	}
}
