/**
 * 
 */
package com.conceicao.pontointeligente.api.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conceicao.pontointeligente.api.entities.Funcionario;
import com.conceicao.pontointeligente.api.repositories.FuncionarioRepository;
import com.conceicao.pontointeligente.api.service.FuncionarioService;

/**
 * @author Antonio Cicero 4 de jan de 2018
 */
@Service
public class FuncionarioServiceImpl implements FuncionarioService {

	private static final Logger log = LoggerFactory.getLogger(FuncionarioServiceImpl.class);

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@Override
	public Funcionario buscaPorCpf(String cpf) {
		return funcionarioRepository.findByCpf(cpf);
	}

	@Override
	public Funcionario buscaPorEmail(String email) {
		return funcionarioRepository.findByEmail(email);
	}

	@Override
	public Funcionario buscaPorCpfOuEmail(String cpf, String email) {
		return funcionarioRepository.findByCpfOrEmail(cpf, email);
	}

	@Override
	public Funcionario persist(Funcionario funcionario) {
		return funcionarioRepository.save(funcionario);
	}

}
