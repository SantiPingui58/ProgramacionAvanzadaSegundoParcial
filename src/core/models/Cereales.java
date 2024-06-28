package core.models;

import java.time.LocalDate;

import core.enums.TipoCereales;
import core.interfaces.EsAlimento;

public class Cereales extends Producto implements EsAlimento {
    private String marca;
    private TipoCereales tipo;
    private LocalDate caducidad;

    public Cereales(String nombre, String descripcion, double precio, String paisImportacion, String marca, TipoCereales tipo) {
        super(nombre, descripcion, precio, paisImportacion);
        this.marca = marca;
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
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
        return super.toString() + ", Marca: " + marca + ", Tipo: " + tipo + ", Caducidad: " + caducidad + ", Calorias: " + getCalorias();
    }

	@Override
	public double getDescuento() {
		// TODO Auto-generated method stub
		return 0;
	}
}
