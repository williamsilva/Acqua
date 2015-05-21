/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import DAO.*;
import MODELO.ModeloTabela;
import java.awt.Color;
import java.awt.HeadlessException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

/**
 *
 * @author WILLIAM
 */
public final class FrmUsuario extends javax.swing.JInternalFrame {

    ConectaBanco conecta = new ConectaBanco();
    String usuario = "";

    /**
     * Creates new form FrmUsuario
     */
    public FrmUsuario() {
        init();
        mostraDtaHora();
        conecta.conexao();
        preencherTabela("select * from login order by Nome");
        jBExcluir.setEnabled(false);
        jPEditar.setVisible(false);
    }

    private void init() {
        initComponents();
    }

    FrmUsuario(String usuarioFrm) {
        init();
        usuario = usuarioFrm;
        jLUsuario1.setText(usuario);
        jLUsuario1.repaint();

        JOptionPane.showMessageDialog(null, usuario);

    }

    public void intensSelecionado() {
        int seleciona = jTabelaUsuario.getSelectedRow();
        jTNome.setText(jTabelaUsuario.getModel().getValueAt(seleciona, 0).toString());
        jTUsuario.setText(jTabelaUsuario.getModel().getValueAt(seleciona, 1).toString());

    }

    public void mostraDtaHora() {
        jTdataHora.setText(ClassUtiuls.mostraHoraData());
    }

    public void preencherTabela(String SQL) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Nome", "Login", "Data Castro", "Última Auteração", "Ativo"};
        conecta.executaSQL(SQL);
        try {
            conecta.rs.first();
            do {
                dados.add(new Object[]{
                    conecta.rs.getString("Nome"),
                    conecta.rs.getString("Login"),
                    conecta.rs.getString("data_Cadastro"),
                    conecta.rs.getString("ultima_Auteracao"),
                    conecta.rs.getString("Ativo")});

            } while (conecta.rs.next());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaUsuario.setModel(modelo);

        jTabelaUsuario.getColumnModel().getColumn(0).setPreferredWidth(290);
        jTabelaUsuario.getColumnModel().getColumn(0).setResizable(false);

        jTabelaUsuario.getColumnModel().getColumn(1).setPreferredWidth(180);
        jTabelaUsuario.getColumnModel().getColumn(1).setResizable(false);

        jTabelaUsuario.getColumnModel().getColumn(2).setPreferredWidth(255);
        jTabelaUsuario.getColumnModel().getColumn(2).setResizable(false);

        jTabelaUsuario.getColumnModel().getColumn(3).setPreferredWidth(255);
        jTabelaUsuario.getColumnModel().getColumn(3).setResizable(false);

        jTabelaUsuario.getColumnModel().getColumn(4).setPreferredWidth(55);
        jTabelaUsuario.getColumnModel().getColumn(4).setResizable(false);

        jTabelaUsuario.getTableHeader().setReorderingAllowed(false);
        jTabelaUsuario.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jTabelaUsuario.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rBStatus = new javax.swing.ButtonGroup();
        jLUsuario1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabelaUsuario = new javax.swing.JTable();
        jPEditar = new javax.swing.JPanel();
        jLNomeCadastro = new javax.swing.JLabel();
        jLUsuarioCadastro = new javax.swing.JLabel();
        jBSalvar = new javax.swing.JButton();
        jBCancelar = new javax.swing.JButton();
        jTUsuario = new javax.swing.JTextField();
        jTNome = new javax.swing.JTextField();
        jLSenhaCadastro = new javax.swing.JLabel();
        jLConfirmaSenhaCadastro = new javax.swing.JLabel();
        jPConfirmeSenha = new javax.swing.JPasswordField();
        jPSenha = new javax.swing.JPasswordField();
        jRSim = new javax.swing.JRadioButton();
        jRNao = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jBExcluir = new javax.swing.JButton();
        jBNovo = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jTdataHora = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);

        jLUsuario1.setText("usuario");

