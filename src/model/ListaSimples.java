package model;

public class ListaSimples {
	
	private NoSimples primeiro = null;
	private NoSimples ultimo = null;
	private int qt = 0;

	public void appendSimples(String nome) {
		
		NoSimples no = new NoSimples(nome);
		
		if (qt == 0) {
			this.primeiro = no;
			this.ultimo = no;
		} else if (qt == 1) {
			this.ultimo = no;
			this.primeiro.setProximo(ultimo);
		} else {
			this.ultimo.setProximo(no);
			this.ultimo = no;
			no.setProximo(null);
		}
		++qt;
	}
	
	public NoSimples getNoSimples(int index) throws Exception{
		
		if (qt == 0) {
			throw new Exception ("A lista está vazia.");
		} else if (index == 0) {
			return this.primeiro;
		} else if (index == (qt-1)) {
			return this.ultimo;
		} else if (index >= qt) {
			throw new Exception ("Indice inválido para a lista");
		} else {
			
			NoSimples no = this.primeiro; 
				for (int i = 1; i < index; i++) {
					no = no.getProximo();
				}
			return no;
		}
	}
	
	public int indexDoNome(String nome) throws Exception{
		if(this.primeiro.getPalavra() == nome) {
			return 0;
		}else {
			NoSimples guarda = this.primeiro;
			int i = 0;
			
			while(guarda.getProximo() != null) {
				++i;
				guarda = guarda.getProximo();
				
				if(guarda.getPalavra() == nome) {
					break;
				}
			}
			
			return i;
		}
		
		
		
	}
	
	public void remove(String nome) throws Exception {
		
		if (qt == 0) {
			throw new Exception ("A lista está vazia.");
		} else if (this.primeiro.getPalavra() == nome) {
			NoSimples anterior = this.primeiro.getProximo();
			this.primeiro = null;
			this.primeiro = anterior;
		} else if (this.ultimo.getPalavra() == nome) {
			NoSimples anterior = getNoSimples(qt-2);
			//qt-1 é o último, qt-2 é o penúltimo
			this.ultimo = null;
			this.ultimo = anterior;
		} else {
			
			NoSimples no = primeiro;
			int i;
			
			for (i = 1; i < qt; i++) {
				no = no.getProximo();
				if (no.getPalavra() == nome) {
					break;
				}
			}
			
			/*/
			 * como o i começa em 1 e a primeira  coisa do for é a alocação
			 * na verdade, o i está com o index do anterior
			/*/
			
			if (no.getPalavra() != null) {
				NoSimples anterior = getNoSimples(i);
				NoSimples proximo = no.getProximo();
				anterior.setProximo(proximo);
				no = null;
			} else {
				throw new Exception ("O elemento não está na lista");
			}
		}
		--qt;
	}
	
	@Override
	public String toString() {
		if (qt == 0) {
			return "[]";
		}
		StringBuilder builder = new StringBuilder("[");
		NoSimples no = primeiro;
		builder.append(no.getPalavra());
		
		for (int i = 1; i < qt; i++) {
			builder.append(", "); 
			no = no.getProximo();
			builder.append(no.getPalavra());
		}
		builder.append("]");
		return builder.toString();
	}
}
