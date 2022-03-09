package br.com.fiap.projetocoleta.testes;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.fiap.projetocoleta.domain.Parceiro;
import br.com.fiap.projetocoleta.domain.TipoResiduos;

public class RemoverTeste {

	public static void main(String[] args) {

		EntityManager em = null;
		try {

			em = Persistence.createEntityManagerFactory("projetocoleta").createEntityManager();

			Parceiro deletarParceiro = em.find(Parceiro.class, 1);
			em.remove(deletarParceiro);
			
			TipoResiduos deletarResiduos1 = em.find(TipoResiduos.class, 1);
			em.remove(deletarResiduos1);
			
			TipoResiduos deletarResiduos2 = em.find(TipoResiduos.class, 2);
			em.remove(deletarResiduos2);
			
			
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
