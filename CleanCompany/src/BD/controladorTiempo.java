/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.servicio;
import modelo.tiempo;

/**
 *
 * @author LENOVO
 */
public class controladorTiempo {
     conexion conexionPostgres = null;
     
     public controladorTiempo(conexion conexionBd){
         conexionPostgres = conexionBd;
     }
     
      public List<tiempo> listaTiempo() {
        String SQL = "SELECT * FROM \"cleanCompany\".tiempo";

        java.util.List<tiempo> listaTiempo = null;
        tiempo p;
        ResultSet rset = null;

        try {
            Connection conn = conexionPostgres.connectDatabase();
            PreparedStatement pstm = conn.prepareCall(SQL);
            rset = pstm.executeQuery();

            listaTiempo = new ArrayList<tiempo>();
            while (rset.next() == true) {
                p = new tiempo();
                p.id = rset.getInt(1);
                p.dias = rset.getInt(2);
                p.nombre = rset.getString(3);
               

                listaTiempo.add(p);
            }

        } catch (SQLException ex) {

            System.out.println(ex.getMessage());

        }
        return listaTiempo;
    }
    
}
