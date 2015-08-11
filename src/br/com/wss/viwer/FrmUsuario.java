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
import br.com.wss.utilidades.NumeroMaximoCaracters;
import java.awt.Color;
import java.awt.event.KeyEvent;
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
    int modificador = 1;

    /**
     * Creates new form FrmUsuario
     */
    public FrmUsuario() {
        init();
        preencherTabela();
        jBExcluir.setEnabled(false);
        jPUsuario.setVisible(false);
        jPanelSenha.setVisible(false);
        jTextFieldNome.setDocument(new NumeroMaximoCaracters(30));
        jTextFieldUsuario.setDocument(new NumeroMaximoCaracters(20));

    }

    private void init() {
        initComponents();
        timer1.start();
        jTId.setVisible(false);
    }

    private void intensSelecionado() {
        int seleciona = jTabelaUsuario.getSelectedRow();

        jTId.setText(String.valueOf(dados.get(seleciona).getCodigo()));
        jTextFieldNome.setText(dados.get(seleciona).getNome());
        jTextFieldUsuario.setText(dados.get(seleciona).getUsuario());
        jPasswordFieldSenha.setText(dados.get(seleciona).getSenha());
        jPasswordFieldConfirmeSenha.setText(dados.get(seleciona).getSenha());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rBStatus = new javax.swing.ButtonGroup();
        timer1 = new org.netbeans.examples.lib.timerbean.Timer();
        jPUsuario = new javax.swing.JPanel();
        jLNome = new javax.swing.JLabel();
        jLUsuario = new javax.swing.JLabel();
        jButtonSalvar = new javax.swing.JButton();
        jBCancelar = new javax.swing.JButton();
        jTextFieldUsuario = new javax.swing.JTextField();
        jTextFieldNome = new javax.swing.JTextField();
        jRSim = new javax.swing.JRadioButton();
        jRNao = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jLUsuarioCadastro1 = new javax.swing.JLabel();
        jTId = new javax.swing.JTextField();
        jBExcluir = new javax.swing.JButton();
        jBNovo = new javax.swing.JButton();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabelaUsuario = new javax.swing.JTable();
        jPanelSenha = new javax.swing.JPanel();
        jPasswordFieldSenha = new javax.swing.JPasswordField();
        jLabelSenha = new javax.swing.JLabel();
        jLabelConfirmeSenha = new javax.swing.JLabel();
        jPasswordFieldConfirmeSenha = new javax.swing.JPasswordField();
        jButtonSalvarSenha = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setClosable(true);
        setIconifiable(true);
        setTitle("Cadastro de Usúario");
        setEnabled(false);

        jPUsuario.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Usuário"));

        jLNome.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLNome.setText("Nome:");

        jLUsuario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLUsuario.setText("Usuário:");

        jButtonSalvar.setText("variavel");
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

        jBCancelar.setText("Cancelar");
        jBCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCancelarActionPerformed(evt);
            }
        });

        jTextFieldUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldUsuarioKeyPressed(evt);
            }
        });

        jTextFieldNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldNomeKeyPressed(evt);
            }
        });

        rBStatus.add(jRSim);
        jRSim.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jRSim.setSelected(true);
        jRSim.setText("Ativo");

        rBStatus.add(jRNao);
        jRNao.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jRNao.setText("Bloqueado");

        jButton1.setText("Definir Senha");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLUsuarioCadastro1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLUsuarioCadastro1.setText("Status Usuário:");

        jTId.setEditable(false);
        jTId.setText("iD");

        javax.swing.GroupLayout jPUsuarioLayout = new javax.swing.GroupLayout(jPUsuario);
        jPUsuario.setLayout(jPUsuarioLayout);
        jPUsuarioLayout.setHorizontalGroup(
            jPUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPUsuarioLayout.createSequentialGroup()
                .addGroup(jPUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPUsuarioLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPUsuarioLayout.createSequentialGroup()
                                .addComponent(jLUsuarioCadastro1)
                                .addGap(18, 18, 18)
                                .addComponent(jRSim)
                                .addGap(18, 18, 18)
                                .addComponent(jRNao))
                            .addGroup(jPUsuarioLayout.createSequentialGroup()
                                .addGap(176, 176, 176)
                                .addComponent(jBCancelar)
                                .addGap(43, 43, 43)
                                .addComponent(jButton1))
                            .addGroup(jPUsuarioLayout.createSequentialGroup()
                                .addGroup(jPUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLUsuario)
                                    .addGroup(jPUsuarioLayout.createSequentialGroup()
                                        .addGap(11, 11, 11)
                                        .addComponent(jLNome)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFieldUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                                    .addComponent(jTextFieldNome))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTId, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16))))
                    .addGroup(jPUsuarioLayout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(jButtonSalvar)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPUsuarioLayout.setVerticalGroup(
            jPUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPUsuarioLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLNome)
                    .addComponent(jTId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLUsuario))
                .addGap(18, 18, 18)
                .addGroup(jPUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLUsuarioCadastro1)
                    .addComponent(jRSim)
                    .addComponent(jRNao))
                .addGap(18, 18, 18)
                .addGroup(jPUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSalvar)
                    .addComponent(jBCancelar)
                    .addComponent(jButton1))
                .addGap(64, 64, 64))
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

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
        );
        jDesktopPane1.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jPanelSenha.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Senha"));

        jPasswordFieldSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordFieldSenhaKeyPressed(evt);
            }
        });

        jLabelSenha.setText("Senha:");

        jLabelConfirmeSenha.setText("Confirme Senha:");

        jPasswordFieldConfirmeSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordFieldConfirmeSenhaKeyPressed(evt);
            }
        });

        jButtonSalvarSenha.setText("Salvar");
        jButtonSalvarSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarSenhaActionPerformed(evt);
            }
        });
        jButtonSalvarSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButtonSalvarSenhaKeyPressed(evt);
            }
        });

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelSenhaLayout = new javax.swing.GroupLayout(jPanelSenha);
        jPanelSenha.setLayout(jPanelSenhaLayout);
        jPanelSenhaLayout.setHorizontalGroup(
            jPanelSenhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSenhaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelSenhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelSenhaLayout.createSequentialGroup()
                        .addGroup(jPanelSenhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelConfirmeSenha)
                            .addComponent(jLabelSenha))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelSenhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPasswordFieldSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPasswordFieldConfirmeSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelSenhaLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jButtonSalvarSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonCancelar)
                        .addGap(22, 22, 22))))
        );
        jPanelSenhaLayout.setVerticalGroup(
            jPanelSenhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelSenhaLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanelSenhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSenha)
                    .addComponent(jPasswordFieldSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanelSenhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelConfirmeSenha)
                    .addComponent(jPasswordFieldConfirmeSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(jPanelSenhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSalvarSenha)
                    .addComponent(jButtonCancelar))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jBNovo)
                        .addGap(50, 50, 50)
                        .addComponent(jBExcluir))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanelSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBExcluir)
                    .addComponent(jBNovo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3))
        );

        setBounds(0, 0, 787, 538);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        if (modificador == 1) {
            jButtonSalvar.setText("Salvar");
            cadastrar();
        } else if (modificador == 2) {
            jButtonSalvar.setText("Editar");
            atualizar();
        }
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jBExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExcluirActionPerformed
        Usuario usuarioTemp = new Usuario();
        usuarioTemp.setUsuario(jTextFieldUsuario.getText());
        UsuarioDao dao = new UsuarioDao();
        dao.deletar(usuarioTemp);

        jPUsuario.setVisible(false);
        jBNovo.setEnabled(true);
        jBExcluir.setEnabled(false);
        preencherTabela();
        limparCanpos();
    }//GEN-LAST:event_jBExcluirActionPerformed

    private void jBNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBNovoActionPerformed
        if (modificador == 1) {
            jPUsuario.setVisible(true);
            jBNovo.setEnabled(false);
            jBExcluir.setEnabled(false);
            jBExcluir.setVisible(true);
            jButtonSalvar.setVisible(true);
            jButtonSalvar.setEnabled(true);
            limparCanpos();
            jButtonSalvar.setText("Salvar");
        } else {
            modificador = 1;
            jPUsuario.setVisible(true);
            jBNovo.setEnabled(false);
            jBExcluir.setEnabled(false);
            jBExcluir.setVisible(true);
            jButtonSalvar.setVisible(true);
            jButtonSalvar.setEnabled(true);
            limparCanpos();
            jButtonSalvar.setText("Salvar");
        }
        jTextFieldNome.requestFocus();
    }//GEN-LAST:event_jBNovoActionPerformed

    private void jBCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCancelarActionPerformed
        jPUsuario.setVisible(false);
        jPanelSenha.setVisible(false);
        jBNovo.setEnabled(true);
        jBExcluir.setEnabled(false);
        limparCanpos();
        modificador = 1;
        jLNome.setForeground(Color.black);
        jLUsuario.setForeground(Color.black);
    }//GEN-LAST:event_jBCancelarActionPerformed

    private void jTabelaUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaUsuarioMouseClicked

        if (evt.getClickCount() == 2) {
            intensSelecionado();
            jPUsuario.setVisible(true);
            jPanelSenha.setVisible(false);
            jBNovo.setEnabled(false);
            jBExcluir.setEnabled(true);
            jBExcluir.setVisible(true);
            modificador = 2;
            jButtonSalvar.setText("Editar");
            jLNome.setForeground(Color.black);
            jLUsuario.setForeground(Color.black);
        }
    }//GEN-LAST:event_jTabelaUsuarioMouseClicked

    private void timer1OnTime(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timer1OnTime

    }//GEN-LAST:event_timer1OnTime

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jPanelSenha.setVisible(true);
        jPUsuario.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        jPanelSenha.setVisible(false);
        jPUsuario.setEnabled(true);
        jPasswordFieldConfirmeSenha.setText("");
        jPasswordFieldSenha.setText("");
        jPUsuario.setVisible(true);
        jLabelSenha.setForeground(Color.BLACK);
        jLabelConfirmeSenha.setForeground(Color.BLACK);
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonSalvarSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarSenhaActionPerformed
        if (!new String(jPasswordFieldSenha.getPassword()).equals("")
                && !new String(jPasswordFieldConfirmeSenha.getPassword()).equals("")
                && new String(jPasswordFieldSenha.getPassword()).equals(new String(jPasswordFieldConfirmeSenha.getPassword()))) {
            jPanelSenha.setVisible(false);
            jPUsuario.setEnabled(true);
            jLabelSenha.setForeground(Color.BLACK);
            jLabelConfirmeSenha.setForeground(Color.BLACK);
            jPUsuario.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "As Senhas Não são Iguais");
            jLabelSenha.setForeground(Color.red);
            jLabelConfirmeSenha.setForeground(Color.red);
            jPUsuario.setVisible(true);
            jPanelSenha.setVisible(true);
            jPasswordFieldSenha.requestFocus();
        }
    }//GEN-LAST:event_jButtonSalvarSenhaActionPerformed

    private void jTextFieldNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNomeKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER && !jTextFieldNome.getText().equals("")) {
            jTextFieldUsuario.requestFocus();
            jLNome.setForeground(Color.BLACK);
        } else {
            jLNome.setForeground(Color.red);
        }
    }//GEN-LAST:event_jTextFieldNomeKeyPressed

    private void jTextFieldUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldUsuarioKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER && !jTextFieldUsuario.getText().equals("")) {
            jPanelSenha.setVisible(true);
            jPasswordFieldSenha.requestFocus();
            jLUsuario.setForeground(Color.BLACK);
        } else {
            jLUsuario.setForeground(Color.red);
        }
    }//GEN-LAST:event_jTextFieldUsuarioKeyPressed

    private void jPasswordFieldSenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordFieldSenhaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER && !jPasswordFieldSenha.getText().equals("")) {
            jPasswordFieldConfirmeSenha.requestFocus();
            jLabelSenha.setForeground(Color.BLACK);
        } else {
            jLabelSenha.setForeground(Color.red);
        }
    }//GEN-LAST:event_jPasswordFieldSenhaKeyPressed

    private void jPasswordFieldConfirmeSenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordFieldConfirmeSenhaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER && !jPasswordFieldConfirmeSenha.getText().equals("")) {
            jButtonSalvarSenha.requestFocus();
            jLabelConfirmeSenha.setForeground(Color.BLACK);
        } else {
            jLabelConfirmeSenha.setForeground(Color.red);
        }
    }//GEN-LAST:event_jPasswordFieldConfirmeSenhaKeyPressed

    private void jButtonSalvarSenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButtonSalvarSenhaKeyPressed
        if (!new String(jPasswordFieldSenha.getPassword()).equals("")
                && !new String(jPasswordFieldConfirmeSenha.getPassword()).equals("")
                && new String(jPasswordFieldSenha.getPassword()).equals(new String(jPasswordFieldConfirmeSenha.getPassword()))) {
            jPanelSenha.setVisible(false);
            jPUsuario.setEnabled(true);
            jLabelSenha.setForeground(Color.BLACK);
            jLabelConfirmeSenha.setForeground(Color.BLACK);
            jPUsuario.setVisible(true);
            jButtonSalvar.requestFocus();
        } else {
            JOptionPane.showMessageDialog(null, "As Senhas Não são Iguais");
            jLabelSenha.setForeground(Color.red);
            jLabelConfirmeSenha.setForeground(Color.red);
            jPUsuario.setVisible(true);
            jPanelSenha.setVisible(true);
            jPasswordFieldSenha.requestFocus();
        }
    }//GEN-LAST:event_jButtonSalvarSenhaKeyPressed

    private void jButtonSalvarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButtonSalvarKeyPressed
        if (modificador == 1) {
            jButtonSalvar.setText("Salvar");
            cadastrar();
        } else if (modificador == 2) {
            jButtonSalvar.setText("Editar");
            atualizar();
        }
    }//GEN-LAST:event_jButtonSalvarKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBCancelar;
    private javax.swing.JButton jBExcluir;
    private javax.swing.JButton jBNovo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JButton jButtonSalvarSenha;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLNome;
    private javax.swing.JLabel jLUsuario;
    private javax.swing.JLabel jLUsuarioCadastro1;
    private javax.swing.JLabel jLabelConfirmeSenha;
    private javax.swing.JLabel jLabelSenha;
    private javax.swing.JPanel jPUsuario;
    private javax.swing.JPanel jPanelSenha;
    private javax.swing.JPasswordField jPasswordFieldConfirmeSenha;
    private javax.swing.JPasswordField jPasswordFieldSenha;
    private javax.swing.JRadioButton jRNao;
    private javax.swing.JRadioButton jRSim;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTId;
    private javax.swing.JTable jTabelaUsuario;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldUsuario;
    private javax.swing.ButtonGroup rBStatus;
    private org.netbeans.examples.lib.timerbean.Timer timer1;
    // End of variables declaration//GEN-END:variables

    private void limparCanpos() {
        jTextFieldNome.setText("");
        jTextFieldUsuario.setText("");
        jPasswordFieldConfirmeSenha.setText("");
        jPasswordFieldSenha.setText("");
        jTId.setText("");
    }

    private void atualizar() {
        Usuario usuarioTemp = new Usuario();

        usuarioTemp.setNome(jTextFieldNome.getText());
        usuarioTemp.setUsuario(jTextFieldUsuario.getText());
        usuarioTemp.setSenha(new String(jPasswordFieldSenha.getPassword()));
        usuarioTemp.setCodigo(jTId.getText());
        usuarioTemp.setIdUsuarioAlt((ClassUtils.getIdUsuario()));

        usuarioTemp.setUltimaAlteracao(ClassUtils.setDateMsqy());

        if (jRSim.isSelected()) {
            usuarioTemp.setAtivo("Sim");
        } else if (jRNao.isSelected()) {
            usuarioTemp.setAtivo("Nao");
        }

        UsuarioDao dao = new UsuarioDao();
        dao.atualizar(usuarioTemp);
        limparCanpos();
        preencherTabela();

        jLabelSenha.setForeground(Color.BLACK);
        jLabelConfirmeSenha.setForeground(Color.BLACK);
        jPUsuario.setVisible(false);
        jPanelSenha.setVisible(false);
        jBNovo.setVisible(true);
        jBNovo.setEnabled(true);
        jBExcluir.setVisible(true);
        jBExcluir.setEnabled(false);
        jButtonSalvar.setVisible(true);
        limparCanpos();
    }

    private void cadastrar() {
        if (!jTextFieldNome.getText().equals("") && !jTextFieldUsuario.getText().equals("")) {
            if (!new String(jPasswordFieldSenha.getPassword()).equals("") && !new String(jPasswordFieldConfirmeSenha.getPassword()).equals("")) {

                Usuario usuarioTemp = new Usuario();
                usuarioTemp.setNome(jTextFieldNome.getText());
                usuarioTemp.setUsuario(jTextFieldUsuario.getText());
                usuarioTemp.setUltimaAlteracao(ClassUtils.setDateMsqy());
                usuarioTemp.setDataCadastro(ClassUtils.setDateMsqy());
                usuarioTemp.setSenha(new String(jPasswordFieldSenha.getPassword()));
                usuarioTemp.setIdUsuarioCad((ClassUtils.getIdUsuario()));
                usuarioTemp.setIdUsuarioAlt(ClassUtils.getIdUsuario());

                if (jRSim.isSelected()) {
                    usuarioTemp.setAtivo("Sim");
                } else if (jRNao.isSelected()) {
                    usuarioTemp.setAtivo("Não");
                }
                UsuarioDao dao = new UsuarioDao();
                dao.cadastrarUsuario(usuarioTemp);
                limparCanpos();
                jPUsuario.setVisible(false);
                jPanelSenha.setVisible(false);
                jBNovo.setEnabled(true);
                jBExcluir.setEnabled(false);
                jLabelSenha.setForeground(Color.BLACK);
                jLabelConfirmeSenha.setForeground(Color.BLACK);
                preencherTabela();

            } else {
                JOptionPane.showMessageDialog(null, "Necessario Cadastrar Uma Senha!");
                jPUsuario.setVisible(true);
                jPanelSenha.setVisible(true);
                jLNome.setForeground(Color.red);
                jLUsuario.setForeground(Color.red);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nenhun campo pode ser vazio!");
            jLNome.setForeground(Color.red);
            jLUsuario.setForeground(Color.red);
        }
    }

    private void preencherTabela() {

        String[] Colunas = new String[]{"Nome", "Usuário", "Data Castro", "Última Alteração", "Ativo", "Logado Em"};

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

        jTabelaUsuario.getColumnModel().getColumn(5).setPreferredWidth(200);
        jTabelaUsuario.getColumnModel().getColumn(5).setResizable(false);

        jTabelaUsuario.getTableHeader().setReorderingAllowed(false);
        jTabelaUsuario.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jTabelaUsuario.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    }

}
