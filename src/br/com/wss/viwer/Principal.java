package br.com.wss.viwer;

import br.com.wss.dao.ConectionFactory;
import java.net.*;
import java.sql.*;
import javax.swing.*;

public class Principal {

    public static void main(String[] args) throws ClassNotFoundException,
            InstantiationException, IllegalAccessException,
            UnsupportedLookAndFeelException {

        Principal principal = new Principal();
        principal.chamar();

    }
    public static String computador;

    Connection conexao;
    PreparedStatement prepared;
    ResultSet result;
    String sql;

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
        sql = "select * from computador where mac_computador = ?";
        try {
            prepared = conexao.prepareStatement(sql);
            prepared.setString(1, mac);
            result = prepared.executeQuery();
            if (result.next()) {
                nome = result.getString("nome_computador");
            } else {
                nome = "";
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return nome;
    }

    public void chamar() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        String macComputador = getMac();
        String macBanco = verificaMac(); 
        if (!"".equals(macComputador) && !"".equals(macBanco)) {

            if (macComputador != null || equals(macBanco)) {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                SpleshScreen splesh = new SpleshScreen();
                splesh.setSize(486, 407);
                splesh.setLocationRelativeTo(null);
                splesh.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Computador não Autorizado");
            }
        } else if (macBanco.equals("")) {
            JOptionPane.showMessageDialog(null, "Computador não Autorizado", "Falha no Login", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao Verificar MAC", "Falha na Verifação", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
