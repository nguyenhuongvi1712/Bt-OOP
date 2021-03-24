package Lab04;

import junit.framework.TestCase;

import static Lab04.DateUtils.compare;
import static Lab04.DateUtils.sortDate;

public class DateTest extends TestCase {
    public static void main(String []args){
        MyDate date1= new MyDate(18,3,2021);
        testGetDay(18,date1);
        testGetMonth(3,date1);
        testGetYear(2021,date1);
        testSetYear(-2001,date1,1);
        testSetYear(2013,date1,0);
        testSetMonth(13,date1,1);
        testSetMonth(2,date1,0);

        testSetDay(29,date1,1); // Invalid day because 2013 is not leap year
        testSetDay(100,date1,1);
        testSetDay(12,date1,0);

        testAccept(12,13,2020,date1,1); // Invalid date
        date1.print();
        testAccept(12,11,2020,date1,0); // valid date
        date1.print();

        MyDate[] dateArr = new MyDate[5];
        dateArr[0] = new MyDate(2,3,2021);
        dateArr[1] = new MyDate(3,2,2021);
        dateArr[2] = new MyDate(2,3,2021);
        dateArr[3] = new MyDate(1,1,2020);
        dateArr[4] = new MyDate(31,12,2019);
        testCompare(dateArr[0],dateArr[1],1);
        testCompare(dateArr[0],dateArr[2],0);
        testCompare(dateArr[1],dateArr[0],-1);
        testCompare(dateArr[3],dateArr[4],1);
        testSortDate(dateArr);
        testPrintWithMultiOption(dateArr[1],1,"My Date (yyyy-MM-dd): 2020-01-01");
        testPrintWithMultiOption(dateArr[1],2,"My Date (d/M/yyyy): 1/1/2020");
        testPrintWithMultiOption(dateArr[1],3,"My Date (dd-MMM-yyyy): 01-Jan-2020");
        testPrintWithMultiOption(dateArr[1],4,"My Date (MMM d yyyy): Jan 1 2020");
        testPrintWithMultiOption(dateArr[1],5,"My Date (mm-dd-yyyy): 01-01-2020");
        testPrintWithMultiOption(dateArr[1],7,"My Date : January 1st 2020"); // test default print
        testPrintWithMultiOption(dateArr[0],6,"My Date : December 31th 2019"); // test default print
        testPrintWithMultiOption(dateArr[2],6,"My Date : February 3rd 2021"); // test default print
        testPrintWithMultiOption(dateArr[3],6,"My Date : March 2nd 2021"); // test default print

        MyDate date2 = new MyDate("second","March","twenty hundred");
        testPrintWithMultiOption(date2,6,"My Date : March 2nd 2000"); // test constructor
        MyDate date3 = new MyDate("thirty-first","december","nineteen ninety-one");
        testPrintWithMultiOption(date3,6,"My Date : December 31th 1991"); // test constructor
        MyDate date4 = new MyDate("twenty-ninth","February","twenty eleven");
        testPrintWithMultiOption(date4,6,"My Date : February 29th 2011"); // test constructor

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

    public static void testCompare(MyDate d1, MyDate d2,int expectation){
        assertEquals("The result of compare method did not meet the expectation.",compare(d1,d2),expectation);
    }
    public static void testSortDate(MyDate[] dateArr){
        sortDate(dateArr);
        for (int i = 0 ; i < dateArr.length ; i++){
            for (int j = i + 1 ; j < dateArr.length ; j++ ){
                    assertFalse("The result of sortDate method did not meet the expectation.",compare(dateArr[i],dateArr[j])>0);
            }
        }
    }
    public static void testPrintWithMultiOption(MyDate d1,int option, String expectation){
        assertEquals("The result of print with option "+option+" did not meet the expectation.",d1.print(option),expectation);
    }
}
