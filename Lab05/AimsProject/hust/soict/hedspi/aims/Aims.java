package hust.soict.hedspi.aims;
import hust.soict.hedspi.aims.disc.DigitalVideoDisc;
import hust.soict.hedspi.aims.order.Order;

import java.util.Scanner;

import static hust.soict.hedspi.aims.DiskTest.testDiskSearch;


public class Aims {



    public static void main(String[] args){
        String option ;

        Scanner sc = new Scanner(System.in);
        Order anOrder = new Order();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King");
        dvd1.setCategory("Animation");
        dvd1.setCost(19.95f);
        dvd1.setDirector("Roger Allers");
        dvd1.setLength(87);
        anOrder.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars");
        dvd2.setCategory("Science Fiction");
        dvd2.setCost(24.95f);
        dvd2.setDirector("Geogre Lucas");
        dvd2.setLength(124);
        anOrder.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("ALaddin");
        dvd3.setCategory("Animation");
        dvd3.setCost(18.99f);
        dvd3.setDirector("John Musker");
        dvd3.setLength(90);
        anOrder.addDigitalVideoDisc(dvd3);



        anOrder.print();

            System.out.println(anOrder.getALuckyItem().toString());
        anOrder.print();

        testDiskSearch(dvd1,"king LiOn",true);
        testDiskSearch(dvd2,"star x",false);
        testDiskSearch(dvd1,"the lion",true);

    }
}
