package br.com.wss.viwer;

import br.com.wss.utilidades.ClassUtils;
import br.com.wss.dao.UsuarioDao;
import br.com.wss.modelo.Usuario;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class FrmBloqueio extends javax.swing.JDialog {

     FrmBloqueio() {
        init();      
        jTUsuario.setText(ClassUtils.buscaUsuario());
    }  

    private void init() {
        initComponents();
        this.setSize(453, 348);
        this.setModal(true);

    }

    private void desbloqueioTela() {
        Usuario usuarioTemp = new Usuario();
        UsuarioDao dao = new UsuarioDao();
        ResultSet rs = null;
        if (!jTUsuario.getText().equals("") || jTUsuario.getText().equals(rs)
                && !jPSenha.getPassword().equals("") || jPSenha.getPassword().equals(rs)) {

            usuarioTemp.setUsuario(jTUsuario.getText());
            usuarioTemp.setSenha(new String(jPSenha.getPassword()));
            usuarioTemp = dao.logar(usuarioTemp);

            if (usuarioTemp != null) {
                this.dispose();

            } else {
                JOptionPane.showMessageDialog(null, "Usuário o senha Invalidos!", "Falha No Login", JOptionPane.INFORMATION_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Nenhum Campo pode ser vazio!", "Falha No Login", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTUsuario = new javax.swing.JTextField();
        jPSenha = new javax.swing.JPasswordField();
        jBDesbloquear = new javax.swing.JButton();
        jLCabecalho = new javax.swing.JLabel();
        jLSenha = new javax.swing.JLabel();
        jLusuario = new javax.swing.JLabel();
        jLImg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);

        jTUsuario.setEditable(false);
        getContentPane().add(jTUsuario);
        jTUsuario.setBounds(130, 220, 150, 20);

        jPSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPSenhaKeyPressed(evt);
            }
        });
        getContentPane().add(jPSenha);
        jPSenha.setBounds(130, 260, 150, 20);

        jBDesbloquear.setText("Desbloquear");
        jBDesbloquear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBDesbloquearActionPerformed(evt);
            }
        });
        getContentPane().add(jBDesbloquear);
        jBDesbloquear.setBounds(160, 300, 100, 23);

        jLCabecalho.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLCabecalho.setForeground(new java.awt.Color(0, 0, 153));
        jLCabecalho.setText("Sessão Bloqueada");
        getContentPane().add(jLCabecalho);
        jLCabecalho.setBounds(110, 20, 260, 29);

        jLSenha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLSenha.setText("Senha:");
        getContentPane().add(jLSenha);
        jLSenha.setBounds(60, 260, 50, 17);

        jLusuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLusuario.setText("Usúario:");
        getContentPane().add(jLusuario);
        jLusuario.setBounds(60, 220, 60, 17);

        jLImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/wss/img/telaBloqueio.jpg"))); // NOI18N
        jLImg.setText("jLabel2");
        getContentPane().add(jLImg);
        jLImg.setBounds(0, 0, 490, 360);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBDesbloquearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBDesbloquearActionPerformed
        desbloqueioTela();
    }//GEN-LAST:event_jBDesbloquearActionPerformed

    private void jPSenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPSenhaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            desbloqueioTela();
        }
    }//GEN-LAST:event_jPSenhaKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBDesbloquear;
    private javax.swing.JLabel jLCabecalho;
    private javax.swing.JLabel jLImg;
    private javax.swing.JLabel jLSenha;
    private javax.swing.JLabel jLusuario;
    private javax.swing.JPasswordField jPSenha;
    private javax.swing.JTextField jTUsuario;
    // End of variables declaration//GEN-END:variables
   
}
