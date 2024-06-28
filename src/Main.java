import java.util.HashMap;
import java.util.Scanner;

import core.Supermercado;
import core.exceptions.ProductoNoEncontradoException;
import core.exceptions.SupermercadoSinProductosException;
import core.interfaces.ConDescuento;
import core.interfaces.EsAlimento;
import core.interfaces.EsLiquido;
import core.models.Producto;


public class Main {

	private static Scanner input = new Scanner(System.in);
	private static Supermercado supermercado;
	public static void main(String[] args) {
		
		supermercado = Supermercado.getInstance();
		String nombre = null, descripcion, tipoEnvase, nuevoNombre = null, nuevaMarca= null, nuevaDescripcion= null, nuevoTipoEnvase= null, nuevoTipoVino= null, nuevoPais= null;
		double precio= 0, descuento= 0, nuevoPrecio = 0, nuevoDescuento= 0, nuevosGradosAlcohol= 0;
		int id = 0, opcion=0;


		    

		do{
	        System.out.println("----------------------------------");
	        System.out.println("Menú de gestión de productos");
	        System.out.println("----------------------------------");
	        System.out.println("1. Precarga de productos.");
	        System.out.println("2. Buscar producto.");
	        System.out.println("3. Eliminar un producto.");
	        System.out.println("4. Listado de productos.");
	        System.out.println("5. Mostrar stock de productos.");
	        System.out.println("6. Ordenamiento de productos.");
	        System.out.println("7. Modificar producto.");
	        System.out.println("8. Mostrar alimentos.");
	        System.out.println("9. Mostrar producto con mayor descuento.");
	        System.out.println("0. Salir.");
	        System.out.println("----------------------------------");

	

	        	opcion = Integer.parseInt(input.nextLine());
		        switch (opcion) {
		            case 1:
		                supermercado.precargarDatos();
		                break;
		            case 2:
					Producto producto = buscarProducto();
					producto.mostrar();
		            case 3:
					try {
						System.out.println("----------------------------------");
						System.out.println("Ingrese el ID del producto que quiere eliminar.");
						System.out.println("----------------------------------");
						int inputId = Integer.parseInt(input.nextLine());
						supermercado.eliminar(inputId);
					} catch (ProductoNoEncontradoException e) {
						System.out.println(e.getMessage());
					} catch (SupermercadoSinProductosException e) {
						System.out.println(e.getMessage());
					} catch (NumberFormatException e) {
						System.out.println("El ID ingresado no es valido");
					}
		                break;
		            case 4:
		            	supermercado.mostrarProductos();
		                break;
		            case 5:

						System.out.println("----------------------------------");
						System.out.println("Ingrese el nombre del producto que quiere ver.");
						System.out.println("----------------------------------");
						
						String inputNombre = input.nextLine();
					try {
						System.out.println("Cantidad de productos con nombre " + inputNombre + ": "+ 
						supermercado.cantidadProductosPorNombre(inputNombre));
					} catch (ProductoNoEncontradoException e) {
						System.out.println(e.getMessage());
					} catch (SupermercadoSinProductosException e) {
						System.out.println(e.getMessage());
					}

		                break;
		            case 6:
		            	System.out.println("----------------------------------");
		    	        System.out.println("Menú de orden");
		    	        System.out.println("----------------------------------");
		    	        System.out.println("1. Ordenar por nombre.");
		    	        System.out.println("2. Ordenar por descripción.");
		    	        System.out.println("3. Ordenar por precio.");
		    	        System.out.println("4. Ordenar por descuento.");
		    	        System.out.println("----------------------------------");
		    	        opcion = Integer.parseInt(input.nextLine());
		    	        for (Producto p : supermercado.getProductosOrdenados(opcion)) 
		    	        	p.mostrar();
		            	break;
		            case 7:
		            	producto = buscarProducto();
		            	HashMap<Integer,String> hashmap = new HashMap<>();
		            	System.out.println("----------------------------------");
		    	        System.out.println("Menú de modificación");
		    	        System.out.println("----------------------------------");
		    	        int i = 0;
		    	        System.out.println(i++ + ". Modificar nombre.");
		    	        System.out.println(i++ +". Modificar descripción.");
		    	        System.out.println(i++ + ". Modificar precio.");
		    	        System.out.println(i++ +". Modificar pais de importación.");
		    	        
		    	        if (producto instanceof ConDescuento) {
		    	            System.out.println(i++ +". Modificar descuento.");	
		    	        }
		    	        if (producto instanceof EsAlimento) {
		    	            System.out.println(i++ +". Modificar caducidad.");	
		    	        }
		    	        
		    	        if (producto instanceof EsLiquido) {
		    	        	  System.out.println(i++ +". Modificar volumen.");	
		    	            System.out.println(i++ +". Modificar tipo de envase.");	
		    	        }

		    	        System.out.println("----------------------------------");
		            case 8:
					try {
						for (Producto p : supermercado.getAlimentos()) 
			    	        	p.mostrar();
					} catch (SupermercadoSinProductosException e) {
						System.out.println(e.getMessage());
					} 
		                break;
		            case 9:    
		              Producto p= (Producto) supermercado.getProductoMasBarato();
		              p.mostrar();
		                break;
		            case 0:
		                System.out.println("¡Hasta luego!");
				input.close();
		                break;
		            default:
		                System.out.println("Opción inválida. Vuelva a intentarlo.");
				input.nextLine();
		        }

		        }while(opcion!=0);
		        
		    }
	
	
	public static Producto buscarProducto() {
		try {
			System.out.println("----------------------------------");
			System.out.println("Ingrese el nombre o el ID del producto que quiere ver.");
			System.out.println("----------------------------------");
			
			String inputNombre = input.nextLine();
			Producto p = null;
			if (esNumero(inputNombre)) {
				int inputId = Integer.parseInt(inputNombre);
				p = supermercado.buscar(inputId);
			} else {
				p = supermercado.buscarPorNombre(inputNombre);
			}
			
			return p;
		} catch (ProductoNoEncontradoException e) {
			System.out.println(e.getMessage());
		} catch (SupermercadoSinProductosException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
		public static boolean esNumero(String str) {
		    str = str.trim(); 
		    if (str.isEmpty()) {
		        return false;
		    }
		    for (char c : str.toCharArray()) {
		        if (!Character.isDigit(c)) {
		            return false;
		        }
		    }
		    return true;
		}
}



