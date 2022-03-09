package br.com.fiap.projetocoleta.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "t_user_pj")	
public class UsuarioPJ extends Usuario {
	
	
	@Column(name= "nm_empresa", nullable = false, length = 30)
	private String nomeEmpresa;
	
	@Column(name= "nr_cnpj", nullable = false, length = 20)
	private String cnpj;
	
	@Column(name= "nm_fantasia", nullable = false, length = 30)
	private String nomeFantasia;


	public UsuarioPJ() {
		super();
	}


	public UsuarioPJ(String nomeEmpresa, String cnpj, String nomeFantasia) {
		super();
		this.nomeEmpresa = nomeEmpresa;
		this.cnpj = cnpj;
		this.nomeFantasia = nomeFantasia;
	}


	public String getNomeEmpresa() {
		return nomeEmpresa;
	}


	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}


	public String getCnpj() {
		return cnpj;
	}


	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}


	public String getNomeFantasia() {
		return nomeFantasia;
	}


	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}
	
	
	
}