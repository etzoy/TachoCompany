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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.servicio;

/**
 *
 * @author LENOVO
 */
public class controladorServicio {

    conexion conexionPostgres = null;

    public controladorServicio(conexion conexionBd) {
        conexionPostgres = conexionBd;
    }

    public long insertServicio(servicio actor) {
        String SQL = "INSERT INTO \"cleanCompany\".servicio(nombre, descripcion, \"unidadCostoServicio\", \"valorCostoServicio\", \"tipoUnidadMantenimiento\", \"cantidadTiempoMantenimiento\") "
                + "VALUES(?,?,?,?,?,?)";

        long id = 0;

        try (Connection conn = conexionPostgres.connectDatabase();
                PreparedStatement pstmt = conn.prepareStatement(SQL,
                        Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, actor.nombre);
            pstmt.setString(2, actor.descripcion);
            pstmt.setString(3, actor.unidad);
            pstmt.setInt(4, actor.costo);
            pstmt.setInt(5, actor.tipoUnidad);
            pstmt.setInt(6, actor.cantidadUnidad);

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

    public void actualizarServicio(servicio actual, servicio update) {
        String SQL = "UPDATE \"cleanCompany\".servicio "
                + "SET nombre='" + update.nombre
                + "' , descripcion='" + update.descripcion + "', \"unidadCostoServicio\"='" + update.unidad
                + "', \"valorCostoServicio\"='" + update.costo + "', \"tipoUnidadMantenimiento\"='" + update.tipoUnidad + "', \"cantidadTiempoMantenimiento\"='" + update.cantidadUnidad + "'"
                + "WHERE nombre='" + actual.nombre
                + "' and descripcion='" + actual.descripcion + "' and \"unidadCostoServicio\"='" + actual.unidad
                + "' and \"valorCostoServicio\"='" + actual.costo + "' and  \"tipoUnidadMantenimiento\"='" + actual.tipoUnidad + "' and \"cantidadTiempoMantenimiento\"='" + actual.cantidadUnidad + "'";

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

    public void eliminarServicio(servicio servicio) {

        String SQL = "UPDATE \"cleanCompany\".servicio SET eliminado = '1' WHERE nombre='" + servicio.nombre
                + "' and descripcion='" + servicio.descripcion + "' and \"unidadCostoServicio\"='" + servicio.unidad
                + "' and \"valorCostoServicio\"='" + servicio.costo + "'";

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

    public List<servicio> listaServiciosVigentes() {
        String SQL = "SELECT * FROM \"cleanCompany\".servicio WHERE (eliminado = '0')";

        java.util.List<servicio> listaServicios = null;
        servicio p;
        ResultSet rset = null;

        try {
            Connection conn = conexionPostgres.connectDatabase();
            PreparedStatement pstm = conn.prepareCall(SQL);
            rset = pstm.executeQuery();

            listaServicios = new ArrayList<servicio>();
            while (rset.next() == true) {
                p = new servicio();
                p.nombre = rset.getString(2);
                p.descripcion = rset.getString(3);
                p.unidad = rset.getString(4);
                p.costo = rset.getInt(5);
                p.tipoUnidad = rset.getInt(6);
                p.cantidadUnidad = rset.getInt(7);

                listaServicios.add(p);
            }

        } catch (SQLException ex) {

            System.out.println(ex.getMessage());

        }
        return listaServicios;
    }
}
