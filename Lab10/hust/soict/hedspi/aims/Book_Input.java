package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.exceptions.AddMediaException;
import hust.soict.hedspi.aims.media.Book;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static hust.soict.hedspi.aims.Aims_gui.anOrder;

public class Book_Input extends JFrame{
    public  JPanel mainFrame;
    private JFormattedTextField formattedTextField1;
    private JFormattedTextField formattedTextField2;
    private JFormattedTextField formattedTextField3;
    private JFormattedTextField formattedTextField4;
    private JFormattedTextField formattedTextField5;
    private JButton submitButton;
    private JLabel names;

    public Book_Input() {
        setSize(700,700);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int error = 0;
                if(formattedTextField1.getText().isEmpty() || formattedTextField2.getText().isEmpty()|| formattedTextField3.getText().isEmpty()|| formattedTextField4.getText().isEmpty() || formattedTextField5.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,"Can khai bao day du thong tin");
                }
                else{
                    try {
                        int id = Integer.parseInt(formattedTextField1.getText());
                        String title = formattedTextField2.getText();
                        String category = formattedTextField3.getText();
                        float cost = Float.parseFloat(formattedTextField4.getText());
                        String names = formattedTextField5.getText();
                        String[] array_name = names.split(";");
                        if(anOrder.searchById(id)!=null){
                            JOptionPane.showMessageDialog(null,"Media which have this id is already exists. Please enter id again");
                        }
                        else{
                            Book book = new Book(id, title, category, cost);
                            for(int i = 0 ; i< array_name.length ; i++) {
                                book.addAuthor(array_name[i]);
                            }
                            try {
                                anOrder.addMedia(book);
                                JOptionPane.showMessageDialog(null,"Them vao Book thanh cong");
                                Aims_ShowMenuMedia.frame.dispose();
                            } catch (AddMediaException addMediaException) {
                                JOptionPane.showMessageDialog(null, addMediaException.getMessage(),"Warning",JOptionPane.ERROR_MESSAGE);
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
