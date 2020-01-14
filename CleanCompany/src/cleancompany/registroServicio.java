/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cleancompany;

import Reportes.generarReportes;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import modelo.modeloTablaServicio;
import modelo.servicio;

/**
 *
 * @author etzoy
 */
public class registroServicio extends javax.swing.JFrame {

    cleanCompany principal = null;
    modeloTablaServicio mts = new modeloTablaServicio();

    int clickTabla;
    servicio nuevo = new servicio();
    nuevoServicio nuevoServicio;

    /**
     * Creates new form catalogoServicio
     */
    public registroServicio(cleanCompany principalOrigen) {
        this.principal = principalOrigen;
        initComponents();
        this.getContentPane().setBackground(Color.BLACK);
        this.setLocationRelativeTo(null);
        this.setTitle("Registro de Servicios");
//        this.botonModificar.setVisible(false);
//        this.jButton4.setVisible(false);

        try {
            mts.visualizarTabla(this.jtblListaServicios, principal);
        } catch (Exception ex) {
            Logger.getLogger(registroServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                visiblePrincipal();
            }
        });
    }

    public void visiblePrincipal() {
        this.principal.setVisible(true);
//        this.botonModificar.setVisible(false);
        this.getContentPane().setBackground(Color.BLACK);
        vaciarCampos();
    }

    public void actualizar() {
        try {
            mts.visualizarTabla(this.jtblListaServicios, principal);
            //mtc.fireTableDataChanged();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error en la actualizacion de la base de datos");
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

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtblListaServicios = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Cancelar");
        jButton1.setToolTipText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));

        jtblListaServicios.setModel(new javax.swing.table.DefaultTableModel(
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
        jtblListaServicios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtblListaServiciosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtblListaServicios);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Crear un nuevo servicio");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Actualizar tabla");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Imprimir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 443, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(17, 17, 17)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.getContentPane().setBackground(Color.BLACK);
        this.setVisible(false);        // TODO add your handling code here:
        this.principal.setVisible(true);
//        this.botonModificar.setVisible(false);
        vaciarCampos();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jtblListaServiciosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblListaServiciosMouseClicked
        // TODO add your handling code here:
        boolean prueba = true;
        int column = jtblListaServicios.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY() / jtblListaServicios.getRowHeight();

        if (row < jtblListaServicios.getRowCount() && row >= 0 && column < jtblListaServicios.getColumnCount() && column >= 0) {
            Object value = jtblListaServicios.getValueAt(row, column);

            if (value instanceof JButton) {
                ((JButton) value).doClick();
                JButton boton = (JButton) value;

                if (boton.getName().equals("m")) {
                    System.out.println("Click Boton Modificar" + row + column);

                    this.nuevo.nombre = jtblListaServicios.getValueAt(row, 0).toString();
                    this.nuevo.descripcion = jtblListaServicios.getValueAt(row, 1).toString();
                    this.nuevo.unidad = jtblListaServicios.getValueAt(row, 2).toString();
                    this.nuevo.costo = Integer.parseInt(jtblListaServicios.getValueAt(row, 3).toString());

                    if (jtblListaServicios.getValueAt(row, 4).toString().equals("Dia")) {
                        this.nuevo.tipoUnidad = 1;
                    } else if (jtblListaServicios.getValueAt(row, 4).toString().equals("Semana")) {
                        this.nuevo.tipoUnidad = 2;
                    } else {
                        this.nuevo.tipoUnidad = 3;
                    }
                    this.nuevo.cantidadUnidad = Integer.parseInt(jtblListaServicios.getValueAt(row, 5).toString());
                    clickTabla = this.jtblListaServicios.rowAtPoint(evt.getPoint());
                    String nombre = this.jtblListaServicios.getValueAt(clickTabla, 0).toString();
                    String descripcion = this.jtblListaServicios.getValueAt(clickTabla, 1).toString();
                    String unidad = this.jtblListaServicios.getValueAt(clickTabla, 2).toString();
                    String costo = this.jtblListaServicios.getValueAt(clickTabla, 3).toString();
                    String cantidadUnidad = this.jtblListaServicios.getValueAt(clickTabla, 5).toString();
                    int combo = 0;
                    if (jtblListaServicios.getValueAt(clickTabla, 4).toString().equals("Dia")) {
                        combo=1;
                    } else if (jtblListaServicios.getValueAt(clickTabla, 4).toString().equals("Semana")) {
                        combo=2;
                    } else {
                        combo=3;
                    }

                    nuevoServicio = new nuevoServicio(principal);
                    nuevoServicio.getContentPane().setBackground(Color.gray);
                    nuevoServicio.setVisible(true);
                    nuevoServicio.botonModificar.setVisible(true);
                    nuevoServicio.jButton2.setVisible(false);
                    nuevoServicio.texts(nombre, costo, unidad, cantidadUnidad, descripcion, combo);
                    nuevoServicio.nuevo =nuevo;
                    this.setVisible(false);
//                    this.botonModificar.setVisible(true);
//                    this.jButton2.setVisible(false);
//                    this.jButton4.setVisible(true);

                }

                if (boton.getName().equals("e")) {
                    System.out.println("Click Boton Eliminar" + row + column);
                    servicio nuevo = new servicio();
                    nuevo.nombre = jtblListaServicios.getValueAt(row, 0).toString();
                    nuevo.descripcion = jtblListaServicios.getValueAt(row, 1).toString();
                    nuevo.unidad = jtblListaServicios.getValueAt(row, 2).toString();
                    nuevo.costo = Integer.parseInt(jtblListaServicios.getValueAt(row, 3).toString());

                    if (JOptionPane.showConfirmDialog(rootPane, "Se eliminará el registro, ¿desea continuar?",
                            "Eliminar Registro", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        try {
                            this.principal.controlServicio.eliminarServicio(nuevo);
                        } catch (Exception ex) {
                            Logger.getLogger(nuevoCliente.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        actualizar();
                        try {
                            this.principal.rVentaServicio.llenarCombos();
                        } catch (Exception ex) {
                            Logger.getLogger(nuevoCliente.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    prueba = false;
                }
            }
            if (prueba) {
                texts(evt);
            }
        }
        prueba = true;
    }//GEN-LAST:event_jtblListaServiciosMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        actualizar();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        nuevoServicio = new nuevoServicio(principal);
        nuevoServicio.setVisible(true);
        nuevoServicio.botonModificar.setVisible(false);

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        generarReportes rep = new generarReportes();
        rep.reporteServicios(principal);
    }//GEN-LAST:event_jButton3ActionPerformed

    public void texts(java.awt.event.MouseEvent evt) {

//        this.jTextField1.setText(nombre);
//        this.jTextField2.setText(costo);
//        this.jTextField3.setText(unidad);
//        this.jTextField4.setText(cantidadUnidad);
//        this.jTextArea1.setText(descripcion);
//        if (jtblListaServicios.getValueAt(clickTabla, 4).toString().equals("Dia")) {
//            this.jComboBox1.setSelectedIndex(1);
//        } else if (jtblListaServicios.getValueAt(clickTabla, 4).toString().equals("Semana")) {
//            this.jComboBox1.setSelectedIndex(2);
//        } else {
//            this.jComboBox1.setSelectedIndex(3);
//        }
    }

    public void vaciarCampos() {
//        jTextField1.setText("");
//        jTextArea1.setText("");
//        jTextField3.setText("");
//        jTextField2.setText("");
//        jTextField4.setText("");
//        jComboBox1.setSelectedIndex(0);
    }
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jtblListaServicios;
    // End of variables declaration//GEN-END:variables
}
