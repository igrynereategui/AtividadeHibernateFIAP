package br.com.fiap.projetocoleta.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "t_tp_resid")	
public class TipoResiduos {
	
	@Id
	@SequenceGenerator(name = "tipoResiduos", sequenceName = "sq_tp_resid", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tipoResiduos")
	@Column(name = "id_tp_resid", nullable = false, length = 10)
	private int codigoTipoResiduos;	
	
	@Column(name= "nm_resid", nullable = false, length = 30)
	private String nomeResiduos;

	@JoinColumn(name = "id_coleta")
	@ManyToOne
	private Coleta coletaResiduos;

	public TipoResiduos() {
		super();
	}


	public TipoResiduos(int codigoTipoResiduos, String nomeResiduos) {
		super();
		this.codigoTipoResiduos = codigoTipoResiduos;
		this.nomeResiduos = nomeResiduos;
	}

	public int getCodigoTipoResiduos() {
		return codigoTipoResiduos;
	}

	public void setCodigoTipoResiduos(int codigoTipoResiduos) {
		this.codigoTipoResiduos = codigoTipoResiduos;
	}

	public String getNomeResiduos() {
		return nomeResiduos;
	}

	public void setNomeResiduos(String nomeResiduos) {
		this.nomeResiduos = nomeResiduos;
	}


}