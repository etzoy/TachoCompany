/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Date;
import java.sql.Time;
import java.util.Calendar;

/**
 *
 * @author LENOVO
 */
public class regVentaServicio {
    public int idCliente;
    public int idServicio;
    public String unidad;
    
    public double costo;
    public int tipoUnidad;
    public int cantidadUnidad;
    public Date fecha;
    public Time horaInicio;
    public Time horaFin;
    public boolean darleSeguimiento;
    public Date fechaMantenimiento;
    
}
