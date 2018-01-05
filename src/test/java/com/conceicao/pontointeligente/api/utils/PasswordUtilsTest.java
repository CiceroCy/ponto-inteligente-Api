/**
 * 
 */
package com.conceicao.pontointeligente.api.utils;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author Antonio Cicero 4 de jan de 2018
 */
public class PasswordUtilsTest {

	private static final String SENHA = "1234";

	private final BCryptPasswordEncoder bCryptEncode = new BCryptPasswordEncoder();

	@Test
	public void testSenhaNula() {
		assertNull(PasswordUtils.gerarBcript(null));
	}
	
	@Test
	public void testarGerarSenhaHash() {
		String hash=PasswordUtils.gerarBcript(SENHA);
		assertTrue(bCryptEncode.matches(SENHA, hash));
	}

}
