package br.com.wss.viwer;

import br.com.wss.dao.ComputadorDao;
import br.com.wss.dao.UsuarioDao;
import br.com.wss.modelo.Usuario;
import br.com.wss.utilidades.ClassUtils;
import java.sql.ResultSet;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public final class FrmLogin extends javax.swing.JFrame {

    /**
     *
     */
    public FrmLogin() {
        initComponents();
        this.setResizable(false);
        confirmaFechamento();
    }

    Usuario usuarioTemp = new Usuario();
    UsuarioDao usuarioDao = new UsuarioDao();
    ComputadorDao computadorDao = new ComputadorDao();

    /**
     *
     * @throws SQLException
     * @throws InterruptedException
     */
    public void logar() throws SQLException, InterruptedException {

        ResultSet result = null;
        usuarioTemp = new Usuario();

        if (!jTUsuario.getText().equals("") || jTUsuario.getText().equals(result)
                && !jtSenha.getPassword().equals("") || jtSenha.getPassword().equals(result)) {

            usuarioTemp.setUsuario(jTUsuario.getText());
            usuarioTemp.setSenha(new String(jtSenha.getPassword()));

            usuarioTemp = usuarioDao.logar(usuarioTemp);

            if (usuarioTemp != null) {
                if (usuarioTemp.getAtivo().equals("Sim")) {
                    String mac = ClassUtils.getMac();
                    String computador = computadorDao.buscarComputador(mac).toUpperCase();

                    if (usuarioTemp.getLogado().equals("") || usuarioTemp.getLogado().equalsIgnoreCase(computador)) {
                        FrmPrincipal princiapl = new FrmPrincipal(usuarioTemp);
                        princiapl.setVisible(true);
                        setLogado();
                        this.dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuário Logado Em! \n\n" + usuarioTemp.getLogado(), "Falha No Login", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Usuário Bloqueado\n\n Consulte o Administrador do Sitema.!", "Falha No Login", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Usuário ou senha Invalidos!", "Falha No Login", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum Campo pode ser vazio!", "Falha No Login", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLUsuario = new javax.swing.JLabel();
        jLSenha = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jbLogar = new javax.swing.JButton();
        jtSenha = new javax.swing.JPasswordField();
        jTUsuario = new javax.swing.JTextField();
        jbSair = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabelIMG = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TELE LOGIN");
        getContentPane().setLayout(null);

        jLUsuario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLUsuario.setText("Usúario:");
        getContentPane().add(jLUsuario);
        jLUsuario.setBounds(20, 200, 70, 17);

        jLSenha.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLSenha.setText("Senha:");
        getContentPane().add(jLSenha);
        jLSenha.setBounds(20, 240, 50, 17);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel4.setText("Informe ao lado seu Usúario e \n"); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(280, 210, 150, 13);

        jbLogar.setText("Login");
        jbLogar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLogarActionPerformed(evt);
            }
        });
        jbLogar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jbLogarKeyPressed(evt);
            }
        });
        getContentPane().add(jbLogar);
        jbLogar.setBounds(90, 280, 70, 23);

        jtSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtSenhaActionPerformed(evt);
            }
        });
        jtSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtSenhaKeyPressed(evt);
            }
        });
        getContentPane().add(jtSenha);
        jtSenha.setBounds(90, 240, 170, 26);

        jTUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTUsuarioKeyPressed(evt);
            }
        });
        getContentPane().add(jTUsuario);
        jTUsuario.setBounds(90, 200, 170, 26);

        jbSair.setText("Sair");
        jbSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSairActionPerformed(evt);
            }
        });
        getContentPane().add(jbSair);
        jbSair.setBounds(200, 280, 60, 23);

        jLabel5.setBackground(new java.awt.Color(102, 255, 51));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("TELA LOGIN SISTEMA DE CADASTRO");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(50, 20, 329, 22);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel1.setText("Senha para entrar no Sistema.");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(280, 230, 150, 13);

        jLabelIMG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/wss/img/Trend.jpg"))); // NOI18N
        jLabelIMG.setText("jLabel2");
        getContentPane().add(jLabelIMG);
        jLabelIMG.setBounds(0, 0, 450, 320);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSairActionPerformed
        int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?", "Saída", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            System.exit(0);
        } else {
            repaint();
        }
    }//GEN-LAST:event_jbSairActionPerformed

    private void jbLogarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLogarActionPerformed
        try {
            logar();
        } catch (SQLException | InterruptedException ex) {
            Logger.getLogger(FrmLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbLogarActionPerformed

    private void jbLogarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbLogarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                logar();
            } catch (SQLException | InterruptedException ex) {
                Logger.getLogger(FrmLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jbLogarKeyPressed

    private void jtSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtSenhaActionPerformed

    }//GEN-LAST:event_jtSenhaActionPerformed

    private void jtSenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtSenhaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                logar();
            } catch (SQLException | InterruptedException ex) {
                Logger.getLogger(FrmLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jtSenhaKeyPressed

    private void jTUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTUsuarioKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtSenha.requestFocus();
        }
    }//GEN-LAST:event_jTUsuarioKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLSenha;
    private javax.swing.JLabel jLUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelIMG;
    private javax.swing.JTextField jTUsuario;
    private javax.swing.JButton jbLogar;
    private javax.swing.JButton jbSair;
    private javax.swing.JPasswordField jtSenha;
    // End of variables declaration//GEN-END:variables

    private void setLogado() {
        String mac = ClassUtils.getMac();
        ComputadorDao computadorDao = new ComputadorDao();
        String computador = computadorDao.buscarComputador(mac);

        usuarioTemp.setLogado(computador);
        usuarioTemp.setCodigo(usuarioTemp.getCodigo());
        usuarioDao.setLogado(usuarioTemp);

    }

    private void confirmaFechamento() {
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int i = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?", "Saída", JOptionPane.YES_NO_OPTION);
                if (i == JOptionPane.YES_OPTION) {
                    System.exit(0);
                } else {
                    repaint();
                }
            }
        });
    }

}
