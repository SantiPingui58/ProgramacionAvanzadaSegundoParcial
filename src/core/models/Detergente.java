package core.models;

import core.interfaces.ConDescuento;

public class Detergente extends Producto implements ConDescuento {
    private String marca;
    private double descuento;

    public Detergente(String nombre, String descripcion, double precio, String paisImportacion, String marca) {
        super(nombre, descripcion, precio, paisImportacion);
        this.marca = marca;
        this.descuento = 0.0;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    @Override
    public double getDescuento() {
        return descuento;
    }

    @Override
    public double getPrecioDescuento() {
        return getPrecio() * (1 - descuento / 100);
    }

    @Override
    public String toString() {
        return super.toString() + ", Marca: " + marca + ", Descuento: " + descuento + "%, Precio con Descuento: " + getPrecioDescuento();
    }
}
