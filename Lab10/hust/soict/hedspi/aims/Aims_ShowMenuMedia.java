package hust.soict.hedspi.aims;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Aims_ShowMenuMedia extends JFrame{
    public JPanel mainPanel;
    private JButton chooseDVDButton;
    private JButton chooseCDButton;
    private JButton chooseBookButton;
    private JButton exitButton;
    public static JFrame frame;

    public Aims_ShowMenuMedia() {
        setSize(700,700);
        chooseDVDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame = new JFrame("DVD input");
                frame.setContentPane(new DVD_Input().mainFrame);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
                Aims_G.frame2.dispose();
            }
        });
        chooseCDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame = new JFrame("Book input");
                frame.setContentPane(new CD_INPUT().mainFrame);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
                Aims_G.frame2.dispose();
            }
        });
        chooseBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame = new JFrame("Book input");
                frame.setContentPane(new Book_Input().mainFrame);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);

                Aims_G.frame2.dispose();

            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Aims_G.frame2.dispose();
            }
        });
    }
}
