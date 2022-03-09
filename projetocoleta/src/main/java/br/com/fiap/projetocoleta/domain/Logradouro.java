package br.com.fiap.projetocoleta.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "t_logra")	
public class Logradouro {
	
	@Id
	@SequenceGenerator(name = "logradouro", sequenceName = "sq_t_logradouro", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "logradouro")
	@Column(name = "id_logra", nullable = false, length = 10)
	private int codigoLogradouro;	
	
	
	@Column(name= "ds_logra", nullable = false, length = 30)
	private String nomeLogradouro;
	
	@JoinColumn(name = "id_bairro")
	@ManyToOne
	private Bairro bairros;
	
	@OneToOne
	@JoinColumn(name = "id_end")
	private Endereco endereco;


	public Logradouro() {
		super();
	}


	public Logradouro(int codigoLogradouro, String nomeLogradouro) {
		super();
		this.codigoLogradouro = codigoLogradouro;
		this.nomeLogradouro = nomeLogradouro;
	}


	public int getCodigoLogradouro() {
		return codigoLogradouro;
	}


	public void setCodigoLogradouro(int codigoLogradouro) {
		this.codigoLogradouro = codigoLogradouro;
	}


	public String getNomeLogradouro() {
		return nomeLogradouro;
	}


	public void setNomeLogradouro(String nomeLogradouro) {
		this.nomeLogradouro = nomeLogradouro;
	}



	
}