package controller;
import model.ListaSimples;
public class TesteListaSimples {
	
	public static void testeListaSimples() {
		try {
			ListaSimples lista = new ListaSimples();
			
			lista.appendSimples("A");
			lista.appendSimples("B");
			lista.appendSimples("C");
			lista.appendSimples("D");

			System.out.println(lista.toString());
			lista.remove("D");
			System.out.println(lista.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
