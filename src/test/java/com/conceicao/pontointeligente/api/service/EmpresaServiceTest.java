/**
 * 
 */
package com.conceicao.pontointeligente.api.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.conceicao.pontointeligente.api.entities.Empresa;
import com.conceicao.pontointeligente.api.repositories.EmpresaRepository;

/**
 * @author Antonio Cicero 4 de jan de 2018
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class EmpresaServiceTest {

	@MockBean
	private EmpresaRepository empresaRepository;

	@Autowired
	private EmpresaService empresaService;

	private static final String CNPJ = "12345678453576";

	@Before
	public void setUp() {
		BDDMockito.given(this.empresaRepository.findByCnpj(Mockito.anyString())).willReturn(new Empresa());
		BDDMockito.given(this.empresaRepository.save(Mockito.any(Empresa.class))).willReturn(new Empresa());
	}

	@Test
	public void testBuscaEmpresaPorCnpj() {
		Optional<Empresa> empresa = this.empresaService.buscaPorCnpj(CNPJ);

		assertTrue(empresa.isPresent());

	}

	@Test
	public void testPersistEMpresa() {
		Empresa empresa = this.empresaService.persist(new Empresa());

		assertNotNull(empresa);

	}
}
