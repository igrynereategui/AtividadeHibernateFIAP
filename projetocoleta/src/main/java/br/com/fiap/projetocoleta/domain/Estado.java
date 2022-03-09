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
@Table(name = "t_estado")	
public class Estado {
	
	@Id
	@SequenceGenerator(name = "estado", sequenceName = "sq_t_estado", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "estado")
	@Column(name = "id_estado", nullable = false, length = 10)
	private int codigoEstado;	
	
	@Column(name = "nm_estado", nullable = false, length = 30)
	private String nomeEstado;
	
	@OneToMany(mappedBy = "estado")
	private Collection<Cidade> cidades;


	public Estado() {
		super();
	}

	public Estado(int codigoEstado, String nomeEstado) {
		super();
		this.codigoEstado = codigoEstado;
		this.nomeEstado = nomeEstado;
	}

	public int getCodigoEstado() {
		return codigoEstado;
	}

	public void setCodigoEstado(int codigoEstado) {
		this.codigoEstado = codigoEstado;
	}

	public String getNomeEstado() {
		return nomeEstado;
	}

	public void setNomeEstado(String nomeEstado) {
		this.nomeEstado = nomeEstado;
	}

	
	
}