package br.com.wss.utilidades;

import br.com.wss.dao.ConectionFactory;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
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

    /**
     *
     * @param caminho
     * @param titulo
     */
    public void relatorio(String caminho, String titulo) {
        try {
//            HashMap parametros = new HashMap();
//            parametros.put("bens", "1");
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminho, new HashMap(), ConectionFactory.getConnection());
            JasperViewer jrviewer = new JasperViewer(jasperPrint, false);
            jrviewer.setExtendedState(MAXIMIZED_BOTH);
            jrviewer.setTitle(titulo);
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
        java.util.Date data = new java.util.Date();
        java.text.SimpleDateFormat sdf
                = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String setDate = sdf.format(data);
        return setDate;
    }

    /**
     *
     * @param data
     * @return
     * @throws ParseException
     */
    public static Date setDateChoose(String data) throws ParseException {
        if (data == null || data.equals("")) {
            Date date = null;
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            date = new java.sql.Date(((java.util.Date) formatter.parse("2000-01-01")).getTime());
            return date;
        } else {
            Date date = null;
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            date = new java.sql.Date(((java.util.Date) formatter.parse(data)).getTime());
            return date;
        }
    }

    /**
     *
     * @return @throws InterruptedException
     */
    public static String mostraHora() throws InterruptedException {

        Locale locale = new Locale("pt", "BR");
        GregorianCalendar calendar = new GregorianCalendar();
        SimpleDateFormat formatador = new SimpleDateFormat("HH':'mm':'ss", locale);
        String hora = (formatador.format(calendar.getTime()));
        return hora;
    }

    /**
     *
     * @return
     */
    public static String mostraHoraData() {
        Locale locale = new Locale("pt", "BR");
        GregorianCalendar calendar = new GregorianCalendar();
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy  HH':'mm':'ss", locale);
        String hora = (formatador.format(calendar.getTime()));
        return hora;
    }

    /**
     *
     * @param cpf
     * @param label
     * @param texto
     */
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

    /**
     *
     * @param data
     * @return
     */
    public static String setDateChooserMysql(JDateChooser data) {
        if (data != null) {
            String novaData;
            java.util.Date pega = data.getDate();
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            novaData = formato.format(pega);
            return novaData;
        } else {
            return null;
        }
    }

    /**
     *
     * @param date
     * @param dias
     * @return
     */
    public static String somarDias(JDateChooser date, JTextField dias) {

        java.util.Date data = date.getDate();
        String contador = String.valueOf(dias.getText());
        data.setDate(data.getDate() + Integer.parseInt(contador));
        String mostraFormato = "yyyy/MM/dd";
        SimpleDateFormat dataFormatada = new SimpleDateFormat(mostraFormato);
        String mostra = dataFormatada.format(data);
        return mostra;
    }

    /**
     *
     * @param date
     * @param text
     */
    public void totalDias(JDateChooser date, JTextField text) {

        LocalDate hoje = LocalDate.now();
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("yyyyMMdd");
        String dataAtual = hoje.format(formatador);

        String dataCompra = ClassUtils.setDateChooserMysql(date).replace("-", "");

        int dias = Integer.parseInt(dataAtual) - Integer.parseInt(dataCompra);
        text.setText(String.valueOf(dias));

    }
    
    public static String getMac (){
         StringBuilder sb = new StringBuilder();
        String mac = "";
        try {
            NetworkInterface network = NetworkInterface.getByInetAddress(InetAddress.getLocalHost());
            byte[] netWork = network.getHardwareAddress();

            if (netWork != null) {
                for (int i = 0; i < netWork.length; i++) {
                    sb.append(String.format("%02X%s", netWork[i], (i < netWork.length - 1) ? "" : ""));
                    mac = sb.toString();
                }
            } else {
                mac = "";
            }

        } catch (UnknownHostException | SocketException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
         return mac;
    }
  
}
