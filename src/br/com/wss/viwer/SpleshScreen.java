package br.com.wss.viwer;

import br.com.wss.utilidades.ArquivosIni;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;

public class SpleshScreen extends javax.swing.JFrame {

    private Timer tempo;
    private final ActionListener al;

    public SpleshScreen() {
        Properties config = new Properties();
        String arquivo = ArquivosIni.getDiretorioInicial();//local do arquivo
        try {
            config.load(new FileInputStream(arquivo));

        } catch (IOException ex) {
            Logger.getLogger(SpleshScreen.class.getName()).log(Level.SEVERE, null, ex);
        }

        al = (ActionEvent e) -> {
            String versao = config.getProperty("VERSION");
            jLabelVersao.setText("Versão: " + versao);
            if (barraProgresso.getValue() < 25) {
                barraProgresso.setValue(barraProgresso.getValue() + 1);
                lBCarregando.setText("Conectando ao Banco...");
            } else if (barraProgresso.getValue() < 50) {
                barraProgresso.setValue(barraProgresso.getValue() + 1);
                lBCarregando.setText("Carregando Dados...");
            } else if (barraProgresso.getValue() < 85) {
                barraProgresso.setValue(barraProgresso.getValue() + 1);
                lBCarregando.setText("Carregando Sistema...");
            } else if (barraProgresso.getValue() < 100) {
                barraProgresso.setValue(barraProgresso.getValue() + 1);
                lBCarregando.setText("Iniciando Programa...");
            } else {
                tempo.stop();
                mostrar();
            }
        };
        tempo = new Timer(20, al);
        initComponents();
        tempo.start();
    }

    private void mostrar() {
        frmLogin login = new frmLogin();
        login.setSize(453, 348);
        login.setLocationRelativeTo(null);
        login.setVisible(true);
        this.dispose();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        barraProgresso = new javax.swing.JProgressBar();
        jLabelVersao = new javax.swing.JLabel();
        lBCarregando = new javax.swing.JLabel();
        jLabelIMG = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setFocusTraversalPolicyProvider(true);
        setUndecorated(true);
        getContentPane().setLayout(null);

        barraProgresso.setStringPainted(true);
        getContentPane().add(barraProgresso);
        barraProgresso.setBounds(60, 232, 360, 28);

        jLabelVersao.setText("Versao");
        getContentPane().add(jLabelVersao);
        jLabelVersao.setBounds(70, 210, 260, 14);

        lBCarregando.setText("william");
        getContentPane().add(lBCarregando);
        lBCarregando.setBounds(90, 266, 310, 20);

        jLabelIMG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/wss/img/Screen.jpg"))); // NOI18N
        getContentPane().add(jLabelIMG);
        jLabelIMG.setBounds(0, 0, 480, 286);

        setBounds(0, 0, 478, 286);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar barraProgresso;
    private javax.swing.JLabel jLabelIMG;
    private javax.swing.JLabel jLabelVersao;
    private javax.swing.JLabel lBCarregando;
    // End of variables declaration//GEN-END:variables

}
