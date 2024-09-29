package controller;

import model.ListaDupla;

public class TesteListaDupla {
	
	
	public static void main(String[] args) throws Exception {
		ListaDupla listaDupla = new ListaDupla();
		
		listaDupla.adicionaNome("Amanda");
		listaDupla.adicionaNome("Amaro");
		listaDupla.adicionaNome("Alvaro");
		listaDupla.adicionaNome("Camila");
		listaDupla.adicionaNome("Vampeta");
		listaDupla.adicionaNome("Kayaky");
		listaDupla.adicionaNome("Kaky");
		listaDupla.adicionaNome("Kayky");
		listaDupla.adicionaNome("Kay");
		
		listaDupla.removePessoa("Kay");
		
		listaDupla.encontraPessoa("Alvaro");
		
		
		
	}
	
}
