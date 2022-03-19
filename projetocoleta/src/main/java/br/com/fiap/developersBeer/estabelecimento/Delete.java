package br.com.fiap.developersBeer.estabelecimento;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.fiap.developersBeer.domain.Cervejaria;


public class Delete {

	public static void main(String[] args) {

		EntityManager em = null;
		try {

			em = Persistence.createEntityManagerFactory("smartcities-orm").createEntityManager();
			
			
			Cervejaria deletarCervejaria =  em.find(Cervejaria.class, 1);	
			em.remove(deletarCervejaria);
			

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
