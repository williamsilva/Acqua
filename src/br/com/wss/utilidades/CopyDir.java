/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wss.utilidades;

import java.io.*;
import javax.swing.JOptionPane;

/**
 *
 * @author William
 */
public class CopyDir {

    public static void copyFiles(File origem, File destino) throws FileNotFoundException, IOException {
        File srcFolder = origem;
        File destFolder = destino;

        if (!srcFolder.exists()) {
            JOptionPane.showMessageDialog(null, "Directory não Existe");
        } else {
            try {
                copyFolder(srcFolder, destFolder);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }

    public static void copyFolder(File src, File dest) throws IOException {
        if (src.isDirectory()) {
            if (!dest.exists()) {
                dest.mkdir();
                System.out.println("Directory copied from "
                        + src + "  to " + dest);
            }
            String files[] = src.list();

            for (String file : files) {

                File srcFile = new File(src, file);
                File destFile = new File(dest, file);
                copyFolder(srcFile, destFile);
            }

        } else {
            OutputStream out;
            try (InputStream in = new FileInputStream(src)) {
                out = new FileOutputStream(dest);
                byte[] buffer = new byte[1024];
                int length;

                while ((length = in.read(buffer)) > 0) {
                    out.write(buffer, 0, length);
                }
            }
            out.close();
            System.out.println("File copied from " + src + " to " + dest);
        }
        //Runtime.getRuntime().exec("java -jar C:\\Users\\william\\Documents\\NetBeansProjects\\Solutions\\dist\\acqua.jar");
    }

}
