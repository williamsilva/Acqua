package br.com.wss.viwer;

import br.com.wss.dao.ComputadorDao;
import br.com.wss.dao.UsuarioDao;
import br.com.wss.utilidades.ClassUtils;
import br.com.wss.modelo.Usuario;
import br.com.wss.utilidades.ArquivosIni;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public final class frmPrincipal extends javax.swing.JFrame {

    UsuarioDao usuarioDao = new UsuarioDao();
    Usuario usuarioTemp = new Usuario();
    ComputadorDao computadorDao = new ComputadorDao();
    ClassUtils utilidades = new ClassUtils();
    String idUsuario;
    String login;

    FrmUsuario frmUsuarios;
    FrmComputador frmComputador;
    FrmBens bens;
    FrmGrupoBens grupoBens;
    FrmManutecao manutencao;
    FrmFornecedor fornecedor;
    FrmVoucher voucher;
    FrmProdutos produtos;

    public frmPrincipal() throws InterruptedException {
        init();
    }

    private void init() throws InterruptedException {
        this.setExtendedState(MAXIMIZED_BOTH);
        initComponents();
        confirmaFechamento();
        timer1.start();
        jTextAreaAtalho.setEnabled(false);
        jTextAreaAtalho.setText(ArquivosIni.LendoArquivo("C:\\WssSolutions\\br\\\\com\\wss\\Config\\Atalhos.txt"));
    }

    private void mostraHora() throws InterruptedException {
        jLHora.setText("Hora Atual: " + ClassUtils.mostraHora());
    }

    private void mostraData() {
        jLData.setText("Data Atual: " + ClassUtils.mostraData());
    }

    private void servidor() {
        jLabelServidor.setText("Servidor: " + ArquivosIni.getServidor());
    }

    private void computador() {
        String mac = ClassUtils.getMac();
        String computador = computadorDao.buscarComputador(mac).toUpperCase();
        jLComputador.setText("Logado em: " + computador);
    }

    private void usuario(String codigo) {
        String usuario = usuarioDao.buscaUsuario(codigo);
        jLUsuario.setText("Usúario: " + usuario);
    }

    frmPrincipal(Usuario usuarioTemp) throws InterruptedException {
        init();
        login = usuarioTemp.getUsuario();
        idUsuario = usuarioTemp.getCodigo();
        ClassUtils.setIdUsuario(idUsuario);
        ClassUtils.setUsuario(login);
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
        jLabelServidor = new javax.swing.JLabel();
        jPSecundario = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaAtalho = new javax.swing.JTextArea();
        jPPrincipal = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmArquivo = new javax.swing.JMenu();
        jMAlterarSenha = new javax.swing.JMenuItem();
        jMBloquear = new javax.swing.JMenuItem();
        jMDesconectar = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuICadastroBens = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItemRelatorioBens = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
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

        jLabelServidor.setText("Servidor");

        javax.swing.GroupLayout jPStatusBarLayout = new javax.swing.GroupLayout(jPStatusBar);
        jPStatusBar.setLayout(jPStatusBarLayout);
        jPStatusBarLayout.setHorizontalGroup(
            jPStatusBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPStatusBarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLComputador, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jLabelServidor, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(jLUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(114, 114, 114)
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
                .addComponent(jLHora)
                .addComponent(jLabelServidor))
        );

        jPSecundario.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPSecundario.setForeground(new java.awt.Color(255, 153, 51));

        jTextAreaAtalho.setColumns(20);
        jTextAreaAtalho.setRows(5);
        jScrollPane1.setViewportView(jTextAreaAtalho);

        javax.swing.GroupLayout jPSecundarioLayout = new javax.swing.GroupLayout(jPSecundario);
        jPSecundario.setLayout(jPSecundarioLayout);
        jPSecundarioLayout.setHorizontalGroup(
            jPSecundarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
        );
        jPSecundarioLayout.setVerticalGroup(
            jPSecundarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPSecundarioLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 285, Short.MAX_VALUE))
        );

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

        jMenuItem1.setText("Grupos");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Manutenção");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem4.setText("Fornecedor");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        jMenu4.setText("Reservas");

        jMenuItem7.setText("Voucher");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem7);

        jMenuItem8.setText("Produtos");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem8);

        jMenuBar1.add(jMenu4);

        jMenu3.setText("Relatorios");

        jMenuItemRelatorioBens.setText("Relatorio Bens");
        jMenuItemRelatorioBens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRelatorioBensActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItemRelatorioBens);

        jMenuItem6.setText("Bens");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem6);

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
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem5);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPStatusBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPSecundario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPPrincipal))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPSecundario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPPrincipal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPStatusBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMDesconectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMDesconectarActionPerformed
        if (deslogar()) {
            frmLogin login = new frmLogin();
            login.setSize(453, 348);
            login.setLocationRelativeTo(null);
            login.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jMDesconectarActionPerformed

    private void jMBloquearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMBloquearActionPerformed

        FrmBloqueio bloqueio = new FrmBloqueio();
        bloqueio.setSize(453, 348);
        bloqueio.setLocationRelativeTo(null);
        bloqueio.setVisible(true);
    }//GEN-LAST:event_jMBloquearActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

    }//GEN-LAST:event_formWindowOpened

    private void timer1OnTime(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timer1OnTime
        try {
            usuario(idUsuario);
            computador();
            servidor();
            mostraHora();
            mostraData();
        } catch (InterruptedException ex) {
            Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_timer1OnTime

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?", "Saída", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            if (deslogar()) {
                System.exit(0);
            } else {
                repaint();
            }
        } else {
            repaint();
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMAlterarSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMAlterarSenhaActionPerformed
        FrmAuterarSenha senha = new FrmAuterarSenha();
        senha.setSize(400, 320);
        senha.setLocationRelativeTo(null);
        senha.setVisible(true);
    }//GEN-LAST:event_jMAlterarSenhaActionPerformed

    private void jMUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMUsuarioActionPerformed
        jInternalUsuarios();
    }//GEN-LAST:event_jMUsuarioActionPerformed

    private void jMComputadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMComputadoresActionPerformed
        jInternalComputador();
    }//GEN-LAST:event_jMComputadoresActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        jInternalManutencao();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuICadastroBensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuICadastroBensActionPerformed
        jInternalCadastroBens();
    }//GEN-LAST:event_jMenuICadastroBensActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        ArquivosIni.sobre();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        jInternalGrupoBens();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItemRelatorioBensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRelatorioBensActionPerformed
        String url = "C:\\WssSolutions\\br\\com\\wss\\relatorios\\relatorio bens.jasper";
        utilidades.relatorio(url, "Relátorio Bens");
    }//GEN-LAST:event_jMenuItemRelatorioBensActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        jInternalFornecedor();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
