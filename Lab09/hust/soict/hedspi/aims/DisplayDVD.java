package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.disc.DigitalVideoDisc;

import javax.swing.*;

public class DisplayDVD extends JFrame{
    public JPanel mainFrame;
    private JTextField textField1;
    private JTextField textField2;

    public DisplayDVD(DigitalVideoDisc dvd){
        textField1.setText(dvd.getTitle());
        textField2.setText(""+dvd.getLength());
        textField1.setEditable(false);
        textField2.setEditable(false);
    }
}
