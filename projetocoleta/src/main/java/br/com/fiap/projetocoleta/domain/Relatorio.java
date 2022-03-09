package br.com.fiap.projetocoleta.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "t_relatorio")	
public class Relatorio {
	
	@Id
	@SequenceGenerator(name = "relatorio", sequenceName = "sq_t_relatorio", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "relatorio")
	@Column(name = "id_relat", nullable = false, length = 10)
	private int codigoRelatorio;	
	
	@Column(name= "nm_relat", nullable = false, length = 30)
	private String nomeRelatorio;
	
	@OneToOne(mappedBy = "relatorio")
	private Servico servico;

	public Relatorio() {
		super();
	}

	public Relatorio(int codigoRelatorio, String nomeRelatorio) {
		super();
		this.codigoRelatorio = codigoRelatorio;
		this.nomeRelatorio = nomeRelatorio;
	}

	public int getCodigoRelatorio() {
		return codigoRelatorio;
	}

	public void setCodigoRelatorio(int codigoRelatorio) {
		this.codigoRelatorio = codigoRelatorio;
	}

	public String getNomeRelatorio() {
		return nomeRelatorio;
	}

	public void setNomeRelatorio(String nomeRelatorio) {
		this.nomeRelatorio = nomeRelatorio;
	}
	
	
}