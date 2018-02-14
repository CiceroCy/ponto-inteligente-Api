/**
 * 
 */
package com.conceicao.pontointeligente.api.service;

import com.conceicao.pontointeligente.api.entities.Funcionario;

/**
 * @author Antonio Cicero 
 * 4 de jan de 2018
 */

public interface FuncionarioService {

	/**
	 * Busca um FUncionario pelo CPF
	 * 
	 * @param cpf
	 * @return
	 */
	Funcionario buscaPorCpf(String cpf);

	/**
	 * BUsca funcionario pelo Email
	 * 
	 * @param email
	 * @return
	 */
	Funcionario buscaPorEmail(String email);

	/**
	 * Busca Funcionario pelo CPF ou Pelo EMail
	 * 
	 * @param cpf
	 * @param email
	 * @return
	 */
	Funcionario buscaPorCpfOuEmail(String cpf, String email);

	/**
	 * Persisti um funcionario na base de dados
	 * 
	 * @param funcionario
	 * @return
	 */
	Funcionario persist(Funcionario funcionario);

}
