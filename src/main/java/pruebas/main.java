/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebas;

import config.Conexion;
import java.sql.*;

/**
 *
 * @author is-da
 */
public class main {
    public static void main(String[] args) throws SQLException{
        Conexion con = Conexion.getInstance();
        con.conectar();
    }
}
