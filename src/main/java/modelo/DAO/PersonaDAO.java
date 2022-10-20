/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.DAO;

import config.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.DTO.PersonaDTO;

/**
 *
 * @author is-da
 */
public class PersonaDAO {
   private static final String SQL_READALL ="SELECT * FROM tb_persona";
   private static final Conexion con = Conexion.getInstance();

    public PersonaDAO() {
        con.conectar();
    }
   
   
    public List<PersonaDTO> readAll(){
        List<PersonaDTO> lista = null;
        PreparedStatement ps;
       
        try{
             ps = con.conectar().prepareStatement(SQL_READALL);
             ResultSet rs = ps.executeQuery();
             lista = new ArrayList<>();
             while(rs.next()){
                 PersonaDTO objeto = new PersonaDTO(
                         rs.getString("nombres"),
                         rs.getString("telefono"),
                         rs.getString(""),
                         rs.getString(""));
             }
            
        }catch(SQLException ex){
            
        }
        
       return lista;
        
    }
}
