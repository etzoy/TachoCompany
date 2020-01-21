/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import modelo.cliente;
import modelo.regVentaServicio;
import modelo.servicio;

/**
 *
 * @author LENOVO
 */
public class controladorRegistroVentaServicio {

    conexion conexionPostgres = null;
    int idCliente;
    int idServicio;

    public controladorRegistroVentaServicio(conexion conexionBd) {
        conexionPostgres = conexionBd;
    }

    public long insertVentaServicio(regVentaServicio insert) {
        String SQL = "INSERT INTO \"cleanCompany\".\"ProgramacionServicio\"("
                + "	\"idServicio\", \"idCliente\", \"unidadCostoServicio\", \"valorCostoServicio\", \"tipoUnidadmantenimiento\", \"cantidadTiempoMantenimiento\", fecha, \"darleSeguimiento\", \"horaInicio\", \"horaFin\")"
                + "	VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        

        long id = 0;
        try (Connection conn = conexionPostgres.connectDatabase();
                PreparedStatement pstmt = conn.prepareStatement(SQL,
                        Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setInt(1, insert.idServicio);
            pstmt.setInt(2, insert.idCliente);
            pstmt.setString(3, insert.unidad);
            pstmt.setDouble(4, insert.costo);
            pstmt.setInt(5, insert.tipoUnidad);
            pstmt.setInt(6, insert.cantidadUnidad);
            pstmt.setDate(7, insert.fecha);
            pstmt.setBoolean(8, insert.darleSeguimiento);
            pstmt.setTime(9, insert.horaInicio);
            pstmt.setTime(10, insert.horaFin);
            
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
            String fechaMant = "UPDATE \"cleanCompany\".\"ProgramacionServicio\""
                + "	SET \"fechaMantenimiento\"='" + fechaFin(insert)+"'" 
                + "        WHERE \"idServicio\"= '" + insert.idServicio + "' and \"idCliente\" = '" + insert.idCliente + "' and \"unidadCostoServicio\" = '" + insert.unidad
                + "' and fecha='" + insert.fecha + "'";
         ResultSet rset = null;
        try {
            
            PreparedStatement pstm = conn.prepareCall(fechaMant);
            rset = pstm.executeQuery();
        } catch (SQLException ex) {

            System.out.println(ex.getMessage());
        } finally {

        }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return id;
    }
    public Date fechaFin(regVentaServicio consulta){
        
        Date fecha = null;
       // String SQL = "SELECT * FROM \"cleanCompany\".servicio WHERE ( eliminado='0' and nombre = '" + nombre + "')";
        String Sql1 = "SELECT  fecha + (\"cantidadTiempoMantenimiento\" * t.dias || ' days')::interval From \"cleanCompany\".\"ProgramacionServicio\"  inner join \"cleanCompany\".\"tiempo\" t on \"cleanCompany\".\"ProgramacionServicio\".\"tipoUnidadmantenimiento\" = t.\"idTiempo\""
                + "WHERE ( \"idServicio\"= '" + consulta.idServicio + "' and \"idCliente\" = '" + consulta.idCliente + "' and \"unidadCostoServicio\" = '" + consulta.unidad+"'and fecha='" + consulta.fecha + "')";
                
        ResultSet rset = null;
        try {
            Connection conn = conexionPostgres.connectDatabase();
            PreparedStatement pstm = conn.prepareCall(Sql1);
            rset = pstm.executeQuery();

            while (rset.next() == true) {

                fecha = rset.getDate(1);

            }
        } catch (SQLException ex) {

        }
        return fecha;
    }
    public void actualizarRegistro(regVentaServicio actual, regVentaServicio update) {
        String SQL = "UPDATE \"cleanCompany\".\"ProgramacionServicio\"\n"
                + "	SET \"idServicio\"='" + update.idServicio + "' , \"idCliente\"='" + update.idCliente + "' , \"unidadCostoServicio\"='" + update.unidad + "', \"valorCostoServicio\"='" + update.costo + "', \"tipoUnidadmantenimiento\"='" + update.tipoUnidad + "', \"cantidadTiempoMantenimiento\"='" + update.cantidadUnidad + "', fecha='" + update.fecha + "', \"darleSeguimiento\"='" + update.darleSeguimiento + "'"
                + " , \"horaInicio\"='"+ update.horaInicio +"', \"horaFin\"='"+update.horaFin+"'"
                + "        WHERE \"idServicio\"= '" + actual.idServicio + "' and \"idCliente\" = '" + actual.idCliente + "' and \"unidadCostoServicio\" = '" + actual.unidad
                + "' and fecha='" + actual.fecha + "'";

        ResultSet rset = null;
        try {
            Connection conn = conexionPostgres.connectDatabase();
            PreparedStatement pstm = conn.prepareCall(SQL);
            rset = pstm.executeQuery();
        
        String fechaMant = "UPDATE \"cleanCompany\".\"ProgramacionServicio\""
                + "	SET \"fechaMantenimiento\"='" + fechaFin(update)+"'" 
                + "        WHERE \"idServicio\"= '" + update.idServicio + "' and \"idCliente\" = '" + update.idCliente + "' and \"unidadCostoServicio\" = '" + update.unidad
                + "' and fecha='" + update.fecha + "'";
          rset = null;
        
            
             pstm = conn.prepareCall(fechaMant);
            rset = pstm.executeQuery();
        } catch (SQLException ex) {

            System.out.println(ex.getMessage());
        } finally {

        }
    }

    public void eliminarRegistro(regVentaServicio delete) {

        String SQL = "UPDATE  \"cleanCompany\".\"ProgramacionServicio\" SET eliminado = '1'"
                + "	WHERE \"idServicio\"= '" + delete.idServicio + "' and \"idCliente\" = '" + delete.idCliente + "' and \"unidadCostoServicio\" = '" + delete.unidad
                + "' and fecha='" + delete.fecha + "'";

        ResultSet rset = null;
        try {
            Connection conn = conexionPostgres.connectDatabase();
            PreparedStatement pstm = conn.prepareCall(SQL);
            rset = pstm.executeQuery();
        } catch (SQLException ex) {

            System.out.println(ex.getMessage());
        }
    }

    public List<regVentaServicio> listaRegistrosVigentes() {
        String SQL = "SELECT * FROM \"cleanCompany\".\"ProgramacionServicio\" WHERE (eliminado = '0' and fecha <= current_date and \"darleSeguimiento\"='true') order by \"fechaMantenimiento\"";

        java.util.List<regVentaServicio> listaRegistros = null;

        regVentaServicio p;
        ResultSet rset = null;

        try {
            Connection conn = conexionPostgres.connectDatabase();
            PreparedStatement pstm = conn.prepareCall(SQL);
            rset = pstm.executeQuery();

            listaRegistros = new ArrayList<regVentaServicio>();
            while (rset.next() == true) {
                p = new regVentaServicio();
                p.idServicio = rset.getInt(1);
                p.idCliente = rset.getInt(2);
                p.unidad = rset.getString(3);
                p.costo = rset.getInt(4);
                p.tipoUnidad = rset.getInt(5);
                p.cantidadUnidad = rset.getInt(6);
                p.fecha = rset.getDate(7);
                p.darleSeguimiento = rset.getBoolean(8);
                p.fechaMantenimiento = rset.getDate(12);

                listaRegistros.add(p);
            }

        } catch (SQLException ex) {

            System.out.println(ex.getMessage());

        }
        return listaRegistros;
    }

    public List<regVentaServicio> listaAgenda() {
        String SQL = "SELECT * FROM \"cleanCompany\".\"ProgramacionServicio\" WHERE (eliminado = '0' and fecha >= current_date and \"darleSeguimiento\"='true') order by (fecha,  \"horaInicio\")";

        java.util.List<regVentaServicio> listaRegistros = null;

        regVentaServicio p;
        ResultSet rset = null;

        try {
            Connection conn = conexionPostgres.connectDatabase();
            PreparedStatement pstm = conn.prepareCall(SQL);
            rset = pstm.executeQuery();

            listaRegistros = new ArrayList<regVentaServicio>();
            while (rset.next() == true) {
                p = new regVentaServicio();
                p.idServicio = rset.getInt(1);
                p.idCliente = rset.getInt(2);
                p.unidad = rset.getString(3);
                p.costo = rset.getInt(4);
                p.tipoUnidad = rset.getInt(5);
                p.cantidadUnidad = rset.getInt(6);
                p.fecha = rset.getDate(7);
                p.darleSeguimiento = rset.getBoolean(8);
                p.horaInicio = (Time) rset.getObject(10);
                p.horaFin = rset.getTime(11);

                listaRegistros.add(p);
            }

        } catch (SQLException ex) {

            System.out.println(ex.getMessage());

        }
        return listaRegistros;
    }

    public String cliente(int idCliente) {
        String nombre = null;

        String SQL = "SELECT nombre FROM \"cleanCompany\".cliente WHERE (eliminado = '0' and \"idCliente\" = '" + idCliente + "')";
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

    public servicio getServicio(String nombreServ) {
        String SQL = "SELECT * FROM \"cleanCompany\".servicio WHERE ( eliminado = '0' and \"nombre\" = '" + nombreServ + "')";

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
                p.costo = rset.getDouble(5);
                p.tipoUnidad = rset.getInt(6);
                p.cantidadUnidad = rset.getInt(7);

            }

        } catch (SQLException ex) {

            System.out.println(ex.getMessage());

        }
        return p;
    }

    public String servicio(int idServicio) {
        String nombre = null;
        String SQL = "SELECT * FROM \"cleanCompany\".servicio WHERE ( eliminado =  '0' and \"idServicio\" = '" + idServicio + "')";

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

    public int getIdCliente(String nombre) {
        int id = 0;
        String SQL = "SELECT \"idCliente\" FROM \"cleanCompany\".cliente WHERE ( eliminado= '0' and nombre = '" + nombre + "')";
        ResultSet rset = null;
        try {
            Connection conn = conexionPostgres.connectDatabase();
            PreparedStatement pstm = conn.prepareCall(SQL);
            rset = pstm.executeQuery();
            while (rset.next() == true) {

                id = rset.getInt(1);
            }

        } catch (SQLException ex) {

        }
        return id;
    }

    public int getIdServicio(String nombre) {
        int id = 0;
        String SQL = "SELECT * FROM \"cleanCompany\".servicio WHERE ( eliminado='0' and nombre = '" + nombre + "')";

        ResultSet rset = null;
        try {
            Connection conn = conexionPostgres.connectDatabase();
            PreparedStatement pstm = conn.prepareCall(SQL);
            rset = pstm.executeQuery();

            while (rset.next() == true) {

                id = rset.getInt(1);

            }
        } catch (SQLException ex) {

        }
        return id;
    }
    public Time getHoraInicio(int idServicio, int idCliente, Date fecha){
        Time hora = null;
        String SQL = "SELECT * FROM \"cleanCompany\".\"ProgramacionServicio\" WHERE ( eliminado='0' and \"idServicio\" = '" + idServicio + "' and \"idCliente\" ='"+idCliente+"' and fecha ='"+fecha+"')";

         ResultSet rset = null;
        try {
            Connection conn = conexionPostgres.connectDatabase();
            PreparedStatement pstm = conn.prepareCall(SQL);
            rset = pstm.executeQuery();

            while (rset.next() == true) {

                hora = rset.getTime(10);

            }
        } catch (SQLException ex) {

        }
        return hora;
        
    }
    public Time getHoraFin(int idServicio, int idCliente, Date fecha){
        Time hora = null;
        String SQL = "SELECT * FROM \"cleanCompany\".\"ProgramacionServicio\" WHERE ( eliminado='0' and \"idServicio\" = '" + idServicio + "' and \"idCliente\" ='"+idCliente+"' and fecha ='"+fecha+"')";

         ResultSet rset = null;
        try {
            Connection conn = conexionPostgres.connectDatabase();
            PreparedStatement pstm = conn.prepareCall(SQL);
            rset = pstm.executeQuery();

            while (rset.next() == true) {

                hora = rset.getTime(11);

            }
        } catch (SQLException ex) {

        }
        return hora;
        
    }
}
