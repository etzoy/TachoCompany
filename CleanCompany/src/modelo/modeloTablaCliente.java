/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

//imports
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import BD.controladorCliente;
import cleancompany.cleanCompany;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.table.TableRowSorter;

        
public class modeloTablaCliente{
    cleanCompany principal=null;
   private cliente cliente;
   
  
    public void visualizarTabla(JTable tabla, cleanCompany principalOrigen){
        this.principal=principalOrigen;
        tabla.setDefaultRenderer(Object.class, new render());
        DefaultTableModel dt = new DefaultTableModel(){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };    
        TableRowSorter sorter = new TableRowSorter(dt);
        dt.addColumn("Nombre");
        dt.addColumn("Descripcion");
        dt.addColumn("Telefono");
        dt.addColumn("Direccion");
        dt.addColumn("Modificar");
        dt.addColumn("Eliminar");
        
        JButton btn_modificar = new JButton();
        btn_modificar.setIcon(new ImageIcon("update.png"));
        btn_modificar.setName("m");
        btn_modificar.setToolTipText("Modifica el Cliente Seleccionado");
        JButton btn_eliminar = new JButton();
        btn_eliminar.setIcon(new ImageIcon("delete.png"));
        btn_eliminar.setName("e");
        btn_eliminar.setToolTipText("Elimina el Cliente Seleccionado");

        
        cliente = new cliente();
        
       try {
          List<cliente> list = principal.controlCliente.listaClientesVigentes();
           if (list != null && !list.isEmpty()) {

        if(list.size() > 0){
            for(int i=0; i<list.size(); i++){
                Object fila[] = new Object[6];
                cliente = list.get(i);
                fila[0] = cliente.nombre;
                fila[1] = cliente.descripcion;
                fila[2] = cliente.telefono;
                fila[3] = cliente.direccion;
                fila[4] = btn_modificar;
                fila[5] = btn_eliminar;
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
