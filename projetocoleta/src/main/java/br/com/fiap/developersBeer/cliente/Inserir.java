package br.com.fiap.developersBeer.cliente;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.fiap.developersBeer.domain.Cliente;
import br.com.fiap.developersBeer.domain.Cliente.Genero;

public class Inserir {

	public static void main(String[] args) {

		EntityManager em = null;

		try {

			em = Persistence.createEntityManagerFactory("developersbeer").createEntityManager();

			Cliente cliente1 = new Cliente();
			Genero genero = Genero.MASCULINO_CIS;
			
			cliente1.setNomeCliente("Eliel Dantas");
			cliente1.setCpfCliente("111.111.111-11");
			cliente1.setContatoCliente("91111-1111");
			cliente1.setEnderecoCliente("Avenida Paulista");
			cliente1.setGeneroCliente(genero);
			cliente1.setPontuacaoCliente(10);

			em.persist(cliente1);
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
