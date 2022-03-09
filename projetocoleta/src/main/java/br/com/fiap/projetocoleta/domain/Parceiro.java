package br.com.fiap.projetocoleta.domain;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "t_parceiro")
public class Parceiro {
	
	@Id
	@SequenceGenerator(name = "parceiro", sequenceName = "sq_t_parceiro", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "parceiro")
	@Column(name = "id_parceiro", nullable = false, length = 10)
	private int codigoParceiro;
	
	@Column(name = "nm_parceiro", nullable = false, length = 30)
	private String nomeParceiro;
	
	@Column(name = "nr_cnpj", nullable = false, length = 20)
	private String numeroCnpj;
	
	@Column(name = "qtd_desc", nullable = false, length = 3)
	private int qndDesconto;

	@OneToMany(mappedBy = "parceiro")
	private Collection<Promocao> promocoes;

	public Parceiro() {
		super();
	}

	
	public Parceiro(int codigoParceiro, String nomeParceiro, String numeroCnpj, int qndDesconto) {
		super();
		this.codigoParceiro = codigoParceiro;
		this.nomeParceiro = nomeParceiro;
		this.numeroCnpj = numeroCnpj;
		this.qndDesconto = qndDesconto;
	}

	public int getCodigoParceiro() {
		return codigoParceiro;
	}

	public void setCodigoParceiro(int codigoParceiro) {
		this.codigoParceiro = codigoParceiro;
	}

	public String getNomeParceiro() {
		return nomeParceiro;
	}

	public void setNomeParceiro(String nomeParceiro) {
		this.nomeParceiro = nomeParceiro;
	}

	public String getNumeroCnpj() {
		return numeroCnpj;
	}

	public void setNumeroCnpj(String numeroCnpj) {
		this.numeroCnpj = numeroCnpj;
	}

	public int getQndDesconto() {
		return qndDesconto;
	}

	public void setQndDesconto(int qndDesconto) {
		this.qndDesconto = qndDesconto;
	}

	
	
}
