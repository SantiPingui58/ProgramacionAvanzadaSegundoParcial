package core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import core.enums.TipoCereales;
import core.exceptions.ProductoNoEncontradoException;
import core.exceptions.SupermercadoSinProductosException;
import core.interfaces.ConDescuento;
import core.interfaces.EsAlimento;
import core.models.Cereales;
import core.models.Detergente;
import core.models.Producto;
import core.models.Vino;

public class Supermercado {
    private LinkedHashSet<Producto> productos;

    private static Supermercado instance;
    public static Supermercado getInstance() {
    	if (instance==null) instance = new Supermercado();
		return instance;
    
    }
   
    public Supermercado() {
        this.productos = new LinkedHashSet<>();
    }
    
    public Set<Producto> getProductos() {
    	return this.productos;
    }

    public void precargarDatos() {
    	System.out.println("Precargando productos...");
    	
    	Detergente detergente1 = new Detergente("Detergente 1", "Detergente para ropa", 10.5, "España", "Skip");
    	Detergente detergente2 = new Detergente("Detergente 2", "Detergente para platos", 5.0, "Francia", "Magistral");
    	detergente1.setDescuento(15);
    	detergente2.setDescuento(12);
        productos.add(detergente1);
        productos.add(detergente2);
        productos.add(new Detergente("Detergente 3", "Detergente para platos", 9.0, "Argentina", "Ariel"));
        productos.add(new Detergente("Detergente 4", "Detergente para platos", 8.0, "Argentina", "Micolor"));
        productos.add(new Detergente("Detergente 5", "Detergente para platos", 10.0, "Argentina", "Formil"));
        
        productos.add(new Cereales("Cereal 1", "Cereal de maiz", 2.5, "USA", "Nesquik", TipoCereales.MAIZ));
        productos.add(new Cereales("Cereal 2", "Cereal de trigo", 3.0, "Argentina", "Nesfit", TipoCereales.TRIGO));
        productos.add(new Cereales("Cereal 3", "Cereal de espelta", 3.0, "USA", "Chocapic", TipoCereales.ESPELTA));
        productos.add(new Cereales("Cereal 4", "Cereal barato", 3.0, "Chile", "Lion", TipoCereales.MAIZ));
        productos.add(new Cereales("Cereal 5", "Cereal importado", 3.0, "USA", "Trix", TipoCereales.MAIZ));
        
        Vino vino1 = new Vino("Vino 1", "Vino Tinto", 15.0, "Chile", "Marca E", "Begani", 12.5);
        Vino vino2 = new Vino("Vino 2", "Vino Blanco", 12.0, "Italia", "Marca F", "El Espia", 11.0);
        
        vino1.setDescuento(20);
        vino2.setDescuento(15);
        productos.add(vino1);
        productos.add(vino2);
        productos.add(new Vino("Vino 3", "Vino Blanco", 12.0, "Italia", "Marca X", "Otro Loco Más", 11.0));
        productos.add(new Vino("Vino 4", "Vino Tinto", 12.0, "Argentina", "Marca X", "Cordero con piel de Lobo", 13.0));
        productos.add(new Vino("Vino 5", "Vino Malbec", 12.0, "Bolivia", "Marca X", "Sapo de otro pozo", 15.0));
     
    }

    
    
    public Producto buscar(int id) throws ProductoNoEncontradoException, SupermercadoSinProductosException {
    	if (productos.isEmpty())  throw new SupermercadoSinProductosException();
       for (Producto pr : productos) {
    	   if (pr.getId()==id) {
    		   return pr;
    	   }
       }
       throw new ProductoNoEncontradoException(id);
       }
    
    public Producto buscarPorNombre(String nombre) throws ProductoNoEncontradoException, SupermercadoSinProductosException {
    	if (productos.isEmpty())  throw new SupermercadoSinProductosException();
    	
    	for (Producto pr : productos) {
    		if (pr.getNombre().toLowerCase().contains(nombre.toLowerCase())) {
    			return pr;
    		}
    	}
    	
    	   throw new ProductoNoEncontradoException(nombre);
    }
    
    public int cantidadProductosPorNombre(String nombre) throws ProductoNoEncontradoException, SupermercadoSinProductosException{
    	if (productos.isEmpty())  throw new SupermercadoSinProductosException();
    	int cantidad=0;
    	for (Producto p : this.productos) {
    		if (p.getNombre().toLowerCase().contains(nombre.toLowerCase())) {
    			cantidad++;
    		}
    	}
    	if (cantidad==0) throw new ProductoNoEncontradoException(nombre);
    	return cantidad;
    }
    

