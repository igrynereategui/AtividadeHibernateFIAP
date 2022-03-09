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
@Table(name = "t_tp_serv")	
public class TipoServico {
	
	@Id
	@SequenceGenerator(name = "tipoServico", sequenceName = "sq_tp_servico", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tipoServico")
	@Column(name = "id_tp_serv", nullable = false, length = 10)
	private int codigoTipoServico;
	
	@Column(name=" nm_tp_serv", nullable = false, length = 30)
	private String nomeServico;

	@OneToMany(mappedBy = "tipoServico")
	private Collection<Servico> servicos;
	
	public TipoServico() {
		super();
	}


	public TipoServico(int codigoTipoServico, String nomeServico) {
		super();
		this.codigoTipoServico = codigoTipoServico;
		this.nomeServico = nomeServico;
	}

	public int getCodigoTipoServico() {
		return codigoTipoServico;
	}

	public void setCodigoTipoServico(int codigoTipoServico) {
		this.codigoTipoServico = codigoTipoServico;
	}

	public String getNomeServico() {
		return nomeServico;
	}

	public void setNomeServico(String nomeServico) {
		this.nomeServico = nomeServico;
	}

	

}
