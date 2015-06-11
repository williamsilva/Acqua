/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wss.viwer;

import br.com.wss.dao.utilidades.ClassUtils;
import br.com.wss.dao.ComputadorDao;
import br.com.wss.modelo.TabelaComputador;
import br.com.wss.modelo.Tabela;
import br.com.wss.modelo.Computador;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

/**
 *
 * @author WILLIAM
 */
public final class FrmComputador extends javax.swing.JInternalFrame {

    ArrayList<Computador> dados;

    /**
     * Creates new form FrmComputador
     */
    public FrmComputador() {
        initComponents();
        jLid.setVisible(false);
        jTId.setVisible(false);

        preencherTabela();
        jPComputador.setVisible(false);
        jBExcluir.setEnabled(false);
        jBEditar.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTabelaComputador = new javax.swing.JTable();
        jBNovo = new javax.swing.JButton();
        jBExcluir = new javax.swing.JButton();
        jPComputador = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jBCancelar = new javax.swing.JButton();
        jBSalvar = new javax.swing.JButton();
        jTNomeCoputador = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTMacCoputador = new javax.swing.JTextField();
        jTId = new javax.swing.JTextField();
        jLid = new javax.swing.JLabel();
        jBEditar = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setClosable(true);
        setEnabled(false);

        jTabelaComputador.setModel(new javax.swing.table.DefaultTableModel(
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
        jTabelaComputador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaComputadorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTabelaComputador);

        jBNovo.setText("Novo");
        jBNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBNovoActionPerformed(evt);
            }
        });

        jBExcluir.setText("Excluir");
        jBExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBExcluirActionPerformed(evt);
            }
        });

        jPComputador.setBorder(javax.swing.BorderFactory.createTitledBorder("Computador"));

        jLabel1.setText("Descrição do Computador:");

        jBCancelar.setText("Cancelar");
        jBCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCancelarActionPerformed(evt);
            }
        });

        jBSalvar.setText("Salvar");
        jBSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalvarActionPerformed(evt);
            }
        });

        jLabel2.setText("Mac do Computador:");

        jTId.setEditable(false);

        jLid.setText("Id Cadastrado");

        jBEditar.setText("Editar");
        jBEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPComputadorLayout = new javax.swing.GroupLayout(jPComputador);
        jPComputador.setLayout(jPComputadorLayout);
        jPComputadorLayout.setHorizontalGroup(
            jPComputadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPComputadorLayout.createSequentialGroup()
                .addGroup(jPComputadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPComputadorLayout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(jBEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBCancelar))
                    .addGroup(jPComputadorLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPComputadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLid))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPComputadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTId, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTMacCoputador, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                            .addComponent(jTNomeCoputador))))
                .addContainerGap(285, Short.MAX_VALUE))
        );
        jPComputadorLayout.setVerticalGroup(
            jPComputadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPComputadorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPComputadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTNomeCoputador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPComputadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTMacCoputador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPComputadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLid))
                .addGap(18, 18, 18)
                .addGroup(jPComputadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBCancelar)
                    .addComponent(jBSalvar)
                    .addComponent(jBEditar))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPComputador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBExcluir)))
                .addContainerGap(109, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBNovo)
                    .addComponent(jBExcluir))
                .addGap(18, 18, 18)
                .addComponent(jPComputador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTabelaComputadorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaComputadorMouseClicked
        if (evt.getClickCount() == 2) {
            itensSelecionados();
            jBNovo.setEnabled(false);
            jBExcluir.setEnabled(true);
            jPComputador.setVisible(true);
            jBEditar.setVisible(true);
            jBSalvar.setVisible(false);
        }
    }//GEN-LAST:event_jTabelaComputadorMouseClicked

    private void jBCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCancelarActionPerformed
        limparCampos();
        jPComputador.setVisible(false);
        jBExcluir.setEnabled(false);
        jBNovo.setEnabled(true);
    }//GEN-LAST:event_jBCancelarActionPerformed

    private void jBNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBNovoActionPerformed
        jPComputador.setVisible(true);
        jBExcluir.setEnabled(false);
        jBNovo.setEnabled(false);
        jBSalvar.setVisible(true);
        jBEditar.setVisible(false);

    }//GEN-LAST:event_jBNovoActionPerformed

    private void jBEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEditarActionPerformed

        Computador computadorTemp = new Computador();

        computadorTemp.setComputador(jTNomeCoputador.getText());
        computadorTemp.setMac(jTMacCoputador.getText());
        computadorTemp.setId(Integer.parseInt(jTId.getText()));
        computadorTemp.setUltimaAlteracao("Em " + ClassUtils.mostraHoraData() + " Por " + ClassUtils.buscaUsuarioLogado());

        ComputadorDao dao = new ComputadorDao();
        dao.atualizar(computadorTemp);

        limparCampos();
        preencherTabela();

        jPComputador.setVisible(false);
        jBNovo.setEnabled(true);
        jBExcluir.setEnabled(false);
    }//GEN-LAST:event_jBEditarActionPerformed

    private void jBSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalvarActionPerformed
        if (!jTNomeCoputador.getText().equals("") && !jTMacCoputador.getText().equals("")) {

            Computador computadorTemp = new Computador();

            computadorTemp.setComputador(jTNomeCoputador.getText());
            computadorTemp.setMac(jTMacCoputador.getText());
            computadorTemp.setUltimaAlteracao("Em " + ClassUtils.mostraHoraData() + " Por " + ClassUtils.buscaUsuarioLogado());
            computadorTemp.setDataCadastro("Em " + ClassUtils.mostraHoraData() + " Por " + ClassUtils.buscaUsuarioLogado());

            ComputadorDao dao = new ComputadorDao();
            dao.cadastrarComputador(computadorTemp);
            limparCampos();
            jBEditar.setVisible(false);
            jBNovo.setEnabled(true);
            jBExcluir.setEnabled(false);
            preencherTabela();

        } else {
            JOptionPane.showMessageDialog(null, "Nenhun campo pode ser vazio!");
            repaint();
        }
    }//GEN-LAST:event_jBSalvarActionPerformed

    private void jBExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExcluirActionPerformed
       
            Computador computadorTemp = new Computador();
            computadorTemp.setId(Integer.parseInt(jTId.getText()));
            ComputadorDao dao = new ComputadorDao();

            dao.deletar(computadorTemp);
            jPComputador.setVisible(false);
            jBEditar.setVisible(false);
            jBNovo.setEnabled(true);
            jBExcluir.setEnabled(false);
            preencherTabela();
            limparCampos();
       
    }//GEN-LAST:event_jBExcluirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBCancelar;
    private javax.swing.JButton jBEditar;
    private javax.swing.JButton jBExcluir;
    private javax.swing.JButton jBNovo;
    private javax.swing.JButton jBSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLid;
    private javax.swing.JPanel jPComputador;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTId;
    private javax.swing.JTextField jTMacCoputador;
    private javax.swing.JTextField jTNomeCoputador;
    private javax.swing.JTable jTabelaComputador;
    // End of variables declaration//GEN-END:variables

    public void itensSelecionados() {
        int seleciona = jTabelaComputador.getSelectedRow();

        jTId.setText(String.valueOf(dados.get(seleciona).getId()));
        jTNomeCoputador.setText(dados.get(seleciona).getComputador());
        jTMacCoputador.setText(dados.get(seleciona).getMac());

    }

    public void preencherTabela() {

        String[] Colunas = new String[]{"Computador", "Endereço Mac", "Data Cadastro", "Última Auteração"};

        ComputadorDao computadorDao = new ComputadorDao();
        dados = computadorDao.listar();
        
        Tabela modelo = new TabelaComputador(dados, Colunas);
        jTabelaComputador.setModel(modelo);

        jTabelaComputador.getColumnModel().getColumn(0).setPreferredWidth(275);
        jTabelaComputador.getColumnModel().getColumn(0).setResizable(false);

        jTabelaComputador.getColumnModel().getColumn(1).setPreferredWidth(200);
        jTabelaComputador.getColumnModel().getColumn(1).setResizable(false);

        jTabelaComputador.getColumnModel().getColumn(2).setPreferredWidth(325);
        jTabelaComputador.getColumnModel().getColumn(2).setResizable(false);

        jTabelaComputador.getColumnModel().getColumn(3).setPreferredWidth(325);
        jTabelaComputador.getColumnModel().getColumn(3).setResizable(false);

        jTabelaComputador.getTableHeader().setReorderingAllowed(false);
        jTabelaComputador.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jTabelaComputador.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    }

    public void limparCampos() {
        jTMacCoputador.setText("");
        jTNomeCoputador.setText("");
        jTId.setText("");
    }

}
