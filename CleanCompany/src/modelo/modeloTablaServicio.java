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
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author LENOVO
 */
public class modeloTablaServicio {

    cleanCompany principal = null;
    private servicio servicio;

    public void visualizarTabla(JTable tabla, cleanCompany principalOrigen) {
        this.principal = principalOrigen;
        tabla.setDefaultRenderer(Object.class, new render());
        DefaultTableModel dt = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        TableRowSorter sorter = new TableRowSorter(dt);
        dt.addColumn("Nombre");
        dt.addColumn("Descripcion");
        dt.addColumn("Unidad");
        dt.addColumn("Costo Unidad");
        dt.addColumn("Tipo Unidad");
        dt.addColumn("Cantidad Unidad");
        dt.addColumn("Modificar");
        dt.addColumn("Eliminar");

        JButton btn_modificar = new JButton();
        btn_modificar.setIcon(new ImageIcon("update.png"));
        btn_modificar.setName("m");
        btn_modificar.setToolTipText("Modifica el Servicio Seleccionado");
        JButton btn_eliminar = new JButton();
        btn_eliminar.setIcon(new ImageIcon("delete.png"));
        btn_eliminar.setName("e");
        btn_eliminar.setToolTipText("Elimina el Servicio Seleccionado");

        servicio = new servicio();

        try {
            List<servicio> list = principal.controlServicio.listaServiciosVigentes();

            if (list != null && !list.isEmpty()) {
                if (list.size() > 0) {
                    for (int i = 0; i < list.size(); i++) {
                        Object fila[] = new Object[8];
                        servicio = list.get(i);
                        fila[0] = servicio.nombre;
                        fila[1] = servicio.descripcion;
                        fila[2] = servicio.unidad;
                        fila[3] = servicio.costo;
                        if (servicio.tipoUnidad == 1) {
                            fila[4] = "Dia";
                        } else if (servicio.tipoUnidad == 2) {
                            fila[4] = "Semana";
                        } else {
                            fila[4] = "Mes";
                        }
                        fila[5] = servicio.cantidadUnidad;
                        fila[6] = btn_modificar;
                        fila[7] = btn_eliminar;
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
