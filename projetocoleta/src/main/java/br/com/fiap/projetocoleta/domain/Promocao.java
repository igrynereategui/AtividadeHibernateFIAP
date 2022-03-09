package br.com.fiap.projetocoleta.domain;

import java.util.Calendar;

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

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "t_promo")
public class Promocao {
	
	@Id
	@SequenceGenerator(name = "promocao", sequenceName = "sq_t_promo", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "promocao")
	@Column(name = "id_promo", nullable = false, length = 10)
	private int codigoPromocao;
	
	@CreationTimestamp
	@Column(name = "dt_promo", nullable = false)
	private Calendar dataPromocao;

	@OneToOne(mappedBy = "promocao")
	private Servico promocao;
	
	@JoinColumn(name = "id_parceiro")
	@ManyToOne
	private Parceiro parceiro;

	public Promocao() {
		super();
	}


	public Promocao(int codigoPromocao, Calendar dataPromocao) {
		super();
		this.codigoPromocao = codigoPromocao;
		this.dataPromocao = dataPromocao;
	}

	public int getCodigoPromocao() {
		return codigoPromocao;
	}

	public void setCodigoPromocao(int codigoPromocao) {
		this.codigoPromocao = codigoPromocao;
	}

	public Calendar getDataPromocao() {
		return dataPromocao;
	}

	public void setDataPromocao(Calendar dataPromocao) {
		this.dataPromocao = dataPromocao;
	}
	
	
	
}
