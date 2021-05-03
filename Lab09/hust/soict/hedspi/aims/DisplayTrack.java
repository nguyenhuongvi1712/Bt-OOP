package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.media.Track;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class DisplayTrack extends JFrame{
    public DisplayTrack(List<Track> tracks){
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(tracks.size(), 1)); // The content-pane sets its layout

        for (int i = 0 ; i < tracks.size() ; i++){
            cp.add(new JTextField(tracks.get(i).toString()));

        }
        setSize(300, 100);
    }
}
