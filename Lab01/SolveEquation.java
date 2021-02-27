package Lab01;
import java.util.Scanner;
import java.lang.Math;

public class SolveEquation {
    public static void main(String[] argv){
        Integer s = 0;
        Double a,b,c,a11,a12,a21,a22,b1,b2,D,D1,D2;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("MENU");
            System.out.println("1. Enter 1 to solve the first-degree equation with one variable");
            System.out.println("2. Enter 2 to solve the system of first-degree equations with two variables");
            System.out.println("3. Enter 3 to solve the second-degree equation with one variable");
            System.out.println("4. Enter 4 to quit");
            s = Integer.parseInt(sc.nextLine());
            switch (s){
                case 1:
                    System.out.println("A first-degree equation with one variable can have a form such as ax + b = 0 (a !=0),where x is the variable,and a and b are coefficients . Please enter a and b : ");
                    do{
                        System.out.println("Enter a: ");
                        a = Double.parseDouble(sc.nextLine());
                        if(a==0) System.out.println("a != 0 . Please enter one again!");
                    }while (a==0);
                    System.out.println("Enter b : ");
                    b = Double.parseDouble(sc.nextLine());
                    System.out.println("The equation "+a+"x+ "+b+" =0 has a unique solution x = "+-b/a);
                    break;
                case 2:
                    System.out.println("A system of first-degree equations with two variables x1 and x2 can have a from such as a11x1 + a12x2 = b1 and a21a1 + a22x2 = b2. Please enter a11,a12,a21,a22,b1,b2 : ");
                    System.out.println("Enter a11 : ");
                    a11 = Double.parseDouble(sc.nextLine());
                    System.out.println("Enter a12 : ");
                    a12 = Double.parseDouble(sc.nextLine());
                    System.out.println("Enter a21 : ");
                    a21 = Double.parseDouble(sc.nextLine());
                    System.out.println("Enter a22 : ");
                    a22 = Double.parseDouble(sc.nextLine());
                    System.out.println("Enter b1 : ");
                    b1 = Double.parseDouble(sc.nextLine());
                    System.out.println("Enter b2 : ");
                    b2 = Double.parseDouble(sc.nextLine());
                    D = a11*a22 - a21*a12;
                    D1 = b1*a22 - b2*a12;
                    D2 = a11*b2 - a21*b1;
                    if(D!=0)
                        System.out.println("The system has a unique solution (x1,x2) = ("+D1/D+","+D2/D+"),");
                    else{
                        if(D1==0 && D2==0)
                            System.out.println("The system has infinitely many solutions. ");
                        else
                            System.out.println("The system has no solution");
                    }
                    break;
                case 3:
                    System.out.println("A second-degree equation with one variable can have a from such as ax^2 + bx + c = 0 (a!=0).Please enter a,b,c:  ");
                    do{
                        System.out.println("Enter a: ");
                        a = Double.parseDouble(sc.nextLine());
                        if(a==0) System.out.println("a != 0 . Please enter one again!");
                    }while (a==0);
                    System.out.println("Enter b : ");
                    b = Double.parseDouble(sc.nextLine());
                    System.out.println("Enter c : ");
                    c = Double.parseDouble(sc.nextLine());
                    double d = Math.pow(b,2) - 4*a*c;
                    if(d==0)
                        System.out.println("The equation has double root : "+-b/2*a);
                    else if(d>0)
                        System.out.println("The equation has two distinct roots : "+((-b + Math.sqrt(d))/2*a) +" and "+((-b-Math.sqrt(d))/2*a));
                    else
                        System.out.println("The equation has no solution.");
                    break;
                case 4:
                    System.out.println("Bye");
                    break;
                default:
                    System.out.println("Syntax error . Please enter one again!");
                    break;
            }
        }while(s != 4);
    }
}
