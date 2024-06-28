package core.models;

import core.interfaces.ConDescuento;

public class Detergente extends Producto implements ConDescuento {
    private double descuento;

    public Detergente(String nombre, String descripcion, double precio, String paisImportacion, String marca) {
        super(nombre, descripcion, precio, paisImportacion,marca);
        this.descuento = 0.0;
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
        return super.toString() + ", Descuento: " + descuento + "%, Precio con Descuento: " + getPrecioDescuento();
    }
}
