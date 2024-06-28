package core.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import core.models.Producto;

public class ProductoDAOImpl implements ProductoDAO {
    private Connection conn;

    public ProductoDAOImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void guardar(Producto producto) {
        String sql = "INSERT INTO productos (nombre, descripcion, precio, pais_importacion, marca) VALUES (?, ?, ?, ?,?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, producto.getNombre());
            stmt.setString(2, producto.getDescripcion());
            stmt.setDouble(3, producto.getPrecio());
            stmt.setString(4, producto.getPaisImportacion());
            stmt.setString(5, producto.getMarca());
            stmt.executeUpdate();
        } catch (SQLException e) {
           System.out.println(e.getMessage());
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM productos WHERE id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
        	   System.out.println(e.getMessage());
        }
    }


}

