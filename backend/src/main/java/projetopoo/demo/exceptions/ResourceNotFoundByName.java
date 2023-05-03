package projetopoo.demo.exceptions;

public class ResourceNotFoundByName extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ResourceNotFoundByName(String name) {
		super("Resource not found, name: " + name);
	}
}
