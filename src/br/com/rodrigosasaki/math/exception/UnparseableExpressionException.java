package br.com.rodrigosasaki.math.exception;

/**
 * @author Rodrigo Sasaki
 */
public class UnparseableExpressionException extends Exception{

	private static final long serialVersionUID = 1L;

	public UnparseableExpressionException(){
	}

	public UnparseableExpressionException(String arg0){
		super(arg0);
	}

	public UnparseableExpressionException(Throwable arg0){
		super(arg0);
	}

	public UnparseableExpressionException(String arg0, Throwable arg1){
		super(arg0, arg1);
	}

}
