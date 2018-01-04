/**
 * 
 */
package com.conceicao.pontointeligente.api.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.conceicao.pontointeligente.api.entities.Empresa;

/**
 * @author Antonio Cicero
 * 4 de jan de 2018
 */
public interface EmpresaRepository extends JpaRepository<Empresa, Long>{
  
	@Transactional(readOnly = true)
	Empresa findByCnpj(String cnpj);
	

}
