/**
 * 
 */
package com.conceicao.pontointeligente.api.repositories;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.conceicao.pontointeligente.api.entities.Empresa;
import com.conceicao.pontointeligente.api.entities.Funcionario;
import com.conceicao.pontointeligente.api.entities.Lancamento;
import com.conceicao.pontointeligente.api.enums.PerfilEnum;
import com.conceicao.pontointeligente.api.enums.TipoEnum;
import com.conceicao.pontointeligente.api.utils.PasswordUtils;

/**
 * @author Antonio Cicero 4 de jan de 2018
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class LancamentoRespositoryTest {

	@Autowired
	private EmpresaRepository empresaRepository;

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@Autowired
	private LancamentoRepository lancamentoRepository;

	private Long funcionaroId;

	@Before
	public void setUp() {
		Empresa empresa = this.empresaRepository.save(obterDadosEmpresa());
		Funcionario funcionario = this.funcionarioRepository.save(obterDadosFuncionario(empresa));
		this.funcionaroId = funcionario.getId();

		this.lancamentoRepository.save(ObterDadosLancamento(funcionario));
		this.lancamentoRepository.save(ObterDadosLancamento(funcionario));

	}
	
	public void tearDown() {
		this.empresaRepository.deleteAll();
	}
	
	@Test
	public void testBuscaLancamentoPorFuncionarioId() {
		List<Lancamento> lancamento=this.lancamentoRepository.findByfuncionarioId(funcionaroId);
		
		assertEquals(2, lancamento.size());
	}
	
	@Test
	public void testBuscaLancamentoPaginadoPorFuncionarioId() {
		PageRequest page=new PageRequest(0, 10);
		Page<Lancamento> lancamento=this.lancamentoRepository.findByfuncionarioId(funcionaroId,page);
		
		assertEquals(2, lancamento.getTotalElements());
	}

	/**
	 * @param funcionario
	 * @return
	 */
	private Lancamento ObterDadosLancamento(Funcionario funcionario) {
		Lancamento lan = new Lancamento();
		lan.setData(new Date());
		lan.setTipo(TipoEnum.INICIO_ALMOCO);
		lan.setDescricao("Pausa Almoço");
		lan.setFuncionario(funcionario);
		return lan;
	}

	/**
	 * @return Funcionario
	 */
	private Funcionario obterDadosFuncionario(Empresa empresa) {
		Funcionario fun = new Funcionario();
		fun.setName("Teste");
		fun.setCpf("12345678900");
		fun.setPerfil(PerfilEnum.ROLE_USUARIO);
		fun.setSenha(PasswordUtils.gerarBcript("12345"));
		fun.setEmail("teste@hotmail.com");
		fun.setEmpresa(empresa);
		return fun;
	}

	/**
	 * @return Empresa
	 */
	private Empresa obterDadosEmpresa() {
		Empresa empresa = new Empresa();
		empresa.setRazaoSocial("Empresa Cicero");
		empresa.setCnpj("786409567245068455");
		return empresa;
	}

}
