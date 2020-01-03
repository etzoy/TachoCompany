/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

//imports
import java.util.List;
import javax.swing.table.AbstractTableModel;

        
public class modeloTablaCliente extends AbstractTableModel{
    
   private cliente cliente;
   private List<cliente> listaClientes;
   
   public cliente getCliente(){
       return cliente;
   }
   
   public void setCliente(cliente cliente){
       this.cliente = cliente;
   }
   
   public List<cliente> getListClientes(){
       return listaClientes;
   }
   
   public void setListaClientes(List<cliente> listaClientes){
       this.listaClientes = listaClientes;
   }
   
   @Override
   public int getRowCount(){
       int filas = 0;
       if (this.listaClientes != null) {
            filas = this.listaClientes.size();
        }
        return filas;
   }
   
   @Override
   public String getColumnName(int col){
       String nombreColumna = null;

        switch (col) {
            case 0:
                nombreColumna = "Nombres";
                break;
            case 1:
                nombreColumna = "Descripciones";
                break;
            case 2:
                nombreColumna = "Telefonos";
                break;
            case 3:
                nombreColumna = "Direcciones";
                break;
                      
        }
        return nombreColumna;
   }
   
   @Override
    public int getColumnCount() {
        return 4;
    }
    
     @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        cliente cli;
        Object valor = "";
        if (this.listaClientes != null) {
            cli = this.listaClientes.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    valor = cli.nombre;
                    break;
                case 1:
                    valor = cli.descripcion;
                    break;
                case 2:
                    valor = cli.telefono;
                    break;
                case 3:
                    valor = cli.direccion;
                    break;
              
            }
        }
        return valor;
    }
}
