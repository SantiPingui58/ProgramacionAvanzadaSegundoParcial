package core.models;

import java.time.LocalDate;

import core.interfaces.ConDescuento;
import core.interfaces.EsAlimento;
import core.interfaces.EsLiquido;

public class Vino extends Producto implements EsLiquido, EsAlimento, ConDescuento {
    private String tipoVino;
    private double gradosAlcohol;
    private double volumen;
    private String tipoEnvase;
    private LocalDate caducidad;
    private double descuento;

    public Vino(String nombre, String descripcion, double precio, String paisImportacion, String marca, String tipoVino, double gradosAlcohol) {
        super(nombre, descripcion, precio, paisImportacion,marca);
        this.tipoVino = tipoVino;
        this.gradosAlcohol = gradosAlcohol;
        this.descuento = 0.0;
    }

    public String getTipoVino() {
        return tipoVino;
    }

    public void setTipoVino(String tipoVino) {
        this.tipoVino = tipoVino;
    }

    public double getGradosAlcohol() {
        return gradosAlcohol;
    }

    public void setGradosAlcohol(double gradosAlcohol) {
        this.gradosAlcohol = gradosAlcohol;
    }

    @Override
    public void setVolumen(double volumen) {
        this.volumen = volumen;
    }

    @Override
    public double getVolumen() {
        return volumen;
    }

    @Override
    public void setTipoEnvase(String tipoEnvase) {
        this.tipoEnvase = tipoEnvase;
    }

    @Override
    public String getTipoEnvase() {
        return tipoEnvase;
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
        return (int) (10 * gradosAlcohol);
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
        return super.toString() + ", , Tipo de Vino: " + tipoVino + ", Grados de Alcohol: " + gradosAlcohol +
               ", Volumen: " + volumen + "L, Tipo de Envase: " + tipoEnvase + ", Caducidad: " + caducidad +
               ", Calorias: " + getCalorias() + ", Descuento: " + descuento + "%, Precio con Descuento: " + getPrecioDescuento();
    }
}
