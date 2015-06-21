package br.com.wss.utilidades;

import br.com.wss.dao.ConectionFactory;
import br.com.wss.viwer.SpleshScreen;
import java.io.*;
import java.net.*;
import java.sql.*;
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
    static String diretorioFinal = "C:\\Users\\william\\Google Drive\\Solutions\\Version\\Version.txt";
    static String diretorioInicial = "C:\\Users\\william\\Documents\\NetBeansProjects\\Solutions\\Version\\Version.txt";

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
            System.out.println(e.getMessage());
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
            if (Integer.parseInt(VersaoAtual) >= Integer.parseInt(VersaoNova)) {
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
                    Runtime.getRuntime().exec("java -jar C:\\Users\\william\\Documents\\NetBeansProjects\\ControleAtualizacao\\dist\\ControleAtualizacao.jar");
                } catch (IOException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }
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

//                try {
//                    for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                        if ("Nimbus".equals(info.getName())) {
//                            javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                            break;
//                        }
//                    }
//                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
//                    java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//                }
        SpleshScreen splesh = new SpleshScreen();
        splesh.setSize(485, 305);
        splesh.setLocationRelativeTo(null);
        splesh.setVisible(true);
    }

    public static String versaoAtual() {
        String versaoAtual = null;
        try {
            BufferedReader br = new BufferedReader(new FileReader(diretorioFinal));
            String ultimaLinha = br.readLine();

            while (ultimaLinha != null) {
                versaoAtual = ultimaLinha;
                ultimaLinha = br.readLine();
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return versaoAtual;
    }

    public static String novaVersao() {
        String versaoNova = null;

        try {
            BufferedReader br = new BufferedReader(new FileReader(diretorioInicial));
            String ultimaLinha = br.readLine();
            while (ultimaLinha != null) {
                versaoNova = ultimaLinha;
                ultimaLinha = br.readLine();
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return versaoNova;
    }
}
