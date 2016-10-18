package model.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Clase que manipula datos de la tabla Specialist de la base de datos.
 * 
 * @author SOSA-PC
 * @version 1.0
 * @created 17-oct.-2016 9:32:11 p. m.
 */
public class ConnectionTableSpecialist {

	private ConnectionDB connectionDB;

	/**
	 * Metodo constructor.
	 */
	public ConnectionTableSpecialist() {
		connectionDB = new ConnectionDB();
	}

	/**
	 * Metodo que busca una password en la tabla y retorna un booleano.
	 * 
	 * @param password
	 */
	public boolean searchPass(String password) {
		connectionDB.createConnection();
		ResultSet resultSet = null;
		Statement statement;
		boolean exist = false;
		try {
			statement = connectionDB.getConn().createStatement();
			resultSet = statement
					.executeQuery("SELECT contraseña FROM especialista WHERE contraseña=UPPER('" + password + "')");
			while (resultSet.next()) {
				if (resultSet != null) {
					exist = true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return exist;
	}

	/**
	 * Metodo que busca un usuario en la tabla y retorna un booleano.
	 * 
	 * @param name
	 */
	public boolean searchUser(String name) {
		connectionDB.createConnection();
		ResultSet resultSet = null;
		Statement statement;
		boolean exist = false;
		try {
			statement = connectionDB.getConn().createStatement();
			resultSet = statement.executeQuery("SELECT nombre FROM especialista WHERE nombre=UPPER('" + name + "')");
			while (resultSet.next()) {
				if (resultSet != null) {
					exist = true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return exist;
	}
}// end ConnectionTableSpecialist