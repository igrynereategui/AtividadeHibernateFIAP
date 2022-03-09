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
@Table(name = "t_cidade")	
public class Cidade {
	
	@Id
	@SequenceGenerator(name = "cidade", sequenceName = "sq_t_cidade", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cidade")
	@Column(name = "id_cidade", nullable = false, length = 10)
	private int codigoCidade;	
	
	@Column(name = "nm_cidade", nullable = false, length = 30)
	private String nomeCidade;

	@JoinColumn(name = "id_estado")
	@ManyToOne
	private Estado estado;
	
	@OneToMany(mappedBy = "cidade")
	private Collection<Bairro> bairros;
	
	public Cidade() {
		super();
	}


	public Cidade(int codigoCidade, String nomeCidade) {
		super();
		this.codigoCidade = codigoCidade;
		this.nomeCidade = nomeCidade;
	}

	public int getCodigoCidade() {
		return codigoCidade;
	}

	public void setCodigoCidade(int codigoCidade) {
		this.codigoCidade = codigoCidade;
	}

	public String getNomeCidade() {
		return nomeCidade;
	}

	public void setNomeCidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
	}
	
	
}