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
import modelo.cliente;
import modelo.registroVentaServicio;
import modelo.servicio;

/**
 *
 * @author LENOVO
 */
public class controladorRegistroVentaServicio {

    conexion conexionPostgres = null;
    String nombre;
    int idCliente;
    int idServicio;

    public controladorRegistroVentaServicio(conexion conexionBd) {
        conexionPostgres = conexionBd;
    }

    public List<registroVentaServicio> listaRegistrosVigentes() {
        String SQL = "SELECT * FROM \"cleanCompany\".\"ProgramacionServicio\"";

        java.util.List<registroVentaServicio> listaRegistros = null;

        registroVentaServicio p;
        ResultSet rset = null;

        try {
            Connection conn = conexionPostgres.connectDatabase();
            PreparedStatement pstm = conn.prepareCall(SQL);
            rset = pstm.executeQuery();

            listaRegistros = new ArrayList<registroVentaServicio>();
            while (rset.next() == true) {
                p = new registroVentaServicio();
                p.idServicio = rset.getInt(1);
                p.idCliente = rset.getInt(2);
                p.unidad = rset.getString(3);
                p.costo = rset.getInt(4);
                p.tipoUnidad = rset.getInt(5);
                p.cantidadUnidad = rset.getInt(6);
                p.fecha = rset.getDate(7);
                p.darleSeguimiento = rset.getBoolean(8);

                listaRegistros.add(p);
            }

        } catch (SQLException ex) {

            System.out.println(ex.getMessage());

        }
        return listaRegistros;
    }

    public String cliente(int idCliente) {

        String SQL = "SELECT nombre FROM \"cleanCompany\".cliente WHERE (\"idCliente\" = '" + idCliente + "')";
        ResultSet rset = null;
        try {
            Connection conn = conexionPostgres.connectDatabase();
            PreparedStatement pstm = conn.prepareCall(SQL);
            rset = pstm.executeQuery();
            while (rset.next() == true) {

                nombre = rset.getString(1);
            }

        } catch (SQLException ex) {

        }
        return nombre;
    }
    public servicio getServicio(String nombreServ){
       String SQL = "SELECT * FROM \"cleanCompany\".servicio WHERE ( \"nombre\" = '" + nombreServ + "')";

        servicio p = null;
        ResultSet rset = null;

        try {
            Connection conn = conexionPostgres.connectDatabase();
            PreparedStatement pstm = conn.prepareCall(SQL);
            rset = pstm.executeQuery();

            
            while (rset.next() == true) {
                p = new servicio();
                p.nombre = rset.getString(2);
                p.descripcion = rset.getString(3);
                p.unidad = rset.getString(4);
                p.costo = rset.getInt(5);
                p.tipoUnidad = rset.getInt(6);
                p.cantidadUnidad = rset.getInt(7);

                
            }

        } catch (SQLException ex) {

            System.out.println(ex.getMessage());

        }
        return p;
    }
    public String servicio(int idServicio) {

        String SQL = "SELECT * FROM \"cleanCompany\".servicio WHERE ( \"idServicio\" = '" + idServicio + "')";

        ResultSet rset = null;
        try {
            Connection conn = conexionPostgres.connectDatabase();
            PreparedStatement pstm = conn.prepareCall(SQL);
            rset = pstm.executeQuery();

            while (rset.next() == true) {

                nombre = rset.getString(2);

            }
        } catch (SQLException ex) {

        }
        return nombre;
    }
}
