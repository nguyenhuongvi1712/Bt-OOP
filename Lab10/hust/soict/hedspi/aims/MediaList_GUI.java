package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.order.Order;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

// A Swing GUI application inherits from top-level container javax.swing.JFrame
public class MediaList_GUI extends JFrame { // JFrame instead of Frame


    // Constructor to setup the GUI components and event handlers
    public MediaList_GUI(Order anorder) {

        Container cp = getContentPane();
        ArrayList<Media> itemsOrdered = anorder.getItemsOrdered();
        cp.setLayout(new GridLayout(itemsOrdered.size(), 1)); // The content-pane sets its layout

        for (int i = 0 ; i < itemsOrdered.size() ; i++){
            cp.add(new JTextField(itemsOrdered.get(i).toString()));
        }

        setTitle("Display Media");  // "super" JFrame sets title
        setSize(300, 100);          // "super" JFrame sets initial size
        setVisible(true);           // "super" JFrame shows
    }


}

