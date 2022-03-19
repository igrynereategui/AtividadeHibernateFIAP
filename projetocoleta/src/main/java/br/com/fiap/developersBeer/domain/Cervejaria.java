package br.com.fiap.developersBeer.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "tbl_cervejaria")

public class Cervejaria {
	
	
	@Id
	@SequenceGenerator(name="cervejaria",sequenceName="sq_tbl_cervejaria",allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="cervejaria")
	@Column(name = "id_cervejaria")
	private int IdEstabelecimento;
	
	@Column(name = "nome_estabelecimento", length = 50)
	private String nomeEstabelecimento; 
	
	@Column(name = "contato_estabelecimento", length = 50)
	private String contatoEstabelecimento; 
	
	@Column(name = "endereco_estabelecimento", length = 100)
	private String enderecoEstabelecimento;

	public int getIdEstabelecimento() {
		return IdEstabelecimento;
	}

	public void setIdEstabelecimento(int idEstabelecimento) {
		IdEstabelecimento = idEstabelecimento;
	}

	public String getNomeEstabelecimento() {
		return nomeEstabelecimento;
	}

	public void setNomeEstabelecimento(String nomeEstabelecimento) {
		this.nomeEstabelecimento = nomeEstabelecimento;
	}

	public String getContatoEstabelecimento() {
		return contatoEstabelecimento;
	}

	public void setContatoEstabelecimento(String contatoEstabelecimento) {
		this.contatoEstabelecimento = contatoEstabelecimento;
	}

	public String getEnderecoEstabelecimento() {
		return enderecoEstabelecimento;
	}

	public void setEnderecoEstabelecimento(String enderecoEstabelecimento) {
		this.enderecoEstabelecimento = enderecoEstabelecimento;
	}
	
}
