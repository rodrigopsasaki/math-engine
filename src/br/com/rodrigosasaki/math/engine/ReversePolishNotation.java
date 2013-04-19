package br.com.rodrigosasaki.math.engine;

import br.com.rodrigosasaki.math.engine.operator.Operator;
import br.com.rodrigosasaki.math.exception.UnparseableExpressionException;
import br.com.rodrigosasaki.structures.list.List;
import br.com.rodrigosasaki.structures.queue.Queue;
import br.com.rodrigosasaki.structures.stack.Stack;

/**
 * @author Rodrigo Sasaki
 */
public class ReversePolishNotation{

	public static Queue<String> toRPN(List<String> tokens) throws UnparseableExpressionException{
		Queue<String> output = new Queue<String>();
		Stack<String> stack = new Stack<String>();
		try{
			for (String token : tokens){
				if (isNumber(token)){
					output.enqueue(token);
				} else if (isOperator(token)){
					Operator op = Operator.asOperator(token);
					while (!stack.isEmpty() && isOperator(stack.peek())){
						Operator other = Operator.asOperator(stack.peek());
						if (op.isLeftAssociative() && op.lowerOrEqualPrecedenceThan(other)
								|| op.lowerPrecedenceThan(other)){
							output.enqueue(stack.pop());
						}else{
							break;
						}
					}
					stack.push(token);
				} else if ("(".equals(token)){
					stack.push(token);
				} else if (")".equals(token)){
					while (!"(".equals(stack.peek())){
						output.enqueue(stack.pop());
					}
					stack.pop();
				}
			}

			while (!stack.isEmpty()){
				output.enqueue(stack.pop());
			}
		} catch (Exception e){
			throw new UnparseableExpressionException("The informed expression is not valid. No functions or commas are supported yet.");
		}

		return output;
	}

	private static boolean isNumber(String token){
		try{
			Double.parseDouble(token);
			return true;
		} catch (NumberFormatException e){
			return false;
		}
	}

	private static boolean isOperator(String token){
		return Operator.isOperator(token);
	}

}
