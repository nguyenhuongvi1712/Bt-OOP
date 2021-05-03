package hust.soict.hedspi.aims;
import hust.soict.hedspi.aims.order.Order;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static hust.soict.hedspi.aims.Aims_gui.anOrder;


public class Aims_G extends JFrame{
    private JButton chooseOption1Button;
    private JButton chooseOption2Button;
    private JButton chooseOption3Button;
    private JButton chooseOption4Button;
    private JButton chooseOption0Button;
    public JPanel mainPanel;


    public static JFrame frame2;


    public Aims_G() {
      setSize(500,500);
        chooseOption1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                anOrder = new Order();
                Aims_gui.case1 = 1;
                JOptionPane.showMessageDialog(null,"Create successfully");
            }
        });
        chooseOption2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Aims_gui.case1==0)
                    JOptionPane.showMessageDialog(null,"Please create new order before add anything!");
                else{
                    frame2 = new JFrame("Menu media");
                    frame2.setContentPane(new Aims_ShowMenuMedia().mainPanel);
                    frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    frame2.pack();
                    frame2.setVisible(true);
                }
            }
        });
        chooseOption3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Aims_gui.case1==0)
                    JOptionPane.showMessageDialog(null,"The Media list is empty !");
                else{
                    String s =(String) JOptionPane.showInputDialog(null,"Nhap id san pham muon xoa");
                    if(s != null && (s.length()>0) ){
                        Integer id = Integer.parseInt(s);
                        if(anOrder.searchById(id)==null)
                            JOptionPane.showMessageDialog(null,"ID khong ton tai !");
                        else {
                            anOrder.removeMedia(id);
                            JOptionPane.showMessageDialog(null,"Deleted");
                        }
                    }
                }
            }
        });
        chooseOption4Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Aims_gui.case1==0)
                    JOptionPane.showMessageDialog(null,"The Media list is empty !");
                else{
                    frame2 = new JFrame("media list");
                    frame2.setContentPane(new MediaList_GUI(anOrder));
                    frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    frame2.pack();
                    frame2.setVisible(true);

                }
            }
        });
        chooseOption0Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Quit!");
                System.exit(0);
            }
        });
    }

}
