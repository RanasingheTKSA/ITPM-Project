package springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus (value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundExceptionI extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundExceptionI (String messeage) {
		super(messeage);
	}

}