//        String url = "C:\\Users\\william\\JaspersoftWorkspace\\MyReports\\Relatorio Total Bens.jasper";
//        utilidades.relatorio(url, "Relátorio Total Bens");
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        jInternalVoucher();
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        jInternalProdutos();
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jInternalGrupoBens() {

        if (grupoBens == null) {
            grupoBens = new FrmGrupoBens();
            this.jPPrincipal.add(grupoBens);
            try {
                //set o tamanho máximo dela, que depende da janela pai     
                grupoBens.setMaximum(true);
            } catch (java.beans.PropertyVetoException e) {
                Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, e);
            }

        } else if (grupoBens != null) {
            grupoBens.dispose();
            grupoBens = null;
            grupoBens = new FrmGrupoBens();
            this.jPPrincipal.add(grupoBens);
            try {
                //set o tamanho máximo dela, que depende da janela pai     
                grupoBens.setMaximum(true);
            } catch (java.beans.PropertyVetoException e) {
                Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        grupoBens.show();
    }

    private void jInternalComputador() {
        if (frmComputador == null) {
            frmComputador = new FrmComputador();
            this.jPPrincipal.add(frmComputador);
            try {
                // set o tamanho máximo dela, que depende da janela pai     
                frmComputador.setMaximum(true);
            } catch (java.beans.PropertyVetoException e) {
                Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, e);
            }

        } else if (frmComputador != null) {
            frmComputador.dispose();
            frmComputador = null;
            frmComputador = new FrmComputador();
            this.jPPrincipal.add(frmComputador);
            try {
                //set o tamanho máximo dela, que depende da janela pai     
                frmComputador.setMaximum(true);
            } catch (java.beans.PropertyVetoException e) {
                Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        frmComputador.show();
    }

    private void jInternalCadastroBens() {
        if (bens == null) {
            bens = new FrmBens();
            this.jPPrincipal.add(bens);
            try {
                // set o tamanho máximo dela, que depende da janela pai     
                bens.setMaximum(true);
            } catch (java.beans.PropertyVetoException e) {
                Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, e);
            }

        } else if (bens != null) {
            bens.dispose();
            bens = null;
            bens = new FrmBens();
            this.jPPrincipal.add(bens);
            try {
                //set o tamanho máximo dela, que depende da janela pai     
                bens.setMaximum(true);
            } catch (java.beans.PropertyVetoException e) {
                Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, e);
            }

        }
        bens.show();
    }

    private void jInternalUsuarios() {
        if (frmUsuarios == null) {
            frmUsuarios = new FrmUsuario();
            this.jPPrincipal.add(frmUsuarios);
            try {
                // set o tamanho máximo dela, que depende da janela pai     
                frmUsuarios.setMaximum(true);
            } catch (java.beans.PropertyVetoException e) {
                Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, e);
            }

        } else if (frmUsuarios != null) {
            frmUsuarios.dispose();
            frmUsuarios = null;
            frmUsuarios = new FrmUsuario();
            this.jPPrincipal.add(frmUsuarios);
            try {
                //set o tamanho máximo dela, que depende da janela pai     
                frmUsuarios.setMaximum(true);
            } catch (java.beans.PropertyVetoException e) {
                Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        frmUsuarios.show();

    }

    private void jInternalManutencao() {
        if (manutencao == null) {
            manutencao = new FrmManutecao();
            this.jPPrincipal.add(manutencao);
            try {
                // set o tamanho máximo dela, que depende da janela pai     
                manutencao.setMaximum(true);
            } catch (java.beans.PropertyVetoException e) {
                Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, e);
            }

        } else if (manutencao != null) {
            manutencao.dispose();
            manutencao = null;
            manutencao = new FrmManutecao();
            this.jPPrincipal.add(manutencao);
            try {
                //set o tamanho máximo dela, que depende da janela pai     
                manutencao.setMaximum(true);
            } catch (java.beans.PropertyVetoException e) {
                Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        manutencao.show();

    }

    private void jInternalFornecedor() {
        if (fornecedor == null) {
            fornecedor = new FrmFornecedor();
            this.jPPrincipal.add(fornecedor);
            try {
                // set o tamanho máximo dela, que depende da janela pai     
                fornecedor.setMaximum(true);
            } catch (java.beans.PropertyVetoException e) {
                Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, e);
            }

        } else if (fornecedor != null) {
            fornecedor.dispose();
            fornecedor = null;
            fornecedor = new FrmFornecedor();
            this.jPPrincipal.add(fornecedor);
            try {
                //set o tamanho máximo dela, que depende da janela pai     
                fornecedor.setMaximum(true);
            } catch (java.beans.PropertyVetoException e) {
                Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        fornecedor.show();

    }

    private void jInternalVoucher() {
        if (voucher == null) {
            voucher = new FrmVoucher();
            this.jPPrincipal.add(voucher);
            try {
                // set o tamanho máximo dela, que depende da janela pai     
                voucher.setMaximum(true);
            } catch (java.beans.PropertyVetoException e) {
                Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, e);
            }

        } else if (voucher != null) {
            voucher.dispose();
            voucher = null;
            voucher = new FrmVoucher();
            this.jPPrincipal.add(voucher);
            try {
                //set o tamanho máximo dela, que depende da janela pai     
                voucher.setMaximum(true);
            } catch (java.beans.PropertyVetoException e) {
                Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        voucher.show();

    }

    private void jInternalProdutos() {
        if (produtos == null) {
            produtos = new FrmProdutos();
            this.jPPrincipal.add(produtos);
            try {
                // set o tamanho máximo dela, que depende da janela pai     
                produtos.setMaximum(true);
            } catch (java.beans.PropertyVetoException e) {
                Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, e);
            }

        } else if (produtos != null) {
            produtos.dispose();
            produtos = null;
            produtos = new FrmProdutos();
            this.jPPrincipal.add(produtos);
            try {
                //set o tamanho máximo dela, que depende da janela pai     
                produtos.setMaximum(true);
            } catch (java.beans.PropertyVetoException e) {
                Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        produtos.show();
    }

//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(() -> {
//            try {
//                new frmPrincipal().setVisible(true);
//            } catch (InterruptedException ex) {
//                Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLComputador;
    private javax.swing.JLabel jLData;
    private javax.swing.JLabel jLHora;
    private javax.swing.JLabel jLUsuario;
    private javax.swing.JLabel jLabelServidor;
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
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItemRelatorioBens;
    private javax.swing.JDesktopPane jPPrincipal;
    private javax.swing.JPanel jPSecundario;
    private javax.swing.JPanel jPStatusBar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaAtalho;
    private javax.swing.JMenu jmArquivo;
    private org.netbeans.examples.lib.timerbean.Timer timer1;
    // End of variables declaration//GEN-END:variables

    private boolean deslogar() {
        boolean retorno = false;
        String computador = "";
        usuarioTemp.setLogado(computador);
        usuarioTemp.setCodigo(idUsuario);

        if (usuarioDao.setLogado(usuarioTemp)) {
            retorno = true;
        }
        return retorno;
    }

    private void confirmaFechamento() {

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int confirma = JOptionPane.showConfirmDialog(null, "Tem Certeza que deseja sair?", "Saída", JOptionPane.YES_NO_OPTION);
                if (confirma == JOptionPane.YES_OPTION) {
                    if (deslogar()) {
                        System.exit(0);
                    } else {
                        repaint();
                    }
                } else {
                    repaint();
                }
            }
        });
    }
}
