package br.com.fiap.developersBeer.domain;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "tbl_cliente")


public class Cliente {
	
	public enum Genero {
		MASCULINO_CIS,
		FEMININO_CIS,
		MASCULINO_TRANS,
		FEMININO_TRANS,
		PREFIRO_NAO_MENCIONAR,
		OUTROS
	}

	@Id
	@SequenceGenerator(name="cliente",sequenceName="sq_tbl_cliente",allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="cliente")
	@Column(name = "id_cliente")
	private int IdCliente;
	
	@Column(name = "nome_cliente", length = 50)
	private String nomeCliente; 
	
	@Column(name = "contato_cliente", length = 50)
	private String contatoCliente; 
	
	@Column(name = "cpf_cliente", length = 50)
	private String cpfCliente; 
	
	@Column(name = "data_nasc_cliente", length = 30)
	private String dataNascCliente; 
	
	@Column(name = "endereco_cliente", length = 100)
	private String enderecoCliente;
	
	@Column(name = "genero_cliente", length = 10)
	private Genero generoCliente;
	
	@Column(name = "pontuacao_cliente", length = 100)
	private int pontuacaoCliente;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ultima_visita")
	private Calendar dt_ultima_visita;

	public int getIdCliente() {
		return IdCliente;
	}

	public void setIdCliente(int idCliente) {
		IdCliente = idCliente;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getContatoCliente() {
		return contatoCliente;
	}

	public void setContatoCliente(String contatoCliente) {
		this.contatoCliente = contatoCliente;
	}

	public String getCpfCliente() {
		return cpfCliente;
	}

	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}

	public String getDataNascCliente() {
		return dataNascCliente;
	}

	public void setDataNascCliente(String dataNascCliente) {
		this.dataNascCliente = dataNascCliente;
	}

	public String getEnderecoCliente() {
		return enderecoCliente;
	}

	public void setEnderecoCliente(String enderecoCliente) {
		this.enderecoCliente = enderecoCliente;
	}

	public Genero getGeneroCliente() {
		return generoCliente;
	}

	public void setGeneroCliente(Genero generoCliente) {
		this.generoCliente = generoCliente;
	}

	public int getPontuacaoCliente() {
		return pontuacaoCliente;
	}

	public void setPontuacaoCliente(int pontuacaoCliente) {
		this.pontuacaoCliente = pontuacaoCliente;
	}

	public Calendar getDt_ultima_visita() {
		return dt_ultima_visita;
	}

	public void setDt_ultima_visita(Calendar dt_ultima_visita) {
		this.dt_ultima_visita = dt_ultima_visita;
	}
	
	
}
