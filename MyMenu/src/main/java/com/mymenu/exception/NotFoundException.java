package com.mymenu.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;  
/**
 * @author mahalakshmi
 *
 */
@ResponseStatus(HttpStatus.NOT_FOUND)  
public class NotFoundException extends RuntimeException{

	public NotFoundException(String message)   
	{  
	super(message);  
	}  
	
}
