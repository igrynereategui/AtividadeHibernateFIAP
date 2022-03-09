package br.com.fiap.projetocoleta.testes;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.fiap.projetocoleta.domain.Parceiro;
import br.com.fiap.projetocoleta.domain.TipoResiduos;

public class ConsultaTeste {

	public static void main(String[] args) {

		EntityManager em = null;
		try {

			em = Persistence.createEntityManagerFactory("projetocoleta").createEntityManager();

			
			Parceiro parceiro = em.find(Parceiro.class, 1);
			TipoResiduos residuos1 = em.find(TipoResiduos.class, 1);
			TipoResiduos residuos2 = em.find(TipoResiduos.class, 2);
			
			System.out.println("");
			
			System.out.println(parceiro.getCodigoParceiro() + " " +
							   parceiro.getNomeParceiro() + " " +
							   parceiro.getNumeroCnpj() + " " +
							   parceiro.getQndDesconto() + "%");
			
			
			System.out.println(residuos1.getCodigoTipoResiduos() + " " +
							   residuos1.getNomeResiduos());
			
			
			System.out.println(residuos2.getCodigoTipoResiduos() + " " +
							   residuos2.getNomeResiduos());
			

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
