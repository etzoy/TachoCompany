/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.cliente;

/**
 *
 * @author etzoy
 */
public class controladorCliente {
    conexion conexionPostgres=null;
    
   public  controladorCliente (conexion conexionBd){
    conexionPostgres=conexionBd;
    }
   public void insertCliente(cliente client) {
        String SQL = "INSERT INTO cliente(nombre, descripcion, telefono, direccion) "
                + "VALUES(?,?,?,?)";
        try {
                    Connection conn = conexionPostgres.connectDatabase();
                    
                PreparedStatement statement = conn.prepareStatement(SQL);
                
             
                statement.setString(1, client.nombre);
                statement.setString(2, client.descripcion);
                statement.setString(3, client.telefono);
                statement.setString(4, client.direccion);
                statement.executeUpdate();
                statement.close(); 
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    } 
   
   
   public long insertCliente2(cliente actor) {
        String SQL = "INSERT INTO \"cleanCompany\".cliente(nombre, descripcion, telefono, direccion) "
                + "VALUES(?,?,?,?)";
 
        long id = 0;
 
        try ( Connection conn = conexionPostgres.connectDatabase();
                PreparedStatement pstmt = conn.prepareStatement(SQL,
                Statement.RETURN_GENERATED_KEYS)) {
 
            pstmt.setString(1, actor.nombre);
            pstmt.setString(2, actor.descripcion);
            pstmt.setString(3, actor.direccion);
            pstmt.setString(4, actor.telefono);
 
            int affectedRows = pstmt.executeUpdate();
            // check the affected rows 
            if (affectedRows > 0) {
                // get the ID back
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        id = rs.getLong(1);
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return id;
    }
}
