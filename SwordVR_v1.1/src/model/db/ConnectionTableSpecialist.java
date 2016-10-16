package model.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by SOSA-PC on 30/09/2016.
 */
public class ConnectionTableSpecialist {

    private ConnectionDB connectionDB;

    public ConnectionTableSpecialist() {
        connectionDB = new ConnectionDB();
    }

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

    public boolean searchPass(String password){
        connectionDB.createConnection();
        ResultSet resultSet = null;
        Statement statement;
        boolean exist = false;
        try {
            statement = connectionDB.getConn().createStatement();
            resultSet = statement.executeQuery("SELECT contraseña FROM especialista WHERE contraseña=UPPER('" + password + "')");
            while (resultSet.next()) {
                if (resultSet != null) {
                    exist = true;
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return exist;
    }

}
