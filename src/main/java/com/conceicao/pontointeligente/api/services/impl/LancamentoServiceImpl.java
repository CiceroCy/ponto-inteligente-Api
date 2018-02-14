/**
 * 
 */
package com.conceicao.pontointeligente.api.services.impl;

import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.conceicao.pontointeligente.api.entities.Lancamento;
import com.conceicao.pontointeligente.api.repositories.LancamentoRepository;
import com.conceicao.pontointeligente.api.service.LanmcamentoService;

/**
 * @author Antonio Cicero 13 de fev de 2018
 */

@Service
public class LancamentoServiceImpl implements LanmcamentoService {

	private static final org.slf4j.Logger log = LoggerFactory.getLogger(LancamentoServiceImpl.class);

	@Autowired
	private LancamentoRepository lancamentoRepository;

	@Override
	public Page<Lancamento> buscarPorFuncionarioId(Long funcionarioId, PageRequest pageRequest) {
		log.info("Busca lançamento para o funcionario ID{}", funcionarioId);
		return this.lancamentoRepository.findByfuncionarioId(funcionarioId, pageRequest);
	}

	@Override
	public Optional<Lancamento> buscaPorId(Long Id) {
		log.info("Busca Lançamento pelo ID{}", Id);
		return Optional.ofNullable(lancamentoRepository.findOne(Id));
	}

	@Override
	public Lancamento pesistir(Lancamento lancamento) {
		log.info("Persisiti o lançamento{}", lancamento);
		return this.lancamentoRepository.save(lancamento);
	}

	@Override
	public void remove(Long Id) {
		log.info("Remove o lançamento ID{}", Id);
		this.lancamentoRepository.delete(Id);
	}

}
