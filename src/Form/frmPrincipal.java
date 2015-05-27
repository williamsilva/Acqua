package Form;

import DAO.ClassUtiuls;
import MODELO.modelUsuario;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public final class frmPrincipal extends javax.swing.JFrame {

    String usuarioBloqueio = "";

    public frmPrincipal() throws InterruptedException {
        init();
    }

    private void init() throws InterruptedException {
        this.setExtendedState(MAXIMIZED_BOTH);

        initComponents();
        confirmaFechamento();
        Principal principal = new Principal();
        String computador = principal.verificaMac().toUpperCase();
        jLComputador.setText("Logado em: " + computador);
        timer1.start();
    }

    public void mostraHora() throws InterruptedException {
        jLHora.setText("Hora Atual: " + ClassUtiuls.mostraHora());
    }

    public void mostraData() {
        jLData.setText("Data Atual: " + ClassUtiuls.mostraData());
    }

    frmPrincipal(modelUsuario usuarioTemp) throws InterruptedException {
        init();
        String usuario = usuarioTemp.getNome().toUpperCase();
        usuarioBloqueio = usuarioTemp.getUsuario().toUpperCase();
        jLUsuario.setText("Usúario Logado: " + usuario);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        timer1 = new org.netbeans.examples.lib.timerbean.Timer();
        jPStatusBar = new javax.swing.JPanel();
        jLUsuario = new javax.swing.JLabel();
        jLComputador = new javax.swing.JLabel();
        jLData = new javax.swing.JLabel();
        jLHora = new javax.swing.JLabel();
        jPSecundario = new javax.swing.JPanel();
        jPPrincipal = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmArquivo = new javax.swing.JMenu();
        jMAlterarSenha = new javax.swing.JMenuItem();
        jMBloquear = new javax.swing.JMenuItem();
        jMDesconectar = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuICadastroBens = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMUsuario = new javax.swing.JMenuItem();
        jMComputadores = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();

        timer1.addTimerListener(new org.netbeans.examples.lib.timerbean.TimerListener() {
            public void onTime(java.awt.event.ActionEvent evt) {
                timer1OnTime(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MENU PRINCIPAL");
        setBackground(new java.awt.Color(51, 255, 255));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPStatusBar.setBackground(new java.awt.Color(204, 255, 204));
        jPStatusBar.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLUsuario.setText("Usuario");

        jLComputador.setText("Computador");

        jLData.setText("Data: ");

        jLHora.setText("Hora");

        javax.swing.GroupLayout jPStatusBarLayout = new javax.swing.GroupLayout(jPStatusBar);
        jPStatusBar.setLayout(jPStatusBarLayout);
        jPStatusBarLayout.setHorizontalGroup(
            jPStatusBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPStatusBarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLComputador, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(jLUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLData, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLHora, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPStatusBarLayout.setVerticalGroup(
            jPStatusBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPStatusBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLUsuario)
                .addComponent(jLComputador)
                .addComponent(jLData)
                .addComponent(jLHora))
        );

        jPSecundario.setBackground(new java.awt.Color(255, 51, 51));
        jPSecundario.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPSecundario.setForeground(new java.awt.Color(255, 153, 51));

        javax.swing.GroupLayout jPSecundarioLayout = new javax.swing.GroupLayout(jPSecundario);
        jPSecundario.setLayout(jPSecundarioLayout);
        jPSecundarioLayout.setHorizontalGroup(
            jPSecundarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 223, Short.MAX_VALUE)
        );
        jPSecundarioLayout.setVerticalGroup(
            jPSecundarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 501, Short.MAX_VALUE)
        );

        jPPrincipal.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPPrincipal.setForeground(new java.awt.Color(255, 204, 0));

        javax.swing.GroupLayout jPPrincipalLayout = new javax.swing.GroupLayout(jPPrincipal);
        jPPrincipal.setLayout(jPPrincipalLayout);
        jPPrincipalLayout.setHorizontalGroup(
            jPPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPPrincipalLayout.setVerticalGroup(
            jPPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jmArquivo.setText("Arquivo");

        jMAlterarSenha.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, java.awt.event.InputEvent.CTRL_MASK));
        jMAlterarSenha.setText("Alterar Senha");
        jMAlterarSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMAlterarSenhaActionPerformed(evt);
            }
        });
        jmArquivo.add(jMAlterarSenha);

        jMBloquear.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, java.awt.event.InputEvent.CTRL_MASK));
        jMBloquear.setText("Bloquear");
        jMBloquear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMBloquearActionPerformed(evt);
            }
        });
        jmArquivo.add(jMBloquear);

        jMDesconectar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, java.awt.event.InputEvent.CTRL_MASK));
        jMDesconectar.setText("Desconectar");
        jMDesconectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMDesconectarActionPerformed(evt);
            }
        });
        jmArquivo.add(jMDesconectar);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem3.setText("Sair");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jmArquivo.add(jMenuItem3);

        jMenuBar1.add(jmArquivo);

        jMenu1.setText("Bens");

        jMenuICadastroBens.setText("Cadastro de Bens");
        jMenuICadastroBens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuICadastroBensActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuICadastroBens);

        jMenuItem2.setText("Cadastro de Manutenção");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu4.setText("Reservas");
        jMenuBar1.add(jMenu4);

        jMenu3.setText("Relatorios");
        jMenuBar1.add(jMenu3);

        jMenu2.setText("Sistema");

        jMUsuario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.CTRL_MASK));
        jMUsuario.setText("Usuários");
        jMUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMUsuarioActionPerformed(evt);
            }
        });
        jMenu2.add(jMUsuario);

        jMComputadores.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, java.awt.event.InputEvent.CTRL_MASK));
        jMComputadores.setText("Coputadores");
        jMComputadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMComputadoresActionPerformed(evt);
            }
        });
        jMenu2.add(jMComputadores);

        jMenuBar1.add(jMenu2);

        jMenu5.setText("Ajuda");

        jMenuItem5.setText("Sobre");
        jMenu5.add(jMenuItem5);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPStatusBar, javax.swing.GroupLayout.PREFERRED_SIZE, 678, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPSecundario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPSecundario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPStatusBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMDesconectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMDesconectarActionPerformed
        frmLogin login = new frmLogin();
        login.setSize(453, 348);
        login.setLocationRelativeTo(null);
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMDesconectarActionPerformed

    private void jMBloquearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMBloquearActionPerformed

        FrmBloqueio bloqueio = new FrmBloqueio(usuarioBloqueio);
        bloqueio.setSize(453, 348);
        bloqueio.setLocationRelativeTo(null);
        bloqueio.setVisible(true);
    }//GEN-LAST:event_jMBloquearActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

    }//GEN-LAST:event_formWindowOpened

    private void timer1OnTime(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timer1OnTime
        try {
            mostraHora();
            mostraData();
        } catch (InterruptedException ex) {
            Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_timer1OnTime

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?", "Saída", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            System.exit(0);
        } else {
            repaint();
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMAlterarSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMAlterarSenhaActionPerformed
        jInternalUsuarios();
    }//GEN-LAST:event_jMAlterarSenhaActionPerformed

    private void jMUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMUsuarioActionPerformed

        jInternalUsuarios();
    }//GEN-LAST:event_jMUsuarioActionPerformed

    private void jMComputadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMComputadoresActionPerformed

        jInternalComputador();
    }//GEN-LAST:event_jMComputadoresActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuICadastroBensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuICadastroBensActionPerformed
        jInternalCadastroBens();
    }//GEN-LAST:event_jMenuICadastroBensActionPerformed

    FrmUsuario frmUsuarios;
    FrmComputador frmComputador;
    FrmBens bens;

    public void jInternalComputador() {
        if (frmComputador == null) {
            frmComputador = new FrmComputador();
           // frmComputador.setLocation(260, 0);
           // frmComputador.setSize(1100,660);            
            this.jPPrincipal.add(frmComputador);
            try {
                frmComputador.setMaximum(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(frmComputador!=null){
           frmComputador.dispose();
           frmComputador = null;
           frmComputador = new FrmComputador();
           this.jPPrincipal.add(frmComputador);
           try {
                frmComputador.setMaximum(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        frmComputador.setVisible(true);
    }

    private void jInternalCadastroBens() {

        if (bens == null) {
            bens = new FrmBens();
            bens.setSize(1100,660);
            bens.setLocation(260,0);
            bens.setVisible(true);
            this.jPPrincipal.add(bens);
            try {
                bens.setMaximum(true);
            } catch (Exception e) {
            }
        }
        bens.setVisible(true);
    }

    private void jInternalUsuarios() {

        if (frmUsuarios == null) {
            frmUsuarios = new FrmUsuario();
           frmUsuarios.setLocation(260, 0);
            frmUsuarios.setSize(1100, 660);
            frmUsuarios.setResizable(true);

            this.jPPrincipal.add(frmUsuarios);
            try {
                frmUsuarios.setMaximum(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        frmUsuarios.setVisible(true);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLComputador;
    private javax.swing.JLabel jLData;
    private javax.swing.JLabel jLHora;
    private javax.swing.JLabel jLUsuario;
    private javax.swing.JMenuItem jMAlterarSenha;
    private javax.swing.JMenuItem jMBloquear;
    private javax.swing.JMenuItem jMComputadores;
    private javax.swing.JMenuItem jMDesconectar;
    private javax.swing.JMenuItem jMUsuario;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuICadastroBens;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPanel jPPrincipal;
    private javax.swing.JPanel jPSecundario;
    private javax.swing.JPanel jPStatusBar;
    private javax.swing.JMenu jmArquivo;
    private org.netbeans.examples.lib.timerbean.Timer timer1;
    // End of variables declaration//GEN-END:variables

    public void confirmaFechamento() {

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?", "Saída", JOptionPane.YES_NO_OPTION);
                if (confirma == JOptionPane.YES_OPTION) {
                    System.exit(0);
                } else {
                    repaint();
                }
            }
        });
    }

    private void telaBloqueio() {
        modelUsuario usuarioBloqueio = new modelUsuario();
        usuarioBloqueio.setUsuario(jLUsuario.getText());

    }

}
