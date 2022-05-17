package com.mymenu.userresponse;
import org.springframework.http.HttpStatus;
public class ReceipeResponse<T>{
   private HttpStatus status;
   private String message;
   private T response;
   
   public ReceipeResponse() {
   	
   }
   

    public ReceipeResponse(HttpStatus status, String message, T response) {
   	 super();
        this.status = status;
        this.message = message;
        this.response = response;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) { 
    	        this.message = message;
    }

    public T getResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }
}