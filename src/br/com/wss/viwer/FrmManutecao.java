/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wss.viwer;

import br.com.wss.dao.BensDao;
import br.com.wss.dao.ManutencaoDao;
import br.com.wss.modelo.Manutencao;
import br.com.wss.tabelas.Tabela;
import br.com.wss.tabelas.TabelaManutecao;
import br.com.wss.utilidades.ClassUtils;
import br.com.wss.utilidades.FormatDouble;
import br.com.wss.utilidades.NumeroMaximoCaracters;
import br.com.wss.utilidades.SomenteNumero;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

/**
 *
 * @author William
 */
public class FrmManutecao extends javax.swing.JInternalFrame {

    ArrayList<Manutencao> dados;
    ManutencaoDao manutencaoDao = new ManutencaoDao();
    BensDao bensDao = new BensDao();
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
        jTextFieldEquipamento.setEnabled(false);
        jTextFieldIdManutencao.setVisible(false);

        validaCampos();
        preencherTabela();

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
        jTextFieldNumeroRegistro = new javax.swing.JTextField();
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
        jLabelValorConserto = new javax.swing.JLabel();
        jTextFieldAltorizada = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextFieldObservacoes = new javax.swing.JTextArea();
        jLabelObservacoes = new javax.swing.JLabel();
        jTextFieldGarantia = new javax.swing.JTextField();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableManutencao = new javax.swing.JTable();
        jButtonNovo = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setClosable(true);
        setIconifiable(true);
        setTitle("Cadastro de Manutenção");
        setEnabled(false);

        jPanelManutencao.setBorder(javax.swing.BorderFactory.createTitledBorder("Manutenção"));
        jPanelManutencao.setLayout(null);

        jLabelNumeroRegistro.setText("Nº Registro:");
        jPanelManutencao.add(jLabelNumeroRegistro);
        jLabelNumeroRegistro.setBounds(20, 30, 110, 20);

        jTextFieldNumeroRegistro.setText("jTextField1");
        jPanelManutencao.add(jTextFieldNumeroRegistro);
        jTextFieldNumeroRegistro.setBounds(144, 30, 190, 26);

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

