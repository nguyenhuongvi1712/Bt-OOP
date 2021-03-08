package Lab02;
import java.util.*;

public class DisplayDaysOfAMonth {
    public static void main(String []args){
        int m;
        int year;
        int numOfDays;
        List<String> validMonth = Arrays.asList("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December",
                "Jan.", "Feb.", "Mar.", "Apr.", "Aug.", "Sept.", "Oct.", "Nov.", "Dec.",
                "Jan","Feb","Mar","Apr","Jul","Aug","Aug","Sep","Oct","Nov","Dec"
        );
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the month and the year: ");
        do {
            System.out.println("Month : (Ex: January or Jan. or Jan or 1)");
            String month = sc.nextLine();
            m = checkValidMonth(month,validMonth);
            if(m==0)
                System.out.println("Syntax of Error ! Please enter again !");
        }while (m==0);
        do {
            System.out.println("Year: (Ex: 1999)");
            year = sc.nextInt();
            if(year<0)
                System.out.println("Invalid year . Please enter again");
        }while (year<0);
        if(m==1||m==3||m==5||m==7||m==8||m==10||m==12)
            numOfDays = 31;
        else if(m==2 && checkLeadYear(year)==1){
            numOfDays = 29;
        }
        else if (m==2 && checkLeadYear(year)==0)
            numOfDays = 28;
        else
            numOfDays = 30;
        System.out.println("The number of days : "+numOfDays);

    }
    public static int checkLeadYear(int year){
        if(year%4==0&&!(year%100==0&&year%400!=0))
            return 1;
        return 0;
    }
    public static int checkValidMonth(String month,List<String> validMonth){
        if(isNumeric(month)&&Integer.parseInt(month)>=1&&Integer.parseInt(month)<=12)
            return Integer.parseInt(month);
        if(validMonth.stream().filter(o-> o.toLowerCase().equals(month.toLowerCase())).findFirst()!=null){
            String m = month.toLowerCase();
            if(m.equals("january")||m.equals("jan.")||m.equals("jan"))
                return 1;
            else if (m.equals("february")||m.equals("feb.")||m.equals("feb"))
                return 2;
            else if (m.equals("march")||m.equals("mar.")||m.equals("mar"))
                return 3;
            else if (m.equals("april")||m.equals("apr.")||m.equals("apr"))
                return 4;
            else if (m.equals("may"))
                return 5;
            else if (m.equals("june")||m.equals("jun"))
                return 6;
            else if (m.equals("july")||m.equals("jul"))
                return 7;
            else if (m.equals("august")||m.equals("aug.")||m.equals("aug"))
                return 8;
            else if (m.equals("september")||m.equals("sep.")||m.equals("sep"))
                return 9;
            else if (m.equals("october")||m.equals("oct.")||m.equals("oct"))
                return 10;
            else if (m.equals("november")||m.equals("nov.")||m.equals("nov"))
                return 11;
            else if (m.equals("december")||m.equals("dec.")||m.equals("dec"))
                return 12;
        }
        return 0;
    }
    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
