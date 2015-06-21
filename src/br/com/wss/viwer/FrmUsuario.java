/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wss.viwer;

import br.com.wss.tabelas.TabelaUsuario;
import br.com.wss.tabelas.Tabela;
import br.com.wss.utilidades.ClassUtils;
import br.com.wss.dao.*;
import br.com.wss.modelo.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

/**
 *
 * @author WILLIAM
 */
public final class FrmUsuario extends javax.swing.JInternalFrame {

    ArrayList<Usuario> dados;
    String usuario = "";
    String usuarioSenha = "";

    /**
     * Creates new form FrmUsuario
     */
    public FrmUsuario() {
        init();
        preencherTabela();
        jBExcluir.setEnabled(false);
        jPEditar.setVisible(false);

    }

    private void init() {
        initComponents();
        timer1.start();
        jLid.setVisible(false);
        jTId.setVisible(false);
    }

    public void intensSelecionado() {
        int seleciona = jTabelaUsuario.getSelectedRow();

        jTId.setText(String.valueOf(dados.get(seleciona).getCodigo()));
        jTNome.setText(dados.get(seleciona).getNome());
        jTUsuario.setText(dados.get(seleciona).getUsuario());
        jPasswordTetsSenha.setText(dados.get(seleciona).getSenha());

    }

