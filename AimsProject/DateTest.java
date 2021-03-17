package AimsProject;

import junit.framework.TestCase;

public class DateTest extends TestCase {
    public static void main(String []args){
        MyDate date1= new MyDate();
        testGetDay(18,date1);
        testGetMonth(3,date1);
        testGetYear(2021,date1);
        testSetYear(-2001,date1,1);
        testSetYear(2013,date1,0);
        testSetMonth(13,date1,1);
        testSetMonth(2,date1,0);

        date1.print();

        testSetDay(29,date1,1); // Invalid day because 2013 is not leap year
        testSetDay(100,date1,1);
        testSetDay(12,date1,0);

        testAccept(12,13,2020,date1,1); // Invalid date
        date1.print();
        testAccept(12,11,2020,date1,0); // valid date
        date1.print();

    }
    public static void testGetDay(int day, MyDate d){
        assertEquals("Method getDay() is not working properly",day,d.getDay());
        System.out.println("Method getDay() worked just fine");
    }
    public static void testGetMonth(int month, MyDate d){
        assertEquals("Method getMonth() is not working properly",month,d.getMonth());
        System.out.println("Method getMonth() worked just fine");
    }
    public static void testGetYear(int year, MyDate d){
        assertEquals("Method getYear() is not working properly",year,d.getYear());
        System.out.println("Method getYear() worked just fine");
    }

    public static void testSetYear(int year, MyDate d,int option){ // option = 0 : Valid Year ; Option = 1 : Invalid Year
        if(option == 0 ) {
            d.setYear(year);
            assertEquals("Method SetYear() is not working properly",year, d.getYear());
            System.out.println("Method SetYear() worked just fine");
        }
        else if (option == 1) {
            d.setYear(year);
            assertTrue("Method SetYear() is not working properly",year != d.getYear());
            System.out.println("Method SetYear() worked just fine");
        }
    }

    public static void testSetMonth(int month, MyDate d,int option){ // option = 0 : Valid Month ; Option = 1 : Invalid Month
        if(option == 0 ) {
            d.setMonth(month);
            assertEquals("Method setMonth() is not working properly",month, d.getMonth());
            System.out.println("Method setMonth() worked just fine");
        }
        else if (option == 1) {
            d.setMonth(month);
            assertTrue("Method setMonth() is not working properly",month != d.getMonth());
            System.out.println("Method setMonth() worked just fine");
        }
    }
    public static void testSetDay(int day, MyDate d,int option){ // option = 0 : Valid Day ; Option = 1 : Invalid Day
        if(option == 0 ) {
            d.setDay(day);
            assertEquals("Method setDay() is not working properly",day, d.getDay());
            System.out.println("Method setDay() worked just fine");
        }
        else if (option == 1) {
            d.setDay(day);
            assertTrue("Method setDay() is not working properly",day != d.getDay());
            System.out.println("Method setDay() worked just fine");
        }
    }

    public static void testAccept(int day, int month, int year, MyDate d,int option){ //option = 0 : Valid date ; Option = 1 : Invalid date
        if (option == 0) {
            d.accept();
            assertTrue("Method accept() is not working properly",d.getDay() == day && d.getMonth() == month && d.getYear() == year);
            System.out.println("Method acceptDay() worked just fine");
        }
        else if (option == 1){
            d.accept();
            assertTrue("Method accept() is not working properly",d.getDay() != day || d.getMonth() != month || d.getYear() != year);
            System.out.println("Method acceptDay() worked just fine");
        }
    }


}
