/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Miguel
 */
public class DBManager {

    public String result = "";
    private String bd, login, password, url;
    private Connection conn;
    private boolean DBConected = false;

    DBManager(String url, String login, String Password) {
        /*Asigna los valores de las variable principales del metodo
         el proposito de este metodo CONSTRUCTOR es de general las variable primarias
         sin conocer el nombre de la base de datos a manipular...
         luego devera utilizar el metodo .setDataBaseName(nombre de la base de datos)
         */
        this.url = url;
        this.login = login;
        this.password = Password;
    }

    DBManager(String url, String login, String Password, String name) {
        /*Asigna los valores de las variable principales del metodo
         el proposito de este metodo CONSTRUCTOR es de general las variable primarias        
         */
        this.url = url + "/" + name;
        this.login = login;
        this.password = Password;
        this.bd = name;
    }

    public void setDataBaseName(String name) {
        /*
         Metodo donde se Inicializa el nombre de la base de datos para inicial una conexion
         */

        this.bd = name;
        this.url = url + "/" + bd;
    }

    public String getDBname() {
        return bd;
    }

    public boolean IsDBConected() {
        /*
         Prueba la conexion correcta de la base de datos 
        
         */

        try {
            conn = DriverManager.getConnection(url, login, password);
        } catch (SQLException ex) {
            DBConected = false;
            System.out.println("Bases de datos desconectada");
        }

        return DBConected;
    }

    public boolean IsDBLinked() {
        /*
         Devuleve el el estado de la conexion independiente mente de si esta funcionando o no!
         */
        return DBConected;
    }

    public Statement DBconect() {
        /*
         Conecta la base de datos con las configuraciones dadas en el constructor
         */
        conn = null;
        Statement st = null;
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            conn = DriverManager.getConnection(url, login, password);
            if (conn != null) {
                DBConected = true;
                st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            }
        } catch (SQLException ex) {
            DBConected = false;
        } catch (ClassNotFoundException ex) {

        }
        return st;
    }

    public void DBdisconect() {
        try {
            conn.close();
            DBConected = false;
        } catch (SQLException ex) {

        }
    }

    public void ExeSQL(String SQLcommand) {
        /*
         Ejecuta Codigo SQL nativo 
         CUIDADO! CONTROL TOTAL DE EL ALCANCE DEL USUARIO!
         NO USAR SIN EXPERIENCIA EN CODIFICACION SQL        
         */
        try {
            PreparedStatement d = conn.prepareStatement(SQLcommand);
            d.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error de SQL");
        }
    }

    public ResultSet Select(String table, String column, String statement) {
        /*
         Obtiene todos los datos de  una fila a la vez 
        
         */
        ResultSet rs = null;

        try {
            Statement g = conn.createStatement();
            rs = g.executeQuery("SELECT * FROM `" + table + "` WHERE `" + column + "` LIKE '" + statement + "' ");

        } catch (SQLException ex) {

        }

        return rs;
    }

    public ResultSet SelectAllFrom(String table) {
        /*
         Obtiene todos los datos de una tabla
         NO SE ACONSEJA SU USO CON BASES DE DATOS GRANDES (ALENTAN EL PROCESO)
         */
        ResultSet rs = null;

        try {
            Statement g = conn.createStatement();
            rs = g.executeQuery("SELECT * FROM `" + table);

        } catch (SQLException ex) {

        }

        return rs;
    }

    public void updateWhere(String table, String column, String value, String where, String value2) {
        /*
         Actualiza los datos de una columna de una fila sin alterar otra columna
        
         */

        String command = "UPDATE `" + bd + "`.`" + table + "` SET `" + column + "` = '" + value + "' WHERE `" + table + "`.`" + where + "` = '" + value2 + "';";
        try {
            PreparedStatement d = conn.prepareStatement(command);
            d.executeUpdate();
        } catch (SQLException ex) {
            System.out.printf("ERROR SQL ");

            System.out.println(command);
        }

    }
}
