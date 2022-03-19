package br.com.fiap.developersBeer.cliente;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.fiap.developersBeer.domain.Cliente;

public class Delete {

	public static void main(String[] args) {

		EntityManager em = null;
		try {

			em = Persistence.createEntityManagerFactory("developersbeer").createEntityManager();
			
			
			Cliente deletarcliente1 =  em.find(Cliente.class, 1);	
			em.remove(deletarcliente1);
			

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
