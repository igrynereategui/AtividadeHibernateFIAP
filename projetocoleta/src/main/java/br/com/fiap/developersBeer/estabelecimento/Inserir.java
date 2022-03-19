package br.com.fiap.developersBeer.estabelecimento;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.fiap.developersBeer.domain.Cervejaria;

public class Inserir {
	

	public static void main(String[] args) {

		EntityManager em = null;
		
		try {

			em = Persistence.createEntityManagerFactory("smartcities-orm").createEntityManager();

			Cervejaria cervejaria = new Cervejaria();

			cervejaria.setNomeEstabelecimento("Developers Beer");
			cervejaria.setEnderecoEstabelecimento("Rua não faço ideia");
			cervejaria.setContatoEstabelecimento("1111-1111");
			
			em.persist(cervejaria);
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

