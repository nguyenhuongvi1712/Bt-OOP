package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.disc.DigitalVideoDisc;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class DiskTest {
    public static void testDiskSearch(DigitalVideoDisc dvd, String search_title, boolean option){
        if(option == true){
            assertTrue("Method search must return true",dvd.search(search_title));
        }
        else{
            assertFalse("Method search must return false",dvd.search(search_title));
        }
    }


}
