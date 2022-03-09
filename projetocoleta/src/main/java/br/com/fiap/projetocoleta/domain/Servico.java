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
@Table(name = "t_servico")
public class Servico {
	
	@Id
	@SequenceGenerator(name = "servico", sequenceName = "sq_tb_servico", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "servico")
	@Column(name = "id_serv", nullable = false, length = 10)
	private int codigoServico;
	
	@CreationTimestamp
	@Column(name=" dt_serv", nullable = false)
	private Calendar dataServico;

	@JoinColumn(name = "id_user")
	@ManyToOne
	private Usuario user;
	
	@OneToOne
	@JoinColumn(name = "id_promo")
	private Promocao promocao;
	
	@JoinColumn(name = "id_tp_serv")
	@ManyToOne
	private TipoServico tipoServico;
	
	@OneToOne
	@JoinColumn(name = "id_coleta")
	private Coleta coleta;
	
	@OneToOne
	@JoinColumn(name = "id_relat")
	private Relatorio relatorio;

}
