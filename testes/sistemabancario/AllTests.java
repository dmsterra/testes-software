package sistemabancario;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

//Essa classe é uma suite de testes, ou seja, ela chama todos os testes do meu projeto

@RunWith(Suite.class)
@SuiteClasses({GerenciadoraClientesTest1.class, GerenciadoraClientesTest2.class, GerenciadoraContasTest1.class, GerenciadoraContasTest2.class})
public class AllTests {

}
