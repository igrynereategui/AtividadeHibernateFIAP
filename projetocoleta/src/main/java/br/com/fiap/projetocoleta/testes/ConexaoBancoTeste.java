package br.com.fiap.projetocoleta.testes;


import javax.persistence.Persistence;


public class ConexaoBancoTeste {

	public static void main(String[] args) {
		Persistence.createEntityManagerFactory("projetocoleta").createEntityManager();
	}
}