/**
 * 
 */
package com.conceicao.pontointeligente.api.service;

import java.util.Optional;

import com.conceicao.pontointeligente.api.entities.Empresa;

/**
 * @author Antonio Cicero 4 de jan de 2018
 */
public interface EmpresaService {

	/**
	 * Retona uma empresa dado um CNPJ
	 * 
	 * @param cnpj
	 * @return
	 */
	Optional<Empresa> buscaPorCnpj(String cnpj);

	/**
	 * Cadastra uma nova empresa na base de Dados
	 * 
	 * @param empresa
	 * @return
	 */
	Empresa persist(Empresa empresa);
}
