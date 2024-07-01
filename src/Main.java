import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Scanner;

import core.Supermercado;
import core.enums.TipoCereales;
import core.exceptions.ProductoNoEncontradoException;
import core.exceptions.SupermercadoSinProductosException;
import core.interfaces.ConDescuento;
import core.interfaces.EsAlimento;
import core.interfaces.EsLiquido;
import core.models.Cereales;
import core.models.Producto;
import core.models.Vino;

public class Main {

    private static Scanner input = new Scanner(System.in);
    private static Supermercado supermercado;
    
    public static void main(String[] args) {
        
    	//Conexion conn = new Conexion();
    	//conn.conectar();
    	
        //Inicializar variables
        supermercado = Supermercado.getInstance();
        int opcion = 0;
        int inputId = 0;
        String inputNombre;
        Producto producto = null;
        LinkedHashMap<Integer, String> hashmap = new LinkedHashMap<>();
        int indexMenu = 0;
        String atributoModificar;
        String nuevoAtributo;

        do {
            // menu principal
            System.out.println("----------------------------------");
            System.out.println("Menu de gestion de productos");
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
                    producto = buscarProducto();
                    if (producto != null) producto.mostrar();             
                    break;
                case 3:
                    try {
                        System.out.println("----------------------------------");
                        System.out.println("Ingrese el ID del producto que quiere eliminar.");
                        System.out.println("----------------------------------");
                        inputId = Integer.parseInt(input.nextLine());
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
                    inputNombre = input.nextLine();
                    try {
                        System.out.println("Cantidad de productos con nombre " + inputNombre + ": " + 
                        supermercado.cantidadProductosPorNombre(inputNombre));
                    } catch (ProductoNoEncontradoException e) {
                        System.out.println(e.getMessage());
                    } catch (SupermercadoSinProductosException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 6:
                    System.out.println("----------------------------------");
                    System.out.println("Menu de orden");
                    System.out.println("----------------------------------");
                    System.out.println("1. Ordenar por nombre.");
                    System.out.println("2. Ordenar por descripcion.");
                    System.out.println("3. Ordenar por precio.");
                    System.out.println("4. Ordenar por descuento.");
                    System.out.println("----------------------------------");
                    opcion = Integer.parseInt(input.nextLine());
                    for (Producto prod : supermercado.getProductosOrdenados(opcion)) 
                        prod.mostrar();
                    break;
                case 7:
                    producto = buscarProducto();
                    if (producto != null) {
                        System.out.println("----------------------------------");
                        System.out.println("Menu de modificacion");
                        System.out.println("----------------------------------");
                        indexMenu = 0;
                        hashmap.clear();
                        hashmap.put(indexMenu++, "nombre");
                        hashmap.put(indexMenu++, "descripcion");
                        hashmap.put(indexMenu++, "precio");
                        hashmap.put(indexMenu++, "importacion");
                        hashmap.put(indexMenu++, "marca");
                        if (producto instanceof Cereales) 
                            hashmap.put(indexMenu++, "tipo cereales");
                        if (producto instanceof Vino) {
                            hashmap.put(indexMenu++, "tipo vino");
                            hashmap.put(indexMenu++, "grados alcohol");
                        }
                        if (producto instanceof ConDescuento) 
                            hashmap.put(indexMenu++, "descuento");
                        if (producto instanceof EsAlimento) 
                            hashmap.put(indexMenu++, "caducidad");
                        if (producto instanceof EsLiquido) {
                            hashmap.put(indexMenu++, "volumen");
                            hashmap.put(indexMenu++, "tipo de envase");
                        }

                        for (Entry<Integer, String> e : hashmap.entrySet()) {
                            System.out.println(e.getKey() + ". Modificar " + e.getValue());
                        }
                        System.out.println("----------------------------------");

                        opcion = Integer.parseInt(input.nextLine());
                        atributoModificar = hashmap.get(opcion);
                        if (atributoModificar != null) {
                            System.out.println("----------------------------------");
                            System.out.println("Ingrese el nuevo valor del atributo del producto.");
                            System.out.println("----------------------------------");
                            nuevoAtributo = input.nextLine();
                            try {
                                // Modificar atributo del producto
                                switch (atributoModificar) {
                                    case "nombre": 
                                        producto.setNombre(nuevoAtributo);
                                        break;
                                    case "descripcion": 
                                        producto.setDescripcion(nuevoAtributo);
                                        break;
                                    case "precio": 
                                        producto.setPrecio(Double.parseDouble(nuevoAtributo));
                                        break;
                                    case "importacion": 
                                        producto.setPaisImportacion(nuevoAtributo);
                                        break;    
                                    case "marca": 
                                        producto.setMarca(nuevoAtributo);
                                        break;    
                                    case "tipo cereales": 
                                        Cereales cereales = (Cereales) producto;
                                        cereales.setTipo(TipoCereales.valueOf(nuevoAtributo));
                                        break;    
                                    case "tipo vino": 
                                        Vino vino = (Vino) producto;
                                        vino.setTipoVino(nuevoAtributo);
                                        break;    
                                    case "grados alcohol": 
                                        vino = (Vino) producto;
                                        vino.setGradosAlcohol(Double.parseDouble(nuevoAtributo));
                                        break;    
                                    case "descuento": 
                                        ConDescuento productoConDescuento = (ConDescuento) producto;
                                        productoConDescuento.setDescuento(Double.parseDouble(nuevoAtributo));
                                        break;
                                    case "caducidad": 
                                        EsAlimento productoAlimento = (EsAlimento) producto;
                                        productoAlimento.setCaducidad(LocalDate.parse(nuevoAtributo, DateTimeFormatter.ofPattern("dd-MM-yyyy")));
                                        break;    
                                    case "volumen": 
                                        EsLiquido productoLiquido = (EsLiquido) producto;
                                        productoLiquido.setVolumen(Double.parseDouble(nuevoAtributo));
                                        break;    
                                    case "tipo de envase": 
                                        productoLiquido = (EsLiquido) producto;
                                        productoLiquido.setTipoEnvase(nuevoAtributo);
                                        break;    
                                }
                                System.out.println("Atributo " + atributoModificar + " ha sido seteado a: " + nuevoAtributo + " correctamente");
                            } catch(Exception ex) {
                                System.out.println("Valor para atributo " + atributoModificar + " invalida");
                            }
                        } else {
                            System.out.println("Valor no valido");
                        }
                    }
                    break;
                case 8:
                    try {
                        for (Producto prod : supermercado.getAlimentos()) 
                            prod.mostrar();
                    } catch (SupermercadoSinProductosException e) {
                        System.out.println(e.getMessage());
                    } 
                    break;
                case 9:    
                    producto = (Producto) supermercado.getProductoMasBarato();
                    producto.mostrar();
                    break;
                case 0:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opcion invalida. Vuelva a intentarlo.");
            }
        } while(opcion != 0);
        
        input.close();   
    }
    
    // Buscar producto por nombre o ID
    public static Producto buscarProducto() {
        try {
       
            System.out.println("----------------------------------");
            System.out.println("Ingrese el nombre o el ID del producto que quiere buscar");
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
    
    // Verificar si una cadena es un numero
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
