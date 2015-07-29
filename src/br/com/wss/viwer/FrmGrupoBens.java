/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wss.viwer;

import br.com.wss.utilidades.ClassUtils;
import br.com.wss.dao.GrupoDao;
import br.com.wss.modelo.Grupo;
import br.com.wss.tabelas.Tabela;
import br.com.wss.tabelas.TabelaGrupo;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

/**
 *
 * @author William
 */
public final class FrmGrupoBens extends javax.swing.JInternalFrame {

    ArrayList<Grupo> dados;
    int modificador = 1;

    /**
     * Creates new form FrmGrupoBens
     */
    public FrmGrupoBens() {
        initComponents();
        jPanelGrupos.setVisible(false);
        jTId.setVisible(false);
        jButtonExcluir.setVisible(false);
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

        jPanelGrupos = new javax.swing.JPanel();
        jButtonSalvar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldGrupo = new javax.swing.JTextField();
        jTextFieldDescricao = new javax.swing.JTextField();
        jTId = new javax.swing.JTextField();
        jButtonNovo = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableGrupo = new javax.swing.JTable();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setClosable(true);
        setIconifiable(true);
        setTitle("Cadastro de Grupo");
        setEnabled(false);

        jPanelGrupos.setBorder(javax.swing.BorderFactory.createTitledBorder("Grupo"));

        jButtonSalvar.setText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jLabel1.setText("Grupo:");

        jLabel2.setText("Decrição:");

        jTId.setEditable(false);
        jTId.setText("iD");

        javax.swing.GroupLayout jPanelGruposLayout = new javax.swing.GroupLayout(jPanelGrupos);
        jPanelGrupos.setLayout(jPanelGruposLayout);
        jPanelGruposLayout.setHorizontalGroup(
            jPanelGruposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGruposLayout.createSequentialGroup()
                .addGroup(jPanelGruposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelGruposLayout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jButtonSalvar)
                        .addGap(53, 53, 53)
                        .addComponent(jButtonCancelar))
                    .addGroup(jPanelGruposLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelGruposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelGruposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldGrupo)
                            .addComponent(jTextFieldDescricao, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)))
                    .addGroup(jPanelGruposLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTId, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanelGruposLayout.setVerticalGroup(
            jPanelGruposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelGruposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelGruposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelGruposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelGruposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSalvar)
                    .addComponent(jButtonCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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

        jTableGrupo.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableGrupo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableGrupoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableGrupo);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 710, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
        );
        jDesktopPane1.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelGrupos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonNovo)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonExcluir)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.Alignment.TRAILING)
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
                .addComponent(jPanelGrupos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoActionPerformed
        if (modificador == 1) {
            jPanelGrupos.setVisible(true);
            jButtonExcluir.setEnabled(false);

            jButtonSalvar.setVisible(true);
            jButtonSalvar.setText("Salvar");
            limparCampos();
        } else {
            modificador = 1;
            jPanelGrupos.setVisible(true);
            jButtonExcluir.setEnabled(false);

            jButtonSalvar.setVisible(true);
            jButtonSalvar.setText("Salvar");
            limparCampos();
        }
    }//GEN-LAST:event_jButtonNovoActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        jPanelGrupos.setVisible(false);
        jButtonExcluir.setEnabled(false);
        jButtonNovo.setEnabled(true);
        limparCampos();
        modificador = 1;

    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jTableGrupoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableGrupoMouseClicked
        if (evt.getClickCount() == 2) {
            itensSelecionados();
            jButtonNovo.setEnabled(false);
            jButtonExcluir.setEnabled(true);
            jPanelGrupos.setVisible(true);

            jButtonSalvar.setVisible(true);
            jButtonExcluir.setVisible(true);
            modificador = 2;
            jButtonSalvar.setText("Editar");
        }
    }//GEN-LAST:event_jTableGrupoMouseClicked

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        Grupo grupoTemp = new Grupo();
        grupoTemp.setIdGrupo(Integer.parseInt(jTId.getText()));

        GrupoDao dao = new GrupoDao();
        dao.deletar(grupoTemp);

        jPanelGrupos.setVisible(false);
        jButtonNovo.setEnabled(true);
        jButtonExcluir.setEnabled(false);
        limparCampos();
        preencherTabela();

    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        if (modificador == 1) {
            jButtonSalvar.setText("Salvar");
            cadastrar();
        } else if (modificador == 2) {
            jButtonSalvar.setText("Editar");
            atualizar();
        }


    }//GEN-LAST:event_jButtonSalvarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonNovo;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanelGrupos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTId;
    private javax.swing.JTable jTableGrupo;
    private javax.swing.JTextField jTextFieldDescricao;
    private javax.swing.JTextField jTextFieldGrupo;
    // End of variables declaration//GEN-END:variables

    private void itensSelecionados() {
        int seleciona = jTableGrupo.getSelectedRow();

        jTId.setText(String.valueOf(dados.get(seleciona).getIdGrupo()));
        jTextFieldGrupo.setText(dados.get(seleciona).getNomeGrupo());
        jTextFieldDescricao.setText(dados.get(seleciona).getDescricao());

    }

    private void preencherTabela() {

        String[] Colunas = new String[]{"Grupo", "Descrição", "Data Cadastro", "Última Auteração"};

        GrupoDao grupoDao = new GrupoDao();
        dados = grupoDao.listar();

        Tabela modelo = new TabelaGrupo(dados, Colunas);
        jTableGrupo.setModel(modelo);

        jTableGrupo.getColumnModel().getColumn(0).setPreferredWidth(275);
        jTableGrupo.getColumnModel().getColumn(0).setResizable(false);

        jTableGrupo.getColumnModel().getColumn(1).setPreferredWidth(200);
        jTableGrupo.getColumnModel().getColumn(1).setResizable(false);

        jTableGrupo.getColumnModel().getColumn(2).setPreferredWidth(350);
        jTableGrupo.getColumnModel().getColumn(2).setResizable(false);

        jTableGrupo.getColumnModel().getColumn(3).setPreferredWidth(350);
        jTableGrupo.getColumnModel().getColumn(3).setResizable(false);

        jTableGrupo.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jTableGrupo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    }

    private void limparCampos() {
        jTextFieldDescricao.setText("");
        jTextFieldGrupo.setText("");
    }

    private void cadastrar() {
        if (!jTextFieldGrupo.getText().equals("")) {

            Grupo grupoTemp = new Grupo();

            grupoTemp.setNomeGrupo(jTextFieldGrupo.getText());
            grupoTemp.setDescricao(jTextFieldDescricao.getText());
            grupoTemp.setUltimaAlteracao(ClassUtils.setDateMsqy());
            grupoTemp.setDataCadastro(ClassUtils.setDateMsqy());
            grupoTemp.setUsuarioCad((ClassUtils.getIdUsuario()));
            grupoTemp.setUsuarioAlt((ClassUtils.getIdUsuario()));

            GrupoDao dao = new GrupoDao();
            dao.cadastrarGrupo(grupoTemp);

            jButtonNovo.setEnabled(true);
            jButtonExcluir.setEnabled(false);
            limparCampos();
            preencherTabela();
            jPanelGrupos.setVisible(false);
            jButtonNovo.setEnabled(true);
        jButtonExcluir.setEnabled(false);

        } else {
            JOptionPane.showMessageDialog(null, "Nenhun campo pode ser vazio!");
            repaint();
        }
    }

    private void atualizar() {
        Grupo grupoTemp = new Grupo();

        grupoTemp.setNomeGrupo(jTextFieldGrupo.getText());
        grupoTemp.setDescricao(jTextFieldDescricao.getText());
        grupoTemp.setIdGrupo(Integer.parseInt(jTId.getText()));
        grupoTemp.setUltimaAlteracao(ClassUtils.setDateMsqy());
        grupoTemp.setUsuarioAlt((ClassUtils.getIdUsuario()));

        GrupoDao dao = new GrupoDao();
        dao.atualizar(grupoTemp);

        preencherTabela();

        jPanelGrupos.setVisible(false);
        jButtonNovo.setEnabled(true);
        jButtonExcluir.setEnabled(false);
    }
}
