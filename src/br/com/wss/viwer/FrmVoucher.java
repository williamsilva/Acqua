/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wss.viwer;

import java.awt.event.KeyEvent;
import java.util.Date;
import javax.swing.JTextField;

/**
 *
 * @author William
 */
public class FrmVoucher extends javax.swing.JInternalFrame {

    /**
     * Creates new form FrmVoucher
     */
    public FrmVoucher() {
        initComponents();
        jPanelVoucher.setVisible(false);
        jDateChooser1.setDate(new Date());
        jDateChooser1.setEnabled(false);
        jDateChooser1.getCalendarButton().setEnabled(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanelVoucher = new javax.swing.JPanel();
        jLabelNumeroControle = new javax.swing.JLabel();
        jTextFieldNumeroControle = new javax.swing.JTextField();
        jTextFieldNumeroControle1 = new javax.swing.JTextField();
        jLabelNumeroControle1 = new javax.swing.JLabel();
        jLabelNumeroControle2 = new javax.swing.JLabel();
        jLabelNumeroControle3 = new javax.swing.JLabel();
        jTextFieldNumeroControle3 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabelNumeroControle4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabelNumeroControle5 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jLabelNumeroControle6 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox();
        jLabelNumeroControle7 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox();
        jButtonNovo = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setClosable(true);
        setIconifiable(true);
        setTitle("Voucher");

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

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
        );
        jDesktopPane1.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jPanelVoucher.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Voucher"));
        jPanelVoucher.setLayout(null);

        jLabelNumeroControle.setText("Grupo:");
        jPanelVoucher.add(jLabelNumeroControle);
        jLabelNumeroControle.setBounds(10, 20, 110, 20);

        jTextFieldNumeroControle.setText("jTextField1");
        jTextFieldNumeroControle.setSelectionEnd(0);
        jTextFieldNumeroControle.setSelectionStart(0);
        jPanelVoucher.add(jTextFieldNumeroControle);
        jTextFieldNumeroControle.setBounds(130, 20, 190, 26);

        jTextFieldNumeroControle1.setText("jTextField1");
        jTextFieldNumeroControle1.setSelectionEnd(0);
        jTextFieldNumeroControle1.setSelectionStart(0);
        jPanelVoucher.add(jTextFieldNumeroControle1);
        jTextFieldNumeroControle1.setBounds(130, 50, 190, 26);

        jLabelNumeroControle1.setText("Responsável:");
        jPanelVoucher.add(jLabelNumeroControle1);
        jLabelNumeroControle1.setBounds(10, 50, 110, 20);

        jLabelNumeroControle2.setText("Data Visita:");
        jPanelVoucher.add(jLabelNumeroControle2);
        jLabelNumeroControle2.setBounds(10, 80, 110, 20);

        jLabelNumeroControle3.setText("Voucher N°:");
        jPanelVoucher.add(jLabelNumeroControle3);
        jLabelNumeroControle3.setBounds(10, 110, 110, 20);

        jTextFieldNumeroControle3.setText("jTextField1");
        jTextFieldNumeroControle3.setSelectionEnd(0);
        jTextFieldNumeroControle3.setSelectionStart(0);
        jPanelVoucher.add(jTextFieldNumeroControle3);
        jTextFieldNumeroControle3.setBounds(130, 110, 190, 26);

        jButton1.setText("jButton1");
        jPanelVoucher.add(jButton1);
        jButton1.setBounds(130, 260, 73, 23);

        jButton2.setText("jButton2");
        jPanelVoucher.add(jButton2);
        jButton2.setBounds(250, 260, 73, 23);
        jPanelVoucher.add(jDateChooser1);
        jDateChooser1.setBounds(130, 80, 190, 26);

        jLabelNumeroControle4.setText("Produto 01");
        jPanelVoucher.add(jLabelNumeroControle4);
        jLabelNumeroControle4.setBounds(350, 20, 110, 20);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanelVoucher.add(jComboBox1);
        jComboBox1.setBounds(480, 20, 150, 26);

        jLabelNumeroControle5.setText("Grupo:");
        jPanelVoucher.add(jLabelNumeroControle5);
        jLabelNumeroControle5.setBounds(350, 50, 110, 20);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanelVoucher.add(jComboBox2);
        jComboBox2.setBounds(480, 50, 150, 26);

        jLabelNumeroControle6.setText("Grupo:");
        jPanelVoucher.add(jLabelNumeroControle6);
        jLabelNumeroControle6.setBounds(350, 80, 110, 20);

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanelVoucher.add(jComboBox3);
        jComboBox3.setBounds(480, 80, 150, 26);

        jLabelNumeroControle7.setText("Grupo:");
        jPanelVoucher.add(jLabelNumeroControle7);
        jLabelNumeroControle7.setBounds(350, 110, 110, 20);

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanelVoucher.add(jComboBox4);
        jComboBox4.setBounds(480, 110, 150, 26);

        jButtonNovo.setText("Novo");
        jButtonNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoActionPerformed(evt);
            }
        });

        jButtonExcluir.setText("Excluir");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jButtonExcluir)
                .addGap(540, 723, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, 697, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonNovo, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonExcluir, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addComponent(jPanelVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoActionPerformed
        jPanelVoucher.setVisible(true);
        jButtonExcluir.setEnabled(false);
        jButtonNovo.setEnabled(false);
    }//GEN-LAST:event_jButtonNovoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonNovo;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox4;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabelNumeroControle;
    private javax.swing.JLabel jLabelNumeroControle1;
    private javax.swing.JLabel jLabelNumeroControle2;
    private javax.swing.JLabel jLabelNumeroControle3;
    private javax.swing.JLabel jLabelNumeroControle4;
    private javax.swing.JLabel jLabelNumeroControle5;
    private javax.swing.JLabel jLabelNumeroControle6;
    private javax.swing.JLabel jLabelNumeroControle7;
    private javax.swing.JPanel jPanelVoucher;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldNumeroControle;
    private javax.swing.JTextField jTextFieldNumeroControle1;
    private javax.swing.JTextField jTextFieldNumeroControle3;
    // End of variables declaration//GEN-END:variables

}
