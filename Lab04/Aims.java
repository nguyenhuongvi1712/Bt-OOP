package Lab04;
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

        TestAddDigitalVideoDiscArr(anOrder,10,0);
        TestAddDigitalVideoDiscArr(anOrder,4,1);

        TestAddDigitalVideoDiscWithToObj(anOrder,2);
        TestAddDigitalVideoDiscWithToObj(anOrder,1);
        TestAddDigitalVideoDiscWithToObj(anOrder,0);

    }
    public static void TestAddDigitalVideoDiscArr(Order anOrder,int qtyTest,int option){ //option 0 : cannot be added ; option 1 : can be added
        DigitalVideoDisc[] itemsOrderListTest = new DigitalVideoDisc[qtyTest];
        int currentQty = anOrder.getQtyOrdered();
        for(int i = 0 ; i < qtyTest ; i++){
            itemsOrderListTest[i] = new DigitalVideoDisc("Test title","Test category","Test director",124,24.95f);
        }
        anOrder.addDigitalVideoDisc(itemsOrderListTest);
        if(option == 0)
            assertEquals("All DVDs of the list must not be added",anOrder.getQtyOrdered(),currentQty);
        else if(option == 1)
            assertEquals("All DVDs of the list must be added",anOrder.getQtyOrdered(),currentQty + qtyTest);
    }
    public static void TestAddDigitalVideoDiscWithToObj(Order anOrder,int option){//option 0 : All DVDs cannot be added ; option 1 :  Only the first DVD  be added ; option 2 : All DVDs must be added
        int currentQty = anOrder.getQtyOrdered();
        DigitalVideoDisc dvdTest1 = new DigitalVideoDisc("Test title1","Test category1","Test director1",124,24.95f);
        DigitalVideoDisc dvdTest2 = new DigitalVideoDisc("Test title2","Test category2","Test director2",124,24.95f);
        anOrder.addDigitalVideoDisc(dvdTest1,dvdTest2);
        if(option == 0)
            assertEquals("All DVDs of the list must not be added",anOrder.getQtyOrdered(),currentQty);
        else if(option == 1)
            assertEquals("Only the first DVD of the list must be added",anOrder.getQtyOrdered(),currentQty + 1);
        else if(option == 2)
            assertEquals("All DVDs of the list must be added",anOrder.getQtyOrdered(),currentQty + 2);
    }
}
