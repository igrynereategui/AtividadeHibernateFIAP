package br.com.fiap.developersBeer.estabelecimento;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.fiap.developersBeer.domain.Cervejaria;

public class Consulta {

	public static void main(String[] args) {

		EntityManager em = null;
		try {

			em = Persistence.createEntityManagerFactory("smartcities-orm").createEntityManager();


			Cervejaria cervejariaDev =  em.find(Cervejaria.class, 1);			
			
			System.out.println();
			System.out.println(
					cervejariaDev.getNomeEstabelecimento() + "\n" +
					cervejariaDev.getContatoEstabelecimento() + "\n" +
					cervejariaDev.getEnderecoEstabelecimento()
					);


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


