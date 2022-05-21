package springboot.exception;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus (value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundExceptionC extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundExceptionC (String messeage) {
		super(messeage);
	}

}