        jTextFieldGarantia.setText("jTextField1");
        jPanelManutencao.add(jTextFieldGarantia);
        jTextFieldGarantia.setBounds(490, 90, 190, 26);

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
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
        );
        jDesktopPane1.setLayer(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);

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
            cadastrarManutencao();

        } else if (modificador == 2) {
            jButtonSalvar.setText("Editar");
            editarManutencao();
        } else {

        }
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        deletarManutencao();
    }//GEN-LAST:event_jButtonExcluirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonNovo;
    private javax.swing.JButton jButtonSalvar;
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
    private javax.swing.JTextField jTextFieldGarantia;
    private javax.swing.JTextField jTextFieldIdManutencao;
    private javax.swing.JTextField jTextFieldNumeroRegistro;
    private javax.swing.JTextArea jTextFieldObservacoes;
    private javax.swing.JTextField jTextFieldResponsavel;
    private javax.swing.JTextField jTextFieldValorConserto;
    // End of variables declaration//GEN-END:variables

    private void preencherTabela() {

        String[] Colunas = new String[]{"Bens", "Numero Controle", "Responsavel", "Altorizada", "Contato", "Data Retorno", "Data Saida","Data Cadastro","Ultima Alteração"};

        ManutencaoDao manutencaoTabela = new ManutencaoDao();
        dados = manutencaoTabela.listar();
        Tabela modelo = new TabelaManutecao(dados, Colunas);

        jTableManutencao.setModel(modelo);

        jTableManutencao.getColumnModel().getColumn(0).setPreferredWidth(250);
        jTableManutencao.getColumnModel().getColumn(0).setResizable(false);

        jTableManutencao.getColumnModel().getColumn(1).setPreferredWidth(155);
        jTableManutencao.getColumnModel().getColumn(1).setResizable(false);

        jTableManutencao.getColumnModel().getColumn(2).setPreferredWidth(170);
        jTableManutencao.getColumnModel().getColumn(2).setResizable(false);

        jTableManutencao.getColumnModel().getColumn(3).setPreferredWidth(170);
        jTableManutencao.getColumnModel().getColumn(3).setResizable(false);

        jTableManutencao.getColumnModel().getColumn(4).setPreferredWidth(170);
        jTableManutencao.getColumnModel().getColumn(4).setResizable(false);

        jTableManutencao.getColumnModel().getColumn(5).setPreferredWidth(103);
        jTableManutencao.getColumnModel().getColumn(5).setResizable(false);

        jTableManutencao.getColumnModel().getColumn(6).setPreferredWidth(103);
        jTableManutencao.getColumnModel().getColumn(6).setResizable(false);
        
        jTableManutencao.getColumnModel().getColumn(7).setPreferredWidth(225);
        jTableManutencao.getColumnModel().getColumn(7).setResizable(false);
        
        jTableManutencao.getColumnModel().getColumn(8).setPreferredWidth(225);
        jTableManutencao.getColumnModel().getColumn(8).setResizable(false);

        jTableManutencao.getTableHeader().setReorderingAllowed(false);
        jTableManutencao.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jTableManutencao.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    }

    private void cadastrarManutencao() {
        if (!jTextFieldAltorizada.getText().equals("") && !jTextFieldGarantia.getText().equals("")
                && !jTextFieldNumeroRegistro.getText().equals("")
                && !jTextFieldResponsavel.getText().equals("")) {

            manutencaoTemp.setAltorizada(jTextFieldAltorizada.getText());
            manutencaoTemp.setContato(jTextFieldContato.getText());
            manutencaoTemp.setDataRetorno(ClassUtils.setDateChooser(jDateChooserDataRetorno));
            manutencaoTemp.setDataSaida(ClassUtils.setDateChooser(jDateChooserDataSaida));
            manutencaoTemp.setObservacoes(jTextFieldObservacoes.getText());
            manutencaoTemp.setResponsavel(jTextFieldResponsavel.getText());
            manutencaoTemp.setValorConserto(Double.parseDouble(jTextFieldValorConserto.getText()));
            manutencaoTemp.setGarantia(String.valueOf(jTextFieldGarantia.getText()));
            manutencaoTemp.setUsuarioCad((ClassUtils.getIdUsuario()));
            manutencaoTemp.setUsuarioAlt((ClassUtils.getIdUsuario()));
            manutencaoTemp.setDataCadastro(ClassUtils.setDateMsqy());
            manutencaoTemp.setUltimaAlteracao(ClassUtils.setDateMsqy());

            manutencaoDao.cadastrarManutencao(manutencaoTemp, bensDao.buscarIdBens(jTextFieldNumeroRegistro.getText()));
            limparCampos();
            modificadorCampos();
            preencherTabela();
            jPanelManutencao.setVisible(false);
            jButtonNovo.setEnabled(true);
            jButtonExcluir.setEnabled(false);

        } else {
            jLabelAltorizada.setForeground(Color.red);
            jLabelContanto.setForeground(Color.red);
            jLabelEquipamento.setForeground(Color.red);
            jLabelNumeroRegistro.setForeground(Color.red);
            jLabelResponsavel.setForeground(Color.red);
            jLabelGarantia.setForeground(Color.red);
        }
    }

    private void editarManutencao() {
        if (!jTextFieldAltorizada.getText().equals("") && !jTextFieldGarantia.getText().equals("")
                && !jTextFieldNumeroRegistro.getText().equals("")
                && !jTextFieldResponsavel.getText().equals("")) {
            manutencaoTemp.setAltorizada(jTextFieldAltorizada.getText());
            manutencaoTemp.setContato(jTextFieldContato.getText());
            manutencaoTemp.setDataRetorno(ClassUtils.setDateChooser(jDateChooserDataRetorno));
            manutencaoTemp.setDataSaida(ClassUtils.setDateChooser(jDateChooserDataSaida));
            manutencaoTemp.setObservacoes(jTextFieldObservacoes.getText());
            manutencaoTemp.setResponsavel(jTextFieldResponsavel.getText());
            manutencaoTemp.setValorConserto(Double.parseDouble(jTextFieldValorConserto.getText()));
            manutencaoTemp.setIdManutecao(Integer.parseInt(jTextFieldIdManutencao.getText()));
            manutencaoTemp.setGarantia(String.valueOf(jTextFieldGarantia.getText()));
            manutencaoTemp.setUsuarioAlt((ClassUtils.getIdUsuario()));
            manutencaoTemp.setUltimaAlteracao(ClassUtils.setDateMsqy());

            manutencaoDao.atualizarManutencao(manutencaoTemp, bensDao.buscarIdBens(jTextFieldNumeroRegistro.getText()));
            limparCampos();
            modificadorCampos();
            preencherTabela();
            jPanelManutencao.setVisible(false);
            jButtonNovo.setEnabled(true);
            jButtonExcluir.setEnabled(false);
            modificador = 1;
        } else {
            jLabelAltorizada.setForeground(Color.red);
            jLabelContanto.setForeground(Color.red);
            jLabelEquipamento.setForeground(Color.red);
            jLabelNumeroRegistro.setForeground(Color.red);
            jLabelResponsavel.setForeground(Color.red);
            jLabelGarantia.setForeground(Color.red);
        }
    }

    private void deletarManutencao() {
        manutencaoTemp.setIdManutecao(Integer.parseInt(jTextFieldIdManutencao.getText()));
        manutencaoDao.deletarManutencao(manutencaoTemp);
        limparCampos();
        preencherTabela();
        jPanelManutencao.setVisible(false);
        jButtonNovo.setEnabled(true);
        jButtonExcluir.setEnabled(false);
        modificador = 1;
    }

    private void itensSelecionados() {
        limparCampos();
        int seleciona = jTableManutencao.getSelectedRow();

        jTextFieldIdManutencao.setText(String.valueOf(dados.get(seleciona).getIdManutecao()));
        jTextFieldResponsavel.setText(dados.get(seleciona).getResponsavel());
        jTextFieldObservacoes.setText(dados.get(seleciona).getObservacoes());
        jTextFieldAltorizada.setText(dados.get(seleciona).getAltorizada());
        jTextFieldContato.setText(dados.get(seleciona).getContato());
        jTextFieldValorConserto.setText(String.valueOf(dados.get(seleciona).getValorConserto()));
        jTextFieldNumeroRegistro.setText(dados.get(seleciona).getNumeroRegistro());
        jTextFieldEquipamento.setText(dados.get(seleciona).getNomeBens());
        jTextFieldGarantia.setText(dados.get(seleciona).getGarantia());

        try {
            String dataSaida;
            String dataRetorno;
            dataSaida = ClassUtils.setFormatData(dados.get(seleciona).getDataSaida());
            jDateChooserDataSaida.setDate(new Date(dataSaida));
            dataRetorno = ClassUtils.setFormatData(dados.get(seleciona).getDataRetorno());
            jDateChooserDataRetorno.setDate(new Date(dataRetorno));
        } catch (Exception ex) {
            Logger.getLogger(FrmManutecao.class.getName()).log(Level.SEVERE, null, ex);
        }

        modificador = 2;
    }

    private void modificadorCampos() {
        jLabelAltorizada.setForeground(Color.BLACK);
        jLabelContanto.setForeground(Color.BLACK);
        jLabelEquipamento.setForeground(Color.BLACK);
        jLabelNumeroRegistro.setForeground(Color.BLACK);
        jLabelResponsavel.setForeground(Color.BLACK);
        jLabelGarantia.setForeground(Color.BLACK);

    }

    private void limparCampos() {

        jDateChooserDataRetorno.setDate(new Date());
        jDateChooserDataSaida.setDate(new Date());
        jTextFieldNumeroRegistro.setText("");
        jTextFieldEquipamento.setText("");
        jTextFieldResponsavel.setText("");
        jTextFieldContato.setText("");
        jTextFieldAltorizada.setText("");
        jTextFieldValorConserto.setText("");
        jTextFieldObservacoes.setText("");
        jTextFieldIdManutencao.setText("");
        jTextFieldGarantia.setText("");
    }

    private void validaCampos() {
        jTextFieldAltorizada.setDocument(new NumeroMaximoCaracters(45));
        jTextFieldContato.setDocument(new NumeroMaximoCaracters(45));
        jTextFieldNumeroRegistro.setDocument(new SomenteNumero(10));
        jTextFieldResponsavel.setDocument(new NumeroMaximoCaracters(45));
        jTextFieldObservacoes.setDocument(new NumeroMaximoCaracters(100));
        jTextFieldValorConserto.setDocument(new FormatDouble(9));
        jTextFieldGarantia.setDocument(new SomenteNumero(10));
    }
}