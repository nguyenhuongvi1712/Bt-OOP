package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.disc.DigitalVideoDisc;

import javax.swing.*;

public class DisplayDVD extends JFrame{
    public JPanel mainFrame;
    private JTextField textField1;
    private JTextField textField2;

    public DisplayDVD(DigitalVideoDisc dvd){
        try{
            dvd.play();
            textField1.setText(dvd.getTitle());
            textField2.setText(""+dvd.getLength());
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage() + "\n" + e.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        textField1.setEditable(false);
        textField2.setEditable(false);
    }
}
