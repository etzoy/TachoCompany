/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import cleancompany.cleanCompany;
import java.sql.Date;
import java.util.Collections;
import java.util.Comparator;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author LENOVO
 */
public class modeloTablaRegPorVencer {

    cleanCompany principal = null;
    private regVentaServicio rVentaServicio;

    public void visualizarTabla(JTable tabla, cleanCompany principalOrigen) {
        this.principal = principalOrigen;
        tabla.setDefaultRenderer(Object.class, new renderAlertas());
        DefaultTableModel dt = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        //TableRowSorter sorter = new TableRowSorter(dt);

        dt.addColumn("Cliente");
        dt.addColumn("Servicio");
        dt.addColumn("Unidad");
        dt.addColumn("Costo Unidad");
        dt.addColumn("Tipo Unidad");
        dt.addColumn("Cantidad Unidad");
        dt.addColumn("Fecha de Finalizacion");
        dt.addColumn("Darle Seguimiento");
        dt.addColumn("Atender");
        dt.addColumn("Descartar");

        JButton btn_modificar = new JButton();
        btn_modificar.setIcon(new ImageIcon("update.png"));
        btn_modificar.setName("m");
        JButton btn_eliminar = new JButton();
        btn_eliminar.setIcon(new ImageIcon("delete.png"));
        btn_eliminar.setName("e");

        rVentaServicio = new regVentaServicio();

        try {
            List<regVentaServicio> list = principal.controlRVentaServicio.listaRegistrosVigentes();
            if (list != null && !list.isEmpty()) {
                Collections.sort(list, new Comparator<regVentaServicio>() {
                    public int compare(regVentaServicio p1, regVentaServicio p2) {
                        return p1.fecha.compareTo(p2.fecha);
                    }
                });

                if (list.size() > 0) {
                    for (int i = 0; i < list.size(); i++) {
                        Object fila[] = new Object[10];
                        rVentaServicio = list.get(i);
                        fila[0] = principal.controlRVentaServicio.cliente(rVentaServicio.idCliente);
                        fila[1] = principal.controlRVentaServicio.servicio(rVentaServicio.idServicio);
                        fila[2] = rVentaServicio.unidad;
                        fila[3] = rVentaServicio.costo;
                        if (rVentaServicio.tipoUnidad == 1) {
                            fila[4] = "Dia";
                        } else if (rVentaServicio.tipoUnidad == 2) {
                            fila[4] = "Semana";
                        } else {
                            fila[4] = "Mes";
                        }
                        fila[5] = rVentaServicio.cantidadUnidad;
                        fila[6] = rVentaServicio.fecha;
                        if (rVentaServicio.darleSeguimiento) {
                            fila[7] = "Si";
                        } else {
                            fila[7] = "No";
                        }
                        fila[8] = btn_modificar;
                        fila[9] = btn_eliminar;
                        dt.addRow(fila);
                    }

                }
            }
            tabla.setModel(dt);
            tabla.setRowHeight(35);
            //tabla.setRowSorter(sorter);
        } catch (Exception ex) {
            Logger.getLogger(modeloTablaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Date fsfs() {
        Date sfs = null;
        return sfs;
    }
}
