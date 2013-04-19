package br.com.rodrigosasaki.math;

import br.com.rodrigosasaki.math.engine.Engine;
import br.com.rodrigosasaki.math.exception.UnparseableExpressionException;

/**
 * @author Rodrigo Sasaki
 */
public class Main{

	public static void main(String[] args) throws UnparseableExpressionException{
		if (args.length == 0 || args.length > 1){
			System.out.println("Usage: java -jar math-engine.jar \"<expression>\"");
		}else{
			System.out.println(format(Engine.evaluate(args[0])));
		}
	}

	private static String format(Double value){
		if (value % 1 == 0){
			return String.format("%d", value.intValue());
		} else{
			return String.format("%.02f", value);
		}
	}

}
