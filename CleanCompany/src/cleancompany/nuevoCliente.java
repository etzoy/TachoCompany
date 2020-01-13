/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cleancompany;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import modelo.cliente;
import modelo.modeloTablaCliente;

/**
 *
 * @author etzoy
 */
public class nuevoCliente extends javax.swing.JFrame {

    cleanCompany principal = null;
    modeloTablaCliente mtc = new modeloTablaCliente();

    int clickTabla = 0;
    cliente nuevo = new cliente();

    /**
     * Creates new form registroCliente
     */
    public nuevoCliente(cleanCompany principalOrigen) {

        this.principal = principalOrigen;
        initComponents();
        this.getContentPane().setBackground(Color.BLACK);
        this.setLocationRelativeTo(null);
        this.setTitle("Nuevo Cliente");
//        this.botonModificar.setVisible(false);
        //this.jButton2.setVisible(false);
        //this.jtblListaClientes.setModel(mtc);
//        try {
//            mtc.visualizarTabla(this.jtblListaClientes, principal);
//        } catch (Exception ex) {
//            Logger.getLogger(nuevoCliente.class.getName()).log(Level.SEVERE, null, ex);
//        }

        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                visiblePrincipal();
            }
        });
    }

    public void visiblePrincipal() {
        this.principal.rCliente.setVisible(true);
        this.botonModificar.setVisible(false);
        this.getContentPane().setBackground(Color.BLACK);
        vaciarCampos();
    }

    public void vaciarCampos() {
        jTextField1.setText("");
        jTextArea1.setText("");
        jTextField3.setText("");
        jFormattedTextField1.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        botonModificar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setSize(new java.awt.Dimension(400, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Cancelar");
        jButton4.setToolTipText("Cancelar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 440, -1, 30));

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Crear");
        jButton5.setToolTipText("Crea un nuevo cliente");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 440, 86, 30));

        botonModificar.setBackground(new java.awt.Color(255, 255, 255));
        botonModificar.setText("Modificar");
        botonModificar.setToolTipText("Modifica el registro seleccionado");
        botonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonModificarActionPerformed(evt);
            }
        });
        getContentPane().add(botonModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 440, -1, 30));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Limpiar");
        jButton1.setToolTipText("Limpia los campos ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 440, -1, 30));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nombre:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

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
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 272, -1));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Descripcion:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 284, 62));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("telefono");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, -1));

        try {
            jFormattedTextField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("+1(###)###-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(jFormattedTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, 270, -1));

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Direccion:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, -1, -1));
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 260, 271, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/clientes.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 290, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        cliente nuevo = new cliente();
        nuevo.nombre = jTextField1.getText();
        nuevo.descripcion = jTextArea1.getText();
        nuevo.direccion = jTextField3.getText();
        nuevo.telefono = jFormattedTextField1.getText();

        if (!jTextField1.getText().equals("")) {
            if (!jFormattedTextField1.getText().equals("")) {
                this.principal.controlCliente.insertCliente2(nuevo);
                vaciarCampos();
                JOptionPane.showMessageDialog(null, "Cliente creado con exito.", "Exito!", JOptionPane.INFORMATION_MESSAGE);
                //actualizar();

                try {
                    this.principal.rVentaServicio.llenarCombos();
                } catch (Exception ex) {
                    Logger.getLogger(nuevoCliente.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "El campo 'telefono' no puede quedar vacio.", "Error!", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "El campo 'nombre' no puede quedar vacio.", "Error!", JOptionPane.WARNING_MESSAGE);
        }
//this.setVisible(false);
// TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

//    public void actualizar() {
//        try {
//            mtc.visualizarTabla(this.jtblListaClientes, principal);
//            //mtc.fireTableDataChanged();
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(this, "Error en la actualizacion de la base de datos");
//        }
//    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.getContentPane().setBackground(Color.BLACK);
        this.setVisible(false);        // TODO add your handling code here:
        this.principal.rCliente.setVisible(true);
        this.botonModificar.setVisible(false);
        vaciarCampos();

    }//GEN-LAST:event_jButton4ActionPerformed

    public void texts(String nombre, String descripcion,String telefono,String direccion) {

       

        this.jTextField1.setText(nombre);
        this.jFormattedTextField1.setText(telefono);
        this.jTextField3.setText(direccion);
        this.jTextArea1.setText(descripcion);
    }
    private void botonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonModificarActionPerformed
        // TODO add your handling code here:
        System.out.println("Boton Modificar");
        cliente update = new cliente();
        update.nombre = jTextField1.getText();
        update.descripcion = jTextArea1.getText();
        update.direccion = jTextField3.getText();
        update.telefono = jFormattedTextField1.getText();
        if (!jTextField1.getText().equals("")) {
            if (!jFormattedTextField1.getText().equals("")) {
                this.principal.controlCliente.actualizarCliente(nuevo, update);
                JOptionPane.showMessageDialog(null, "Se actualizo el registro con exito.", "Exito!", JOptionPane.INFORMATION_MESSAGE);
            
                //actualizar();
                try {
                    this.principal.rVentaServicio.llenarCombos();
                } catch (Exception ex) {
                    Logger.getLogger(nuevoCliente.class.getName()).log(Level.SEVERE, null, ex);
                }

                this.nuevo = null;
                
            } else {
                JOptionPane.showMessageDialog(null, "El campo 'telefono' no puede quedar vacio.", "Error!", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "El campo 'nombre' no puede quedar vacio.", "Error!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_botonModificarActionPerformed

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        // TODO add your handling code here:
        char validar = evt.getKeyChar();

        if (evt.getKeyChar() >= 33 && evt.getKeyChar() <= 64
                || evt.getKeyChar() >= 91 && evt.getKeyChar() <= 96
                || evt.getKeyChar() >= 123 && evt.getKeyChar() <= 208
                || evt.getKeyChar() >= 210 && evt.getKeyChar() <= 240
                || evt.getKeyChar() >= 242 && evt.getKeyChar() <= 255) {
            getToolkit().beep();
            evt.consume();
        }
//        if (Character.isDigit(validar)) {
//            getToolkit().beep();
//            evt.consume();
//        }
    }//GEN-LAST:event_jTextField1KeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        jTextField1.setText("");
        jTextArea1.setText("");
        jTextField3.setText("");
        jFormattedTextField1.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton botonModificar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    public javax.swing.JButton jButton5;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}