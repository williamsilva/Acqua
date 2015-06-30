/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wss.viwer;

import br.com.wss.dao.ManutencaoDao;
import br.com.wss.modelo.Manutencao;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author William
 */
public class FrmManutecao extends javax.swing.JInternalFrame {

    ArrayList<Manutencao> dados;
    ManutencaoDao manutencaoDao = new ManutencaoDao();
    Manutencao manutencaoTemp = new Manutencao();
    int modificador = 1;

    /**
     * Creates new form FrmManutecao
     */
    public FrmManutecao() {
        initComponents();
        jPanelManutencao.setVisible(false);
        jButtonExcluir.setEnabled(false);
        jDateChooserDataSaida.setEnabled(false);
        jDateChooserDataSaida.getCalendarButton().setEnabled(true);
        jDateChooserDataRetorno.setEnabled(false);
        jDateChooserDataRetorno.getCalendarButton().setEnabled(true);
        jDateChooserDataSaida.setDate(new Date());
        jDateChooserDataRetorno.setDate(new Date());

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelManutencao = new javax.swing.JPanel();
        jLabelNumeroRegistro = new javax.swing.JLabel();
        jTextFieldNumerogeristro = new javax.swing.JTextField();
        jLabelResponsavel = new javax.swing.JLabel();
        jTextFieldResponsavel = new javax.swing.JTextField();
        jTextFieldEquipamento = new javax.swing.JTextField();
        jLabelEquipamento = new javax.swing.JLabel();
        jLabelAltorizada = new javax.swing.JLabel();
        jTextFieldValorConserto = new javax.swing.JTextField();
        jButtonSalvar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jTextFieldIdManutencao = new javax.swing.JTextField();
        jLabelContanto = new javax.swing.JLabel();
        jTextFieldContato = new javax.swing.JTextField();
        jLabelDataSaida = new javax.swing.JLabel();
        jDateChooserDataSaida = new com.toedter.calendar.JDateChooser();
        jLabelDataRetorno = new javax.swing.JLabel();
        jDateChooserDataRetorno = new com.toedter.calendar.JDateChooser();
        jLabelGarantia = new javax.swing.JLabel();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jLabelValorConserto = new javax.swing.JLabel();
        jTextFieldAltorizada = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextFieldObservacoes = new javax.swing.JTextArea();
        jLabelObservacoes = new javax.swing.JLabel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableManutencao = new javax.swing.JTable();
        jButtonNovo = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setClosable(true);
        setIconifiable(true);
        setEnabled(false);

        jPanelManutencao.setBorder(javax.swing.BorderFactory.createTitledBorder("Manutenção"));
        jPanelManutencao.setLayout(null);

        jLabelNumeroRegistro.setText("Nº Registro:");
        jPanelManutencao.add(jLabelNumeroRegistro);
        jLabelNumeroRegistro.setBounds(20, 30, 110, 20);

        jTextFieldNumerogeristro.setText("jTextField1");
        jPanelManutencao.add(jTextFieldNumerogeristro);
        jTextFieldNumerogeristro.setBounds(144, 30, 190, 26);

        jLabelResponsavel.setText("Quem Levou:");
        jPanelManutencao.add(jLabelResponsavel);
        jLabelResponsavel.setBounds(20, 90, 110, 20);

        jTextFieldResponsavel.setText("jTextField1");
        jPanelManutencao.add(jTextFieldResponsavel);
        jTextFieldResponsavel.setBounds(144, 90, 190, 26);

        jTextFieldEquipamento.setText("jTextField1");
        jPanelManutencao.add(jTextFieldEquipamento);
        jTextFieldEquipamento.setBounds(144, 60, 190, 26);

        jLabelEquipamento.setText("Equipamento:");
        jPanelManutencao.add(jLabelEquipamento);
        jLabelEquipamento.setBounds(20, 60, 110, 20);

        jLabelAltorizada.setText("Altorzada:");
        jPanelManutencao.add(jLabelAltorizada);
        jLabelAltorizada.setBounds(20, 120, 110, 20);

        jTextFieldValorConserto.setText("jTextField1");
        jPanelManutencao.add(jTextFieldValorConserto);
        jTextFieldValorConserto.setBounds(490, 120, 190, 26);

        jButtonSalvar.setText("Variavel");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });
        jPanelManutencao.add(jButtonSalvar);
        jButtonSalvar.setBounds(140, 190, 80, 26);

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });
        jPanelManutencao.add(jButtonCancelar);
        jButtonCancelar.setBounds(250, 190, 80, 26);

        jTextFieldIdManutencao.setText("IdManu");
        jPanelManutencao.add(jTextFieldIdManutencao);
        jTextFieldIdManutencao.setBounds(20, 180, 50, 26);

        jLabelContanto.setText("Contato:");
        jPanelManutencao.add(jLabelContanto);
        jLabelContanto.setBounds(20, 150, 110, 20);

        jTextFieldContato.setText("jTextField1");
        jPanelManutencao.add(jTextFieldContato);
        jTextFieldContato.setBounds(144, 150, 190, 26);

        jLabelDataSaida.setText("Data Saida:");
        jPanelManutencao.add(jLabelDataSaida);
        jLabelDataSaida.setBounds(360, 30, 110, 20);
        jPanelManutencao.add(jDateChooserDataSaida);
        jDateChooserDataSaida.setBounds(490, 30, 190, 26);

        jLabelDataRetorno.setText("Data Retorno:");
        jPanelManutencao.add(jLabelDataRetorno);
        jLabelDataRetorno.setBounds(360, 60, 110, 20);
        jPanelManutencao.add(jDateChooserDataRetorno);
        jDateChooserDataRetorno.setBounds(490, 60, 190, 26);

        jLabelGarantia.setText("Garantia:");
        jPanelManutencao.add(jLabelGarantia);
        jLabelGarantia.setBounds(360, 90, 110, 20);
        jPanelManutencao.add(jDateChooser3);
        jDateChooser3.setBounds(490, 90, 190, 26);

        jLabelValorConserto.setText("Valor Conserto:");
        jPanelManutencao.add(jLabelValorConserto);
        jLabelValorConserto.setBounds(360, 120, 110, 20);

        jTextFieldAltorizada.setText("jTextField1");
        jPanelManutencao.add(jTextFieldAltorizada);
        jTextFieldAltorizada.setBounds(144, 120, 190, 26);

        jTextFieldObservacoes.setColumns(20);
        jTextFieldObservacoes.setRows(5);
        jTextFieldObservacoes.setText("\n\n\n\n\n\n\n");
        jScrollPane1.setViewportView(jTextFieldObservacoes);

        jPanelManutencao.add(jScrollPane1);
        jScrollPane1.setBounds(360, 170, 320, 50);

        jLabelObservacoes.setText("Observações:");
        jPanelManutencao.add(jLabelObservacoes);
        jLabelObservacoes.setBounds(360, 150, 100, 20);

        jTableManutencao.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableManutencao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableManutencaoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableManutencao);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
        );
        jDesktopPane1.setLayer(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);

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
                .addComponent(jButtonNovo)
                .addGap(29, 29, 29)
                .addComponent(jButtonExcluir)
                .addContainerGap(770, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelManutencao, javax.swing.GroupLayout.PREFERRED_SIZE, 693, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonNovo)
                    .addComponent(jButtonExcluir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelManutencao, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoActionPerformed
        if (modificador == 1) {
            jPanelManutencao.setVisible(true);
            jButtonNovo.setEnabled(false);
            jButtonExcluir.setEnabled(false);
            limparCampos();
            jButtonSalvar.setText("Salvar");
        } else {
            modificador = 1;
            jPanelManutencao.setVisible(true);
            jButtonNovo.setEnabled(false);
            jButtonExcluir.setEnabled(false);
            limparCampos();
        }
    }//GEN-LAST:event_jButtonNovoActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        jPanelManutencao.setVisible(false);
        jButtonNovo.setEnabled(true);
        jButtonExcluir.setEnabled(false);
        limparCampos();
        modificador = 1;
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jTableManutencaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableManutencaoMouseClicked
        if (evt.getClickCount() == 2) {
            itensSelecionados();
            jPanelManutencao.setVisible(true);
            jButtonNovo.setEnabled(false);
            jButtonExcluir.setEnabled(true);
            modificador = 2;
            jButtonSalvar.setText("Editar");
        }
    }//GEN-LAST:event_jTableManutencaoMouseClicked

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        if (modificador == 1) {
            jButtonSalvar.setText("Salvar");
            cadastrarBens();

        } else if (modificador == 2) {
            jButtonSalvar.setText("Editar");
            editarBens();
        } else {

        }
    }//GEN-LAST:event_jButtonSalvarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonNovo;
    private javax.swing.JButton jButtonSalvar;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private com.toedter.calendar.JDateChooser jDateChooserDataRetorno;
    private com.toedter.calendar.JDateChooser jDateChooserDataSaida;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabelAltorizada;
    private javax.swing.JLabel jLabelContanto;
    private javax.swing.JLabel jLabelDataRetorno;
    private javax.swing.JLabel jLabelDataSaida;
    private javax.swing.JLabel jLabelEquipamento;
    private javax.swing.JLabel jLabelGarantia;
    private javax.swing.JLabel jLabelNumeroRegistro;
    private javax.swing.JLabel jLabelObservacoes;
    private javax.swing.JLabel jLabelResponsavel;
    private javax.swing.JLabel jLabelValorConserto;
    private javax.swing.JPanel jPanelManutencao;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableManutencao;
    private javax.swing.JTextField jTextFieldAltorizada;
    private javax.swing.JTextField jTextFieldContato;
    private javax.swing.JTextField jTextFieldEquipamento;
    private javax.swing.JTextField jTextFieldIdManutencao;
    private javax.swing.JTextField jTextFieldNumerogeristro;
    private javax.swing.JTextArea jTextFieldObservacoes;
    private javax.swing.JTextField jTextFieldResponsavel;
    private javax.swing.JTextField jTextFieldValorConserto;
    // End of variables declaration//GEN-END:variables

    private void limparCampos() {

    }

    private void cadastrarBens() {
        if(!jTextFieldAltorizada.getText().equals("")
                && !jTextFieldNumerogeristro.getText().equals("")
                && !jTextFieldResponsavel.getText().equals("")){
           manutencaoTemp.setAltorizada(jTextFieldAltorizada.getText());
           manutencaoTemp.setContato(jTextFieldContato.getText());
           manutencaoTemp.setDataRetorno(title);
           manutencaoTemp.setDataSaida(title);
           manutencaoTemp.setObservacoes(jTextFieldObservacoes.getText());
           manutencaoTemp.setResponsavel(jTextFieldResponsavel.getText());
           manutencaoTemp.setValorConserto(Double.parseDouble(jTextFieldValorConserto.getText()));
        
           manutencaoDao.cadastrarManutencao(manutencaoTemp);
        }else{
            jLabelAltorizada.setForeground(Color.red);
            jLabelContanto.setForeground(Color.red);
            jLabelEquipamento.setForeground(Color.red);
            jLabelNumeroRegistro.setForeground(Color.red);
            jLabelResponsavel.setForeground(Color.red);            
        }
    }

    private void editarBens() {
    }

    private void itensSelecionados() {
        limparCampos();
        int seleciona = jTableManutencao.getSelectedRow();

        jTextFieldIdManutencao.setText(String.valueOf(dados.get(seleciona).getIdManutecao()));
        jTextFieldResponsavel.setText(dados.get(seleciona).getResponsavel());
        jTextFieldObservacoes.setText(dados.get(seleciona).getObservacoes());

        modificador = 2;
    }
}
