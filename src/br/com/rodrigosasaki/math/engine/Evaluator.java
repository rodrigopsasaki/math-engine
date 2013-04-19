package br.com.rodrigosasaki.math.engine;

import br.com.rodrigosasaki.math.engine.operator.Operator;
import br.com.rodrigosasaki.math.exception.UnsupportedOperatorException;
import br.com.rodrigosasaki.structures.stack.Stack;

/**
 * @author Rodrigo Sasaki
 */
public class Evaluator{

	public static double evaluate(Iterable<String> rpnExpression) throws UnsupportedOperatorException{

		Stack<Double> valueStack = new Stack<Double>();

		for (String element : rpnExpression){
			try{
				valueStack.push(Double.valueOf(element));
			} catch (NumberFormatException e){
				Double value1 = valueStack.pop();
				Double value2 = valueStack.pop();
				valueStack.push(evaluate(value2, value1, element));
			}
		}

		return valueStack.pop();
	}

	private static Double evaluate(Double a, Double b, String operator) throws UnsupportedOperatorException{
		Operator op = Operator.asOperator(operator);
		if (op != null){
			return op.evaluate(a, b);
		}
		throw new UnsupportedOperatorException("Could not evaluate operator: " + operator);
	}
}
