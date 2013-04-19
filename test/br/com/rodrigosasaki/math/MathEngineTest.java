package br.com.rodrigosasaki.math;

import org.junit.Test;

import br.com.rodrigosasaki.math.engine.Engine;
import br.com.rodrigosasaki.math.exception.UnparseableExpressionException;
import static org.junit.Assert.*;

/**
 * @author Rodrigo Sasaki
 */
public class MathEngineTest{

	@Test
	public void shouldAddCorrectly(){
		assertEquals(2, calc("1+1"), 0.1);
	}
	
	@Test
	public void shouldSubtractCorrectly(){
		assertEquals(-72, calc("3-75"), 0.1);
	}
	
	@Test
	public void shouldMultiplyCorrectly(){
		assertEquals(27, calc("3*9"), 0.1);
	}
	
	@Test
	public void shouldDivideCorrectly(){
		assertEquals(8, calc("4/0.5"), 0.1);
	}
	
	@Test
	public void shouldCalculateModuloCorrectly(){
		assertEquals(0, calc("10%2"), 0.1);
	}
	
	@Test
	public void shouldCalculatePowerCorrectly(){
		assertEquals(100, calc("10^2"), 0.1);
	}
	
	@Test
	public void shouldAcceptLargeDigitNumbers(){
		assertEquals(5345, calc("345+5000"), 0.1);
	}
	
	@Test
	public void shouldAcceptDecimalsWithoutZero(){
		assertEquals(10, calc("5/.5"), 0.1);
	}
	
	@Test
	public void shouldAssignPrecedenceCorrectly(){
		assertEquals(10, calc("16-1*4^2+10"), 0.1);
	}
	
	public double calc(String expression){
		try{
			return Engine.evaluate(expression);
		} catch (UnparseableExpressionException e){
			e.printStackTrace();
		}
		return -1;
	}
}
