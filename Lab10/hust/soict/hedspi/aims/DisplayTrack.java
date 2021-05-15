package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.exceptions.PlayerException;
import hust.soict.hedspi.aims.media.Track;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class DisplayTrack extends JFrame{
    public DisplayTrack(List<Track> tracks){
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(tracks.size(), 1)); // The content-pane sets its layout

        for (int i = 0 ; i < tracks.size() ; i++){
            try {
                tracks.get(i).play();
                cp.add(new JTextField(tracks.get(i).toString()));
            } catch (PlayerException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(),"Warning",JOptionPane.ERROR_MESSAGE);
            }

        }
        setSize(300, 100);
    }
}
