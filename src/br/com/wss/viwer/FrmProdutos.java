/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wss.viwer;

import br.com.wss.dao.ProdutoDao;
import br.com.wss.modelo.Produto;
import br.com.wss.tabelas.Tabela;
import br.com.wss.tabelas.TabelaProduto;
import br.com.wss.utilidades.ClassUtils;
import br.com.wss.utilidades.FormatDouble;
import br.com.wss.utilidades.NumeroMaximoCaracters;
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
public class FrmProdutos extends javax.swing.JInternalFrame {

    int modificador = 1;
    Produto produtoTemp = new Produto();
    ProdutoDao produtoDao = new ProdutoDao();
    ArrayList<Produto> dados;

    /**
     * Creates new form FrmProdutos
     */
    public FrmProdutos() {
        initComponents();
        jTextFieldIdProduto.setVisible(false);
        jDateChooserValidade.setEnabled(false);
        jDateChooserValidade.setDate(new Date());
        jDateChooserValidade.getCalendarButton().setEnabled(true);
        preecherComboStatus();
        preencherTabela();
        jPanelProdutos.setVisible(false);
        validaCampos();
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
        jPanelProdutos = new javax.swing.JPanel();
        jLabelDescricao = new javax.swing.JLabel();
        jLabelValidade = new javax.swing.JLabel();
        jLabelValor = new javax.swing.JLabel();
        jLabelDesconto = new javax.swing.JLabel();
        jTextFieldDesconto = new javax.swing.JTextField();
        jDateChooserValidade = new com.toedter.calendar.JDateChooser();
        jLabelStatus = new javax.swing.JLabel();
        jComboBoxStatus = new javax.swing.JComboBox();
        jButtonSalvar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jTextFieldIdProduto = new javax.swing.JTextField();
        jTextFieldDescricao = new javax.swing.JTextField();
        jTextFieldValor = new javax.swing.JTextField();
        jButtonExcluir = new javax.swing.JButton();
        jButtonNovo = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Produtos");

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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 796, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
        );
        jDesktopPane1.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jPanelProdutos.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Produtos"));
        jPanelProdutos.setLayout(null);

        jLabelDescricao.setText("Descrição:");
        jPanelProdutos.add(jLabelDescricao);
        jLabelDescricao.setBounds(10, 20, 80, 20);

        jLabelValidade.setText("Validade:");
        jPanelProdutos.add(jLabelValidade);
        jLabelValidade.setBounds(10, 50, 80, 20);

        jLabelValor.setText("Valor:");
        jPanelProdutos.add(jLabelValor);
        jLabelValor.setBounds(10, 80, 80, 20);

        jLabelDesconto.setText("Desconto:");
        jPanelProdutos.add(jLabelDesconto);
        jLabelDesconto.setBounds(10, 110, 80, 20);

        jTextFieldDesconto.setText("jTextField1");
        jTextFieldDesconto.setSelectionEnd(0);
        jTextFieldDesconto.setSelectionStart(0);
        jPanelProdutos.add(jTextFieldDesconto);
        jTextFieldDesconto.setBounds(100, 110, 200, 26);
        jPanelProdutos.add(jDateChooserValidade);
        jDateChooserValidade.setBounds(100, 50, 200, 26);

        jLabelStatus.setText("Status:");
        jPanelProdutos.add(jLabelStatus);
        jLabelStatus.setBounds(10, 140, 80, 20);

        jComboBoxStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanelProdutos.add(jComboBoxStatus);
        jComboBoxStatus.setBounds(100, 140, 200, 26);

