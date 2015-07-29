/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wss.viwer;

import br.com.wss.dao.CidadeDao;
import br.com.wss.dao.EstadoDao;
import br.com.wss.dao.FornecedorDao;
import br.com.wss.modelo.Fornecedor;
import br.com.wss.tabelas.Tabela;
import br.com.wss.tabelas.TabelaFornecedor;
import br.com.wss.utilidades.ClassUtils;
import br.com.wss.utilidades.NumeroMaximoCaracters;
import br.com.wss.utilidades.SomenteNumero;
import java.awt.Color;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

/**
 *
 * @author William
 */
public class FrmFornecedor extends javax.swing.JInternalFrame {

    int modificador = 1;
    String idEstado;
    CidadeDao cidadeDao = new CidadeDao();
    EstadoDao estadoDao = new EstadoDao();
    FornecedorDao fornecedorDao = new FornecedorDao();
    Fornecedor fornecedorTemp = new Fornecedor();
    ArrayList<Fornecedor> dados;

    /**
     * Creates new form FrmFornecedor
     */
    public FrmFornecedor() {
        initComponents();
        preencherComboEstado();
        preencherTabela();
        jPanel2.setVisible(false);
        jButtonExcluir.setEnabled(false);
        jComboBoxCidade.setEnabled(false);
        jComboBoxCidade.removeAllItems();
        jComboBoxCidade.addItem("Selecione uma Cidade");
        jTextFieldIdFornecedor.setVisible(false);
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
        jTableFornecedor = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabelFornecedor = new javax.swing.JLabel();
        jTextFieldFornecedor = new javax.swing.JTextField();
        jLabelContato = new javax.swing.JLabel();
        jTextFieldContato = new javax.swing.JTextField();
        jButtonSalvar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jLabelTelefone = new javax.swing.JLabel();
        jTextFieldTelefone = new javax.swing.JTextField();
        jTextFieldCelular = new javax.swing.JTextField();
        jLabelCelular = new javax.swing.JLabel();
        jLabelEstado = new javax.swing.JLabel();
        jLabelCidade = new javax.swing.JLabel();
        jLabelBairro = new javax.swing.JLabel();
        jTextFieldBairro = new javax.swing.JTextField();
        jLabelNumero = new javax.swing.JLabel();
        jTextFieldNumero = new javax.swing.JTextField();
        jComboBoxCidade = new javax.swing.JComboBox();
        jComboBoxEstado = new javax.swing.JComboBox();
        jLabelEmail = new javax.swing.JLabel();
        jTextFieldEmail = new javax.swing.JTextField();
        jTextFieldEndereco = new javax.swing.JTextField();
        jLabelEndereco = new javax.swing.JLabel();
        jLabelCep = new javax.swing.JLabel();
        jTextFieldCep = new javax.swing.JTextField();
        jTextFieldIdFornecedor = new javax.swing.JTextField();
        jButtonNovo = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setClosable(true);
        setIconifiable(true);
        setTitle("Cadastro Fornecedor");
        setEnabled(false);

        jTableFornecedor.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableFornecedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableFornecedorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableFornecedor);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
        );
        jDesktopPane1.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Fornecedor"));
        jPanel2.setLayout(null);

        jLabelFornecedor.setText("Fornecedor:");
        jPanel2.add(jLabelFornecedor);
        jLabelFornecedor.setBounds(20, 29, 70, 20);
        jPanel2.add(jTextFieldFornecedor);
        jTextFieldFornecedor.setBounds(100, 29, 190, 26);

        jLabelContato.setText("Contato:");
        jPanel2.add(jLabelContato);
        jLabelContato.setBounds(20, 60, 70, 20);
        jPanel2.add(jTextFieldContato);
        jTextFieldContato.setBounds(100, 60, 190, 26);

        jButtonSalvar.setText("Variavel");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonSalvar);
        jButtonSalvar.setBounds(100, 190, 71, 23);

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonCancelar);
        jButtonCancelar.setBounds(210, 190, 80, 23);

        jLabelTelefone.setText("Telefone:");
        jPanel2.add(jLabelTelefone);
        jLabelTelefone.setBounds(20, 90, 70, 20);
        jPanel2.add(jTextFieldTelefone);
        jTextFieldTelefone.setBounds(100, 90, 190, 26);
        jPanel2.add(jTextFieldCelular);
        jTextFieldCelular.setBounds(100, 120, 190, 26);

        jLabelCelular.setText("Celular:");
        jPanel2.add(jLabelCelular);
        jLabelCelular.setBounds(20, 120, 70, 20);

        jLabelEstado.setText("Estado:");
        jPanel2.add(jLabelEstado);
        jLabelEstado.setBounds(310, 29, 70, 20);

        jLabelCidade.setText("Cidade:");
        jPanel2.add(jLabelCidade);
        jLabelCidade.setBounds(310, 60, 70, 20);

        jLabelBairro.setText("Bairro:");
        jPanel2.add(jLabelBairro);
        jLabelBairro.setBounds(310, 90, 70, 20);
        jPanel2.add(jTextFieldBairro);
        jTextFieldBairro.setBounds(390, 90, 190, 26);

        jLabelNumero.setText("Numero:");
        jPanel2.add(jLabelNumero);
        jLabelNumero.setBounds(310, 150, 70, 20);
        jPanel2.add(jTextFieldNumero);
        jTextFieldNumero.setBounds(390, 150, 190, 26);

        jComboBoxCidade.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(jComboBoxCidade);
        jComboBoxCidade.setBounds(390, 60, 190, 26);

        jComboBoxEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxEstado.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jComboBoxEstadoPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        jPanel2.add(jComboBoxEstado);
        jComboBoxEstado.setBounds(390, 30, 190, 26);

        jLabelEmail.setText("E-mail:");
        jPanel2.add(jLabelEmail);
        jLabelEmail.setBounds(20, 150, 70, 20);
        jPanel2.add(jTextFieldEmail);
        jTextFieldEmail.setBounds(100, 150, 190, 26);
        jPanel2.add(jTextFieldEndereco);
        jTextFieldEndereco.setBounds(390, 120, 190, 26);

        jLabelEndereco.setText("Endereço:");
        jPanel2.add(jLabelEndereco);
        jLabelEndereco.setBounds(310, 120, 70, 20);

        jLabelCep.setText("Cep:");
        jPanel2.add(jLabelCep);
        jLabelCep.setBounds(310, 180, 70, 20);
        jPanel2.add(jTextFieldCep);
        jTextFieldCep.setBounds(390, 180, 190, 26);

        jTextFieldIdFornecedor.setText("ID");
        jPanel2.add(jTextFieldIdFornecedor);
        jTextFieldIdFornecedor.setBounds(20, 190, 50, 30);

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
                .addGap(18, 18, 18)
                .addComponent(jButtonExcluir)
                .addGap(545, 719, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 599, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoActionPerformed
        if (modificador == 1) {
            jPanel2.setVisible(true);
            jButtonExcluir.setEnabled(false);
            jButtonNovo.setEnabled(false);
            limparCampos();
            jButtonSalvar.setText("Salvar");
        } else {
            modificador = 1;
            jPanel2.setVisible(true);
            jButtonExcluir.setEnabled(false);
            jButtonNovo.setEnabled(false);
            limparCampos();
            jButtonSalvar.setText("Salvar");
        }
    }//GEN-LAST:event_jButtonNovoActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        jPanel2.setVisible(false);
        jButtonNovo.setEnabled(true);
        jButtonExcluir.setEnabled(false);
        jComboBoxCidade.setEnabled(false);
        limparCampos();
        modificador = 1;

        modificadorCampos();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        if (modificador == 1) {
            jButtonSalvar.setText("Salvar");
            cadastrarFornecedor();

        } else if (modificador == 2) {
            jButtonSalvar.setText("Editar");
            editarFornecedor();
        } else {

        }
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        deletarFornecedor();
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jComboBoxEstadoPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBoxEstadoPopupMenuWillBecomeInvisible
        preencherComboCidade();
        jComboBoxCidade.setEnabled(true);
    }//GEN-LAST:event_jComboBoxEstadoPopupMenuWillBecomeInvisible

    private void jTableFornecedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableFornecedorMouseClicked
        if (evt.getClickCount() == 2) {
            try {
                comboCidade();
                itensSelecionados();
            } catch (Exception ex) {
                Logger.getLogger(FrmBens.class.getName()).log(Level.SEVERE, null, ex);
            }
            jPanel2.setVisible(true);
            jButtonNovo.setEnabled(false);
            jButtonExcluir.setEnabled(true);
            modificador = 2;
            jButtonSalvar.setText("Editar");
        }
    }//GEN-LAST:event_jTableFornecedorMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonNovo;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JComboBox jComboBoxCidade;
    private javax.swing.JComboBox jComboBoxEstado;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabelBairro;
    private javax.swing.JLabel jLabelCelular;
    private javax.swing.JLabel jLabelCep;
    private javax.swing.JLabel jLabelCidade;
    private javax.swing.JLabel jLabelContato;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelEndereco;
    private javax.swing.JLabel jLabelEstado;
    private javax.swing.JLabel jLabelFornecedor;
    private javax.swing.JLabel jLabelNumero;
    private javax.swing.JLabel jLabelTelefone;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableFornecedor;
    private javax.swing.JTextField jTextFieldBairro;
    private javax.swing.JTextField jTextFieldCelular;
    private javax.swing.JTextField jTextFieldCep;
    private javax.swing.JTextField jTextFieldContato;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldEndereco;
    private javax.swing.JTextField jTextFieldFornecedor;
    private javax.swing.JTextField jTextFieldIdFornecedor;
    private javax.swing.JTextField jTextFieldNumero;
    private javax.swing.JTextField jTextFieldTelefone;
    // End of variables declaration//GEN-END:variables

    private void cadastrarFornecedor() {
        if (!jTextFieldContato.getText().equals("") && !jTextFieldCelular.getText().equals("")
                && !jTextFieldBairro.getText().equals("") && !jTextFieldFornecedor.getText().equals("")
                && !jTextFieldNumero.getText().equals("") && !jTextFieldTelefone.getText().equals("")
                && jComboBoxCidade.getSelectedIndex() != 0 && jComboBoxEstado.getSelectedIndex() != 0) {

            fornecedorTemp.setNomeFornecedor(jTextFieldFornecedor.getText());
            fornecedorTemp.setBairro(jTextFieldBairro.getText());
            fornecedorTemp.setCelular(jTextFieldCelular.getText());
            fornecedorTemp.setContato(jTextFieldContato.getText());
            fornecedorTemp.setDataCadastro(ClassUtils.setDateMsqy());
            fornecedorTemp.setEmail(jTextFieldEmail.getText());
            fornecedorTemp.setEndereco(jTextFieldEndereco.getText());
            fornecedorTemp.setNumero(jTextFieldNumero.getText());
            fornecedorTemp.setTelefone(jTextFieldTelefone.getText());
            fornecedorTemp.setUltimaAlteracao(ClassUtils.setDateMsqy());
            fornecedorTemp.setUsuarioAlt((ClassUtils.getIdUsuario()));
            fornecedorTemp.setUsuarioCad((ClassUtils.getIdUsuario()));

            fornecedorDao.cadastra(fornecedorTemp,
                    Integer.parseInt(cidadeDao.buscarIdcidade(jComboBoxCidade.getSelectedItem().toString())));
            limparCampos();
            preencherTabela();
            jPanel2.setVisible(false);
            jButtonNovo.setEnabled(true);

        } else {
            jLabelContato.setForeground(Color.red);
            jLabelCelular.setForeground(Color.red);
            jLabelBairro.setForeground(Color.red);
            jLabelEstado.setForeground(Color.red);
            jLabelFornecedor.setForeground(Color.red);
            jLabelCidade.setForeground(Color.red);
            jLabelNumero.setForeground(Color.red);
            jLabelTelefone.setForeground(Color.red);
            jLabelEndereco.setForeground(Color.red);
            jLabelCep.setForeground(Color.red);
            jLabelEmail.setForeground(Color.red);
        }

    }

    private void editarFornecedor() {
        if (!jTextFieldContato.getText().equals("") && !jTextFieldCelular.getText().equals("")
                && !jTextFieldBairro.getText().equals("") && !jTextFieldFornecedor.getText().equals("")
                && !jTextFieldNumero.getText().equals("") && !jTextFieldTelefone.getText().equals("")) {

            fornecedorTemp.setNomeFornecedor(jTextFieldFornecedor.getText());
            fornecedorTemp.setBairro(jTextFieldBairro.getText());
            fornecedorTemp.setCelular(jTextFieldCelular.getText());
            fornecedorTemp.setContato(jTextFieldContato.getText());
            fornecedorTemp.setEmail(jTextFieldEmail.getText());
            fornecedorTemp.setEndereco(jTextFieldEndereco.getText());
            fornecedorTemp.setNumero(jTextFieldNumero.getText());
            fornecedorTemp.setTelefone(jTextFieldTelefone.getText());
            fornecedorTemp.setUltimaAlteracao(ClassUtils.setDateMsqy());
            fornecedorTemp.setUsuarioAlt((ClassUtils.getIdUsuario()));
            fornecedorTemp.setCep(jTextFieldCep.getText());
            fornecedorTemp.setIdFornecedor(Integer.parseInt(jTextFieldIdFornecedor.getText()));           
          
            fornecedorDao.atualizar(fornecedorTemp,
                    Integer.parseInt(cidadeDao.buscarIdcidade(jComboBoxCidade.getSelectedItem().toString())));
            limparCampos();
            preencherTabela();
            jPanel2.setVisible(false);
            jButtonNovo.setEnabled(true);
            jButtonExcluir.setEnabled(false);
            jComboBoxCidade.setEnabled(false);
        } else {
            jLabelContato.setForeground(Color.red);
            jLabelCelular.setForeground(Color.red);
            jLabelBairro.setForeground(Color.red);
            jLabelEstado.setForeground(Color.red);
            jLabelFornecedor.setForeground(Color.red);
            jLabelCidade.setForeground(Color.red);
            jLabelNumero.setForeground(Color.red);
            jLabelTelefone.setForeground(Color.red);
            jLabelEndereco.setForeground(Color.red);
            jLabelCep.setForeground(Color.red);
            jLabelEmail.setForeground(Color.red);
        }

    }

    private void limparCampos() {
        jComboBoxEstado.setSelectedIndex(0);
        jComboBoxCidade.setSelectedIndex(0);
        jTextFieldBairro.setText("");
        jTextFieldCelular.setText("");
        jTextFieldCep.setText("");
        jTextFieldContato.setText("");
        jTextFieldEmail.setText("");
        jTextFieldEndereco.setText("");
        jTextFieldFornecedor.setText("");
        jTextFieldNumero.setText("");
        jTextFieldTelefone.setText("");
    }

    private void deletarFornecedor() {
        fornecedorTemp.setIdFornecedor(Integer.parseInt(jTextFieldIdFornecedor.getText()));

        fornecedorDao.deletar(fornecedorTemp);
        limparCampos();
        preencherTabela();
        jPanel2.setVisible(false);
        jButtonNovo.setEnabled(true);
        jButtonExcluir.setEnabled(false);
        jComboBoxCidade.setEnabled(false);
        modificador = 1;
    }

    private void modificadorCampos() {
        jLabelContato.setForeground(Color.BLACK);
        jLabelCelular.setForeground(Color.BLACK);
        jLabelBairro.setForeground(Color.BLACK);
        jLabelEstado.setForeground(Color.BLACK);
        jLabelFornecedor.setForeground(Color.BLACK);
        jLabelCidade.setForeground(Color.BLACK);
        jLabelNumero.setForeground(Color.BLACK);
        jLabelTelefone.setForeground(Color.BLACK);
        jLabelEndereco.setForeground(Color.BLACK);
        jLabelCep.setForeground(Color.BLACK);
        jLabelEmail.setForeground(Color.BLACK);
    }

    private void preencherComboCidade() {
        jComboBoxCidade.removeAllItems();
        jComboBoxCidade.addItem("Selecione uma Cidade");
        if (jComboBoxEstado.getSelectedIndex() != 0) {
            idEstado = (String) estadoDao.buscarIdEstado(jComboBoxEstado.getSelectedItem().toString());
            @SuppressWarnings("UnusedAssignment")
            ArrayList<Object> objetos = new ArrayList<>();
            objetos = cidadeDao.listarCidade(idEstado);

            for (Object objeto : objetos) {
                jComboBoxCidade.addItem(objeto);
            }
        }
    }

    private void preencherComboEstado() {
        jComboBoxEstado.removeAllItems();
        jComboBoxEstado.addItem("Selecione um Estado");

        @SuppressWarnings("UnusedAssignment")
        ArrayList<Object> objetos = new ArrayList<>();
        objetos = estadoDao.listarEstados();

        for (Object objeto : objetos) {
            jComboBoxEstado.addItem(objeto);
        }

    }

    private void preencherTabela() {
        String[] Colunas = new String[]{"Fornecedor", "Contato", "Celular","Telefone", "Estado", "Cidade", " Data Cadastro ", "Última Alteração"};

        FornecedorDao fornecedorTempTabela = new FornecedorDao();
        dados = fornecedorTempTabela.listar();
        Tabela modelo = new TabelaFornecedor(dados, Colunas);

        jTableFornecedor.setModel(modelo);

        jTableFornecedor.getColumnModel().getColumn(0).setPreferredWidth(250);
        jTableFornecedor.getColumnModel().getColumn(0).setResizable(false);

        jTableFornecedor.getColumnModel().getColumn(1).setPreferredWidth(165);
        jTableFornecedor.getColumnModel().getColumn(1).setResizable(false);

        jTableFornecedor.getColumnModel().getColumn(2).setPreferredWidth(100);
        jTableFornecedor.getColumnModel().getColumn(2).setResizable(false);
        
        jTableFornecedor.getColumnModel().getColumn(3).setPreferredWidth(100);
        jTableFornecedor.getColumnModel().getColumn(3).setResizable(false);

        jTableFornecedor.getColumnModel().getColumn(4).setPreferredWidth(100);
        jTableFornecedor.getColumnModel().getColumn(4).setResizable(false);

        jTableFornecedor.getColumnModel().getColumn(5).setPreferredWidth(120);
        jTableFornecedor.getColumnModel().getColumn(5).setResizable(false);

        jTableFornecedor.getColumnModel().getColumn(6).setPreferredWidth(300);
        jTableFornecedor.getColumnModel().getColumn(6).setResizable(false);

        jTableFornecedor.getColumnModel().getColumn(7).setPreferredWidth(300);
        jTableFornecedor.getColumnModel().getColumn(7).setResizable(false);

        jTableFornecedor.getTableHeader().setReorderingAllowed(false);
        jTableFornecedor.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jTableFornecedor.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    private void itensSelecionados() {
        limparCampos();
        jComboBoxCidade.setEnabled(true);

        int seleciona = jTableFornecedor.getSelectedRow();

        jTextFieldBairro.setText(dados.get(seleciona).getBairro());
        jTextFieldCelular.setText(dados.get(seleciona).getCelular());
        jTextFieldCep.setText(dados.get(seleciona).getCep());
        jTextFieldContato.setText(dados.get(seleciona).getContato());
        jTextFieldEmail.setText(dados.get(seleciona).getEmail());
        jTextFieldEndereco.setText(dados.get(seleciona).getEndereco());
        jTextFieldFornecedor.setText(dados.get(seleciona).getNomeFornecedor());
        jTextFieldNumero.setText(dados.get(seleciona).getNumero());
        jTextFieldTelefone.setText(dados.get(seleciona).getTelefone());
        jTextFieldIdFornecedor.setText(String.valueOf(dados.get(seleciona).getIdFornecedor()));
        jTextFieldCep.setText(dados.get(seleciona).getCep());

        jComboBoxEstado.setSelectedItem(dados.get(seleciona).getEstado());
                jComboBoxCidade.setSelectedItem(dados.get(seleciona).getCidade());

        modificador = 2;
        modificadorCampos();
    }

    private void validaCampos() {
        jTextFieldBairro.setDocument(new NumeroMaximoCaracters(45));
        jTextFieldCelular.setDocument(new SomenteNumero(11));
        jTextFieldCep.setDocument(new SomenteNumero(8));
        jTextFieldContato.setDocument(new NumeroMaximoCaracters(45));
        jTextFieldEmail.setDocument(new NumeroMaximoCaracters(45));
        jTextFieldEndereco.setDocument(new NumeroMaximoCaracters(45));
        jTextFieldFornecedor.setDocument(new NumeroMaximoCaracters(45));
        jTextFieldNumero.setDocument(new SomenteNumero(5));
        jTextFieldTelefone.setDocument(new SomenteNumero(10));
    }

    private void comboCidade() {
        jComboBoxCidade.removeAllItems();
        jComboBoxCidade.addItem("Selecione uma Cidade");

        @SuppressWarnings("UnusedAssignment")
        ArrayList<Object> objetos = new ArrayList<>();
        objetos = cidadeDao.listarTodasCidade();

        for (Object objeto : objetos) {
            jComboBoxCidade.addItem(objeto);
        }
    }
}