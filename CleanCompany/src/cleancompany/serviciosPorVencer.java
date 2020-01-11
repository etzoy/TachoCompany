/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cleancompany;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import modelo.modeloTablaRegPorVencer;
import modelo.regVentaServicio;

/**
 *
 * @author etzoy
 */
public class serviciosPorVencer extends javax.swing.JFrame {
    
    cleanCompany principal = null;
    modeloTablaRegPorVencer mts = new modeloTablaRegPorVencer();
// TableRowSorter<modeloTablaRegPorVencer> elQueOrdena = new TableRowSorter<modeloTablaRegPorVencer>(mts);

    /**
     * Creates new form serviciosPorVencer
     */
    public serviciosPorVencer(cleanCompany principalOrigen) {
        this.principal = principalOrigen;
        initComponents();
        this.getContentPane().setBackground(Color.BLACK);
        this.setLocationRelativeTo(null);
        this.setTitle("Alertas");
        
        try {
            mts.visualizarTabla(this.jTable2, principal);
        } catch (Exception ex) {
            Logger.getLogger(registroServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        //jTable2.setRowSorter(elQueOrdena);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                visiblePrincipal();
            }
        });
    }
    
    public void visiblePrincipal() {
        this.principal.setVisible(true);
    }

    public void actualizar(){
        try {
            mts.visualizarTabla(this.jTable2, principal);
        } catch (Exception ex) {
            Logger.getLogger(registroServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Aceptar");
        jButton5.setToolTipText("Cierra la ventana");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 825, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addGap(374, 374, 374))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton5)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        
        this.setVisible(false);
        this.principal.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
         boolean prueba = true;
        java.sql.Date sqlDate;
        int column = jTable1.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY() / jTable1.getRowHeight();

        if (row < jTable1.getRowCount() && row >= 0 && column < jTable1.getColumnCount() && column >= 0) {
            Object value = jTable1.getValueAt(row, column);

            if (value instanceof JButton) {
                ((JButton) value).doClick();
                JButton boton = (JButton) value;

                if (boton.getName().equals("m")) {
                    System.out.println("Click Boton Modificar" + row + column);
                    regVentaServicio actual = new regVentaServicio();
                    actual.idCliente = this.principal.controlRVentaServicio.getIdCliente(jTable1.getValueAt(row, 0).toString());
                    actual.idServicio = this.principal.controlRVentaServicio.getIdServicio(jTable1.getValueAt(row, 1).toString());
                    actual.unidad = jTable1.getValueAt(row, 2).toString();
                    String nombreCliente = jTable1.getValueAt(row, 0).toString();
                    String nombreServicio = jTable1.getValueAt(row, 1).toString();
                    SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

                    Date fechaDate = null;
                    try {
                        fechaDate = formato.parse(jTable1.getValueAt(row, 6).toString());
                    } catch (ParseException ex) {
                        System.out.println(ex);
                    }
                    sqlDate = new java.sql.Date(fechaDate.getTime());
                    actual.fecha = sqlDate;
                    if (jTable1.getValueAt(row, 4).toString().equals("Dia")) {
                        actual.tipoUnidad = 1;
                    } else if (jTable1.getValueAt(row, 4).toString().equals("Semana")) {
                        actual.tipoUnidad = 2;
                    } else {
                        actual.tipoUnidad = 3;
                    }
                    actual.costo = Integer.valueOf(jTable1.getValueAt(row, 3).toString());
                    actual.cantidadUnidad = Integer.valueOf(jTable1.getValueAt(row, 5).toString());
                    if (jTable1.getValueAt(row, 7).toString().equals("Si")) {
                        actual.darleSeguimiento = true;
                    } else {
                        actual.darleSeguimiento = false;
                    }

                    modificar(actual, nombreCliente, nombreServicio, jTable1);

                }
                if (boton.getName().equals("e")) {
                    System.out.println("Click Boton Eliminar" + row + column);
                    regVentaServicio nuevo = new regVentaServicio();
                    nuevo.idCliente = this.principal.controlRVentaServicio.getIdCliente(jTable1.getValueAt(row, 0).toString());
                    nuevo.idServicio = this.principal.controlRVentaServicio.getIdServicio(jTable1.getValueAt(row, 1).toString());
                    nuevo.unidad = jTable1.getValueAt(row, 2).toString();
                    SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

                    Date fechaDate = null;
                    try {
                        fechaDate = formato.parse(jTable1.getValueAt(row, 6).toString());
                    } catch (ParseException ex) {
                        System.out.println(ex);
                    }
                    sqlDate = new java.sql.Date(fechaDate.getTime());
                    nuevo.fecha = sqlDate;

                    if (JOptionPane.showConfirmDialog(rootPane, "Se eliminará el registro, ¿desea continuar?",
                            "Eliminar Registro", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        try {
                            this.principal.controlRVentaServicio.eliminarRegistro(nuevo);
                        } catch (Exception ex) {
                            Logger.getLogger(registroCliente.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        actualizar();
                        this.principal.rServicioPorVencer.actualizar();

                    }
                    prueba = false;
                }

            }
            if (prueba) {
                //texts(evt);
            }
        }

    }//GEN-LAST:event_jTable2MouseClicked
public void modificar(regVentaServicio actual, String nombreCliente, String nombreServicio, JTable tabla) {
        modVentaServicio ven = new modVentaServicio(this.principal, actual, nombreCliente, nombreServicio, tabla);
        ven.setVisible(true);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
