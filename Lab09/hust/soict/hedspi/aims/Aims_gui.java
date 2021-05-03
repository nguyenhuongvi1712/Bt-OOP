package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.order.Order;

import javax.swing.*;

public class Aims_gui {
    public static int case1 = 0;
    public static Order anOrder = null;
    public static JFrame frame;

    public static void main(String[] args) {
        frame = new JFrame("Aims_G");
        frame.setContentPane(new Aims_G().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
