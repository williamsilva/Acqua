package br.com.wss.utilidades;

import br.com.wss.dao.ConectionFactory;
import br.com.wss.viwer.SpleshScreen;
import br.com.wss.viwer.frmPrincipal;
import java.io.*;
import java.net.*;
import java.sql.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Principal {

    public static void main(String[] args) throws ClassNotFoundException,
            InstantiationException, IllegalAccessException,
            UnsupportedLookAndFeelException, IOException {

        Principal principal = new Principal();
        principal.chamar();

    }
    public static String computador;

    Connection conexao;
    PreparedStatement prepared;
    ResultSet result;
    String sql;
    static String copyFileDest = "C:\\WssSolutions\\sobre.ini";
    static String copyFileOrig = "C:\\Users\\william\\Documents\\NetBeansProjects\\Solutions\\sobre.ini";
    
    File origemFolder = new File("C:\\Users\\william\\Documents\\NetBeansProjects\\Solutions");
    File destinoFolder = new File("C:\\WssSolutions");

    public Principal() {
        conexao = ConectionFactory.getConnection();
    }

    public static String getMac() {
        StringBuilder sb = new StringBuilder();
        String verifica = "";
        try {
            NetworkInterface network = NetworkInterface.getByInetAddress(InetAddress.getLocalHost());
            byte[] mac = network.getHardwareAddress();

            if (mac != null) {
                for (int i = 0; i < mac.length; i++) {
                    sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "" : ""));
                    verifica = sb.toString();
                }
            } else {
                verifica = "";
            }

        } catch (UnknownHostException | SocketException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return verifica;
    }

    public String verificaMac() {
        String nome = "";
        String mac = getMac();
        sql = "select * from computador where macComputador = ?";
        try {
            prepared = conexao.prepareStatement(sql);
            prepared.setString(1, mac);
            result = prepared.executeQuery();
            if (result.next()) {
                nome = result.getString("nomeComputador");
            } else {
                nome = "";
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return nome;
    }

    public void chamar() {
        String macComputador = getMac();
        String macBanco = verificaMac();
        String VersaoAtual = versaoAtual();
        String VersaoNova = novaVersao();

        if (VersaoAtual == null || VersaoNova == null) {
            JOptionPane.showMessageDialog(null, "Não foi possivel verificar Atualizações!!");
            newForm();
        } else {
            if (Double.parseDouble(VersaoAtual) >= Double.parseDouble(VersaoNova)) {
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
                    CopyDir.copyFiles(origemFolder, destinoFolder);
                    
                   //Runtime.getRuntime().exec("java -jar C:\\Users\\william\\Documents\\NetBeansProjects\\ControleAtualizacao\\dist\\ControleAtualizacao.jar");
                } catch (IOException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }
                newForm();
                System.exit(0);
            }
        }
    }

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
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        SpleshScreen splesh = new SpleshScreen();
        splesh.setSize(480, 290);
        splesh.setLocationRelativeTo(null);
        splesh.setVisible(true);
    }

    public static String versaoAtual() {

        Properties config = new Properties();
        String arquivo = copyFileDest;//local do arquivo
        try {
            config.load(new FileInputStream(arquivo));
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        String versaoAtual = config.getProperty("versao");
        return versaoAtual;
    }

    public static String novaVersao() {
        Properties config = new Properties();
        String arquivo = copyFileOrig;//local do arquivo
        try {
            config.load(new FileInputStream(arquivo));
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        String versaoNova = config.getProperty("versao");
        return versaoNova;
    }
}
