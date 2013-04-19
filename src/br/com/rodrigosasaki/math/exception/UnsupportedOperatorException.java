package br.com.rodrigosasaki.math.exception;

/**
 * @author Rodrigo Sasaki
 */
public class UnsupportedOperatorException extends Exception{

	private static final long serialVersionUID = 1L;

	public UnsupportedOperatorException(){
	}

	public UnsupportedOperatorException(String paramString){
		super(paramString);
	}

	public UnsupportedOperatorException(Throwable paramThrowable){
		super(paramThrowable);
	}

	public UnsupportedOperatorException(String paramString, Throwable paramThrowable){
		super(paramString, paramThrowable);
	}

}