    public void eliminar(int id) throws ProductoNoEncontradoException, SupermercadoSinProductosException {
    	if (productos.isEmpty())  throw new SupermercadoSinProductosException();
		Producto pr = buscar(id);
		productos.remove(pr);
		System.out.println("El producto con ID " + id + " ha sido eliminado exitosamente.");
    }

    
    public void mostrarProductos() {
    	System.out.println("Mostrando productos: ");
    	for (Producto p : this.getProductosOrdenados(0)) {
    		System.out.println(p.toString());
    	}
    }
    /*
     * orden de ordenamiento:
     * 0 - Default
     * 1 - Nombre
     * 2 - Descripcion
     * 3 - Precio
     * 4 - Descuento
     */
    public List<Producto> getProductosOrdenados(int orden) {
    	if (orden<0 || orden>=5) throw new IllegalArgumentException("Orden ingresado no válido");
    	List<Producto> list = new ArrayList<>(productos);
    	 Collections.sort(list, new Comparator<Producto>() {
    	        @Override
    	        public int compare(Producto p1, Producto p2) {
    	        	int comparacion = 0;
    	        	switch(orden) {
    	        	case 1: 
    	        		comparacion = p1.getNombre().compareToIgnoreCase(p2.getNombre());
    	        		break;
    	        	case 2: 
    	        		comparacion = p1.getDescripcion().compareToIgnoreCase(p2.getDescripcion());
    	        		break;
    	        	case 3: 
    	        		comparacion = Double.compare(p1.getPrecio(), p2.getPrecio());
    	        		break;
    	        	case 4: 
    	        		comparacion = Double.compare(p1.getDescuento(), p2.getDescuento());
    	        		break;     		
    	        	}
    	            return comparacion;
    	        }
    	    });
    	 return list;
    }
    
    public ConDescuento getProductoMasBarato() {
    	List<ConDescuento> list = new ArrayList<>();
    	for (Producto p : productos) 
    	if (p instanceof ConDescuento) {
    		ConDescuento productoConDescuento = (ConDescuento) p;
    		list.add(productoConDescuento);
    	}

    	 Collections.sort(list, new Comparator<ConDescuento>() {
    	        @Override
    	        public int compare(ConDescuento p1, ConDescuento p2) {
    	        		int 	comparacion = Double.compare(p1.getPrecioDescuento(), p2.getPrecioDescuento());
    	            return comparacion;
    	        }
    	    });
    	 return list.get(0);
    }
    
    public List<Producto> getAlimentos() throws SupermercadoSinProductosException {
    	if (productos.isEmpty())  throw new SupermercadoSinProductosException();
    	List<Producto> lista = new ArrayList<>();
    	for (Producto p : this.productos) {
    		if (p instanceof EsAlimento) {
    			lista.add(p);
    		}
    	}
    	return lista;
    }

	public void modificar(int id, String nuevoNombre, String nuevaDescripcion, double nuevoPrecio,
			String nuevoPais, String nuevaMarca, String nuevoTipoEnvase,String nuevoTipoVino, Double nuevosGradosAlcohol, Double nuevoDescuento)
			throws ProductoNoEncontradoException, SupermercadoSinProductosException {
		Producto p = buscar(id);

		if (p != null) {
			p.setNombre(nuevoNombre);
			p.setDescripcion(nuevaDescripcion);
			p.setPrecio(nuevoPrecio);
			p.setPaisImportacion(nuevoPais);

			if (p instanceof Detergente) {
				Detergente det = (Detergente) p;
				det.setMarca(nuevaMarca);
				if (nuevoDescuento != null) {
					det.setDescuento(nuevoDescuento);
				}
			} else if (p instanceof Cereales) {
				Cereales cer = (Cereales) p;
				cer.setMarca(nuevaMarca);
			} else if (p instanceof Vino) {
				Vino vin = (Vino) p;
				vin.setMarca(nuevaMarca);
				vin.setTipoEnvase(nuevoTipoEnvase);
				if (nuevosGradosAlcohol != null) {
					vin.setGradosAlcohol(nuevosGradosAlcohol);
					}
				if (nuevoDescuento != null) {
					vin.setDescuento(nuevoDescuento);
				}
			}
		} else {
			throw new ProductoNoEncontradoException("Producto con ID " + id + " no encontrado.");
		}
	}

}