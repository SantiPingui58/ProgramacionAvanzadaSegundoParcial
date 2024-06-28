package core.models;


public abstract class Producto {
	
	private static int lastId;
	
    private final int id;
    private String nombre;
    private String descripcion;
    private double precio;
    private String paisImportacion;

    public Producto(String nombre, String descripcion, double precio, String paisImportacion) {
        this.id = lastId++;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.paisImportacion = paisImportacion;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getPaisImportacion() {
        return paisImportacion;
    }

    public void setPaisImportacion(String paisImportacion) {
        this.paisImportacion = paisImportacion;
    }
   
	public abstract double getDescuento();

    @Override
    public String toString() {
        return "ID: " + id + ", Nombre: " + nombre + ", Descripcion: " + descripcion +
               ", Precio: " + precio + ", Pais de Importacion: " + paisImportacion;
    }

    public void mostrar() {
    	System.out.println(toString());
    }
}
