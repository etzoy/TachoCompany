/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.awt.Color;
import java.awt.Component;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author LENOVO
 */
public class renderAlertas extends DefaultTableCellRenderer {
    private Component componente;
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, 
            boolean isSelected, boolean hasFocus, int row, int column) {
        
        if(value instanceof JButton){
            JButton btn = (JButton)value;
            if(isSelected){
                btn.setForeground(table.getSelectionForeground());
                btn.setBackground(table.getSelectionBackground());
            }else{
                btn.setForeground(table.getForeground());
                btn.setBackground(UIManager.getColor("Button.background"));
            }
            return btn;
        }
        int dif = difMes(table.getValueAt(row, 7).toString());
        if (dif<=1) {
            setBackground(Color.red);
        }else if (dif <=3) {
            setBackground(Color.orange);
        }else if (dif <= 5) {
            setBackground(Color.yellow);
        }else if (dif >=6) {
            setBackground(Color.green);
        }
        
//        if (row <= 2) {
//            setBackground(Color.red);
//        }else if (row <=6) {
//            setBackground(Color.orange);
//        }else if (row <= 9) {
//            setBackground(Color.yellow);
//        }else if (row <= 12) {
//            setBackground(Color.green);
//        }
        
        return super.getTableCellRendererComponent(table, value, isSelected, 
                hasFocus, row, column); //To change body of generated methods, choose Tools | Templates.
    }
    
    public int difMes(String comparacion){
        int difA=0;
        int difM=0;
        try {
            Date f = new Date();
            SimpleDateFormat formato =new SimpleDateFormat("yyyy-mm-dd");
            
            Calendar inicio = new GregorianCalendar();
            Calendar fin = new GregorianCalendar();
            inicio.setTime(new SimpleDateFormat("yyyy-mmm-dd").parse(formato.format(f)));
            
            fin.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(comparacion));
           
             difA = fin.get(Calendar.YEAR) - inicio.get(Calendar.YEAR);
             difM = difA * 12 + fin.get(Calendar.MONTH) - inicio.get(Calendar.MONTH);
            System.out.println(difM);
        } catch(ParseException ex) {

        }
        return difM;
    }
}
