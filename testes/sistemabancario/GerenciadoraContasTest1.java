package sistemabancario;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * Classe de teste para testar operacoes de {@link GerenciadoraContas}
 * @author Diego Morais
 * @date 17/03/2023
 */

public class GerenciadoraContasTest1 {
	
	private GerenciadoraContas gerContas;
	
	@Test
	public void testTransfereValor() {
		//1 - Criacao do cenario
		ContaCorrente conta01 = new ContaCorrente(1, 200, true);
		ContaCorrente conta02 = new ContaCorrente(2, 0, true);
		
		List<ContaCorrente> contaDoBanco = new ArrayList<>();
		contaDoBanco.add(conta01);
		contaDoBanco.add(conta02);
		
		gerContas = new GerenciadoraContas(contaDoBanco);
		
		//2 - execucao do teste
		boolean sucesso = gerContas.transfereValor(1, 100, 2);
		
		//3 - verificacao do resultado
		assertTrue(sucesso);
		assertThat(conta01.getSaldo(), is(100.0));
		assertThat(conta02.getSaldo(), is(100.0));
		
		
		
	}

}
