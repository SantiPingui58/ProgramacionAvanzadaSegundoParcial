package core.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	Connection con;
	
	public Connection conectar() {
		
		try {
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/prueba", 
					"root", "");
			System.out.println("Conectado a base de datos");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		
		
		return con;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
