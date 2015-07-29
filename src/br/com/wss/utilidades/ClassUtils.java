package br.com.wss.utilidades;

import br.com.wss.dao.ConectionFactory;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Locale;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import jdk.nashorn.internal.runtime.JSType;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class ClassUtils {

    private static String usuario;
    private static String idUsuario;

    public void relatorio(String caminho){
        try {
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminho, new HashMap<>(), ConectionFactory.getConnection());
            JasperViewer jrviewer = new JasperViewer(jasperPrint, false);
            jrviewer.setExtendedState(MAXIMIZED_BOTH);
            jrviewer.setVisible(true);
            jrviewer.toFront();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }         
    }
    
    public static void setIdUsuario(String id) {
        idUsuario = id;
    }

    public static String getUsuario() {
        return usuario;
    }
    
    public static void setUsuario(String nome) {
        usuario = nome;
    }

    public static String getIdUsuario() {
        return idUsuario;
    }

    public static String mostraData() {

        LocalDate hoje = LocalDate.now();
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String data = hoje.format(formatador);
        return data;
    }

    /**
     *
     * @return
     */
    public static String setDateMsqy() {
        java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf
                = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = sdf.format(dt);
        return currentTime;
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
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy  HH':'mm':'ss", locale);
        String hora = (formatador.format(calendar.getTime()));
        return hora;
    }

    public static void validaCPF(String cpf, JLabel label, JFormattedTextField texto) {
        cpf = cpf.replace("-", "");
        cpf = cpf.replace(".", "");

        if (cpfParseString(cpf, label, texto)) {
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

    private static boolean cpfParseString(String numCpf, JLabel label, JFormattedTextField texto) {
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

    public static String setFormatData(String data) throws Exception {
        String[] teste = new String[2];
        teste = data.split("-");
        data = "";
        for (int i = 0; i < 3; i++) {
            data = data + "/" + teste[i];
        }
        data = data.substring(1, 11);
        return data;
    }

    public static String setDateChooser(JDateChooser data) {
        String novaData;
        java.util.Date pega = data.getDate();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        novaData = formato.format(pega);

        return novaData;
    }

    public static String somarDias(JDateChooser date, JTextField dias) {

        java.util.Date data = date.getDate();
        String contador = String.valueOf(dias.getText());

        data.setDate(data.getDate() + Integer.parseInt(contador));

        String mostraFormato = "yyyy/MM/dd";
        SimpleDateFormat dataFormatada = new SimpleDateFormat(mostraFormato);
        String mostra = dataFormatada.format(data);
        return mostra;
    }

    public void totalDias(JDateChooser date, JTextField text) {

        LocalDate hoje = LocalDate.now();
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("yyyyMMdd");
        String dataAtual = hoje.format(formatador);

        String dataCompra = ClassUtils.setDateChooser(date).replace("-", "");

        int dias = Integer.parseInt(dataAtual) - Integer.parseInt(dataCompra);
        text.setText(String.valueOf(dias));

    }
}