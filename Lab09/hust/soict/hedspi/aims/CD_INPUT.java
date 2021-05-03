package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.Track;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

    public CD_INPUT() {
        setSize(700,700);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(formattedTextField1.getText().isEmpty() || formattedTextField2.getText().isEmpty()|| formattedTextField3.getText().isEmpty()|| formattedTextField4.getText().isEmpty() || formattedTextField5.getText().isEmpty() || formattedTextField6.getText().isEmpty() || formattedTextField7.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,"Can khai bao day du thong tin");
                }
                else{
                    int id = Integer.parseInt(formattedTextField1.getText());
                    String title = formattedTextField2.getText();
                    String category = formattedTextField3.getText();
                    String artist = formattedTextField4.getText();
                    float cost = Float.parseFloat(formattedTextField5.getText());
                    String length_arr[] =  formattedTextField6.getText().split(";");
                    String title_arr[] = formattedTextField7.getText().split(";");
                    if(anOrder.searchById(id)!=null){
                        JOptionPane.showMessageDialog(null,"Media which have this id is already exists. Please enter id again");
                    }
                    else{
                        if(length_arr.length != title_arr.length)
                            JOptionPane.showMessageDialog(null,"length va title khong khop nhau !");
                        else{
                            CompactDisc cd = new CompactDisc(id, title, category,cost ,artist);
                            Track track = null;
                            for(int i = 0 ; i < length_arr.length;i++){
                                track = new Track(title_arr[i], Integer.parseInt(length_arr[i]));
                                cd.addTrack(track);
                            }
                            anOrder.addMedia(cd);
                            JOptionPane.showMessageDialog(null,"Them vao CD thanh cong");
                            int c = JOptionPane.showConfirmDialog(null,"Do you want to play ? ");
                            Aims_ShowMenuMedia.frame.dispose();
                            if(c == 0){
                                List<Track> tracks = cd.getTracks();
                                JFrame framePlay = new JFrame("DVD input");
                                framePlay.setContentPane(new DisplayTrack(tracks));
                                framePlay.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                framePlay.pack();
                                framePlay.setVisible(true);
                            }
                        }
                    }
                }
            }
        });
    }
}
