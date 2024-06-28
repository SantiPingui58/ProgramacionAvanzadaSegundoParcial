package core.interfaces;

import java.time.LocalDate;

public interface EsAlimento {
    void setCaducidad(LocalDate caducidad);
    LocalDate getCaducidad();
    int getCalorias();
}

