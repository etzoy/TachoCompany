/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import cleancompany.cleanCompany;
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
public class modeloTablaRegistroServicio {

    cleanCompany principal = null;
    private regVentaServicio rVentaServicio;

    public void visualizarTabla(JTable tabla, cleanCompany principalOrigen) {
        this.principal = principalOrigen;
        tabla.setDefaultRenderer(Object.class, new render());
        DefaultTableModel dt = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        TableRowSorter sorter = new TableRowSorter(dt);
        dt.addColumn("Cliente");
        dt.addColumn("Servicio");
        dt.addColumn("Unidad");
        dt.addColumn("Costo Unidad");
        dt.addColumn("Tipo Unidad");
        dt.addColumn("Cantidad Unidad");
        dt.addColumn("Fecha");
        dt.addColumn("Darle Seguimiento");
        dt.addColumn("Modificar");
        dt.addColumn("Eliminar");

        JButton btn_modificar = new JButton();
        btn_modificar.setIcon(new ImageIcon("update.png"));
        btn_modificar.setName("m");
        btn_modificar.setToolTipText("Modifica la Venta");
        JButton btn_eliminar = new JButton();
        btn_eliminar.setIcon(new ImageIcon("delete.png"));
        btn_eliminar.setName("e");
        btn_eliminar.setToolTipText("Elimina la Venta");

        rVentaServicio = new regVentaServicio();

        try {
            List<regVentaServicio> list = principal.controlRVentaServicio.listaRegistrosVigentes();

            if (list != null && !list.isEmpty()) {

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
            tabla.setRowSorter(sorter);
        } catch (Exception ex) {
            Logger.getLogger(modeloTablaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
