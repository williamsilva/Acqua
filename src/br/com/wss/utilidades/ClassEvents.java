/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wss.utilidades;

import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author William
 */
public class ClassEvents {

    /**
     *
     * @param label
     * @param text
     */
    public static void focusLostTextField(JLabel label, JTextField text) {
        if (!text.getText().equals("")) {
            label.setForeground(Color.BLACK);
        } else {
            label.setForeground(Color.red);
        }
    }
    
    /**
     *
     * @param label
     * @param combo
     */
    public static void focusLostCombobox(JLabel label, JComboBox combo) {
        if (combo.getSelectedIndex() != 0) {
            label.setForeground(Color.BLACK);
        } else {
            label.setForeground(Color.red);
        }
    }

}
