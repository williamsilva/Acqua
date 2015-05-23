/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import DAO.*;
import MODELO.ModeloTabela;
import MODELO.modelUsuario;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

/**
 *
 * @author WILLIAM
 */
public final class FrmUsuario extends javax.swing.JInternalFrame {

    ConectionFactory conecta = new ConectionFactory();
    String usuario = "";
    String usuarioSenha = "";

    /**
     * Creates new form FrmUsuario
     */
    public FrmUsuario() {
        init();

        conecta.conexao();
        preencherTabela();
        jBExcluir.setEnabled(false);
        jPEditar.setVisible(false);
       
    }

    private void init() {
        initComponents();
        timer1.start();
    }

    public void intensSelecionado() {
        int seleciona = jTabelaUsuario.getSelectedRow();
        jTNome.setText(jTabelaUsuario.getModel().getValueAt(seleciona, 0).toString());
        jTUsuario.setText(jTabelaUsuario.getModel().getValueAt(seleciona, 1).toString());

    }


    public void preencherTabela() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Nome", "Usuário", "Data Castro", "Última Auteração", "Ativo"};

        conecta.executaSQL("select * from login order by Nome");
        try {
            conecta.rs.first();
            do {
                dados.add(new Object[]{
                    conecta.rs.getString("Nome"),
                    conecta.rs.getString("Login"),
                    conecta.rs.getString("data_Cadastro"),
                    conecta.rs.getString("ultima_Auteracao"),
                    conecta.rs.getString("Ativo"),
                    conecta.rs.getString("Senha")});

            } while (conecta.rs.next());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaUsuario.setModel(modelo);

        jTabelaUsuario.getColumnModel().getColumn(0).setPreferredWidth(300);
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
        jLSenhaCadastro = new javax.swing.JLabel();
        jLConfirmaSenhaCadastro = new javax.swing.JLabel();
        jPConfirmeSenha = new javax.swing.JPasswordField();
        jPSenha = new javax.swing.JPasswordField();
        jRSim = new javax.swing.JRadioButton();
        jRNao = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jBEditar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jBExcluir = new javax.swing.JButton();
        jBNovo = new javax.swing.JButton();

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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
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

        jButton2.setText("Teste");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPEditarLayout = new javax.swing.GroupLayout(jPEditar);
        jPEditar.setLayout(jPEditarLayout);
        jPEditarLayout.setHorizontalGroup(
            jPEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPEditarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPEditarLayout.createSequentialGroup()
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
                                    .addComponent(jTNome, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPConfirmeSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPEditarLayout.createSequentialGroup()
                                        .addComponent(jPSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(62, 62, 62)
                                        .addComponent(jButton1))))
                            .addGroup(jPEditarLayout.createSequentialGroup()
                                .addComponent(jRSim)
                                .addGap(18, 18, 18)
                                .addComponent(jRNao)
                                .addGap(31, 31, 31)
                                .addComponent(jBEditar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBSalvar)
                                .addGap(18, 18, 18)
                                .addComponent(jBCancelar)))
                        .addContainerGap(45, Short.MAX_VALUE))
                    .addGroup(jPEditarLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(61, 61, 61))))
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
                    .addComponent(jLSenhaCadastro)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLConfirmaSenhaCadastro)
                    .addComponent(jPConfirmeSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPEditarLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBSalvar)
                            .addComponent(jBEditar)
                            .addComponent(jBCancelar)))
                    .addGroup(jPEditarLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jButton2))
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
                .addGap(60, 401, Short.MAX_VALUE))
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
                .addComponent(jPEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setBounds(0, 0, 989, 485);
    }// </editor-fold>//GEN-END:initComponents

    private void jBSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalvarActionPerformed

        if (!jTNome.getText().equals("") && !jTUsuario.getText().equals("") && !new String(jPSenha.getPassword()).equals("")) {

            modelUsuario usuarioTemp = new modelUsuario();
            usuarioTemp.setSenha(new String(jPSenha.getPassword()));
            usuarioTemp.setNome(jTNome.getText());
            usuarioTemp.setUsuario(jTUsuario.getText());
            usuarioTemp.setUltima_auteracao("Em "+ClassUtiuls.mostraHoraData()+" Por ");
            usuarioTemp.setData_cadastro("Em "+ClassUtiuls.mostraHoraData()+" Por ");

            if (jRSim.isSelected()) {
                usuarioTemp.setAtivo("Sim");
            } else if (jRNao.isSelected()) {
                usuarioTemp.setAtivo("Não");
            }
            if (new String(jPSenha.getPassword()).equals(new String(jPConfirmeSenha.getPassword()))) {
                usuarioDao dao = new usuarioDao();
                dao.cadastrarUsuario(usuarioTemp);
                limparCanpos();
                jPEditar.setVisible(false);
                jBNovo.setEnabled(true);
                jBExcluir.setEnabled(false);
                preencherTabela();

            } else {
                JOptionPane.showMessageDialog(null, "As senhas não são iguais!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nenhun campo pode ser vazio!");
        }
    }//GEN-LAST:event_jBSalvarActionPerformed

    private void jBExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExcluirActionPerformed

        modelUsuario usuarioTemp = new modelUsuario();
        usuarioTemp.setUsuario(jTUsuario.getText());
        usuarioDao dao = new usuarioDao();
        dao.deletar(usuarioTemp);

        jPEditar.setVisible(false);
        jBNovo.setEnabled(true);
        jBExcluir.setEnabled(false);
        preencherTabela();
        limparCanpos();
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