    public void preencherTabela() {

        String[] Colunas = new String[]{"Nome", "Usuário", "Data Castro", "Última Alteração", "Ativo"};

        UsuarioDao usuarioDao = new UsuarioDao();
        dados = usuarioDao.listar();
        Tabela modelo = new TabelaUsuario(dados, Colunas);
        jTabelaUsuario.setModel(modelo);

        jTabelaUsuario.getColumnModel().getColumn(0).setPreferredWidth(210);
        jTabelaUsuario.getColumnModel().getColumn(0).setResizable(false);

        jTabelaUsuario.getColumnModel().getColumn(1).setPreferredWidth(200);
        jTabelaUsuario.getColumnModel().getColumn(1).setResizable(false);

        jTabelaUsuario.getColumnModel().getColumn(2).setPreferredWidth(325);
        jTabelaUsuario.getColumnModel().getColumn(2).setResizable(false);

        jTabelaUsuario.getColumnModel().getColumn(3).setPreferredWidth(325);
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
        timer1 = new org.netbeans.examples.lib.timerbean.Timer();
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
        jRSim = new javax.swing.JRadioButton();
        jRNao = new javax.swing.JRadioButton();
        jBEditar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLUsuarioCadastro1 = new javax.swing.JLabel();
        jTId = new javax.swing.JTextField();
        jLid = new javax.swing.JLabel();
        jBExcluir = new javax.swing.JButton();
        jBNovo = new javax.swing.JButton();
        jPasswordTetsSenha = new javax.swing.JLabel();

        timer1.addTimerListener(new org.netbeans.examples.lib.timerbean.TimerListener() {
            public void onTime(java.awt.event.ActionEvent evt) {
                timer1OnTime(evt);
            }
        });

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setClosable(true);
        setIconifiable(true);
        setResizable(true);

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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 981, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
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

        rBStatus.add(jRSim);
        jRSim.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jRSim.setSelected(true);
        jRSim.setText("Ativo");

        rBStatus.add(jRNao);
        jRNao.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jRNao.setText("Bloqueado");

        jBEditar.setText("Editar");
        jBEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEditarActionPerformed(evt);
            }
        });

        jButton1.setText("Definir Senha");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLUsuarioCadastro1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLUsuarioCadastro1.setText("Status Usuário:");

        jTId.setEditable(false);

        jLid.setText("Id Cadastrado");

        javax.swing.GroupLayout jPEditarLayout = new javax.swing.GroupLayout(jPEditar);
        jPEditar.setLayout(jPEditarLayout);
        jPEditarLayout.setHorizontalGroup(
            jPEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPEditarLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPEditarLayout.createSequentialGroup()
                        .addGroup(jPEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLUsuarioCadastro)
                            .addGroup(jPEditarLayout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jLNomeCadastro)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTNome, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPEditarLayout.createSequentialGroup()
                        .addComponent(jLUsuarioCadastro1)
                        .addGap(18, 18, 18)
                        .addComponent(jRSim)
                        .addGap(18, 18, 18)
                        .addComponent(jRNao)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPEditarLayout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(jPEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPEditarLayout.createSequentialGroup()
                        .addComponent(jLid)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTId, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPEditarLayout.createSequentialGroup()
                        .addComponent(jBEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBSalvar)
                        .addGap(18, 18, 18)
                        .addComponent(jBCancelar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(28, 28, 28))
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
                    .addComponent(jLUsuarioCadastro1)
                    .addComponent(jRSim)
                    .addComponent(jRNao))
                .addGap(29, 29, 29)
                .addGroup(jPEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBSalvar)
                    .addComponent(jBEditar)
                    .addComponent(jBCancelar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPEditarLayout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPEditarLayout.createSequentialGroup()
                        .addGroup(jPEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLid))
                        .addContainerGap())))
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

        jPasswordTetsSenha.setText("Senha");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jBNovo)
                        .addGap(50, 50, 50)
                        .addComponent(jBExcluir))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(jPasswordTetsSenha)))
                .addGap(0, 383, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBExcluir)
                    .addComponent(jBNovo))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jPasswordTetsSenha))))
        );

        setBounds(0, 0, 989, 485);
    }// </editor-fold>//GEN-END:initComponents

    private void jBSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalvarActionPerformed

        if (!jTNome.getText().equals("") && !jTUsuario.getText().equals("")) {

            Usuario usuarioTemp = new Usuario();
            usuarioTemp.setNome(jTNome.getText());
            usuarioTemp.setUsuario(jTUsuario.getText());
            usuarioTemp.setUltimaAlteracao("Em " + ClassUtils.mostraHoraData() + " Por " + ClassUtils.buscaUsuarioLogado());
            usuarioTemp.setDataCadastro("Em " + ClassUtils.mostraHoraData() + " Por " + ClassUtils.buscaUsuarioLogado());

            if (jRSim.isSelected()) {
                usuarioTemp.setAtivo("Sim");
            } else if (jRNao.isSelected()) {
                usuarioTemp.setAtivo("Não");
            }
            UsuarioDao dao = new UsuarioDao();
            dao.cadastrarUsuario(usuarioTemp);
            limparCanpos();
            jPEditar.setVisible(false);
            jBNovo.setEnabled(true);
            jBExcluir.setEnabled(false);
            preencherTabela();

        } else {
            JOptionPane.showMessageDialog(null, "Nenhun campo pode ser vazio!");
        }
    }//GEN-LAST:event_jBSalvarActionPerformed

    private void jBExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExcluirActionPerformed

        int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja Excluir?", "Exclusão", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            Usuario usuarioTemp = new Usuario();
            usuarioTemp.setUsuario(jTUsuario.getText());
            UsuarioDao dao = new UsuarioDao();
            dao.deletar(usuarioTemp);

            jPEditar.setVisible(false);
            jBNovo.setEnabled(true);
            jBExcluir.setEnabled(false);
            preencherTabela();
            limparCanpos();

        } else {
            repaint();
        }


    }//GEN-LAST:event_jBExcluirActionPerformed

    private void jBNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBNovoActionPerformed
        jPEditar.setVisible(true);
        jBNovo.setEnabled(false);
        jBExcluir.setEnabled(false);
        jBExcluir.setVisible(true);
        jBEditar.setVisible(false);
        jBSalvar.setVisible(true);
        jBSalvar.setEnabled(true);
        limparCanpos();
    }//GEN-LAST:event_jBNovoActionPerformed

    private void jBCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCancelarActionPerformed
        jPEditar.setVisible(false);
        jBNovo.setEnabled(true);
        jBExcluir.setEnabled(false);
        limparCanpos();
    }//GEN-LAST:event_jBCancelarActionPerformed

    private void jTabelaUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaUsuarioMouseClicked

        if (evt.getClickCount() == 2) {
            intensSelecionado();
            jPEditar.setVisible(true);
            jBNovo.setEnabled(false);
            jBExcluir.setEnabled(true);
            jBEditar.setVisible(true);
            jBSalvar.setVisible(false);
            jBExcluir.setVisible(true);
        }
    }//GEN-LAST:event_jTabelaUsuarioMouseClicked

    private void jBEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEditarActionPerformed
        Usuario usuarioTemp = new Usuario();

        usuarioTemp.setNome(jTNome.getText());
        usuarioTemp.setUsuario(jTUsuario.getText());
        usuarioTemp.setCodigo(jTId.getText());
        usuarioTemp.setUltimaAlteracao("Em " + ClassUtils.mostraHoraData() + " Por " + ClassUtils.buscaUsuarioLogado());

        if (jRSim.isSelected()) {
            usuarioTemp.setAtivo("Sim");
        } else if (jRNao.isSelected()) {
            usuarioTemp.setAtivo("Nao");
        }

        UsuarioDao dao = new UsuarioDao();
        dao.atualizar(usuarioTemp);
        limparCanpos();
        preencherTabela();

        jPEditar.setVisible(false);
        jBNovo.setVisible(true);
        jBNovo.setEnabled(true);
        jBExcluir.setVisible(true);
        jBExcluir.setEnabled(false);
        jBSalvar.setVisible(true);
        limparCanpos();
    }//GEN-LAST:event_jBEditarActionPerformed

    private void timer1OnTime(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timer1OnTime


    }//GEN-LAST:event_timer1OnTime

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        FrmDefinirSenha senha = new FrmDefinirSenha();
        senha.setLocationRelativeTo(null);
        senha.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBCancelar;
    private javax.swing.JButton jBEditar;
    private javax.swing.JButton jBExcluir;
    private javax.swing.JButton jBNovo;
    private javax.swing.JButton jBSalvar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLNomeCadastro;
    private javax.swing.JLabel jLUsuarioCadastro;
    private javax.swing.JLabel jLUsuarioCadastro1;
    private javax.swing.JLabel jLid;
    private javax.swing.JPanel jPEditar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jPasswordTetsSenha;
    private javax.swing.JRadioButton jRNao;
    private javax.swing.JRadioButton jRSim;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTId;
    private javax.swing.JTextField jTNome;
    private javax.swing.JTextField jTUsuario;
    private javax.swing.JTable jTabelaUsuario;
    private javax.swing.ButtonGroup rBStatus;
    private org.netbeans.examples.lib.timerbean.Timer timer1;
    // End of variables declaration//GEN-END:variables

    public void limparCanpos() {
        jTNome.setText("");
        jTUsuario.setText("");
    }
    
}
