package br.com.rodrigosasaki.math.engine;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.rodrigosasaki.math.exception.UnparseableExpressionException;
import br.com.rodrigosasaki.math.exception.UnsupportedOperatorException;
import br.com.rodrigosasaki.structures.list.List;
import br.com.rodrigosasaki.structures.queue.Queue;

/**
 * @author Rodrigo Sasaki
 */
public class Engine{
	
	public static double evaluate(String expression) throws UnparseableExpressionException{
		try{
			Queue<String> rpnExpression = SimplifiedShuntingYard.toRPN(tokenize(expression));
			return Evaluator.evaluate(rpnExpression);
		}catch(UnsupportedOperatorException e){
			throw new UnparseableExpressionException("Could not evaluate expression.", e);
		} catch (Exception e){
			e.printStackTrace();
			throw new UnparseableExpressionException("Could not evaluate expression.");
		}
	}
	
	public static void main(String[] args){
		System.out.println(tokenize("5/.2"));
	}

	private static List<String> tokenize(String expression){
		List<String> elements = new List<String>();
		Pattern pattern = Pattern.compile("\\d+\\.?\\d*|\\.\\d+|[%+-/()^*]");
		Matcher matcher = pattern.matcher(expression);
		while(matcher.find()){
			elements.add(matcher.group());
		}
		return elements;
	}

}
