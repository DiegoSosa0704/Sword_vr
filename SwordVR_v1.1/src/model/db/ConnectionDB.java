package model.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

/**
 * Created by SOSA-PC on 30/09/2016.
 */
public class ConnectionDB {

    private static String usuario = "root";
    private static String pw = "";
    private static String bd = "sword_vr";
    static String url = "jdbc:mysql://localhost/" + bd;
    private Connection conn = null;

    public ConnectionDB(){

    }

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

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }
}
