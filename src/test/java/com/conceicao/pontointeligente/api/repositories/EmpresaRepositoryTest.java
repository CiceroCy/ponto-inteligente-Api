/**
 * 
 */
package com.conceicao.pontointeligente.api.repositories;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.conceicao.pontointeligente.api.entities.Empresa;

/**
 * @author Antonio Cicero 4 de jan de 2018
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class EmpresaRepositoryTest {

	@Autowired
	private EmpresaRepository empresaRepositoty;

	private static final String CNPJ = "12809151000174";

	@Before
	public void setUp() {
		Empresa empresa = new Empresa();
		empresa.setRazaoSocial("Teste Cicero");
		empresa.setCnpj(CNPJ);
		this.empresaRepositoty.save(empresa);
	}

	@After
	public final void tearDown() {
		this.empresaRepositoty.deleteAll();
	}
	
	@Test
	public void testBuscarPorCnpj() {
	Empresa empresa=this.empresaRepositoty.findByCnpj(CNPJ);
	assertEquals(CNPJ, empresa.getCnpj());
	}
	
}
