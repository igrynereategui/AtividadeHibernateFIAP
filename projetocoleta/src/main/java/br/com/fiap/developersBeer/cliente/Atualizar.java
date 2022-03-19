package br.com.fiap.developersBeer.cliente;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.fiap.developersBeer.domain.Cliente;
import br.com.fiap.developersBeer.domain.Cliente.Genero;

public class Atualizar {
	
	public static void main(String[] args) {

		EntityManager em = null;
		try {

			em = Persistence.createEntityManagerFactory("developersbeer").createEntityManager();


			Cliente updatecliente1 = em.find(Cliente.class, 1);
			Genero genero = Genero.MASCULINO_CIS;
			
			updatecliente1.setNomeCliente("Eliel Dantas");
			updatecliente1.setCpfCliente("123.123.234-11");
			updatecliente1.setContatoCliente("91111-1111");
			updatecliente1.setEnderecoCliente("Rua Oscar Freire");
			updatecliente1.setGeneroCliente(genero);
			updatecliente1.setPontuacaoCliente(10);
			
			em.merge(updatecliente1);
			em.getTransaction().begin();
			em.getTransaction().commit();
			

		} catch (Exception e) {
			if (em != null && em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			e.printStackTrace();
		} finally {
			if (em != null) {
				em.close();
			}
			System.exit(0);
		}
	}


}
