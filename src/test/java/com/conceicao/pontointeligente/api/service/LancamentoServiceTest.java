/**
 * 
 */
package com.conceicao.pontointeligente.api.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.conceicao.pontointeligente.api.entities.Lancamento;
import com.conceicao.pontointeligente.api.repositories.LancamentoRepository;

import junit.framework.Assert;

/**
 * @author Antonio Cicero 13 de fev de 2018
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class LancamentoServiceTest {

	@MockBean
	private LancamentoRepository lancamentoRepository;

	@Autowired
	private LanmcamentoService lancamentoService;

	@Before
	public void setUp() throws Exception {
		BDDMockito
				.given(this.lancamentoRepository.findByfuncionarioId(Mockito.anyLong(), Mockito.any(PageRequest.class)))
				.willReturn(new PageImpl<Lancamento>(new ArrayList<Lancamento>()));
		BDDMockito.given(this.lancamentoRepository.findOne(Mockito.anyLong())).willReturn(new Lancamento());
		BDDMockito.given(this.lancamentoRepository.save(Mockito.any(Lancamento.class))).willReturn(new Lancamento());

	}

	@Test
	public void testBuscaLancamentoPorFuncionarioId() {
		Page<Lancamento> lancamento = lancamentoService.buscarPorFuncionarioId(1L, new PageRequest(0, 10));

		assertNotNull(lancamento);

	}

	@Test
	public void testBuscaFunarioPorId() {
		Optional<Lancamento> lancamento = this.lancamentoService.buscaPorId(1L);

		assertTrue(lancamento.isPresent());
	}

	@Test
	public void testPersistirLancamento() {
		Lancamento lancamento = this.lancamentoService.pesistir(new Lancamento());

		assertNotNull(lancamento);
	}

}
