package Form;

import com.sun.awt.AWTUtilities;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class SpleshScreen extends javax.swing.JFrame {
    private Timer tempo;
    private final ActionListener al;
    public SpleshScreen() {
        al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
            }
        };
        tempo = new Timer(20, al);
        initComponents();
        AWTUtilities.setWindowOpaque(this, false);
        tempo.start();
    }

    private void mostrar() {
        frmLogin login = new frmLogin();
        login.setSize(453,348);
        login.setLocationRelativeTo(null);
        login.setVisible(true);
        this.dispose();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        barraProgresso = new javax.swing.JProgressBar();
        lBCarregando = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLImg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);

        barraProgresso.setStringPainted(true);
        getContentPane().add(barraProgresso);
        barraProgresso.setBounds(60, 250, 360, 20);

        lBCarregando.setText("william");
        getContentPane().add(lBCarregando);
        lBCarregando.setBounds(130, 270, 310, 20);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 0, 0);

        jLImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Screen.jpg"))); // NOI18N
        getContentPane().add(jLImg);
        jLImg.setBounds(0, 0, 478, 307);

        setBounds(0, 0, 478, 307);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar barraProgresso;
    private javax.swing.JLabel jLImg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lBCarregando;
    // End of variables declaration//GEN-END:variables

}
