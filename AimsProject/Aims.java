package AimsProject;
import java.util.Scanner;

import static junit.framework.Assert.assertEquals;

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


        System.out.print("Total Cost is: ");
        System.out.println(anOrder.totalCost());

        DigitalVideoDisc dvd4 = new DigitalVideoDisc("ALaddin");
        dvd4.setCategory("Animation");
        dvd4.setCost(2.55f);
        dvd4.setDirector("John Musker");
        dvd4.setLength(90);
        anOrder.addDigitalVideoDisc(dvd4);

        System.out.print("Total Cost is: ");
        System.out.println(anOrder.totalCost());
        do {
            System.out.println("Enter disc of title that you want to delete : ");
            String title = sc.nextLine();
            DigitalVideoDisc disc = anOrder.searchDiscByTitle(title);
            int cnt = anOrder.getCountOfSearchTitle(title);
            int currentQty = anOrder.getQtyOrdered();
            if (disc != null) {
                anOrder.removeDigitalVideoDisc(disc);
                Assert(disc, anOrder, cnt, 1, currentQty);
                System.out.println("Deleted ! ");
            } else {
                Assert(disc, anOrder, cnt, 0, currentQty);
                System.out.println("Title wasn't found !");
            }

            System.out.print("Total Cost is: ");
            System.out.println(anOrder.totalCost());

            System.out.print("Enter 'N' if you want to exit . If not, this program will continue . ");
            option = sc.nextLine();
        }while (!option.equals("N"));
    }
    public static void Assert(DigitalVideoDisc removeDisc,Order anOrder,int count,int expectation,int lassQty){ // expectation  = 0 : not thing to delete ; expectation = 1 : 1 disc deleted
        if(expectation == 0){
            assertEquals(lassQty, anOrder.getQtyOrdered());
        }
        else if(expectation == 1) {
            int c = anOrder.getCountOfSearchTitle(removeDisc.getTitle());
            assertEquals(c, count - 1);
        }
    }
}
