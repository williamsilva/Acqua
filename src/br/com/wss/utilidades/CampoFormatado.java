/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wss.utilidades;

import java.text.DecimalFormat;
import java.text.ParseException;
import javax.swing.JFormattedTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;

/**
 *
 * @author William
 */
public class CampoFormatado {
    
        public static JFormattedTextField getFormatado(String formato) {  
        JFormattedTextField campoFormatado = null;  
        MaskFormatter format = new MaskFormatter();  
             
        format.setPlaceholderCharacter('_');  
        format.setValueContainsLiteralCharacters(false);  
          
        try {  
            format.setMask(formato);  
            campoFormatado = new JFormattedTextField(format);  
        } catch (ParseException ex) {  
            ex.printStackTrace();  
        }  
        return campoFormatado;  
    }  
  
    public static JFormattedTextField getTelefone() {  
        return getFormatado("(##) ####-####");  
    }  
      
    public static JFormattedTextField getCNPJ() {  
        return getFormatado("##.###.###/####-##");  
    }
    public static void setCampovalor(JFormattedTextField textField){
        DecimalFormat dFormat = new DecimalFormat("#,###,###.00") ;
        NumberFormatter formatter = new NumberFormatter(dFormat) ;
        formatter.setFormat(dFormat) ;
        formatter.setAllowsInvalid(false) ;
        
         textField = new JFormattedTextField ( ) ;
        textField.setFormatterFactory ( new DefaultFormatterFactory ( formatter ) ) ;
    }
}  
    
