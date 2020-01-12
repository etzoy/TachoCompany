/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cleancompany;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author LENOVO
 */
public class mascara extends PlainDocument{

  public void insertString(int arg0, String arg1, AttributeSet arg2) 
    throws BadLocationException
   {
       /* Verificamos si la entrada es un número */
       if(Character.isDigit(arg1.charAt(0)))
       {

          switch(arg0)
          {
              /* si está vacía insertamos el (  */
              case 1: 
                   super.insertString(arg0,"("+ arg1, arg2);
                   break;
              case 5: 
                   super.insertString(arg0, ") "+arg1, arg2);
                   break;
              case 10:
                   super.insertString(arg0, "-"+arg1, arg2);
                   break;
              case 16:/* si es 13 entonces no permitimos que sea ingresado el valor*/
                   return;
              default:
                  super.insertString(arg0, arg1, arg2);
          }

       }

   }

}
