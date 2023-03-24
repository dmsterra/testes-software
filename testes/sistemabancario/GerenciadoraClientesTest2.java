package sistemabancario;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

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

public class GerenciadoraClientesTest2 {
	
	private GerenciadoraClientes gerClientes;
	
	private int idCliente01 = 1;
	private int idCliente02 = 2;
	
	private int idContaCorrente01 = 1;
	private int idContaCorrente02 = 2;
	
	//Montagem do cenário global para esta classe: estrutura de setup
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

}
