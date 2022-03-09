package br.com.fiap.projetocoleta.domain;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "t_bairro")	
public class Bairro {
	
	@Id
	@SequenceGenerator(name = "bairro", sequenceName = "sq_t_bairro", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bairro")
	@Column(name = "id_bairro", nullable = false, length = 10)
	private int codigoBairro;	
	
	@Column(name = "nm_bairro", nullable = false, length = 30)
	private String nomeBairro;

	@JoinColumn(name = "id_cidade")
	@ManyToOne
	private Cidade cidade;

	@OneToMany(mappedBy = "bairros")
	private Collection<Logradouro> logradouros;
	

	public Bairro() {
		super();
	}


	public Bairro(int codigoBairro, String nomeBairro) {
		super();
		this.codigoBairro = codigoBairro;
		this.nomeBairro = nomeBairro;
	}

	public int getCodigoBairro() {
		return codigoBairro;
	}

	public void setCodigoBairro(int codigoBairro) {
		this.codigoBairro = codigoBairro;
	}

	public String getNomeBairro() {
		return nomeBairro;
	}

	public void setNomeBairro(String nomeBairro) {
		this.nomeBairro = nomeBairro;
	}	
	
	
	
	
}


