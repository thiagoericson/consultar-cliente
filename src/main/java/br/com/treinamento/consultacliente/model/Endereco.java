package br.com.treinamento.consultacliente.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="enderecos")
public class Endereco {

	//	  id integer not null identity(1,1),
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	//    logradouro varchar(100) not null,
	private String logradouro;
	
	//    numero int not null,
	private Integer numero;

	//    bairro varchar(100) not null,
	private String bairro;
	
	//    cidade varchar(100) not null,
	private String cidade;
	
	//    uf char(2) not null,
	private String uf;
	
	//    cep char(8) not null,
	private String cep;

	//    id_cliente int not null,
	@ManyToOne
	@JoinColumn(name="id_cliente")
	private Cliente cliente;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
}
