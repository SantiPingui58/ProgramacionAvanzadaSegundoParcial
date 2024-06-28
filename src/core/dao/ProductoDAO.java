package core.dao;


import core.models.Producto;

public interface ProductoDAO {
    void guardar(Producto producto);
    void eliminar(int id);
    
}
