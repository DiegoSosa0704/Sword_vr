package Persistence;

import logic.Specialist;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

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

    public boolean searchPass(String password){
        connectionDB.createConnection();
        ResultSet resultSet = null;
        Statement statement;
        boolean exist = false;
        try {
            statement = connectionDB.getConn().createStatement();
            resultSet = statement.executeQuery("SELECT contraseña FROM administrador WHERE contraseña=UPPER('" + password + "')");
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

    public void addSpecialist(String name, String lastName, String pass, String position, String email){
        connectionDB.createConnection();
        Statement statement;
        try {
            statement = connectionDB.getConn().createStatement();
            statement.executeUpdate("INSERT INTO `especialista`(`id_especialista`, `nombre`, `apellido`, `cargo`, `contraseña`, `correo`, `ADMINISTRADOR_id_admin`) VALUES (NULL, '"+ name +"','"+ lastName +"','"+ position +"','"+ pass +"','"+ email +"',1)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateSpecialist(int id_specialist, String name, String lastName, String position, String pass, String email){
        connectionDB.createConnection();
        try{
            Statement statement = connectionDB.getConn().createStatement();
            statement.executeUpdate("UPDATE especialista SET nombre='"+name+"', apellido='"+lastName+"', cargo='"+position+"', contraseña='"+pass+"', correo='"+email+"'  WHERE id_especialista='"+id_specialist+"'");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deleteSpecialist(int id_specialist){
        connectionDB.createConnection();
        Statement statement;
        try {
            statement = connectionDB.getConn().createStatement();
            statement.executeUpdate("DELETE FROM especialista WHERE id_especialista = '"+id_specialist+"'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Specialist> getQuerySpecialists(){
        connectionDB.createConnection();
        ResultSet resultSet = null;
        ArrayList<Specialist> results = new ArrayList();
        try{
            Statement statement = connectionDB.getConn().createStatement();
            resultSet = statement.executeQuery("SELECT id_especialista, nombre, apellido, cargo, correo FROM especialista");
            ResultSetMetaData md = resultSet.getMetaData();
            int columns = md.getColumnCount();
            String id = null, name = null, lastName = null, position = null, email = null;
            while (resultSet.next()) {
                for(int i=1; i<=columns; i++){
                    if(i ==  1){
                        id = resultSet.getObject(i).toString();
                    }else if(i == 2){
                        name = resultSet.getObject(i).toString();
                    }else if(i == 3){
                        lastName = resultSet.getObject(i).toString();
                    }else if(i == 4){
                        position = resultSet.getObject(i).toString();
                    }else if(i == 5){
                        email = resultSet.getObject(i).toString();
                    }
                }
                results.add(new Specialist(id, name, lastName, position, email));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return results;
    }
}
