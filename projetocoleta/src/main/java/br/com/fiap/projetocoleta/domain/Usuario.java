package br.com.fiap.projetocoleta.domain;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "t_user")
@Inheritance
public class Usuario {
	
	@Id
	@SequenceGenerator(name = "user", sequenceName = "sq_tb_user", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user")
	@Column(name = "id_user", nullable = false, length = 10)
	private int codigoUsuario;
	
	@Column(name = "qnt_residentes", nullable = false, length = 10)
	private int qntResidentes;

	@JoinColumn(name = "id_end")
	@ManyToOne
	private Endereco userEndereco;
	
	@OneToMany(mappedBy = "user")
	private Collection<Servico> servicos;

	public Usuario() {
		super();
	}


	public Usuario(int codigoUsuario, int qntResidentes) {
		super();
		this.codigoUsuario = codigoUsuario;
		this.qntResidentes = qntResidentes;
	}


	public int getCodigoUsuario() {
		return codigoUsuario;
	}


	public void setCodigoUsuario(int codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}


	public int getQntResidentes() {
		return qntResidentes;
	}


	public void setQntResidentes(int qntResidentes) {
		this.qntResidentes = qntResidentes;
	}
	
	
	

}
