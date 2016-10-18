package model.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.ObservableList;
import model.Specialist;

/**
 * Clase que manipula datos de la tabla Administrador de la base de datos.
 * 
 * @author SOSA-PC
 * @version 1.0
 * @created 17-oct.-2016 9:32:10 p. m.
 */
public class ConnectionTableAdmin {

	private ConnectionDB connectionDB;

	/**
	 * Metodo constructor.
	 */
	public ConnectionTableAdmin() {
		connectionDB = new ConnectionDB();
	}

	/**
	 * Inserta tuplas en la tabla Administrador.
	 * 
	 * @param name
	 * @param lastName
	 * @param pass
	 * @param position
	 * @param email
	 */
	public void addSpecialist(String name, String lastName, String pass, String position, String email) {
		connectionDB.createConnection();
		Statement statement;
		try {
			statement = connectionDB.getConn().createStatement();
			statement.executeUpdate(
					"INSERT INTO `especialista`(`id_especialista`, `nombre`, `apellido`, `cargo`, `contraseña`, `correo`, `ADMINISTRADOR_id_admin`) VALUES (NULL, '"
							+ name + "','" + lastName + "','" + position + "','" + pass + "','" + email + "',1)");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo que elimina un tuplas de la tabla Administrador.
	 * 
	 * @param id_specialist
	 */
	public void deleteSpecialist(int id_specialist) {
		connectionDB.createConnection();
		Statement statement;
		try {
			statement = connectionDB.getConn().createStatement();
			statement.executeUpdate("DELETE FROM especialista WHERE id_especialista = '" + id_specialist + "'");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo realiza una consulta a la tabla Administrador.
	 * 
	 * @param lista
	 */
	public void getQuerySpecialists(ObservableList<Specialist> lista) {
		lista.removeAll(lista);
		connectionDB.createConnection();
		ResultSet resultSet = null;
		try {
			Statement statement = connectionDB.getConn().createStatement();
			resultSet = statement
					.executeQuery("SELECT id_especialista, nombre, apellido, cargo, correo FROM especialista");
			while (resultSet.next()) {
				lista.add(new Specialist(resultSet.getInt("id_especialista"), resultSet.getString("nombre"),
						resultSet.getString("apellido"), resultSet.getString("cargo"), resultSet.getString("correo")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo que busca un administrador en la tabla y retorna un booleano.
	 * 
	 * @param name
	 */
	public boolean searchAdmin(String name) {
		connectionDB.createConnection();
		ResultSet resultSet = null;
		Statement statement;
		boolean exist = false;
		try {
			statement = connectionDB.getConn().createStatement();
			resultSet = statement.executeQuery("SELECT nombre FROM administrador WHERE nombre=UPPER('" + name + "')");
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
					.executeQuery("SELECT contraseña FROM administrador WHERE contraseña=UPPER('" + password + "')");
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
	 * Metodo que edita una tupla de la tabla Administrador.
	 * 
	 * @param id_specialist
	 * @param name
	 * @param lastName
	 * @param position
	 * @param pass
	 * @param email
	 */
	public void updateSpecialist(int id_specialist, String name, String lastName, String position, String pass,
			String email) {
		connectionDB.createConnection();
		try {
			Statement statement = connectionDB.getConn().createStatement();
			statement.executeUpdate("UPDATE especialista SET nombre='" + name + "', apellido='" + lastName
					+ "', cargo='" + position + "', contraseña='" + pass + "', correo='" + email
					+ "'  WHERE id_especialista='" + id_specialist + "'");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return the connectionDB
	 */
	public ConnectionDB getConnectionDB() {
		return connectionDB;
	}

	/**
	 * @param connectionDB the connectionDB to set
	 */
	public void setConnectionDB(ConnectionDB connectionDB) {
		this.connectionDB = connectionDB;
	}
	
	
}// end ConnectionTableAdmin