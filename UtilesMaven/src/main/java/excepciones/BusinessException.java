package excepciones;

import org.hibernate.exception.ConstraintViolationException;

public class BusinessException extends Exception{
	public BusinessException (){
		super();
	}
	public BusinessException(String msg){
	super(msg);
	}
	
	public BusinessException(ConstraintViolationException e)
	{
		super(e.getMessage());
	}
}
