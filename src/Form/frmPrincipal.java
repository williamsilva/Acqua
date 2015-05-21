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
    String usuarioFrm = "";

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
        usuarioFrm = usuarioTemp.getNome().toUpperCase();
        jLUsuario.setText("Usúario Logado: " + usuario);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        timer1 = new org.netbeans.examples.lib.timerbean.Timer();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jLUsuario = new javax.swing.JLabel();
        jLComputador = new javax.swing.JLabel();
        jLData = new javax.swing.JLabel();
        jLHora = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmArquivo = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMBloquear = new javax.swing.JMenuItem();
        jMDesconectar = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMUsuario = new javax.swing.JMenuItem();

        timer1.addTimerListener(new org.netbeans.examples.lib.timerbean.TimerListener() {
            public void onTime(java.awt.event.ActionEvent evt) {
                timer1OnTime(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MENU PRINCIPAL");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jDesktopPane1.setBackground(new java.awt.Color(240, 240, 240));

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLUsuario.setText("Usuario");

        jLComputador.setText("Computador");

        jLData.setText("Data: ");

        jLHora.setText("Hora");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLComputador, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(jLUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLData, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLHora, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLUsuario)
                .addComponent(jLComputador)
                .addComponent(jLData)
                .addComponent(jLHora))
        );

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 678, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap(511, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jDesktopPane1.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jmArquivo.setText("Arquivo");

        jMenuItem1.setText("Alterar Senha");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jmArquivo.add(jMenuItem1);

        jMBloquear.setText("Bloquear");
        jMBloquear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMBloquearActionPerformed(evt);
            }
        });
        jmArquivo.add(jMBloquear);

        jMDesconectar.setText("Desconectar");
        jMDesconectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMDesconectarActionPerformed(evt);
            }
        });
        jmArquivo.add(jMDesconectar);

        jMenuItem3.setText("Sair");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jmArquivo.add(jMenuItem3);

        jMenuBar1.add(jmArquivo);

        jMenu2.setText("Sistema");

        jMUsuario.setText("Usuários");
        jMUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMUsuarioActionPerformed(evt);
            }
        });
        jMenu2.add(jMUsuario);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        setBounds(0, 0, 694, 589);
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

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        jInternalUsuarios();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMUsuarioActionPerformed
        FrmUsuario usuarioLogado = new FrmUsuario(usuarioFrm);
        
        FrmUsuario usuario = new FrmUsuario();
        usuario.setSize(1066,665);
        jDesktopPane1.add(usuario);
        usuario.setVisible(true);
    }//GEN-LAST:event_jMUsuarioActionPerformed

    FrmUsuario usuarios;

    private void jInternalUsuarios() {

        if (usuarios == null) {
            usuarios = new FrmUsuario();
            this.jDesktopPane1.add(usuarios);
            try {
                usuarios.setMaximum(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        usuarios.setVisible(true);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLComputador;
    private javax.swing.JLabel jLData;
    private javax.swing.JLabel jLHora;
    private javax.swing.JLabel jLUsuario;
    private javax.swing.JMenuItem jMBloquear;
    private javax.swing.JMenuItem jMDesconectar;
    private javax.swing.JMenuItem jMUsuario;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
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