//        try {
//
//            PreparedStatement pst = conecta.conn.prepareStatement("update login set  nome =?,senha = ?,ativo=?,ultima_auteracao =?,login = ?");
//
//            pst.setString(1, jTNome.getText());
//            if (new String(jPSenha.getPassword()).equals(new String(jPConfirmeSenha.getPassword()))) {
//                pst.setString(2, new String(jPSenha.getPassword()));
//            } else {
//                JOptionPane.showMessageDialog(null, "As senhas não corresponde");
//            }
//            if (jRSim.isSelected()) {
//                pst.setString(3, "Sim");
//            } else if (jRNao.isSelected()) {
//                pst.setString(3, "Nao");
//            }
//            pst.setString(4, "Em " + jTdataHora.getText() + "Por " + jLUsuario1.getText());
//            pst.setString(5, jTUsuario.getText());
//
//            pst.execute();
//            JOptionPane.showMessageDialog(null, "Dados Atualizados com sucesso!");
//            preencherTabela();
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, "Erro ao Atualizar!\n Erro: " + e.getMessage());
//
//        }
        modelUsuario usuarioTemp = new modelUsuario();
        //usuarioTemp.setSenha(new String(jPSenha.getPassword()));
        usuarioTemp.setNome(jTNome.getText());
        usuarioTemp.setUsuario(jTUsuario.getText());
        // usuarioTemp.setUltima_auteracao("Em "+ClassUtiuls.mostraHoraData()+" Por ");

        if (jRSim.isSelected()) {
            usuarioTemp.setAtivo("Sim");
        } else if (jRNao.isSelected()) {
            usuarioTemp.setAtivo("Nao");
        }

        usuarioDao dao = new usuarioDao();
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
        senha.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBCancelar;
    private javax.swing.JButton jBEditar;
    private javax.swing.JButton jBExcluir;
    private javax.swing.JButton jBNovo;
    private javax.swing.JButton jBSalvar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLConfirmaSenhaCadastro;
    private javax.swing.JLabel jLNomeCadastro;
    private javax.swing.JLabel jLSenhaCadastro;
    private javax.swing.JLabel jLUsuarioCadastro;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.ButtonGroup rBStatus;
    private org.netbeans.examples.lib.timerbean.Timer timer1;
    // End of variables declaration//GEN-END:variables

    public void limparCanpos() {
        jTNome.setText("");
        jTUsuario.setText("");
        jPConfirmeSenha.setText("");
        jPSenha.setText("");
    }
}
