/**
 * 
 */
package com.conceicao.pontointeligente.api.repositories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.conceicao.pontointeligente.api.entities.Empresa;
import com.conceicao.pontointeligente.api.entities.Funcionario;
import com.conceicao.pontointeligente.api.enums.PerfilEnum;
import com.conceicao.pontointeligente.api.utils.PasswordUtils;


/**
 * @author Antonio Cicero
 * 4 de jan de 2018
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class FuncionarioRepositoryTest {
	
	@Autowired
	private EmpresaRepository empresarepository;
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	private static final String CPF="12345678909";
	
	private static final String EMAIL="teste.test@hotmail.com";
	
	@Before
	public void setUp() {
	 Empresa empresa=this.empresarepository.save(obterDadosEmpresa());	
		this.funcionarioRepository.save(obterDadosFuncionario(empresa));
	 
	}
	
	@After
	public void tearDown() {
		this.empresarepository.deleteAll();
		this.funcionarioRepository.deleteAll();
	}
	
	@Test
	public void testBuscaPorEmail() {
		Funcionario funcionario=this.funcionarioRepository.findByEmail(EMAIL);
		assertEquals(EMAIL, funcionario.getEmail());
	}
	
	@Test
	public void testBuscaPorCpf() {
		Funcionario funcionario=this.funcionarioRepository.findByCpf(CPF);
		assertEquals(CPF, funcionario.getCpf());
	}
	@Test
	public void testBuscaPorCpfOrEMail() {
		Funcionario funcionario=this.funcionarioRepository.findByCpfOrEmail(CPF, EMAIL);
		assertNotNull(funcionario);
	}
	
	@Test
	public void testBuscaPorCpfOrEMailInvalido() {
		Funcionario funcionario=this.funcionarioRepository.findByCpfOrEmail(CPF, "apt.test@hotmail.com");
		assertNotNull(funcionario);
	}
	@Test
	public void testBuscaPorEMailOrCpfInvalido() {
		Funcionario funcionario=this.funcionarioRepository.findByCpfOrEmail("12378959", EMAIL);
		assertNotNull(funcionario);
	}
	
	/**
	 * @return Funcionario
	 */
	private Funcionario obterDadosFuncionario(Empresa empresa) {
		Funcionario fun=new Funcionario();
		fun.setName("Teste");
		fun.setCpf(CPF);
		fun.setPerfil(PerfilEnum.ROLE_USUARIO);
		fun.setSenha(PasswordUtils.gerarBcript("12345"));
		fun.setEmail(EMAIL);
		fun.setEmpresa(empresa);
		return fun;
	}

	/**
	 * @return Empresa
	 */
	private Empresa obterDadosEmpresa() {
		Empresa empresa=new Empresa();
		empresa.setRazaoSocial("Empresa Cicero");
		empresa.setCnpj("786409567245068455");
		return empresa;
	}

}
