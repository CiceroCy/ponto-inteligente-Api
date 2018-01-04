/**
 * 
 */
package com.conceicao.pontointeligente.api.utils;

import org.apache.log4j.Logger;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author Antonio Cicero 
 * 4/01/2018
 */
public class PasswordUtils {
	private static final Logger log = Logger.getLogger(PasswordUtils.class);

	public PasswordUtils() {

	}

	public static String gerarBcript(String senha) {
		if (senha == null) {
			return senha;
		}
		log.info("Gerando hash com BCrypt");
		BCryptPasswordEncoder bCryptEncode = new BCryptPasswordEncoder();
		return bCryptEncode.encode(senha);
	}

}
