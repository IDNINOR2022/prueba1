/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

/**
 *
 * @author is-da
 */
import java.sql.*;

public class ConexionMySQL {
    
    private ConexionMySQL(){
        
    }
    
    private static Connection conexion = null;
    
    //Creamos una sola instancia//
    private static  ConexionMySQL instancia;
    //Creamos las variables para conectarnos a la base de datos//
    private static final String url = "jdbc:mysql://localhost/prueba1";
    private static final String usuario = "root";
    private static final String password = "";
    
    public Connection conectar(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url, usuario, password);
            System.out.println("Conexion Existosa");
            return conexion;
        }catch(Exception e){
            System.out.println("Error al conectar a la BD: "+e);
        }
        return conexion;
    }
    
    //Metodo para cerrar la conexión//
    public void cerrarConexion() throws SQLException{
        try{
            conexion.close();
            System.out.println("Se desconecto de la BD");
        }catch(Exception e){
            System.out.println("Error a cerra conexion: "+e);
            conexion.close();
        }finally{
            conexion.close();
        }
    }
    
    //Patron Singleton//
    public static ConexionMySQL getInstance(){
        if(instancia == null){
            instancia = new ConexionMySQL();
        }
        return instancia;
    }
}
