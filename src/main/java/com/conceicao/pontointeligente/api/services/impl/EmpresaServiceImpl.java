/**
 * 
 */
package com.conceicao.pontointeligente.api.services.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conceicao.pontointeligente.api.entities.Empresa;
import com.conceicao.pontointeligente.api.repositories.EmpresaRepository;
import com.conceicao.pontointeligente.api.service.EmpresaService;

/**
 * @author Antonio Cicero 4 de jan de 2018
 */
@Service
public class EmpresaServiceImpl implements EmpresaService {

	private static final Logger log = LoggerFactory.getLogger(EmpresaServiceImpl.class);

	@Autowired
	private EmpresaRepository empresaRepository;

	@Override
	public Optional<Empresa> buscaPorCnpj(String cnpj) {
		log.info("Buscando Empresa por CNPJ{}", cnpj);
		return Optional.ofNullable(empresaRepository.findByCnpj(cnpj));
	}

	@Override
	public Empresa persist(Empresa empresa) {
		log.info("Pesrsistindo Empresa na base de Dados{}", empresa.toString());
		return this.empresaRepository.save(empresa);
	}

}
