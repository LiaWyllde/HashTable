package model;

public class NoDuplo {
	
	private char letra;
	ListaSimples lista;
	private NoDuplo anterior = null;
	private NoDuplo proximo = null;
	
	public NoDuplo(char l) {
		this.letra = l;
		this.lista = new ListaSimples();
	}

	public char getLetra() {
		return letra;
	}

	public void setLetra(char letra) {
		this.letra = letra;
	}

	public NoDuplo getAnterior() {
		return anterior;
	}

	public void setAnterior(NoDuplo anterior) {
		this.anterior = anterior;
	}

	public NoDuplo getProximo() {
		return proximo;
	}

	public void setProximo(NoDuplo proximo) {
		this.proximo = proximo;
	}
}
