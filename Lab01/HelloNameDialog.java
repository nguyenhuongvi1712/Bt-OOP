package Lab01;
import javax.swing.JOptionPane;
public class HelloNameDialog {
    public static void main(String[] argv){
        String result ;
        result = JOptionPane.showInputDialog("Enter your name: ");
        JOptionPane.showMessageDialog(null,"Hi" + result + " !");
        System.exit(0);
    }


}
