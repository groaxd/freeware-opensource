package freeware;

import javax.swing.*;
import java.awt.*;

public class Main
{
    public static void main(final String[] array) {
        System.out.println("Launcher'i ana klasörden açamazsın!\nLüfen önce Launcher Başlatıcı'yı aç!");
        JOptionPane.showMessageDialog(null, "Launcher'i ana klasörden açamazsın!\nLütfen önce Launcher Başlatıcı'yı aç!", "Freeware", JOptionPane.ERROR_MESSAGE);
    }
}
