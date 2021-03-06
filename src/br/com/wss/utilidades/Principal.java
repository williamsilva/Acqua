package br.com.wss.utilidades;

import br.com.wss.dao.ComputadorDao;
import br.com.wss.dao.ConectionFactory;
import br.com.wss.viwer.SpleshScreen;
import br.com.wss.viwer.FrmPrincipal;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author William
 */
public class Principal {
    ComputadorDao dao = new ComputadorDao();
    /**
     *
     * @param args
     * @throws ClassNotFoundException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws UnsupportedLookAndFeelException
     * @throws IOException
     */
    public static void main(String[] args) throws ClassNotFoundException,
            InstantiationException, IllegalAccessException,
            UnsupportedLookAndFeelException, IOException {

        Principal principal = new Principal();
        principal.chamar();

    }

    /**
     *
     */
    public static String computador;

    Connection conexao;
    PreparedStatement prepared;
    ResultSet result;
    String sql;
    static String versionAtual = ArquivosIni.getDiretorioInicial();
    static String versionNova = ArquivosIni.getDiretorioFinal();

    File origemFolderCopy = new File(ArquivosIni.getCopyDirOrigem());
    File destinoFolderCopy = new File(ArquivosIni.getCopyDirDestino());

    /**
     *
     */
    public Principal() {
        conexao = ConectionFactory.getConnection();
    }
    /**
     *
     */
    public void chamar() {
        String macComputador = ClassUtils.getMac();
        String macBanco = dao.buscarComputador(macComputador);
        String VersaoAtual = getVersaoAtual();
        String VersaoNova = getNovaVersao();

        if (VersaoAtual == null || VersaoNova == null) {
            JOptionPane.showMessageDialog(null, "Não foi possivel verificar Atualizações!!");
            System.exit(0);
        } else if (Double.parseDouble(VersaoAtual) >= Double.parseDouble(VersaoNova)) {
            if (!"".equals(macComputador) && !"".equals(macBanco)) {

                if (macComputador != null || equals(macBanco)) {
                    newForm();
                } else {
                    JOptionPane.showMessageDialog(null, "Computador não Autorizado");
                }
            } else if (macBanco.equals("")) {
                JOptionPane.showMessageDialog(null, "Computador não Autorizado", "Falha no Login", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao Verificar MAC", "Falha na Verifação", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            try {
                CopyDir.copyFiles(origemFolderCopy, destinoFolderCopy);
            } catch (IOException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
            newForm();
            System.exit(0);
        }
    }

    /**
     *
     */
    public void newForm() {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        SpleshScreen splesh = new SpleshScreen();
        splesh.setSize(480, 290);
        splesh.setLocationRelativeTo(null);
        splesh.setVisible(true);

    }

    /**
     *
     * @return
     */
    public static String getVersaoAtual() {

        Properties config = new Properties();
        String arquivo = versionAtual;//local do arquivo
        try {
            config.load(new FileInputStream(arquivo));
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        String versaoAtual = config.getProperty("VERSION");
        return versaoAtual;
    }

    /**
     *
     * @return
     */
    public static String getNovaVersao() {
        Properties config = new Properties();
        String arquivo = versionNova;//local do arquivo
        try {
            config.load(new FileInputStream(arquivo));
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        String versaoNova = config.getProperty("VERSION");
        return versaoNova;
    }
}
