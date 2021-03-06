/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cleancompany;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.text.InternationalFormatter;
import modelo.cliente;
import modelo.modeloTablaRegistroServicio;
import modelo.servicio;
import modelo.regVentaServicio;
import modelo.tiempo;

/**
 *
 * @author etzoy
 */
public class modVentaServicio extends javax.swing.JFrame {

    cleanCompany principal = null;
    regVentaServicio actual = null;
    String nombreCliente = null;
    String nombreServicio = null;
    JTable tabla = null;
    cliente cliente;
    servicio servicio;
    tiempo tiempo;
    int clickTabla = 0;
    modeloTablaRegistroServicio mts = new modeloTablaRegistroServicio();

    /**
     * Creates new form registroVentaServicio
     */
    public modVentaServicio(cleanCompany principalOrigen, regVentaServicio actual, String nombreCliente, String nombreServicio, JTable tabla) {
        this.principal = principalOrigen;
        this.actual = actual;
        this.nombreCliente = nombreCliente;
        this.nombreServicio = nombreServicio;
        this.tabla = tabla;
        initComponents();
        this.getContentPane().setBackground(Color.BLACK);
        this.setLocationRelativeTo(null);
        this.setTitle("Modificacion de Venta");
        this.setIconImage(new ImageIcon(getClass().getResource("/Img/LogoApp.png")).getImage());
        llenarCombos();
//        try {
//            mts.visualizarTabla(this.jtblRegistros, principal);
//        } catch (Exception ex) {
//            Logger.getLogger(registroServicio.class.getName()).log(Level.SEVERE, null, ex);
//        }

        texts();
//        this.jFormattedTextField3.setFormatterFactory(new JFormattedTextField.AbstractFormatterFactory() {
//
//        @Override
//        public JFormattedTextField.AbstractFormatter getFormatter(JFormattedTextField tf) {
//             
//            DecimalFormat format = new DecimalFormat("#.00");
//            format.setMinimumFractionDigits(2);
//            format.setMaximumFractionDigits(2);
//            format.setRoundingMode(RoundingMode.HALF_UP);
//            InternationalFormatter formatter = new InternationalFormatter(format);
//            formatter.setAllowsInvalid(false);
//            formatter.setMinimum(0.0);
//            formatter.setMaximum(1000.00);
//            return formatter;
//        }
//    });
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                visiblePrincipal();
            }
        });
    }

    public void visiblePrincipal() {
        this.principal.agenda.setVisible(true);
        vaciarCampos();
    }

    public void texts() {

        String unidad = this.actual.unidad;
        String costo = Double.toString(this.actual.costo);
        String cantidadUnidades = Integer.toString(this.actual.cantidadUnidad);

        this.jComboBox1.setSelectedIndex(busquedaClient(this.nombreCliente));
        this.jComboBox2.setSelectedIndex(busquedaServ(this.nombreServicio));

//        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
//        Date fechaDate = null;
////        try {
//            fechaDate = formato.parse(this.jtblRegistros.getValueAt(clickTabla, 6).toString());
//        } catch (ParseException ex) {
//            System.out.println(ex);
//        }
        this.jTextField5.setText(unidad);
        this.jFormattedTextField3.setText(costo);
        this.jTextField7.setText(cantidadUnidades);
        this.jFormattedTextField1.setText(actual.horaInicio.toString());
        this.jFormattedTextField2.setText(actual.horaFin.toString());

        this.jComboBox4.setSelectedIndex(this.actual.tipoUnidad);

        this.rSDateChooser1.setDatoFecha(actual.fecha);
        if (this.actual.darleSeguimiento) {
            this.jCheckBox1.setSelected(true);
        } else {
            this.jCheckBox1.setSelected(false);
        }

    }

    public int busquedaClient(String cliente) {
        int index = 0;
        int count = this.jComboBox1.getItemCount();
        for (int i = 0; i <= count; i++) {
            if (this.jComboBox1.getItemAt(i).toString().equals(cliente)) {
                index = i;
                break;
            }
        }

        return index;
    }

    public int busquedaServ(String servicio) {
        int index = 0;
        int count = this.jComboBox2.getItemCount();
        for (int i = 0; i <= count; i++) {
            if (this.jComboBox2.getItemAt(i).toString().equals(servicio)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public void llenarCombos() {
        cliente = new cliente();
        List<cliente> list = principal.controlCliente.listaClientesVigentes();
        removeCombos();
        if (list != null && !list.isEmpty()) {
            if (list.size() > 0) {
                for (int i = 0; i < list.size(); i++) {

                    cliente = list.get(i);
                    this.jComboBox1.addItem(cliente.nombre);

                }

            }
        }
        servicio = new servicio();
        List<servicio> list1 = principal.controlServicio.listaServiciosVigentes();
        if (list1 != null && !list1.isEmpty()) {
            if (list1.size() > 0) {
                for (int i = 0; i < list1.size(); i++) {
                    servicio = list1.get(i);
                    this.jComboBox2.addItem(servicio.nombre);
                }

            }
            tiempo = new tiempo();
            List<tiempo> list2 = this.principal.controlTiempo.listaTiempo();

            if (list2 != null && !list2.isEmpty()) {
                if (list2.size() > 0) {
                    this.jComboBox4.addItem("Tipo Unidad");
                    for (int i = 0; i < list2.size(); i++) {

                        tiempo = list2.get(i);
                        this.jComboBox4.addItem(tiempo.nombre);

                    }

                }
            }

        }
    }

    private void removeCombos() {
        this.jComboBox1.removeAllItems();
        this.jComboBox1.addItem("Seleccione un Cliente");
        this.jComboBox2.removeAllItems();
        this.jComboBox2.addItem("Seleccione un Servicio");
    }

    public void vaciarCampos() {
        this.jComboBox1.setSelectedIndex(0);
        this.jCheckBox1.setSelected(false);
        this.jComboBox2.setSelectedIndex(0);
        this.jComboBox4.setSelectedIndex(0);
        this.jFormattedTextField1.setText("");
        this.jFormattedTextField2.setText("");

        jTextField5.setText("");
        jFormattedTextField3.setText("");
        jTextField7.setText("");
        this.rSDateChooser1.setDatoFecha(null);
    }

    public void actualizar() {
        try {
            mts.visualizarTabla(this.tabla, principal);
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

        jTextField3 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox();
        jTextField2 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jButton2 = new javax.swing.JButton();
        jTextField5 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox();
        jTextField7 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        rSDateChooser1 = new rojeru_san.componentes.RSDateChooser();
        jLabel17 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel19 = new javax.swing.JLabel();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jLabel20 = new javax.swing.JLabel();
        jFormattedTextField2 = new javax.swing.JFormattedTextField();
        jFormattedTextField3 = new javax.swing.JFormattedTextField();

        jLabel6.setText("Seccion Mantenimiento:");

        jLabel7.setText("Tipo de unidades");

        jLabel3.setText("Valor por unidad:");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jLabel8.setText("Cantidad de unides");

        jLabel5.setText("Unidad:");

        jLabel9.setText("Costo de servicio:");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Cliente:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione un Cliente" }));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Nuevo");
        jButton1.setToolTipText("Crea un nuevo cliente");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Servicio:");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione un Servicio" }));
        jComboBox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox2ItemStateChanged(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Nuevo");
        jButton2.setToolTipText("Crea un nuevo servicio");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField5KeyTyped(evt);
            }
        });

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Seccion Mantenimiento:");

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Tipo de unidades");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Valor por unidad:");

        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });
        jTextField7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField7KeyTyped(evt);
            }
        });

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Cantidad de unides");

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Unidad:");

        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Costo de servicio:");

        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Seccion finalizacion de Trabajo:");

        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Fecha finalizacion");

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/eliminar (3).png"))); // NOI18N
        jButton4.setText("Regresar");
        jButton4.setToolTipText("Regresa ");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/actualizar.png"))); // NOI18N
        jButton5.setText("Modificar");
        jButton5.setToolTipText("Modifica el registro seleccionado");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Darle Seguimiento");

        jCheckBox1.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setText("Si / No");

        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Hora inicio");

        try {
            jFormattedTextField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Hora finalizacion");

        try {
            jFormattedTextField2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jFormattedTextField3.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("####0.##"))));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel2))
                                        .addGap(29, 29, 29)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jComboBox2, 0, 320, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jButton1)
                                            .addComponent(jButton2)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(63, 63, 63)
                                        .addComponent(jLabel13))
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jFormattedTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel10)
                            .addComponent(jLabel15)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton4)
                                        .addGap(85, 85, 85)
                                        .addComponent(jButton5))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rSDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel19)
                        .addGap(18, 18, 18)
                        .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jLabel20)
                        .addGap(28, 28, 28)
                        .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jLabel17)
                        .addGap(61, 61, 61)
                        .addComponent(jCheckBox1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2)))
                .addGap(38, 38, 38)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jFormattedTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addComponent(jLabel10)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(47, 47, 47)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(rSDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jCheckBox1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        //this.setVisible(false);
// TODO add your handling code here:
        regVentaServicio nuevo = new regVentaServicio();

        if (this.jComboBox1.getSelectedIndex() != 0) {
            if (this.jComboBox2.getSelectedIndex() != 0) {
                if (this.rSDateChooser1.getDatoFecha() != null) {
                    nuevo.idCliente = this.principal.controlRVentaServicio.getIdCliente(jComboBox1.getSelectedItem().toString());
                    nuevo.idServicio = this.principal.controlRVentaServicio.getIdServicio(jComboBox2.getSelectedItem().toString());
                    nuevo.unidad = this.jTextField5.getText();
                    nuevo.costo = Double.parseDouble(this.jFormattedTextField3.getText());
                    nuevo.tipoUnidad = this.jComboBox4.getSelectedIndex();
                    nuevo.cantidadUnidad = Integer.parseInt(this.jTextField7.getText());
                    java.sql.Date sqlDate = new java.sql.Date(this.rSDateChooser1.getDatoFecha().getTime());
                    nuevo.fecha = sqlDate;
                    nuevo.darleSeguimiento = this.jCheckBox1.isSelected();
                    try {
                        String horaInicio = jFormattedTextField1.getText() + ":00";
                        String[] times = horaInicio.split(":");
                        java.sql.Time time = new java.sql.Time(Integer.valueOf(times[0]), Integer.valueOf(times[1]), Integer.valueOf(times[2]));
                        nuevo.horaInicio = time;

                        String horaFin = jFormattedTextField2.getText() + ":00";
                        times = horaFin.split(":");
                        time = new java.sql.Time(Integer.valueOf(times[0]), Integer.valueOf(times[1]), Integer.valueOf(times[2]));

                        nuevo.horaFin = time;

                    } catch (Exception e) {
                    }

                    if (validarHora(jFormattedTextField1.getText()) && validarHora(jFormattedTextField2.getText())) {
                        try {
                            this.principal.controlRVentaServicio.actualizarRegistro(actual, nuevo);
                        } catch (SQLException ex) {
                            Logger.getLogger(modVentaServicio.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        this.principal.agenda.actualizar();
                        this.principal.alertas.actualizar();
                        JOptionPane.showMessageDialog(null, "Venta registrada con exito.", "Exito!", JOptionPane.INFORMATION_MESSAGE);

                        this.setVisible(false);
                        this.principal.agenda.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Debe ingresar una hora correcta.", "Error!", JOptionPane.WARNING_MESSAGE);

                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Debe seleccionar una Fecha.", "Error!", JOptionPane.WARNING_MESSAGE);

                }
            } else {
                JOptionPane.showMessageDialog(null, "Debe seleccionar un Servicio.", "Error!", JOptionPane.WARNING_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un Cliente.", "Error!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    public boolean validarHora(String hora) {
        boolean b;
        char[] a = hora.toString().toCharArray();
        String[] c = hora.split(":");
        if ((a[0] == ' ') || (a[1] == ' ') || (a[2] == ' ')
                || (a[3] == ' ') || (a[4] == ' ')
                || (getInteger(c[0]) > 24) || (getInteger(c[1]) > 59)) {
            b = false;
        } else {
            b = true;
        }
        return b;
    }

    public int getInteger(String valor) {
        int integer = Integer.parseInt(valor);
        return integer;
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
//        registroCliente rCliente = new registroCliente(principal);
        this.principal.rCliente.setVisible(true);
        this.setVisible(false);

        //llenarCombos();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        this.principal.rServicio.setVisible(true);
        this.setVisible(false);

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.dispose();
        this.principal.agenda.setVisible(true);
        vaciarCampos();
//        this.principal.setVisible(true);
// TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jComboBox2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox2ItemStateChanged
        // TODO add your handling code here:
        if (this.jComboBox2.getSelectedIndex() != 0) {
            String selec = (String) this.jComboBox2.getSelectedItem();
            if (selec != null) {
                if (!selec.equals("Seleccione un Servicio")) {
                    servicio nuevo = new servicio();
                    nuevo = this.principal.controlRVentaServicio.getServicio(selec);
                    seleccion(nuevo);
                }
            }
        } else {
            this.jTextField5.setText("");
            this.jFormattedTextField3.setText("");
            //this.jComboBox4.setSelectedIndex(0);
            this.jTextField7.setText("");
        }


    }//GEN-LAST:event_jComboBox2ItemStateChanged

    private void jTextField5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyTyped
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
    }//GEN-LAST:event_jTextField5KeyTyped

    private void jTextField7KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField7KeyTyped
        // TODO add your handling code here:
        char valid = evt.getKeyChar();
        if (Character.isLetter(valid) || evt.getKeyChar() >= 33 && evt.getKeyChar() <= 47
                || evt.getKeyChar() >= 58 && evt.getKeyChar() <= 96
                || evt.getKeyChar() >= 123 && evt.getKeyChar() <= 208
                || evt.getKeyChar() >= 210 && evt.getKeyChar() <= 240
                || evt.getKeyChar() >= 242 && evt.getKeyChar() <= 255) {
            getToolkit().beep();
            evt.consume();

            //JOptionPane.showMessageDialog(this, "Ingresar Solo Numeros");
        }
    }//GEN-LAST:event_jTextField7KeyTyped
    private void seleccion(servicio actual) {
        this.jTextField5.setText(actual.unidad);
        this.jFormattedTextField3.setText(Double.toString(actual.costo));
        this.jComboBox4.setSelectedIndex(actual.tipoUnidad);
        this.jTextField7.setText(String.valueOf(actual.cantidadUnidad));
    }

//    public void texts(java.awt.event.MouseEvent evt) {
//
//        clickTabla = this.jtblRegistros.rowAtPoint(evt.getPoint());
//        String unidad = this.jtblRegistros.getValueAt(clickTabla, 2).toString();
//        String costo = this.jtblRegistros.getValueAt(clickTabla, 3).toString();
//        String cantidadUnidades = this.jtblRegistros.getValueAt(clickTabla, 5).toString();
//        this.jComboBox1.setSelectedIndex(busquedaClient(this.jtblRegistros.getValueAt(clickTabla, 0).toString()));
//        this.jComboBox2.setSelectedIndex(busquedaServ(this.jtblRegistros.getValueAt(clickTabla, 1).toString()));
//
//        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
//        Date fechaDate = null;
//        try {
//            fechaDate = formato.parse(this.jtblRegistros.getValueAt(clickTabla, 6).toString());
//        } catch (ParseException ex) {
//            System.out.println(ex);
//        }
//
//        this.jTextField5.setText(unidad);
//        this.jTextField6.setText(costo);
//        this.jTextField7.setText(cantidadUnidades);
//
//        if (jtblRegistros.getValueAt(clickTabla, 4).toString().equals("Dia")) {
//            this.jComboBox4.setSelectedIndex(1);
//        } else if (jtblRegistros.getValueAt(clickTabla, 4).toString().equals("Semana")) {
//            this.jComboBox4.setSelectedIndex(2);
//        } else {
//            this.jComboBox4.setSelectedIndex(3);
//        }
//        this.rSDateChooser1.setDatoFecha(fechaDate);
//        if (this.jtblRegistros.getValueAt(clickTabla, 7).toString().equals("true")) {
//            this.jCheckBox1.setSelected(true);
//        } else {
//            this.jCheckBox1.setSelected(false);
//        }
//
//    }
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox4;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JFormattedTextField jFormattedTextField2;
    private javax.swing.JFormattedTextField jFormattedTextField3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField7;
    private rojeru_san.componentes.RSDateChooser rSDateChooser1;
    // End of variables declaration//GEN-END:variables
}
