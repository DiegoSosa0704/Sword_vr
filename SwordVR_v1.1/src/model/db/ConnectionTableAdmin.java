package model.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.ObservableList;
import model.Specialist;

/**
 * Created by SOSA-PC on 30/09/2016.
 */
public class ConnectionTableAdmin {

	private ConnectionDB connectionDB;

	public ConnectionTableAdmin() {
		connectionDB = new ConnectionDB();
	}

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
}
