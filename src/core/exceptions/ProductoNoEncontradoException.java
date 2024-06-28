package core.exceptions;

public class ProductoNoEncontradoException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProductoNoEncontradoException(int id) {
        super("No existe el producto con ID: " + id);
    }
	
	public ProductoNoEncontradoException(String nombre) {
        super("No existe el producto con nombre: " + nombre);
    }
}
