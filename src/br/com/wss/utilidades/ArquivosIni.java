package br.com.wss.utilidades;

import br.com.wss.viwer.SpleshScreen;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author William
 */
public class ArquivosIni {

    static String diretorioConfig = "C:\\WssSolutions\\br\\com\\wss\\Config\\WssSolution.ini";

    /**
     *
     * @return
     */
    public static String getDiretorioInicial() {
        Properties config = new Properties();
        try {
            config.load(new FileInputStream(diretorioConfig));
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex);
            Logger.getLogger(ArquivosIni.class.getName()).log(Level.SEVERE, null, ex);
        }
        String diretorio = config.getProperty("versionAtual");
        return diretorio;
    }

    /**
     *
     * @return
     */
    public static String getDiretorioFinal() {
        Properties config = new Properties();
        try {
            config.load(new FileInputStream(diretorioConfig));
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex);
            Logger.getLogger(ArquivosIni.class.getName()).log(Level.SEVERE, null, ex);
        }
        String diretorio = config.getProperty("versionNova");
        return diretorio;
    }

    /**
     *
     * @return
     */
    public static String getCopyDirOrigem() {
        Properties config = new Properties();
        try {
            config.load(new FileInputStream(diretorioConfig));
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex);
            Logger.getLogger(ArquivosIni.class.getName()).log(Level.SEVERE, null, ex);
        }
        String origemFolderCopy = config.getProperty("origemFolderCopy");
        return origemFolderCopy;
    }

    /**
     *
     * @return
     */
    public static String getCopyDirDestino() {
        Properties config = new Properties();
        try {
            config.load(new FileInputStream(diretorioConfig));
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex);
            Logger.getLogger(ArquivosIni.class.getName()).log(Level.SEVERE, null, ex);
        }
        String destinoFolderCopy = config.getProperty("destinoFolderCopy");
        return destinoFolderCopy;
    }
    
    /**
     *
     * @return
     */
    public static String getSobre() {
        Properties config = new Properties();
        try {
            config.load(new FileInputStream(diretorioConfig));
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex);
            Logger.getLogger(ArquivosIni.class.getName()).log(Level.SEVERE, null, ex);
        }
        String arquivoSobre = config.getProperty("ArquivoSobre");
        return arquivoSobre;
    }
    
    /**
     *
     * @return
     */
    public static String getServidor() {
        Properties config = new Properties();
        try {
            config.load(new FileInputStream(diretorioConfig));
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex);
            Logger.getLogger(ArquivosIni.class.getName()).log(Level.SEVERE, null, ex);
        }
        String servidor = config.getProperty("Servidor");
        return servidor;
    }

    /**
     *
     */
    public static void sobre() {
        String mostra = "";
        String nomeArq = getSobre(); //Nome do arquivo, pode ser absoluto, ou pastas /dir/teste.txt
        String linha = "";
        File arq = new File(nomeArq);
        //Arquivo existe
        if (arq.exists()) {
            Properties config = new Properties();
            String arquivo = ArquivosIni.getDiretorioInicial();//local do arquivo                       
            try {
                config.load(new FileInputStream(arquivo));
                //abrindo arquivo para leitura
                FileReader reader = new FileReader(nomeArq);
                //leitor do arquivo
                BufferedReader leitor = new BufferedReader(reader);
                while (true) {
                    linha = leitor.readLine();
                    if (linha == null) {
                        break;
                    }
                    mostra += linha + "\n";
                }
            } catch (IOException ex) {
                Logger.getLogger(SpleshScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
            String versao = config.getProperty("VERSION");
            JOptionPane.showMessageDialog(null, mostra + "\n\n\n Versão: " + versao, "Arquivo...", 1);
        } //Se nao existir
        else {
            JOptionPane.showMessageDialog(null, "Arquivo nao existe!", "Erro", 0);
        }
    }

    public static String LendoArquivo(String caminho) {
        String mostra = "";
        String nomeArq = caminho;
        String linha = "";
        File arq = new File(nomeArq);
        //Arquivo existe
        if (arq.exists()) {
            try {
                //abrindo arquivo para leitura
                FileReader reader = new FileReader(nomeArq);
                //leitor do arquivo
                BufferedReader leitor = new BufferedReader(reader);
                while (true) {
                    linha = leitor.readLine();
                    if (linha == null) {
                        break;
                    }
                    mostra += linha + "\n";
                }
            } catch (IOException ex) {
                Logger.getLogger(SpleshScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
        } //Se nao existir
        else {
            JOptionPane.showMessageDialog(null, "Arquivo nao existe!", "Erro", 0);
        }
        return mostra;
    }

}
