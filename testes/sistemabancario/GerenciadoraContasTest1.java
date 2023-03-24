package sistemabancario;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Classe de teste para testar operacoes de {@link GerenciadoraContas}
 * @author Diego Morais
 * @date 17/03/2023
 */

public class GerenciadoraContasTest1 {
	
	private GerenciadoraContas gerContas;
	
	private int idConta01 = 1;
	private int idConta02 = 2;


	//Montagem do cenário global para esta classe: estrutura de setup
	@Before
	public void setUp() {
		
		ContaCorrente conta01 = new ContaCorrente(idConta01, 200, true);
		ContaCorrente conta02 = new ContaCorrente(idConta02, 0, true);
		
		List<ContaCorrente> contaDoBanco = new ArrayList<>();
		contaDoBanco.add(conta01);
		contaDoBanco.add(conta02);
		
		gerContas = new GerenciadoraContas(contaDoBanco);
	}
	
	//Desmontagem do cenário global a cada execução de um teste
	@After
	public void tearDown() {
		gerContas.limpa();
	}
	
	@Test
	public void testTransfereValor() {
		
		double valorTransf = 100;

		double saldoc1 = gerContas.pesquisaConta(idConta01).getSaldo();
		double saldoc2 = gerContas.pesquisaConta(idConta02).getSaldo();
		
		
		//2 - execucao do teste
		boolean sucesso = gerContas.transfereValor(idConta01, valorTransf, idConta02);
		
		//3 - verificacao do resultado
		assertTrue(sucesso);
		assertThat(gerContas.pesquisaConta(idConta01).getSaldo(), is(saldoc1 - valorTransf));
		assertThat(gerContas.pesquisaConta(idConta02).getSaldo(), is(saldoc2 + valorTransf));
		
		
		
	}

}
