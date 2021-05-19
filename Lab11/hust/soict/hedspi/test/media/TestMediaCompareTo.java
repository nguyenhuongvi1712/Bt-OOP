package hust.soict.hedspi.test.media;

import hust.soict.hedspi.aims.disc.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Track;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TestMediaCompareTo {
    public static void testcase1() {
        System.out.println("Test 1");
        System.out.println("\nCase1 : sort by title : ");
        DigitalVideoDisc dvd1 = new DigitalVideoDisc(1,"The Lion King","Animation",19.95f,"Roger Allers",87);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(2,"Star Wars","Science Fiction",24.95f,"George Lucas",124);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc(3,"Aladdin","Animation",18.99f,"John Musker",90);

        Collection collection = new ArrayList();
        collection.add(dvd1);
        collection.add(dvd2);
        collection.add(dvd3);

        java.util.Iterator iterator = collection.iterator();

        System.out.println("----------------------------------");
        System.out.println("The DVDs currently in the order are: ");

        while(iterator.hasNext()) {
            System.out.println(((DigitalVideoDisc) iterator.next()).getTitle());
        }

        java.util.Collections.sort((java.util.List) collection);
        iterator = collection.iterator();
        System.out.println("----------------------------------");
        System.out.println("The DVDs in sorted order are: ");

        while(iterator.hasNext()) {
            System.out.println(((DigitalVideoDisc) iterator.next()).getTitle());
        }
        System.out.println("\nCase2 : sort by cost and length : ");
        DigitalVideoDisc dvd4 = new DigitalVideoDisc(4,"The Lion King","Animation",19.95f,"Roger Allers",87);
        DigitalVideoDisc dvd5 = new DigitalVideoDisc(5,"Star Wars","Science Fiction",18.99f,"George Lucas",124);
        DigitalVideoDisc dvd6 = new DigitalVideoDisc(6,"Aladdin","Animation",18.99f,"John Musker",90);

        Collection collection1 = new ArrayList();
        collection1.add(dvd4);
        collection1.add(dvd5);
        collection1.add(dvd6);

        // unsort
        java.util.Iterator iterator1 = collection.iterator();

        System.out.println("----------------------------------");
        System.out.println("The DVDs currently in the order are: ");

        while(iterator1.hasNext()) {
            System.out.println(((DigitalVideoDisc) iterator1.next()).getTitle());
        }

        //sort
        java.util.Collections.sort((java.util.List) collection1);
        iterator1 = collection1.iterator();
        System.out.println("----------------------------------");
        System.out.println("The DVDs in sorted order are: ");

        while(iterator1.hasNext()) {
            System.out.println(((DigitalVideoDisc) iterator1.next()).getTitle());
        }
        System.out.println("\nCase3 : sort by cost , length , title : ");
        DigitalVideoDisc dvd7 = new DigitalVideoDisc(7,"The Lion King","Animation",19.95f,"Roger Allers",87);
        DigitalVideoDisc dvd8 = new DigitalVideoDisc(8,"Star Wars","Science Fiction",18.99f,"George Lucas",90);
        DigitalVideoDisc dvd9 = new DigitalVideoDisc(9,"Aladdin","Animation",18.99f,"John Musker",90);

        Collection collection3 = new ArrayList();
        collection3.add(dvd7);
        collection3.add(dvd8);
        collection3.add(dvd9);

        java.util.Iterator iterator3 = collection3.iterator();

        System.out.println("----------------------------------");
        System.out.println("The DVDs currently in the order are: ");

        while(iterator3.hasNext()) {
            System.out.println(((DigitalVideoDisc) iterator3.next()).getTitle());
        }

        java.util.Collections.sort((java.util.List) collection3);
        iterator3 = collection3.iterator();
        System.out.println("----------------------------------");
        System.out.println("The DVDs in sorted order are: ");

        while(iterator3.hasNext()) {
            System.out.println(((DigitalVideoDisc) iterator3.next()).getTitle());
        }

    }

    public static void testcase2() {
        System.out.println("Test 2");

        DigitalVideoDisc dvd1 = new DigitalVideoDisc(1,"The Lion King","Animation",19.95f,"Roger Allers",87);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(2,"Star Wars","Science Fiction",18.99f,"George Lucas",124);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc(3,"Aladdin","Animation",18.99f,"John Musker",90);

        Collection collection = new ArrayList();
        collection.add(dvd1);
        collection.add(dvd2);
        collection.add(dvd3);

        // unsort
        java.util.Iterator iterator = collection.iterator();

        System.out.println("----------------------------------");
        System.out.println("The DVDs currently in the order are: ");

        while(iterator.hasNext()) {
            System.out.println(((DigitalVideoDisc) iterator.next()).getTitle());
        }

        //sort
        java.util.Collections.sort((java.util.List) collection);
        iterator = collection.iterator();
        System.out.println("----------------------------------");
        System.out.println("The DVDs in sorted order are: ");

        while(iterator.hasNext()) {
            System.out.println(((DigitalVideoDisc) iterator.next()).getTitle());
        }
        // remove order
        collection.remove(dvd1);
        iterator = collection.iterator();
        System.out.println("----------------------------------");
        System.out.println("The DVDs in remove order are: ");

        while(iterator.hasNext()) {
            System.out.println(((DigitalVideoDisc) iterator.next()).getTitle());
        }
    }

    public static void testcase3() {
        System.out.println("Test 3");

        Book b1 = new Book(1,"The Lion King","Animation",19.95f);
        Book b2 = new Book(2,"Star Wars","Science Fiction",24.95f);
        Book b3 = new Book(3,"Aladdin","Animation",18.99f);

        Collection collection = new ArrayList();
        collection.add(b1);
        collection.add(b2);
        collection.add(b3);

        // unsort
        java.util.Iterator iterator = collection.iterator();

        System.out.println("----------------------------------");
        System.out.println("The Books currently in the order are: ");

        while(iterator.hasNext()) {
            System.out.println(((Book) iterator.next()).getTitle());
        }

        //sort
        java.util.Collections.sort((java.util.List) collection);
        iterator = collection.iterator();
        System.out.println("----------------------------------");
        System.out.println("The Books in sorted order are: ");

        while(iterator.hasNext()) {
            System.out.println(((Book) iterator.next()).getTitle());
        }
    }

    public static void testcase4() {
        System.out.println("Test 4");
        Track track = null;
        System.out.println("\nCase1 : sort by numbers of tracks list : ");
        CompactDisc cd1 = new CompactDisc(1, "See you", "Rock",12.95f ,"Taylor","Taylor",30);
        CompactDisc cd2 = new CompactDisc(2, "Love", "Jar",11.95f ,"Selena","Selena",40);
        CompactDisc cd3 = new CompactDisc(3, "Lover", "Jar",32.95f ,"Sam","Sam",120);
        for(int i = 0 ; i < 5;i++){
            track = new Track("Track cd1_"+i,11);
            cd1.addTrack(track);
        }
        for(int i = 0 ; i < 6;i++){
            track = new Track("Track cd2_"+i,11);
            cd2.addTrack(track);
        }
        for(int i = 0 ; i < 3;i++){
            track = new Track("Track cd3_"+i,11);
            cd3.addTrack(track);
        }

        Collection collection = new ArrayList();
        collection.add(cd1);
        collection.add(cd2);
        collection.add(cd3);

        // unsort
        java.util.Iterator iterator = collection.iterator();

        System.out.println("----------------------------------");
        System.out.println("The CDs currently in the order are: ");

        while(iterator.hasNext()) {
            System.out.println(((Media) iterator.next()).getTitle());
        }

        //sort
        java.util.Collections.sort((java.util.List) collection);
        iterator = collection.iterator();
        System.out.println("----------------------------------");
        System.out.println("The CDs in sorted order are: ");

        while(iterator.hasNext()) {
            System.out.println(((Media) iterator.next()).getTitle());
        }
        track = new Track("Track cd test",11);
        cd1.addTrack(track);
        for(int i = 3 ; i < 6;i++){
            track = new Track("Track cd3_"+i,11);
            cd3.addTrack(track);
        }
        Collection collection2 = new ArrayList();
        collection2.add(cd1);
        collection2.add(cd2);
        collection2.add(cd3);

        System.out.println("\nCase2 : sort by numbers of tracks list,length : ");
        System.out.println("Just add new tracks to cd1,cd2!");
        System.out.println("Now , the numbers of tracks of CD is "+cd1.getNumOfTrack());
        System.out.println("Now , the numbers of tracks of CD2 is "+cd2.getNumOfTrack());
        System.out.println("Now , the numbers of tracks of CD3 is "+cd3.getNumOfTrack());
        //sort
        java.util.Collections.sort((java.util.List) collection2);
        iterator = collection2.iterator();
        System.out.println("----------------------------------");
        System.out.println("The CDs in sorted order are: ");

        while(iterator.hasNext()) {
            System.out.println(((Media) iterator.next()).getTitle());
        }
        System.out.println("\nCase3 : sort by numbers of tracks list,length,title : ");
        CompactDisc cd4 = new CompactDisc(1, "See you", "Rock",12.95f ,"Taylor","Taylor",120);
        CompactDisc cd5 = new CompactDisc(2, "Love", "Jar",11.95f ,"Selena","Selena",120);
        CompactDisc cd6 = new CompactDisc(3, "Lover", "Jar",32.95f ,"Sam","Sam",120);
        for(int i = 0 ; i < 5;i++){
            track = new Track("Track cd1_"+i,11);
            cd4.addTrack(track);
            cd5.addTrack(track);
            cd6.addTrack(track);
        }
        Collection collection3 = new ArrayList();
        collection3.add(cd4);
        collection3.add(cd5);
        collection3.add(cd6);

        // unsort
        java.util.Iterator iterator3 = collection3.iterator();

        System.out.println("----------------------------------");
        System.out.println("The CDs currently in the order are: ");

        while(iterator3.hasNext()) {
            System.out.println(((Media) iterator3.next()).getTitle());
        }

        //sort
        java.util.Collections.sort((java.util.List) collection3);
        iterator3 = collection3.iterator();
        System.out.println("----------------------------------");
        System.out.println("The CDs in sorted order are: ");

        while(iterator3.hasNext()) {
            System.out.println(((Media) iterator3.next()).getTitle());
        }
    }
    public static void testcase5() {
        System.out.println("Test 5");
        Book b1 = new Book(1,"The Lion King");
        CompactDisc cd1 = new CompactDisc(2, "See you", "Rock",12.95f ,"Taylor","Taylor",30);
        DigitalVideoDisc dvd1 = new DigitalVideoDisc(3,"The Lion Queen","Animation",19.95f,"Roger Allers",87);
        Collection collection = new ArrayList();
        collection.add(dvd1);
        collection.add(b1);
        collection.add(cd1);

        // unsort
        java.util.Iterator iterator = collection.iterator();

        System.out.println("----------------------------------");
        System.out.println("The lists currently in the order are: ");

        while(iterator.hasNext()) {
            System.out.println(((Media) iterator.next()).getTitle());
        }

        //sort
        java.util.Collections.sort((java.util.List) collection);
        iterator = collection.iterator();
        System.out.println("----------------------------------");
        System.out.println("The lists in sorted order are: ");

        while(iterator.hasNext()) {
            System.out.println(((Media) iterator.next()).getTitle());
        }
    }
    public static void main(String[] args) {
        testcase1();
        System.out.println("#####################################");
        testcase2();
        System.out.println("#####################################");
        testcase3();
        System.out.println("#####################################");
        testcase4();
        System.out.println("#####################################");
        testcase5();
        System.out.println("#####################################");
    }
}
