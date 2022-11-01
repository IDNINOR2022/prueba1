/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author is-da
 */
public class ConexionRHeroku {
      private Connection conectar;
    private String BD;
    private String usuario;
    private String contra;
    private static ConexionRHeroku con;

    public ConexionRHeroku() {

    }

    public Connection conectar() {
        try {
            Class.forName("org.postgresql.Driver");
            this.BD = "jdbc:postgresql://ec2-3-213-66-35.compute-1.amazonaws.com:5432/d463ke2mhm8np0";
            this.usuario = "kmexxmxwgkmyii";
            this.contra = "4432729b89254410e668fae7e926738dbddd3db0b590e86d05bfdbf34b89dffe";
            this.conectar = (Connection) DriverManager.getConnection(BD, usuario, contra);
            System.out.println("SE CONECTO");
        } catch (ClassNotFoundException | HeadlessException | SQLException e) {

            System.out.println("Error al conectar: " + e);
        }
        return conectar;
    }

    public Connection getConexion() {
        return conectar;
    }

    public static ConexionRHeroku getIntance() {
        if (con == null) {
            con = new ConexionRHeroku();
        }
        return con;
    }
}
