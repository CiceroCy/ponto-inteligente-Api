
package com.conceicao.pontointeligente.api.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

/**
 * @author Antonio Cicero
 * 03/01/2018
 */
@Entity
@Table(name = "empresa")
public class Empresa implements Serializable {

	
	private static final long serialVersionUID = 6601263500690949142L;
	
	private Long id;
	private String razaoSocial;
	private String cnpj;
	private Date dataCriacao;
	private Date dataAtualizacao;
	private List<Funcionario> funcionarios;
	

	public Empresa() {
		
	}


	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}


	/**
	 * @return the razaoSocial
	 */
	@Column(name = "razao_social",nullable= false)
	public String getRazaoSocial() {
		return razaoSocial;
	}


	/**
	 * @param razaoSocial the razaoSocial to set
	 */
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}


	/**
	 * @return the cnpj
	 */
	@Column(name = "cnpj",nullable = false)
	public String getCnpj() {
		return cnpj;
	}


	/**
	 * @param cnpj the cnpj to set
	 */
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}


	/**
	 * @return the dataCriacao
	 */
	@Column(name = "data_criacao",nullable = false)
	public Date getDataCriacao() {
		return dataCriacao;
	}


	/**
	 * @param dataCriacao the dataCriacao to set
	 */
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}


	/**
	 * @return the dataAtualizacao
	 */
	@Column(name = "data_atualizacao",nullable = false)
	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}


	/**
	 * @param dataAtualizacao the dataAtualizacao to set
	 */
	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}


	/**
	 * @return the funcionarios
	 */
	@OneToMany(mappedBy = "empresa",fetch= FetchType.LAZY, cascade=CascadeType.ALL)
	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}


	/**
	 * @param funcionarios the funcionarios to set
	 */
	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}
	
	@PreUpdate
	public void preUpdate() {
		dataAtualizacao=new Date();
	}
	
	@PrePersist
	public void prePersist() {
		final Date atual=new Date();
		dataCriacao=atual;
		dataAtualizacao=atual;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Empresa [id=" + id + ", razaoSocial=" + razaoSocial + ", cnpj=" + cnpj + ", dataCriacao=" + dataCriacao
				+ ", dataAtualizacao=" + dataAtualizacao + "]";
	}
	
	
}
