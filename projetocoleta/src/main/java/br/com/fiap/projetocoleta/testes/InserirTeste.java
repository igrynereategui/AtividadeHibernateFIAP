package br.com.fiap.projetocoleta.testes;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.fiap.projetocoleta.domain.Parceiro;
import br.com.fiap.projetocoleta.domain.TipoResiduos;

public class InserirTeste {

	public static void main(String[] args) {

		EntityManager em = null;
		try {

			em = Persistence.createEntityManagerFactory("projetocoleta").createEntityManager();

			Parceiro parceiro = new Parceiro();

			parceiro.setNomeParceiro("Casas Bahias");
			parceiro.setNumeroCnpj("59291534000167");
			parceiro.setQndDesconto(20);
			
			TipoResiduos residuos1 = new TipoResiduos();
			residuos1.setNomeResiduos("Orgânico");
			
			TipoResiduos residuos2 = new TipoResiduos();
			residuos2.setNomeResiduos("Papel");
			

			em.persist(parceiro);
			em.persist(residuos1);
			em.persist(residuos2);
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
