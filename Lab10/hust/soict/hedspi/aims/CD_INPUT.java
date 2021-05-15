package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.exceptions.AddMediaException;
import hust.soict.hedspi.aims.exceptions.PlayerException;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.Track;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.util.List;

import static hust.soict.hedspi.aims.Aims_gui.anOrder;

public class CD_INPUT extends JFrame{
    public JPanel mainFrame;
    private JFormattedTextField formattedTextField1;
    private JFormattedTextField formattedTextField2;
    private JFormattedTextField formattedTextField3;
    private JFormattedTextField formattedTextField4;
    private JFormattedTextField formattedTextField5;
    private JFormattedTextField formattedTextField6;
    private JFormattedTextField formattedTextField7;
    private JButton submitButton;
    private JFormattedTextField formattedTextField8;


    public CD_INPUT() {
        setSize(700,700);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(formattedTextField1.getText().isEmpty() || formattedTextField2.getText().isEmpty()|| formattedTextField3.getText().isEmpty()|| formattedTextField4.getText().isEmpty() || formattedTextField5.getText().isEmpty() || formattedTextField6.getText().isEmpty() || formattedTextField7.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,"Can khai bao day du thong tin");
                }
                else{
                    try{
                        int id = Integer.parseInt(formattedTextField1.getText());
                        int length = Integer.parseInt(formattedTextField8.getText());
                        String title = formattedTextField2.getText();
                        String category = formattedTextField3.getText();
                        String artist = formattedTextField4.getText();
                        float cost = Float.parseFloat(formattedTextField5.getText());
                        String title_arr[] =  formattedTextField6.getText().split(";");
                        String length_arr[]= formattedTextField7.getText().split(";");
                        if(anOrder.searchById(id)!=null){
                            JOptionPane.showMessageDialog(null,"Media which have this id is already exists. Please enter id again");
                        }
                        else{
                            if(length_arr.length != title_arr.length)
                                JOptionPane.showMessageDialog(null,"length va title khong khop nhau !");
                            else{
                                CompactDisc cd = new CompactDisc(id, title, category,cost ,artist,length);
                                Track track = null;
                                for(int i = 0 ; i < length_arr.length;i++){
                                    try{
                                        track = new Track(title_arr[i], Integer.parseInt(length_arr[i]));
                                        cd.addTrack(track);
                                    }catch (NumberFormatException exception){
                                        JOptionPane.showMessageDialog(null, exception.getMessage(),"Warning",JOptionPane.ERROR_MESSAGE);
                                    }
                                }
                                try {
                                    anOrder.addMedia(cd);
                                    JOptionPane.showMessageDialog(null,"Them vao CD thanh cong");
                                    int c = JOptionPane.showConfirmDialog(null,"Do you want to play ? ");
                                    Aims_ShowMenuMedia.frame.dispose();
                                    if(c == 0){
                                        try {
                                            cd.play();
                                            List<Track> tracks = cd.getTracks();
                                            JFrame framePlay = new JFrame("DVD input");
                                            framePlay.setContentPane(new DisplayTrack(tracks));
                                            framePlay.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                            framePlay.pack();
                                            framePlay.setVisible(true);
                                        } catch (PlayerException playerException) {
                                            JOptionPane.showMessageDialog(null, playerException.getMessage(),"Warning",JOptionPane.ERROR_MESSAGE);
                                        }
                                    }
                                } catch (AddMediaException addMediaException) {
                                    JOptionPane.showMessageDialog(null, addMediaException.getMessage(),"Warning",JOptionPane.ERROR_MESSAGE);
                                }
                            }
                        }
                    }catch (NumberFormatException er){
                        JOptionPane.showMessageDialog(null, er.getMessage(),"Warning",JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

    }
}
