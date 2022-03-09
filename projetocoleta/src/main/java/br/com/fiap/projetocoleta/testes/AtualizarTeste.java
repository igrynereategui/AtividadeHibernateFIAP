package br.com.fiap.projetocoleta.testes;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.fiap.projetocoleta.domain.Parceiro;
import br.com.fiap.projetocoleta.domain.TipoResiduos;

public class AtualizarTeste {

	public static void main(String[] args) {

		EntityManager em = null;
		try {

			em = Persistence.createEntityManagerFactory("projetocoleta").createEntityManager();


			Parceiro updateParceiro = em.find(Parceiro.class, 1);

			updateParceiro.setNomeParceiro("Magalu");
			updateParceiro.setNumeroCnpj("59295434000666");
			updateParceiro.setQndDesconto(10);
			
			TipoResiduos updateResiduos1 = em.find(TipoResiduos.class, 1);
			updateResiduos1.setNomeResiduos("Vidro");
			
			TipoResiduos updateResiduos2 = em.find(TipoResiduos.class, 2);
			updateResiduos2.setNomeResiduos("Metal");


			em.merge(updateParceiro);
			em.merge(updateResiduos1);
			em.merge(updateResiduos2);
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