        jPanel1.setBackground(new java.awt.Color(153, 255, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTabelaUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "NOME", "LOGIN"
            }
        ));
        jTabelaUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaUsuarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTabelaUsuario);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
        );

        jPEditar.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLNomeCadastro.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLNomeCadastro.setText("Nome:");

        jLUsuarioCadastro.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLUsuarioCadastro.setText("Usuário:");

        jBSalvar.setText("Salvar");
        jBSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalvarActionPerformed(evt);
            }
        });

        jBCancelar.setText("Cancelar");
        jBCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCancelarActionPerformed(evt);
            }
        });

        jLSenhaCadastro.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLSenhaCadastro.setText("Senha:");

        jLConfirmaSenhaCadastro.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLConfirmaSenhaCadastro.setText("Confirme Senha:");

        rBStatus.add(jRSim);
        jRSim.setSelected(true);
        jRSim.setText("Sim");

        rBStatus.add(jRNao);
        jRNao.setText("Não");

        jLabel1.setText("Status Usuário");

        javax.swing.GroupLayout jPEditarLayout = new javax.swing.GroupLayout(jPEditar);
        jPEditar.setLayout(jPEditarLayout);
        jPEditarLayout.setHorizontalGroup(
            jPEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPEditarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPEditarLayout.createSequentialGroup()
                        .addGroup(jPEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLSenhaCadastro)
                                .addComponent(jLConfirmaSenhaCadastro)
                                .addComponent(jLUsuarioCadastro))
                            .addGroup(jPEditarLayout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addComponent(jLNomeCadastro)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPEditarLayout.createSequentialGroup()
                                .addComponent(jTNome, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 236, Short.MAX_VALUE))
                            .addGroup(jPEditarLayout.createSequentialGroup()
                                .addGroup(jPEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPConfirmeSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPEditarLayout.createSequentialGroup()
                        .addComponent(jRSim)
                        .addGap(18, 18, 18)
                        .addComponent(jRNao)
                        .addGap(31, 31, 31)
                        .addComponent(jBSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(jBCancelar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPEditarLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addGap(34, 34, 34))
        );
        jPEditarLayout.setVerticalGroup(
            jPEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPEditarLayout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(jPEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLNomeCadastro))
                .addGap(18, 18, 18)
                .addGroup(jPEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLUsuarioCadastro))
                .addGap(18, 18, 18)
                .addGroup(jPEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLSenhaCadastro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLConfirmaSenhaCadastro)
                    .addComponent(jPConfirmeSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPEditarLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBCancelar)
                            .addComponent(jBSalvar)))
                    .addGroup(jPEditarLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRNao)
                            .addComponent(jRSim))))
                .addContainerGap())
        );

        jBExcluir.setText("Excluir");
        jBExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBExcluirActionPerformed(evt);
            }
        });

        jBNovo.setText("Novo");
        jBNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBNovoActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Data:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jBNovo)
                .addGap(50, 50, 50)
                .addComponent(jBExcluir)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 147, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(jTdataHora, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLUsuario1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(114, 114, 114))))
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBExcluir)
                    .addComponent(jBNovo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTdataHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(47, 47, 47)
                        .addComponent(jLUsuario1)
                        .addGap(40, 40, 40))
                    .addComponent(jPEditar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalvarActionPerformed
        try {
            PreparedStatement pst = conecta.conn.prepareStatement("insert into login (Nome,Login,Senha,data_cadastro,ultima_auteracao,ativo)"
                    + " values (?,?,?,?,?,?)");
            pst.setString(1, jTNome.getText());
            pst.setString(2, jTUsuario.getText());
            pst.setString(3, jPSenha.getText());
            pst.setString(4, "Em " + jTdataHora.getText() + " Por " + jLUsuario1.getText());
            pst.setString(5, "Em " + jTdataHora.getText() + " Por " + jLUsuario1.getText());

            if (jRSim.isSelected()) {
                pst.setString(6, "Sim");
            } else if (jRNao.isSelected()) {
                pst.setString(6, "Nao");
            }
            if (!jTNome.getText().equals("") && !jTUsuario.getText().equals("") && !new String(jPSenha.getPassword()).equals("")) {

                if (new String(jPSenha.getPassword()).equals(new String (jPConfirmeSenha.getPassword()))) {

                    pst.executeUpdate();
                    jTNome.setText("");
                    jTUsuario.setText("");
                    jPSenha.setText("");
                    jPConfirmeSenha.setText("");
                    
                    jPEditar.setVisible(false);
                    jBNovo.setEnabled(true);
                    jBExcluir.setEnabled(false);

                    preencherTabela("select * from login order by Nome");

                    JOptionPane.showMessageDialog(rootPane, "Dados Gravados com Sucesso");
                } else {
                    JOptionPane.showMessageDialog(null, "As Senhas não são iguais:");
                }
            } else {
                jLConfirmaSenhaCadastro.setBackground(Color.red);
                jLNomeCadastro.setBackground(Color.red);
                jLSenhaCadastro.setBackground(Color.red);
                jLUsuarioCadastro.setBackground(Color.red);
                JOptionPane.showMessageDialog(null, "Preencha os campos corretamente!");
            }

        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Gravar dados. \n Erro:" + e);
        }
    }//GEN-LAST:event_jBSalvarActionPerformed

    private void jBExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExcluirActionPerformed
        try {
            PreparedStatement pst = conecta.conn.prepareStatement("Delete from login where nome = ?");
            pst.setString(1, jTNome.getText());
            pst.execute();
            jPEditar.setVisible(false);
            jBNovo.setEnabled(true);
            jBExcluir.setEnabled(false);
            preencherTabela("select * from login order by Nome");
            JOptionPane.showMessageDialog(null, "Dados excluidos com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Excluir!\n Erro" + e.getMessage());
        }


    }//GEN-LAST:event_jBExcluirActionPerformed

    private void jBNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBNovoActionPerformed
        jPEditar.setVisible(true);
        jBNovo.setEnabled(false);
        jBExcluir.setEnabled(true);
    }//GEN-LAST:event_jBNovoActionPerformed

    private void jBCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCancelarActionPerformed
        jPEditar.setVisible(false);
        jBNovo.setEnabled(true);
        jBExcluir.setEnabled(false);
    }//GEN-LAST:event_jBCancelarActionPerformed

    private void jTabelaUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaUsuarioMouseClicked

        if (evt.getClickCount() == 2) {
            intensSelecionado();
            jPEditar.setVisible(true);
            jBNovo.setEnabled(false);
            jBExcluir.setEnabled(true);
        }
    }//GEN-LAST:event_jTabelaUsuarioMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBCancelar;
    private javax.swing.JButton jBExcluir;
    private javax.swing.JButton jBNovo;
    private javax.swing.JButton jBSalvar;
    private javax.swing.JLabel jLConfirmaSenhaCadastro;
    private javax.swing.JLabel jLNomeCadastro;
    private javax.swing.JLabel jLSenhaCadastro;
    private javax.swing.JLabel jLUsuario1;
    private javax.swing.JLabel jLUsuarioCadastro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPasswordField jPConfirmeSenha;
    private javax.swing.JPanel jPEditar;
    private javax.swing.JPasswordField jPSenha;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRNao;
    private javax.swing.JRadioButton jRSim;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTNome;
    private javax.swing.JTextField jTUsuario;
    private javax.swing.JTable jTabelaUsuario;
    private javax.swing.JTextField jTdataHora;
    private javax.swing.ButtonGroup rBStatus;
    // End of variables declaration//GEN-END:variables

//    jFTFCadastrosDataCadastro.setText(String.valueOf(atms.get(tabela.getSelectedRow()).getDataCadastro()));
//            jFTFCadastrosDataAtivacao.setText(String.valueOf(atms.get(tabela.getSelectedRow()).getDataAtivacao()));
//            jFTFCadastrosDataDesativacaoTemporaria.setText(String.valueOf(atms.get(tabela.getSelectedRow()).getDataDesativacaoTemporaria()));
//            jFTFCadastrosDataReativacao.setText(String.valueOf(atms.get(tabela.getSelectedRow()).getDataReativacao()));
//            jFTFCadastrosDataAtualizacao.setText(String.valueOf(atms.get(tabela.getSelectedRow()).getDataAtualizacao()));
//            jFTFCadastrosDataDesinstalacao.setText(String.valueOf(atms.get(tabela.getSelectedRow()).getDataDesinstalacao()));
//    
}
