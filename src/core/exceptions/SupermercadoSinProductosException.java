package core.exceptions;

public class SupermercadoSinProductosException extends Exception {

	
	private static final long serialVersionUID = 3L;

	public SupermercadoSinProductosException() {
        super("No hay productos cargados en el supermercado.");
    }
	
}
