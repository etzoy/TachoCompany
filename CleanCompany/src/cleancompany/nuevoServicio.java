/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cleancompany;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import modelo.cliente;
import modelo.modeloTablaServicio;
import modelo.servicio;
import modelo.tiempo;

/**
 *
 * @author etzoy
 */
public class nuevoServicio extends javax.swing.JFrame {
    
    cleanCompany principal = null;
    modeloTablaServicio mts = new modeloTablaServicio();
    
    int clickTabla;
    servicio nuevo = new servicio();
    tiempo tiempo;
    registroServicio anterior;

    /**
     * Creates new form catalogoServicio
     */
    public nuevoServicio(cleanCompany principalOrigen, registroServicio anterior) {
        this.principal = principalOrigen;
        initComponents();
        this.getContentPane().setBackground(Color.BLACK);
        this.setLocationRelativeTo(null);
        this.setTitle("Registro de Servicios");
        this.botonModificar.setVisible(false);
        this.anterior=anterior;
        // this.jButton4.setVisible(false);
        llenarCombo();

//        try {
//            mts.visualizarTabla(this.jtblListaServicios, principal);
//        } catch (Exception ex) {
//            Logger.getLogger(registroServicio.class.getName()).log(Level.SEVERE, null, ex);
//        }
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                visiblePrincipal();
            }
        });
    }
    
    public void visiblePrincipal() {
        this.principal.rServicio.setVisible(true);
        this.botonModificar.setVisible(false);
        this.getContentPane().setBackground(Color.BLACK);
        vaciarCampos();
    }

    public void llenarCombo() {
        
        tiempo = new tiempo();
        List<tiempo> list = this.principal.controlTiempo.listaTiempo();
        
        if (list != null && !list.isEmpty()) {
            if (list.size() > 0) {
                this.jComboBox1.addItem("Tipo Unidad");
                for (int i = 0; i < list.size(); i++) {
                    
                    tiempo = list.get(i);
                    this.jComboBox1.addItem(tiempo.nombre);
                    
                }
                
            }
        }
    }
    
    public void actualizar() {
//        try {
//            mts.visualizarTabla(this.jtblListaServicios, principal);
//            //mtc.fireTableDataChanged();
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(this, "Error en la actualizacion de la base de datos");
//        }
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
        jTextField3 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jTextField4 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        botonModificar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
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

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField3KeyTyped(evt);
            }
        });
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 271, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Seccion Mantenimiento:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, -1, -1));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Tipo de unidades");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, -1, -1));
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 310, 271, -1));

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField4KeyTyped(evt);
            }
        });
        getContentPane().add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 350, 266, -1));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Cantidad de unides");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Costo de servicio:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Servicio Nuevo");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, -1, -1));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 272, -1));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nombre:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, -1, -1));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Descripcion:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 284, 62));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Valor por unidad:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, -1, -1));

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField2KeyTyped(evt);
            }
        });
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 271, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Unidad:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, -1, -1));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Cancelar");
        jButton1.setToolTipText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 550, -1, 30));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Crear");
        jButton2.setToolTipText("Crea un nuevo servicio");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 550, 80, 30));

        botonModificar.setBackground(new java.awt.Color(255, 255, 255));
        botonModificar.setText("Modificar");
        botonModificar.setToolTipText("Modifica el  registro seleccionado");
        botonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonModificarActionPerformed(evt);
            }
        });
        getContentPane().add(botonModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 550, -1, 30));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/servicios1.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 410, -1, -1));

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Limpiar");
        jButton3.setToolTipText("Limpia los campos");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 550, -1, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.getContentPane().setBackground(Color.BLACK);
        this.setVisible(false);        // TODO add your handling code here:
        if (this.anterior != null) {
            this.principal.rServicio.setVisible(true);
        }else{
            this.principal.rVentaServicio.setVisible(true);
        }
        this.botonModificar.setVisible(false);
        vaciarCampos();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
