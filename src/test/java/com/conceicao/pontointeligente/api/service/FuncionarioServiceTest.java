/**
 * 
 */
package com.conceicao.pontointeligente.api.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

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

import com.conceicao.pontointeligente.api.entities.Funcionario;
import com.conceicao.pontointeligente.api.repositories.FuncionarioRepository;

/**
 * @author Antonio Cicero 4 de jan de 2018
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class FuncionarioServiceTest {

	@MockBean
	private FuncionarioRepository funcionarioRepository;

	@Autowired
	private FuncionarioService funcionarioService;

	private static final String CPF = "123456789";

	private static final String EMAIL = "teste@gmail.com";

	@Before
	public void setUp() {
		BDDMockito.given(this.funcionarioRepository.findByCpf(Mockito.anyString())).willReturn(new Funcionario());
		BDDMockito.given(this.funcionarioRepository.findByEmail(Mockito.anyString())).willReturn(new Funcionario());
		BDDMockito.given(this.funcionarioRepository.findByCpfOrEmail(Mockito.anyString(), Mockito.anyString()))
				.willReturn(new Funcionario());
		BDDMockito.given(this.funcionarioRepository.save(Mockito.any(Funcionario.class))).willReturn(new Funcionario());

	}

	@Test
	public void testBuscaFuncionarioPorCPF() {
		Funcionario funcionario = this.funcionarioService.buscaPorCpf(CPF);
		assertNotNull(funcionario);
		;
	}

	@Test
	public void testBuscaFuncionarioPorEmail() {
		Funcionario funcionario = this.funcionarioService.buscaPorEmail(EMAIL);
		assertNotNull(funcionario);
		;
	}

	@Test
	public void testBuscaFuncionarioPorCpfOuEMail() {
		Funcionario funcionario = this.funcionarioService.buscaPorCpfOuEmail(CPF, EMAIL);
		assertNotNull(funcionario);
		;
	}

	@Test
	public void testSalvaUsuario() {
		Funcionario funcionario = this.funcionarioService.persist(new Funcionario());
		assertNotNull(funcionario);
		;
	}

}
