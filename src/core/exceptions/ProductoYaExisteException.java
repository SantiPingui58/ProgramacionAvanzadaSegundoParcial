package core.exceptions;

public class ProductoYaExisteException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 2L;

	public ProductoYaExisteException(String nombre) {
        super("Ya existe un producto con nombre " + nombre);
    }
	
}
