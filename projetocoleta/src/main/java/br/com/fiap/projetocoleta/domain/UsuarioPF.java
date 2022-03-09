package br.com.fiap.projetocoleta.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "t_user_pf")	
public class UsuarioPF extends Usuario {
	
	
	@Column(name= "nm_user", nullable = false, length = 30)
	private String nomeUsuario;
	
	@Column(name= "nr_cpf", nullable = false, length = 20)
	private String cpf;
	
	@Column(name= "nr_idade", nullable = false, length = 3)
	private int idadeUsuario;


	public UsuarioPF() {
		super();
	}


	public UsuarioPF(String nomeUsuario, String cpf, int idadeUsuario) {
		super();
		this.nomeUsuario = nomeUsuario;
		this.cpf = cpf;
		this.idadeUsuario = idadeUsuario;
	}


	public String getNomeUsuario() {
		return nomeUsuario;
	}


	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public int getIdadeUsuario() {
		return idadeUsuario;
	}


	public void setIdadeUsuario(int idadeUsuario) {
		this.idadeUsuario = idadeUsuario;
	}
	
	
	
	
	
	
}


