package sistemabancario;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;

/**
 *  Classe de teste para testar operacoes de {@link GerenciadoraClientes}
 * @author Diego Morais
 * @date 10/03/2023
 */

public class GerenciadoraClientesTest1 {
	
	private GerenciadoraClientes gerClientes;
	
	/**
	 * Teste unitário basico de pesquisar cliente a partir do seu ID
	 * @author Diego Morais
	 * @date 10/03/2023
	 */
	@Test
	public void testPesquisaCliente() {
		//Criação do cenário
		Cliente cliente01 = new Cliente(1, "Joao", 46, "joao@gmail.com", 1, true);
		Cliente cliente02 = new Cliente(2, "Maria", 11, "maria@gmail.com", 2, true);
		
		List<Cliente> clientes = new ArrayList<>();
		clientes.add(cliente01);
		clientes.add(cliente02);
		
		gerClientes = new GerenciadoraClientes(clientes);
		
		
		//execução do teste
		Cliente cliente = gerClientes.pesquisaCliente(1);
		
		//verificação do resultado
		assertThat(cliente.getId(), is(1));
		
	}
	
	/**
	 * Teste basico da remocao de um cliente a partir do seu ID
	 * @author Diego Morais
	 * @date 17/03/2023
	 */
	
	@Test
	public void testRemoveCliente() {
		//Criação do cenário
		Cliente cliente01 = new Cliente(1, "Joao", 46, "joao@gmail.com", 1, true);
		Cliente cliente02 = new Cliente(2, "Maria", 11, "maria@gmail.com", 2, true);
		
		List<Cliente> clientes = new ArrayList<>();
		clientes.add(cliente01);
		clientes.add(cliente02);
		
		gerClientes = new GerenciadoraClientes(clientes);
		
		
		//execução do teste
		boolean clienteRemovido = gerClientes.removeCliente(2);
		
		//verificacao do resultado
		//assertTrue(clienteRemovido); diretamente com assertTrue
		assertThat(clienteRemovido, is(true));
		assertThat(gerClientes.getClientesDoBanco().size(), is(1));
		assertNull(gerClientes.pesquisaCliente(2));
		
		
		
		
		
		
	}

}
