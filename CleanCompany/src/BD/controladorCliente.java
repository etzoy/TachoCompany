/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

//import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import modelo.cliente;

/**
 *
 * @author etzoy
 */
public class controladorCliente {
    conexion conexionPostgres=null;
    
    public controladorCliente(){
        
    }
    
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
            pstmt.setString(3, actor.telefono);
            pstmt.setString(4, actor.direccion);
 
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
   
   public void actualizarCliente(cliente client, cliente update){
       
  String SQL = "UPDATE \"cleanCompany\".cliente "
          +"SET nombre='"+update.nombre
               +"' , descripcion='"+update.descripcion+"', telefono='"+update.telefono
               +"', direccion='"+update.direccion+"'" 
          +"WHERE nombre='"+client.nombre
               +"' and descripcion='"+client.descripcion+"' and telefono='"+client.telefono
               +"' and direccion='"+client.direccion+"'" ;
       
       ResultSet rset = null;
        try {
            Connection conn = conexionPostgres.connectDatabase();
            PreparedStatement pstm = conn.prepareCall(SQL);
            rset = pstm.executeQuery();
        } catch (SQLException ex) {
            
            System.out.println(ex.getMessage());
        } finally {
           
        }
        
   } 
   
   public void eliminarCliente(cliente client) throws Exception{
       String SQL = "UPDATE \"cleanCompany\".cliente SET eliminado = '1' WHERE nombre='"+client.nombre
               +"' and descripcion='"+client.descripcion+"' and telefono='"+client.telefono
               +"' and direccion='"+client.direccion+"'" ;
       
       ResultSet rset = null;
        try {
            Connection conn = conexionPostgres.connectDatabase();
            PreparedStatement pstm = conn.prepareCall(SQL);
            rset = pstm.executeQuery();
        } catch (SQLException ex) {
            
            System.out.println(ex.getMessage());
        } finally {
           
        }
        
        
   }
  
   public List<cliente> listaClientesVigentes (){
       String SQL = "SELECT * FROM \"cleanCompany\".cliente WHERE (eliminado = '0')";
       
        
        java.util.List<cliente> listaClientes = null;
        cliente p;
        ResultSet rset = null;
       
       
        try {
            Connection conn = conexionPostgres.connectDatabase();
            PreparedStatement pstm = conn.prepareCall(SQL);
            rset = pstm.executeQuery();
           
            listaClientes = new ArrayList<cliente>();
            while (rset.next() == true) {
                p = new cliente();
                p.nombre = rset.getString(2);
                p.descripcion = rset.getString(3);
                p.telefono = rset.getString(4);
                p.direccion = rset.getString(5);
               
                listaClientes.add(p);
            }
            
        } catch (SQLException ex) {
            
            System.out.println(ex.getMessage());
        
        }
        return listaClientes;
   }
   
//    PreparedStatement pstm = conexion.prepareCall("select * from pg_tables  where schemaname = 'public'");
//         ResultSet rset = pstm.executeQuery();
//         while (rset.next())
//         {
//             modelo.addRow(new Object[]
//                    {
//                        rset.getString(1),
//                        rset.getString(2),
//                        rset.getString(3),
//                        rset.getString(4),
//                        rset.getString(5),
//                        rset.getString(6),
//                        rset.getString(7),
//                    });
//         }
}
