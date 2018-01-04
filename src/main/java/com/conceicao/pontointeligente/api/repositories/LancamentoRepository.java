/**
 * 
 */
package com.conceicao.pontointeligente.api.repositories;

import java.util.List;

import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.conceicao.pontointeligente.api.entities.Lancamento;

/**
 * @author Antonio Cicero
 * 4 de jan de 2018
 */
@Transactional(readOnly = true)
@NamedQueries({
	@NamedQuery(name = "LancamentoRepository.findByfuncionarioId", 
			query = "SELECT lanc from Lancamento lanc wherev lanc.funcionario.id =: funcionarioId") })
public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {

	List<Lancamento> findByfuncionarioId(@Param("funcionarioId") Long funcionarioId);
	
	Page<Lancamento> findByfuncionarioId(@Param("funcionarioId") Long funcionarioId, Pageable pageable);
}
