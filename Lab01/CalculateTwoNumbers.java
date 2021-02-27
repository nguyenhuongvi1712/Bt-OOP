package Lab01;
import javax.swing.JOptionPane;

public class CalculateTwoNumbers {
    public static void main(String[] argv){
        double num1,num2,sum,difference,product,quotient;
        num1 = Double.parseDouble(JOptionPane.showInputDialog(null,"Please input the first number: ","Input the dividend number",
                JOptionPane.INFORMATION_MESSAGE));
        do {
            num2 = Double.parseDouble(JOptionPane.showInputDialog(null, "Please input the divisor number: ", "Input the divisor number",
                    JOptionPane.INFORMATION_MESSAGE));
            if (num2 == 0)
                JOptionPane.showMessageDialog(null, "0 does not divide any other number! Please enter one again");
        }while(num2==0);
        JOptionPane.showMessageDialog(null,num1 +num2 , "Sum :",JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null,num1 -num2 , "Difference :",JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null,num1 *num2 , "Product :",JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null,num1 /num2 , "Quotient :",JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);

    }
}
