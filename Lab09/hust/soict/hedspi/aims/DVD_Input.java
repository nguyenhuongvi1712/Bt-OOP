package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.disc.DigitalVideoDisc;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static hust.soict.hedspi.aims.Aims_gui.anOrder;

public class DVD_Input {
    public JPanel mainFrame;
    private JFormattedTextField formattedTextField1;
    private JFormattedTextField formattedTextField2;
    private JFormattedTextField formattedTextField3;
    private JFormattedTextField formattedTextField4;
    private JFormattedTextField formattedTextField5;
    private JFormattedTextField formattedTextField6;
    private JButton submitButton;

    public DVD_Input() {
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(formattedTextField1.getText().isEmpty() || formattedTextField2.getText().isEmpty()|| formattedTextField3.getText().isEmpty()|| formattedTextField4.getText().isEmpty() || formattedTextField5.getText().isEmpty()  || formattedTextField6.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,"Can khai bao day du thong tin");
                }
                else{
                    int id = Integer.parseInt(formattedTextField1.getText());
                    String title = formattedTextField2.getText();
                    String category = formattedTextField3.getText();
                    String director = formattedTextField4.getText();
                    float cost = Float.parseFloat(formattedTextField5.getText());
                    int length = Integer.parseInt(formattedTextField6.getText());
                    if(anOrder.searchById(id)!=null){
                        JOptionPane.showMessageDialog(null,"Media which have this id is already exists. Please enter id again");
                    }
                    else{
                        DigitalVideoDisc dvd = new DigitalVideoDisc(id, title, category,cost, director, length);
                        anOrder.addMedia(dvd);
                        JOptionPane.showMessageDialog(null,"Them vao DVD thanh cong");
                        int c = JOptionPane.showConfirmDialog(null,"Do you want to play ? ");
                        Aims_ShowMenuMedia.frame.dispose();
                        if(c == 0){
                            JFrame framePlay = new JFrame("DVD input");
                            framePlay.setContentPane(new DisplayDVD(dvd).mainFrame);
                            framePlay.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                            framePlay.pack();
                            framePlay.setVisible(true);
                        }


                    }
                }
            }
        });
    }
}
