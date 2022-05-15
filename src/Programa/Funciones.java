package Programa;

import static Programa.Main_Menu.usuario;
import java.util.*;
import javax.swing.*;

public class Funciones {

    public static String Year, Month, Day, Hour, Minute, ampm; 
    

    public static void hora() {
        Calendar Calendario = new GregorianCalendar();
        Date hora = new Date();
        Calendario.setTime(hora);
        Hour = Calendario.get(Calendar.HOUR_OF_DAY) > 9 ? "" + Calendario.get(Calendar.HOUR_OF_DAY) : "0" + Calendario.get(Calendar.HOUR_OF_DAY);
        int Hora = Integer.valueOf(Hour);
        if (Hora > 12) {
            Hora = Hora - 12;
            ampm = "pm";
        } else {
            ampm = "am";
        }
        Minute = Calendario.get(Calendar.MINUTE) > 9 ? "" + Calendario.get(Calendar.MINUTE) : "0" + Calendario.get(Calendar.MINUTE);
        Day = Calendario.get(Calendar.DATE) > 9 ? "" + Calendario.get(Calendar.DATE) : "0" + Calendario.get(Calendar.DATE);
        
        Month = Calendario.get(Calendar.MONTH) > 9 ? "" + Calendario.get(Calendar.MONTH) : "0" + Calendario.get(Calendar.MONTH);
        int mes = Integer.valueOf(Month)+1;
        if (mes < 10) {
            Month = "0" + String.valueOf(mes);
        }else{
            Month = String.valueOf(mes);
        }
        Year = Calendario.get(Calendar.YEAR) > 9 ? "" + Calendario.get(Calendar.YEAR) : "0" + Calendario.get(Calendar.YEAR);
        
    }

    public static void Apariencia() {
        try {
            JFrame.setDefaultLookAndFeelDecorated(true);
            JDialog.setDefaultLookAndFeelDecorated(true);
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    

}
