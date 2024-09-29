package model;

public class NoSimples {
	
	private String palavra;
	private NoSimples proximo;
	
	public NoSimples(String nome) {
		this.palavra = nome;
	}
	
	public String getPalavra() {
		return palavra;
	}
	
	public void setPalavra(String palavra) {
		this.palavra = palavra;
	}
	
	public NoSimples getProximo() {
		return proximo;
	}
	
	public void setProximo(NoSimples proximo) {
		this.proximo = proximo;
	}
}
