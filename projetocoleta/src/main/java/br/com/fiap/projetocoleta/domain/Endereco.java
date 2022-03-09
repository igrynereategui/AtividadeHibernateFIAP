package br.com.fiap.projetocoleta.domain;

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


@Entity
@Table(name = "t_end")	
public class Endereco {
	
	@Id
	@SequenceGenerator(name = "endereco", sequenceName = "sq_t_endereco", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "endereco")
	@Column(name = "id_end", nullable = false, length = 10)
	private int codigoEndereco;	
	
	@Column(name = "cep_end", nullable = false, length = 8)
	private int cepEndereco;	
	
	
	@Column(name= "ds_end", nullable = false, length = 30)
	private String nomeEndereco;

	@OneToOne(mappedBy = "endereco")
	private Logradouro logradouro;
	
	@OneToMany(mappedBy = "userEndereco")
	private Collection<Usuario> usuarios;

	public Endereco() {
		super();
	}


	public Endereco(int codigoEndereco, int cepEndereco, String nomeEndereco) {
		super();
		this.codigoEndereco = codigoEndereco;
		this.cepEndereco = cepEndereco;
		this.nomeEndereco = nomeEndereco;
	}


	public int getCodigoEndereco() {
		return codigoEndereco;
	}


	public void setCodigoEndereco(int codigoEndereco) {
		this.codigoEndereco = codigoEndereco;
	}


	public int getCepEndereco() {
		return cepEndereco;
	}


	public void setCepEndereco(int cepEndereco) {
		this.cepEndereco = cepEndereco;
	}


	public String getNomeEndereco() {
		return nomeEndereco;
	}


	public void setNomeEndereco(String nomeEndereco) {
		this.nomeEndereco = nomeEndereco;
	}
	
	
	
}
