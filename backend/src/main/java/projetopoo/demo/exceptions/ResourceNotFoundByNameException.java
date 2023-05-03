package projetopoo.demo.exceptions;

public class ResourceNotFoundByNameException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ResourceNotFoundByNameException(String name) {
		super("Resource not found, name: " + name);
	}
}
