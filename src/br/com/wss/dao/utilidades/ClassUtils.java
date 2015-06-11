package br.com.wss.dao.utilidades;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.GregorianCalendar;
import java.util.Locale;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import jdk.nashorn.internal.runtime.JSType;

public class ClassUtils {
    private static String usuarioLogado;
    private static String usuario;
    
    public static void setUsuarioLogado(String usuario){
        usuarioLogado = usuario;
    }
    public static String buscaUsuarioLogado(){
               
        return usuarioLogado;
    }
    public static void setUsuario(String nome) {
        usuario = nome;
    }
    public static String buscaUsuario(){
        return usuario;
    }

    public static String mostraData() {

        LocalDate hoje = LocalDate.now();
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String data = hoje.format(formatador);
        return data;
    }

    public static String mostraHora() throws InterruptedException {

        Locale locale = new Locale("pt", "BR");
        GregorianCalendar calendar = new GregorianCalendar();
        SimpleDateFormat formatador = new SimpleDateFormat("HH':'mm':'ss", locale);
        String hora = (formatador.format(calendar.getTime()));
        return hora;
    }

    public static String mostraHoraData() {
        Locale locale = new Locale("pt", "BR");
        GregorianCalendar calendar = new GregorianCalendar();
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy  HH':'mm':'ss",locale);
        String hora = (formatador.format(calendar.getTime()));
        return hora;
    }
    public static void validaCPF(String cpf, JLabel label, JFormattedTextField texto) {
        cpf = cpf.replace("-", "");
        cpf = cpf.replace(".", "");

        if (cpfParseString(cpf ,label,texto)) {
            String digitosFinais = "" + calculoDigito(dvCpf(10, cpf)) + calculoDigito(dvCpf(11, cpf));
            if (cpf.endsWith(digitosFinais)) {
                label.setText("CPF:");
                label.setForeground(Color.black);
            } else {
                texto.setText(null);
                label.setText("Cpf Invalido:");
                label.setForeground(Color.red);
            }
        }
    }

    private static boolean cpfParseString(String numCpf, JLabel label,JFormattedTextField texto) {
        Boolean confere = false;
        while (!confere == true) {

            if (numCpf == null) {
                label.setText("Campo obrigatoio:");
                texto.setText(null);
                label.setForeground(Color.red);
                return false;
            } else {
                numCpf = numCpf.trim();
                if (JSType.isNumber(numCpf) && numCpf.length() == 11) {
                    confere = true;
                } else {
                    label.setText("Cpf Invalido:");
                    texto.setText(null);
                    label.setForeground(Color.red);
                    return false;
                }
            }
        }
        return true;
    }

    private static int dvCpf(int num, String numCpf) {

        int j = num;
        int soma = 0;

        for (int i = 0; i < (num - 1); i++) {
            String digito = "" + numCpf.charAt(i);
            int digitoCpf = Integer.parseInt(digito);
            soma += (digitoCpf * j);
            j--;
        }

        return soma;

    }

    private static int calculoDigito(int sm) {
        return 11 - (sm % 11);
    }
    
}
