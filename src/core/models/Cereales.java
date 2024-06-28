package core.models;

import java.time.LocalDate;

import core.enums.TipoCereales;
import core.interfaces.EsAlimento;

public class Cereales extends Producto implements EsAlimento {
    private TipoCereales tipo;
    private LocalDate caducidad;

    public Cereales(String nombre, String descripcion, double precio, String paisImportacion, String marca, TipoCereales tipo) {
        super(nombre, descripcion, precio, paisImportacion,marca);
        this.tipo = tipo;
    }

    public TipoCereales getTipo() {
        return tipo;
    }

    public void setTipo(TipoCereales tipo) {
        this.tipo = tipo;
    }

    @Override
    public void setCaducidad(LocalDate caducidad) {
        this.caducidad = caducidad;
    }

    @Override
    public LocalDate getCaducidad() {
        return caducidad;
    }

    @Override
    public int getCalorias() {
        switch (tipo) {
            case ESPELTA: return 5;
            case MAIZ: return 8;
            case TRIGO: return 12;
            default: return 15;
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", Tipo: " + tipo + ", Caducidad: " + caducidad + ", Calorias: " + getCalorias();
    }

	@Override
	public double getDescuento() {
		return 0;
	}
}
