package br.com.wss.viwer;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class SpleshScreen extends javax.swing.JFrame {
    private Timer tempo;
    private final ActionListener al;
    public SpleshScreen() {
        al = (ActionEvent e) -> {
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
        jLabelIMG = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setFocusTraversalPolicyProvider(true);
        setUndecorated(true);

        barraProgresso.setStringPainted(true);

        lBCarregando.setText("william");

        jLabelIMG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/wss/img/Screen.jpg"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(barraProgresso, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(lBCarregando, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabelIMG, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelIMG, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(barraProgresso, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lBCarregando, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setBounds(0, 0, 478, 286);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar barraProgresso;
    private javax.swing.JLabel jLabelIMG;
    private javax.swing.JLabel lBCarregando;
    // End of variables declaration//GEN-END:variables

}