        jButtonSalvar.setText("Variavel");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });
        jPanelProdutos.add(jButtonSalvar);
        jButtonSalvar.setBounds(100, 180, 80, 26);

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });
        jPanelProdutos.add(jButtonCancelar);
        jButtonCancelar.setBounds(220, 180, 80, 26);

        jTextFieldIdProduto.setText("Id");
        jPanelProdutos.add(jTextFieldIdProduto);
        jTextFieldIdProduto.setBounds(10, 180, 40, 30);

        jTextFieldDescricao.setText("jTextField1");
        jPanelProdutos.add(jTextFieldDescricao);
        jTextFieldDescricao.setBounds(100, 20, 200, 26);

        jTextFieldValor.setText("jTextField1");
        jPanelProdutos.add(jTextFieldValor);
        jTextFieldValor.setBounds(100, 80, 200, 26);

        jButtonExcluir.setText("Excluir");
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        jButtonNovo.setText("Novo");
        jButtonNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jButtonExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane1)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoActionPerformed
        if (modificador == 1) {
            jPanelProdutos.setVisible(true);
            jButtonExcluir.setEnabled(false);
            jButtonNovo.setEnabled(false);
            limparCampos();
            jButtonSalvar.setText("Salvar");
        } else {
            modificador = 1;
            jPanelProdutos.setVisible(true);
            jButtonExcluir.setEnabled(false);
            jButtonNovo.setEnabled(false);
            limparCampos();
            jButtonSalvar.setText("Salvar");
        }
    }//GEN-LAST:event_jButtonNovoActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        deletar();
    }//GEN-LAST:event_jButtonExcluirActionPerformed

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

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        jPanelProdutos.setVisible(false);
        jButtonNovo.setEnabled(true);
        jButtonExcluir.setEnabled(false);
        limparCampos();
        modificador = 1;
        modificadorCampos();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        if (evt.getClickCount() == 2) {
            try {
                itensSelecionados();
            } catch (Exception ex) {
                Logger.getLogger(FrmBens.class.getName()).log(Level.SEVERE, null, ex);
            }
            jPanelProdutos.setVisible(true);
            jButtonNovo.setEnabled(false);
            jButtonExcluir.setEnabled(true);
            modificador = 2;
            jButtonSalvar.setText("Editar");
        }
    }//GEN-LAST:event_jTable1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonNovo;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JComboBox jComboBoxStatus;
    private com.toedter.calendar.JDateChooser jDateChooserValidade;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabelDesconto;
    private javax.swing.JLabel jLabelDescricao;
    private javax.swing.JLabel jLabelStatus;
    private javax.swing.JLabel jLabelValidade;
    private javax.swing.JLabel jLabelValor;
    private javax.swing.JPanel jPanelProdutos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldDesconto;
    private javax.swing.JTextField jTextFieldDescricao;
    private javax.swing.JTextField jTextFieldIdProduto;
    private javax.swing.JTextField jTextFieldValor;
    // End of variables declaration//GEN-END:variables

    private void limparCampos() {
        jTextFieldDesconto.setText("");
        jTextFieldDescricao.setText("");
        jTextFieldValor.setText("");
        jComboBoxStatus.setSelectedIndex(0);
    }

    private void deletar() {
        produtoTemp.setIdProduto(Integer.parseInt(jTextFieldIdProduto.getText()));

        produtoDao.deletar(produtoTemp);
        limparCampos();
        preencherTabela();
        jPanelProdutos.setVisible(false);
        jButtonNovo.setEnabled(true);
        jButtonExcluir.setEnabled(false);
        modificador = 1;
    }

    private void cadastrar() {
        if (jComboBoxStatus.getSelectedIndex() != 0 && !jTextFieldDescricao.getText().equals("")
                && !jTextFieldValor.getText().equals("")) {
            produtoTemp.setDescricao(jTextFieldDescricao.getText());
            produtoTemp.setDesconto(jTextFieldDesconto.getText());
            produtoTemp.setStatus((String) jComboBoxStatus.getSelectedItem());
            produtoTemp.setValidade(ClassUtils.setDateChooserMysql(jDateChooserValidade));
            produtoTemp.setValor(Double.parseDouble(jTextFieldValor.getText()));
            produtoTemp.setDataCadastro(ClassUtils.setDateMsqy());
            produtoTemp.setUltimaAlteracao(ClassUtils.setDateMsqy());
            produtoTemp.setIdUsuarioAlt(ClassUtils.getIdUsuario());
            produtoTemp.setIdUsuarioCad(ClassUtils.getIdUsuario());

            produtoDao.cadastrar(produtoTemp);
            limparCampos();
            modificadorCampos();
            preencherTabela();
            jPanelProdutos.setVisible(false);
            jButtonNovo.setEnabled(true);
            jButtonExcluir.setEnabled(false);

        } else {
            jLabelDescricao.setForeground(Color.red);
            jLabelStatus.setForeground(Color.red);
            jLabelValor.setForeground(Color.red);
        }
    }

    private void editar() {
        if (jComboBoxStatus.getSelectedIndex() != 0 && !jTextFieldDescricao.getText().equals("")
                && !jTextFieldValor.getText().equals("")) {
            produtoTemp.setDescricao(jTextFieldDescricao.getText());
            produtoTemp.setDesconto(jTextFieldDesconto.getText());
            produtoTemp.setStatus((String) jComboBoxStatus.getSelectedItem());
            produtoTemp.setValidade(ClassUtils.setDateChooserMysql(jDateChooserValidade));
            produtoTemp.setValor(Double.parseDouble(jTextFieldValor.getText()));
            produtoTemp.setUltimaAlteracao(ClassUtils.setDateMsqy());
            produtoTemp.setIdUsuarioAlt(ClassUtils.getIdUsuario());
            produtoTemp.setIdProduto(Integer.parseInt(jTextFieldIdProduto.getText()));

            produtoDao.editar(produtoTemp);
            limparCampos();
            modificadorCampos();
            preencherTabela();
            jPanelProdutos.setVisible(false);
            jButtonNovo.setEnabled(true);
            jButtonExcluir.setEnabled(false);

        } else {
            jLabelDescricao.setForeground(Color.red);
            jLabelStatus.setForeground(Color.red);
            jLabelValor.setForeground(Color.red);
        }
    }

    private void modificadorCampos() {
        jLabelDesconto.setForeground(Color.BLACK);
        jLabelDescricao.setForeground(Color.BLACK);
        jLabelStatus.setForeground(Color.BLACK);
        jLabelValidade.setForeground(Color.BLACK);
        jLabelValor.setForeground(Color.BLACK);
    }

    private void preecherComboStatus() {
        jComboBoxStatus.removeAllItems();
        jComboBoxStatus.addItem("");
        jComboBoxStatus.addItem("Sim");
        jComboBoxStatus.addItem("Não");
    }

    private void preencherTabela() {
        String[] Colunas = new String[]{"Produto", "Validade", "Ativo", "Data Cadastro", "Ultima Alteração"};
        ProdutoDao produtoDaoTabela = new ProdutoDao();
        dados = produtoDaoTabela.listar();
        Tabela modelo = new TabelaProduto(dados, Colunas);

        jTable1.setModel(modelo);

        jTable1.getColumnModel().getColumn(0).setPreferredWidth(250);
        jTable1.getColumnModel().getColumn(0).setResizable(false);

        jTable1.getColumnModel().getColumn(1).setPreferredWidth(100);
        jTable1.getColumnModel().getColumn(1).setResizable(false);

        jTable1.getColumnModel().getColumn(2).setPreferredWidth(50);
        jTable1.getColumnModel().getColumn(2).setResizable(false);

        jTable1.getColumnModel().getColumn(3).setPreferredWidth(325);
        jTable1.getColumnModel().getColumn(3).setResizable(false);

        jTable1.getColumnModel().getColumn(4).setPreferredWidth(325);
        jTable1.getColumnModel().getColumn(4).setResizable(false);

        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    private void itensSelecionados() {
        limparCampos();
        int seleciona = jTable1.getSelectedRow();
        jTextFieldDesconto.setText(dados.get(seleciona).getDesconto());
        jTextFieldDescricao.setText(dados.get(seleciona).getDescricao());
        jTextFieldIdProduto.setText(String.valueOf(dados.get(seleciona).getIdProduto()));
        jTextFieldValor.setText(String.valueOf(dados.get(seleciona).getValor()));
        jComboBoxStatus.setSelectedItem(dados.get(seleciona).getStatus());

        modificador = 2;
        modificadorCampos();
    }

    private void validaCampos() {
        jTextFieldDesconto.setDocument(new FormatDouble(3));
        jTextFieldDescricao.setDocument(new NumeroMaximoCaracters(45));
        jTextFieldValor.setDocument(new FormatDouble(9));
    }
}
