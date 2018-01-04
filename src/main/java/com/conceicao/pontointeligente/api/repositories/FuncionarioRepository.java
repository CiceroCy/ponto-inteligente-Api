/**
 * 
 */
package com.conceicao.pontointeligente.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.conceicao.pontointeligente.api.entities.Funcionario;

/**
 * @author Antonio Cicero 4 de jan de 2018
 */
@Transactional(readOnly = true)
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

	Funcionario findByCpf(String cpf);

	Funcionario findByEmail(String email);
	
	Funcionario findByCpfOrEmail(String cpf,String email);
}
