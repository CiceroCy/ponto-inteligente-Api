/**
 * 
 */
package com.conceicao.pontointeligente.api.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.conceicao.pontointeligente.api.entities.Lancamento;

/**
 * @author Antonio Cicero
 * 13 de fev de 2018
 */
public interface LanmcamentoService {
	
	/**
	 * Retorna uma lista paginada de lançamentos de um determinado funcionario
	 * @param funcionarioId
	 * @param pageRequest
	 * @return Page<Lançamento>
	 */
	Page<Lancamento> buscarPorFuncionarioId(Long funcionarioId,PageRequest pageRequest);
	
	/**
	 * Busca Funcionario por Id
	 * @param Id
	 * @return Optional<Lancamento>
	 */
	Optional<Lancamento>buscaPorId(Long Id);
	
	/**
	 * Persisti um lancamento na base de Dados
	 * 
	 * @param lancamento
	 * @return lancamento
	 */
	Lancamento pesistir(Lancamento lancamento);
	
	/**
	 * Remove um lancamento da base de dados
	 * @param Id
	 */
	void remove(Long Id);

}
