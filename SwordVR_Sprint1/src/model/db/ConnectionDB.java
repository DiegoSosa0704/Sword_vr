package model.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

/**
 * Clase que crea conexion con la base de datos sword_vr de MySQL.
 * 
 * @author SOSA-PC
 * @version 1.0
 * @created 17-oct.-2016 9:32:10 p. m.
 */
public class ConnectionDB {

	private static String bd = "sword_vr";
	private Connection conn = null;
	private static String pw = "";
	static String url = "jdbc:mysql://localhost/" + bd;
	private static String usuario = "root";

	/**
	 * Metodo constructor.
	 */
	public ConnectionDB() {

	}

	/**
	 * Realiza la conexi�n a la base de datos.
	 */
	public void createConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection(url, usuario, pw);
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Hubo un error al conectarse con la base de datos " + bd);
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return the bd
	 */
	public static String getBd() {
		return bd;
	}

	/**
	 * @param bd the bd to set
	 */
	public static void setBd(String bd) {
		ConnectionDB.bd = bd;
	}

	/**
	 * @return the conn
	 */
	public Connection getConn() {
		return conn;
	}

	/**
	 * @param conn the conn to set
	 */
	public void setConn(Connection conn) {
		this.conn = conn;
	}

	/**
	 * @return the pw
	 */
	public static String getPw() {
		return pw;
	}

	/**
	 * @param pw the pw to set
	 */
	public static void setPw(String pw) {
		ConnectionDB.pw = pw;
	}

	/**
	 * @return the url
	 */
	public static String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public static void setUrl(String url) {
		ConnectionDB.url = url;
	}

	/**
	 * @return the usuario
	 */
	public static String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public static void setUsuario(String usuario) {
		ConnectionDB.usuario = usuario;
	}

	
}