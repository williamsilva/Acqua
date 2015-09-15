/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wss.viwer;

import br.com.wss.dao.ClientesDao;
import br.com.wss.dao.ProdutoDao;
import br.com.wss.utilidades.ClassEvents;
import br.com.wss.utilidades.NumeroMaximoCaracters;
import br.com.wss.utilidades.ValidaCPFCNPJ;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author William
 */
public class FrmVoucher extends javax.swing.JInternalFrame {
    
    int modificador = 1;
    ClientesDao clienteDao = new ClientesDao();
    ProdutoDao produtoDao = new  ProdutoDao();

    /**
     * Creates new form FrmVoucher
     */
    public FrmVoucher() {
        initComponents();
        comboProduto();
        validaCampos();
        jTextFieldIdVoucher.setVisible(false);
        jButtonSalvar.setEnabled(false);
        jPanel1.setVisible(false);
        jDateChooserDataVisita.setEnabled(false);
        jDateChooserDataVisita.getCalendarButton().setEnabled(true);
        jDateChooserDataVisita.setDate(new Date());
        
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
        jButtonNovo = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabelGrupo = new javax.swing.JLabel();
        jLabelResponsavel = new javax.swing.JLabel();
        jLabelDataVisita = new javax.swing.JLabel();
        jLabelVoucher = new javax.swing.JLabel();
        jTextFieldVoucher = new javax.swing.JTextField();
        jDateChooserDataVisita = new com.toedter.calendar.JDateChooser();
        jTextFieldResponsavel = new javax.swing.JTextField();
        jTextFieldGrupo = new javax.swing.JTextField();
        jLabelCpf = new javax.swing.JLabel();
        jFormattedTextFieldCpf = new javax.swing.JFormattedTextField();
        jButtonSalvar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jTextFieldIdVoucher = new javax.swing.JTextField();
        jComboBoxProdutos = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableProduto = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();

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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 890, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
        );
        jDesktopPane1.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButtonNovo.setText("Novo");
        jButtonNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoActionPerformed(evt);
            }
        });

        jButtonExcluir.setText("Excluir");
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Voucher"));
        jPanel1.setLayout(null);

        jLabelGrupo.setText("Grupo:");
        jPanel1.add(jLabelGrupo);
        jLabelGrupo.setBounds(10, 60, 85, 20);

        jLabelResponsavel.setText("Responsável:");
        jPanel1.add(jLabelResponsavel);
        jLabelResponsavel.setBounds(10, 90, 85, 20);

        jLabelDataVisita.setText("Data Visita:");
        jPanel1.add(jLabelDataVisita);
        jLabelDataVisita.setBounds(10, 120, 85, 20);

        jLabelVoucher.setText("Voucher N°:");
        jPanel1.add(jLabelVoucher);
        jLabelVoucher.setBounds(10, 150, 85, 20);

        jTextFieldVoucher.setText("jTextField1");
        jTextFieldVoucher.setSelectionEnd(0);
        jTextFieldVoucher.setSelectionStart(0);
        jPanel1.add(jTextFieldVoucher);
        jTextFieldVoucher.setBounds(105, 150, 170, 26);
        jPanel1.add(jDateChooserDataVisita);
        jDateChooserDataVisita.setBounds(105, 120, 170, 26);

        jTextFieldResponsavel.setText("jTextField1");
        jTextFieldResponsavel.setEnabled(false);
        jTextFieldResponsavel.setSelectionEnd(0);
        jTextFieldResponsavel.setSelectionStart(0);
        jPanel1.add(jTextFieldResponsavel);
        jTextFieldResponsavel.setBounds(105, 90, 170, 26);

        jTextFieldGrupo.setText("jTextField1");
        jTextFieldGrupo.setSelectionEnd(0);
        jTextFieldGrupo.setSelectionStart(0);
        jPanel1.add(jTextFieldGrupo);
        jTextFieldGrupo.setBounds(105, 60, 170, 26);

        jLabelCpf.setText("CPF:");
        jPanel1.add(jLabelCpf);
        jLabelCpf.setBounds(10, 30, 85, 20);

        try {
            jFormattedTextFieldCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextFieldCpf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jFormattedTextFieldCpfFocusLost(evt);
            }
        });
        jPanel1.add(jFormattedTextFieldCpf);
        jFormattedTextFieldCpf.setBounds(105, 30, 170, 26);

        jButtonSalvar.setText("Variavel");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });
        jButtonSalvar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButtonSalvarKeyPressed(evt);
            }
        });
        jPanel1.add(jButtonSalvar);
        jButtonSalvar.setBounds(110, 190, 71, 28);

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonCancelar);
        jButtonCancelar.setBounds(200, 190, 80, 28);

        jTextFieldIdVoucher.setText("ID");
        jPanel1.add(jTextFieldIdVoucher);
        jTextFieldIdVoucher.setBounds(10, 190, 50, 26);

        jComboBoxProdutos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(jComboBoxProdutos);
        jComboBoxProdutos.setBounds(290, 30, 210, 26);

        jButton1.setText("ADD");
        jPanel1.add(jButton1);
        jButton1.setBounds(530, 30, 80, 26);

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTableProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null}
            },
            new String [] {
                "Produto", "Valor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTableProduto);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Itens", jPanel2);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 417, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 124, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab2", jPanel3);

        jPanel1.add(jTabbedPane1);
        jTabbedPane1.setBounds(290, 60, 430, 160);

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonNovo, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonExcluir, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoActionPerformed
        if (modificador == 1) {
            jPanel1.setVisible(true);
            jButtonExcluir.setEnabled(false);
            jButtonNovo.setEnabled(false);
            limparCampos();
            jButtonSalvar.setText("Salvar");
        } else {
            modificador = 1;
            jPanel1.setVisible(true);
            jButtonExcluir.setEnabled(false);
            jButtonNovo.setEnabled(false);
            limparCampos();
            jButtonSalvar.setText("Salvar");
        }
    }//GEN-LAST:event_jButtonNovoActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        if (modificador == 1) {
            jButtonSalvar.setText("Salvar");
            cadastrar();
        } else if (modificador == 2) {
            jButtonSalvar.setText("Editar");
            editar();
        } else {
            
        }
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonSalvarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButtonSalvarKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonSalvarKeyPressed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        jPanel1.setVisible(false);
        jButtonNovo.setEnabled(true);
        jButtonExcluir.setEnabled(false);
        limparCampos();
        modificador = 1;
        
        modificadorCampos();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jFormattedTextFieldCpfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFormattedTextFieldCpfFocusLost
        if (getNomeCliente()) {
            ClassEvents.focusLostTextField(jLabelCpf, jFormattedTextFieldCpf);
        }
    }//GEN-LAST:event_jFormattedTextFieldCpfFocusLost

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        deletarVoucher();
    }//GEN-LAST:event_jButtonExcluirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonNovo;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JComboBox jComboBoxProdutos;
    private com.toedter.calendar.JDateChooser jDateChooserDataVisita;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JFormattedTextField jFormattedTextFieldCpf;
    private javax.swing.JLabel jLabelCpf;
    private javax.swing.JLabel jLabelDataVisita;
    private javax.swing.JLabel jLabelGrupo;
    private javax.swing.JLabel jLabelResponsavel;
    private javax.swing.JLabel jLabelVoucher;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTableProduto;
    private javax.swing.JTextField jTextFieldGrupo;
    private javax.swing.JTextField jTextFieldIdVoucher;
    private javax.swing.JTextField jTextFieldResponsavel;
    private javax.swing.JTextField jTextFieldVoucher;
    // End of variables declaration//GEN-END:variables

    private void comboProduto() {
        jComboBoxProdutos.removeAllItems();
        jComboBoxProdutos.addItem("Selecione um Produto");
        
        @SuppressWarnings("UnusedAssignment")
        ArrayList<Object> objetos = new ArrayList<>();
        objetos = produtoDao.listarProduto();
        
        for (Object objeto : objetos) {
            jComboBoxProdutos.addItem(objeto);
        }
    }
    
    private boolean getNomeCliente() {
        boolean retorno = false;
        String cpf = jFormattedTextFieldCpf.getText().replace(" ", "").replace(".", "").replace("/", "").replace("-", "");
        if (ValidaCPFCNPJ.isValidCPF(cpf)) {
            String nome = clienteDao.getCliente(cpf);
            if (!nome.equalsIgnoreCase("")) {
                retorno = true;
                jTextFieldResponsavel.setText(nome);
                jTextFieldResponsavel.setDisabledTextColor(Color.BLACK);
                jLabelCpf.setForeground(Color.BLACK);
                jButtonSalvar.setEnabled(true);
            } else {
                retorno = false;
                jTextFieldResponsavel.setText("Cliente Não Cadastrado...");
                jTextFieldResponsavel.setDisabledTextColor(Color.red);
                jButtonSalvar.setEnabled(false);
            }
        } else {
             retorno = false;
            jLabelCpf.setForeground(Color.red);
            jFormattedTextFieldCpf.setText("");
        }
        return retorno;
    }
    
    private void limparCampos() {
        jTextFieldGrupo.setText("");
        jTextFieldIdVoucher.setText("");
        jTextFieldResponsavel.setText("");
        jTextFieldVoucher.setText("");
        jComboBoxProdutos.setSelectedIndex(0);
        jFormattedTextFieldCpf.setText("");
    }
    
    private void deletarVoucher() {
        
    }
    
    private void cadastrar() {
        
    }
    
    private void editar() {
        
    }
    
    private void modificadorCampos() {
        
    }

    private void validaCampos() {
       jTextFieldGrupo.setDocument(new NumeroMaximoCaracters(45));
       jTextFieldVoucher.setDocument(new NumeroMaximoCaracters(6));
    }
}
