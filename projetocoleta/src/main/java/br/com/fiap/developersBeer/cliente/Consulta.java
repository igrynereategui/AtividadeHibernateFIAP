package br.com.fiap.developersBeer.cliente;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.fiap.developersBeer.domain.Cliente;

public class Consulta {
	public static void main(String[] args) {

		EntityManager em = null;
		try {

			em = Persistence.createEntityManagerFactory("developersbeer").createEntityManager();

			Cliente cliente1 = em.find(Cliente.class, 1);

			System.out.println();
			System.out.println(
			cliente1.getNomeCliente() + "\n" +
			cliente1.getGeneroCliente() + "\n " +
			cliente1.getCpfCliente() + "\n " +
			cliente1.getContatoCliente() + "\n " +
			cliente1.getDt_ultima_visita() + "\n "
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
