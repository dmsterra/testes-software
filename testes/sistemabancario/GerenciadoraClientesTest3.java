package sistemabancario;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;

/**
 *  Classe de teste para testar operacoes de {@link GerenciadoraClientes}
 * @author Diego Morais
 * @date 10/03/2023
 */

public class GerenciadoraClientesTest3 {
	
	private GerenciadoraClientes gerClientes;
	
	private int idCliente01 = 1;
	private int idCliente02 = 2;
	
	private int idContaCorrente01 = 1;
	private int idContaCorrente02 = 2;
	
	//Montagem do cenário global para esta classe: estrutura de setup 
	//garante a independência e a qualidade dos testes
	@Before
	public void setUp() {
		Cliente cliente01 = new Cliente(idCliente01, "Joao", 46, "joao@gmail.com", idContaCorrente01, true);
		Cliente cliente02 = new Cliente(idCliente02, "Maria", 11, "maria@gmail.com", idContaCorrente02, true);
		
		List<Cliente> clientes = new ArrayList<>();
		clientes.add(cliente01);
		clientes.add(cliente02);
		
		gerClientes = new GerenciadoraClientes(clientes);
	}
	
	//Desmontagem do cenário global a cada execução de um teste
	@After
	public void tearDown() {
		gerClientes.limpa();
	}
	
	/**
	 * Teste unitário basico de pesquisar cliente a partir do seu ID
	 * @author Diego Morais
	 * @date 10/03/2023
	 */
	@Test
	public void testPesquisaCliente() {

		//execução do teste
		Cliente cliente = gerClientes.pesquisaCliente(1);
		
		//verificação do resultado
		assertThat(cliente.getId(), is(idCliente01));
	}
	
	/**
	 * Teste basico da remocao de um cliente a partir do seu ID
	 * @author Diego Morais
	 * @date 17/03/2023
	 */
	
	@Test
	public void testRemoveCliente() {

		//execução do teste
		boolean clienteRemovido = gerClientes.removeCliente(2);
		
		//verificacao do resultado
		//assertTrue(clienteRemovido); diretamente com assertTrue
		assertThat(clienteRemovido, is(true));
		assertThat(gerClientes.getClientesDoBanco().size(), is(1));
		assertNull(gerClientes.pesquisaCliente(idCliente02));
	}
	
	@Test
	public void testClienteIdadePermitida1() throws IdadeNaoPermitidaException {
		//Construção do cenario
		Cliente cliente = new Cliente(3, "Gabriel", 23, "gabriel@gmail.com", 1, true);
		
		//Execução do teste
		boolean idadeValida = gerClientes.validaIdade(cliente.getIdade());
		
		//Validação do teste
		assertTrue(idadeValida);
	}
	
	@Test
	public void testClienteIdadePermitida2() throws IdadeNaoPermitidaException {
		//Construção do cenario
		Cliente cliente = new Cliente(4, "Diego", 18, "diego@gmail.com", 1, true);
		
		//Execução do teste
		boolean idadeValida = gerClientes.validaIdade(cliente.getIdade());
		
		//Validação do teste
		assertTrue(idadeValida);
	}
	
	@Test
	public void testClienteIdadePermitida3() throws IdadeNaoPermitidaException {
		//Construção do cenario
		Cliente cliente = new Cliente(5, "Clayton", 65, "clayton@gmail.com", 1, true);
		
		//Execução do teste
		boolean idadeValida = gerClientes.validaIdade(cliente.getIdade());
		
		//Validação do teste
		assertTrue(idadeValida);
	}
	
	@Test
	public void testClienteIdadePermitida4() {
		//Construção do cenario
		Cliente cliente = new Cliente(6, "Emanuel", 17, "emanuel@gmail.com", 1, true);
		
		//Execução do teste

		try {
			gerClientes.validaIdade(cliente.getIdade());
			fail();			
			
		} catch (Exception e) {
			//Validação
			assertThat(e.getMessage(), is(IdadeNaoPermitidaException.MSG_IDADE_INVALIDA));
		}
		

	}
	
	@Test
	public void testClienteIdadePermitida5() {
		//Construção do cenario
		Cliente cliente = new Cliente(7, "Felipe", 66, "felipe@gmail.com", 1, true);
		
		//Execução do teste
		
		try {
			gerClientes.validaIdade(cliente.getIdade());
			fail();			
			
		} catch (Exception e) {
			//Validação
			assertThat(e.getMessage(), is(IdadeNaoPermitidaException.MSG_IDADE_INVALIDA));
		}
		
	}

}
