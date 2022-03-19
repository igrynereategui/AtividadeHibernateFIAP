package br.com.fiap.developersBeer.estabelecimento;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.fiap.developersBeer.domain.Cervejaria;



public class Atualizar {
	
	public static void main(String[] args) {

		EntityManager em = null;
		try {

			em = Persistence.createEntityManagerFactory("developersbeer").createEntityManager();


			Cervejaria updateCervejaria =  em.find(Cervejaria.class, 1);		
			
			updateCervejaria.setNomeEstabelecimento("Drunk Devs");
			updateCervejaria.setContatoEstabelecimento("2222-2222");
			updateCervejaria.setEnderecoEstabelecimento("Avenida Paulista");
			
			em.merge(updateCervejaria);
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