//this.setVisible(false);
        servicio nuevo = new servicio();
        
        nuevo.nombre = jTextField1.getText();
        nuevo.descripcion = jTextArea1.getText();
        nuevo.unidad = jTextField3.getText();
        
        if (!this.jTextField1.getText().equals("")) {
            if (!this.jTextField2.getText().equals("")) {
                nuevo.costo = Integer.parseInt(jTextField2.getText());
                if (!this.jTextField4.getText().equals("")) {
                    nuevo.cantidadUnidad = Integer.parseInt(jTextField4.getText().trim());
                    
                    if (this.jComboBox1.getSelectedIndex() != 0) {
                        nuevo.tipoUnidad = this.jComboBox1.getSelectedIndex();
                        this.principal.controlServicio.insertServicio(nuevo);
                        
                        vaciarCampos();
                        actualizar();
                        this.principal.rVentaServicio.llenarCombos();
                        JOptionPane.showMessageDialog(null, "Servicio creado con exito.", "Exito!", JOptionPane.INFORMATION_MESSAGE);
                        
                    } else {
                        JOptionPane.showMessageDialog(null, "Debe seleccionar un tipo de unidad.", "Error!", JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "El campo 'Cantidad de Unidades' no puede quedarvacio.", "Error!", JOptionPane.WARNING_MESSAGE);
                }
                
            } else {
                JOptionPane.showMessageDialog(null, "El campo 'Costo' no puede quedar vacio.", "Error!", JOptionPane.WARNING_MESSAGE);
            }
            
        } else {
            JOptionPane.showMessageDialog(null, "El campo 'Nombre' no puede quedar vacio.", "Error!", JOptionPane.WARNING_MESSAGE);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyTyped
        // TODO add your handling code here:
        char valid = evt.getKeyChar();
        
        if (Character.isLetter(valid) || valid == 32) {
            getToolkit().beep();
            evt.consume();

            //JOptionPane.showMessageDialog(this, "Ingresar Solo Numeros");
        }
    }//GEN-LAST:event_jTextField2KeyTyped

    private void jTextField4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyTyped
        // TODO add your handling code here:
        char valid = evt.getKeyChar();
        
        if (Character.isLetter(valid) || valid == 32) {
            getToolkit().beep();
            evt.consume();

            //JOptionPane.showMessageDialog(this, "Ingresar Solo Numeros");
        }

    }//GEN-LAST:event_jTextField4KeyTyped
    
    public void texts(String nombre, String costo, String unidad, String cantidadUnidad, String descripcion, int combo) {
        
        this.jTextField1.setText(nombre);
        this.jTextField2.setText(costo);
        this.jTextField3.setText(unidad);
        this.jTextField4.setText(cantidadUnidad);
        this.jTextArea1.setText(descripcion);
        
        this.jComboBox1.setSelectedIndex(combo);
        
    }
    
    public void vaciarCampos() {
        jTextField1.setText("");
        jTextArea1.setText("");
        jTextField3.setText("");
        jTextField2.setText("");
        jTextField4.setText("");
        jComboBox1.setSelectedIndex(0);
    }
    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void botonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonModificarActionPerformed
        // TODO add your handling code here:

        servicio update = new servicio();
        update.nombre = jTextField1.getText();
        update.descripcion = jTextArea1.getText();
        update.unidad = jTextField3.getText();
        update.costo = Integer.parseInt(jTextField2.getText());
        if (this.jComboBox1.getSelectedIndex() != 0) {
            update.tipoUnidad = this.jComboBox1.getSelectedIndex();
        }
        update.cantidadUnidad = Integer.parseInt(jTextField4.getText());
        
        this.principal.controlServicio.actualizarServicio(nuevo, update);
        JOptionPane.showMessageDialog(null, "Servicio actualizado con exito.", "Exito!", JOptionPane.INFORMATION_MESSAGE);
        
        actualizar();
        try {
            this.principal.rVentaServicio.llenarCombos();
        } catch (Exception ex) {
            Logger.getLogger(nuevoCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.nuevo = null;
        this.setVisible(false);
        this.principal.rServicio.setVisible(true);
        //this.botonModificar.setVisible(false);
    }//GEN-LAST:event_botonModificarActionPerformed

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        // TODO add your handling code here:

        if (evt.getKeyChar() >= 33 && evt.getKeyChar() <= 47
                || evt.getKeyChar() >= 58 && evt.getKeyChar() <= 64
                || evt.getKeyChar() >= 91 && evt.getKeyChar() <= 96
                || evt.getKeyChar() >= 123 && evt.getKeyChar() <= 208
                || evt.getKeyChar() >= 210 && evt.getKeyChar() <= 240
                || evt.getKeyChar() >= 242 && evt.getKeyChar() <= 255) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1KeyTyped

    private void jTextField3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyTyped
        // TODO add your handling code here:
        if (evt.getKeyChar() >= 33 && evt.getKeyChar() <= 64
                || evt.getKeyChar() >= 91 && evt.getKeyChar() <= 96
                || evt.getKeyChar() >= 123 && evt.getKeyChar() <= 208
                || evt.getKeyChar() >= 210 && evt.getKeyChar() <= 240
                || evt.getKeyChar() >= 242 && evt.getKeyChar() <= 255) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_jTextField3KeyTyped

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        vaciarCampos();
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton botonModificar;
    private javax.swing.JButton jButton1;
    public javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
