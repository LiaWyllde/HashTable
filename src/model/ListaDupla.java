package model;

public class ListaDupla {
	
	private String alfabeto = "BCDEFGHIJKLMNOPQRSTUVWXY";
	private NoDuplo primeiro;
	private NoDuplo ultimo;
	private int qt = 2;
	
	public ListaDupla() {
		this.primeiro = new NoDuplo('A');
		this.ultimo = new NoDuplo('Z');
		setAnteriores();
		setProximos();
	}

	private void setAnteriores() {
		
		char[] alfabet = alfabeto.toCharArray();
		NoDuplo anterior = this.primeiro;
		
		for (char letra : alfabet) {
			NoDuplo noDuplo = new NoDuplo(letra);
			noDuplo.setAnterior(anterior);
			anterior = noDuplo;
			++qt;
		}
		this.ultimo.setAnterior(anterior);
	}

	private void setProximos() {
		
		NoDuplo proximo = this.ultimo;
		NoDuplo defineProximo = this.ultimo.getAnterior();
		
		for (int i = 0; i < 24; i++) {
			defineProximo.setProximo(proximo);
			proximo = defineProximo;
			defineProximo = defineProximo.getAnterior();
		}
		this.primeiro.setProximo(proximo);
	}
	
	public void adicionaNome(String nome) {
		char primeira = nome.charAt(0);
		
		NoDuplo nozinho = this.primeiro;
		
		if (primeiro.getLetra() == primeira) {
			this.primeiro.lista.appendSimples(nome);
			nozinho = primeiro;
			System.out.println(nozinho.lista.toString());
			//A lista do primeiro nó recebe o nome passado
		} else if (ultimo.getLetra() == primeira) {
			this.ultimo.lista.appendSimples(nome);
			nozinho = ultimo;
			System.out.println(nozinho.lista.toString());
		} else {
			for (int i = 1; i < qt; i++) {
				nozinho = nozinho.getProximo();				
				if (nozinho.getLetra() == primeira) {
					nozinho.lista.appendSimples(nome);
					System.out.println(nozinho.lista.toString());
				}
			}
		}
	}
	
	private int encontraNo(char primeira) {
		NoDuplo nozinho = this.primeiro;
		if (primeira == primeiro.getLetra()) {
			return 0;
		} else {
			int i = 0;
			for (i = 1; i < qt; i++) {
				nozinho = nozinho.getProximo();
				if (nozinho.getLetra() == primeira) {
					return i;
				}
			}
			return i;
		}
	}
	
	private NoDuplo enviaNo(char primeira) {
		NoDuplo nozinho = this.primeiro;
		if (primeira == primeiro.getLetra()) {
			return nozinho;
		} else {
			int i = 0;
			for (i = 1; i < qt; i++) {
				nozinho = nozinho.getProximo();
				if (nozinho.getLetra() == primeira) {
					return nozinho;
				}
			}
			return nozinho;
		}
	}

	public void removePessoa(String nome) {
		char letra = nome.charAt(0);
		NoDuplo cade = enviaNo(letra);
		
		System.out.println(cade.lista.toString());

		try {
			cade.lista.remove(nome);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(cade.lista.toString());
	}
	
	public void encontraPessoa(String nome) throws Exception {
		
		char letra = nome.charAt(0);
		int arquivo = encontraNo(letra);
		
//		System.out.println("O fulano está no arquivo: " + (arquivo + 1));
		NoDuplo cade = enviaNo(letra);
		int pos = cade.lista.indexDoNome(nome);
		System.out.println("O fulano está no arquivo: " + (arquivo + 1) + " na posição: " + (pos+1));
		
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("[");
		builder.append(primeiro.getLetra());
		NoDuplo no = primeiro.getProximo();
		
		for (int i = 0; i < 25; i++) {
			builder.append(", ");
			builder.append(no.getLetra());
			no = no.getProximo();
		}
		builder.append("]");
		return builder.toString();
	}
}
