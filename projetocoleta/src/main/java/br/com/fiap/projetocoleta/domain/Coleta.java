package br.com.fiap.projetocoleta.domain;

import java.util.Calendar;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;


@Entity
@Table(name = "t_coleta")	
public class Coleta {
	
	@Id
	@SequenceGenerator(name = "coleta", sequenceName = "sq_t_coleta", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "coleta")
	@Column(name = "id_coleta", nullable = false, length = 10)
	private int codigoColeta;
	
	@CreationTimestamp
	@Column(name= "hr_coleta", nullable = false)
	private Calendar horaColeta;

	@OneToOne(mappedBy = "coleta")
	private Servico servico;
	
	@OneToMany(mappedBy = "coletaResiduos")
	private Collection<TipoResiduos> residuos;
		

	public Coleta() {
		super();
	}



	public Coleta(int codigoColeta, Calendar horaColeta) {
		super();
		this.codigoColeta = codigoColeta;
		this.horaColeta = horaColeta;
	}

	public int getCodigoColeta() {
		return codigoColeta;
	}

	public void setCodigoColeta(int codigoColeta) {
		this.codigoColeta = codigoColeta;
	}

	public Calendar getHoraColeta() {
		return horaColeta;
	}

	public void setHoraColeta(Calendar horaColeta) {
		this.horaColeta = horaColeta;
	}
	
	
}	