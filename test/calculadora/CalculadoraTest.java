package calculadora;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.beans.Transient;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Classe para teste da calculadora")
public class CalculadoraTest {
	
	private Calculadora calc;
	
	@BeforeEach
	public void inicializa() {
		calc = new Calculadora();
	}
	
	@DisplayName("Testa a soma de dois n�meros")
	@Test
	public void testSomaDoisNumeros() {
		int soma = calc.soma(4, 5);		
		Assertions.assertEquals(9, soma);		
	}
	
	@Test
	public void testDivisaoDoisNumeros() {
		int divisao = calc.divisao(8, 4);
		assertTrue(divisao == 2);
	}
	
	@Test
	public void testDivisaoPorZero() {
		try {
			int divisao = calc.divisao(8, 0);
			fail("Exce��o n�o lan�ada");
		}catch (ArithmeticException e) {
			assertEquals("/ by zero", e.getMessage());
		}		
	}
	
	@Test
	public void testDivisaoPorZeroComAssertThrows() {
		assertThrows(ArithmeticException.class,
				() -> calc.divisao(8, 0));
	}

	@Test
	public void testMultiplicacaoDoisNumeros() {
		int res_multiplicacao = calc.multiplicacao(2, 2);
		assertEquals(4, res_multiplicacao);
	}

	@Test 
	public void testSubtracaoNegativa(){
		int res_subtracao = calc.subtracao(-2,4);
		boolean negativo = !(calc.ehPositivo(res_subtracao));
		assertTrue(negativo);
	}

	@Test
	public void testSomatorio() {
		int res_somatorio = calc.somatoria(5);
		assertEquals(15, res_somatorio);
	}
	
	@Test
	public void testSomatorioNegativo() {
		int res_somatorio = calc.somatoria(-5);
		assertEquals(0, res_somatorio);
	}

	@Test
	public void testMultiplicacaoPorZero() {
		int res_multiplicacao = calc.multiplicacao(5, 0);
		assertEquals(0, res_multiplicacao);
	}

	@Test
	public void testCompara(){
		int a = 1;
		int b = 2;
		int res_compara = calc.compara(a, b);
		assertEquals(-1, res_compara);
	}

}	
