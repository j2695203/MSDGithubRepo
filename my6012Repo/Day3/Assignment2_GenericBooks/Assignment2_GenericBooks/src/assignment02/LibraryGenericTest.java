package assignment02;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;

class LibraryGenericTest {

    @Test
    public void stringLibraryTest() {
        // test a library that uses names (String) to id patrons
        LibraryGeneric<String> lib = new LibraryGeneric<>();
        lib.add(9780374292799L, "Thomas L. Friedman", "The World is Flat");
        lib.add(9780330351690L, "Jon Krakauer", "Into the Wild");
        lib.add(9780446580342L, "David Baldacci", "Simple Genius");

        String patron1 = "Jane Doe";

        assertTrue(lib.checkout(9780330351690L, patron1, 1, 1, 2008));
        assertTrue(lib.checkout(9780374292799L, patron1, 1, 1, 2008));

        var booksCheckedOut1 = lib.lookup(patron1);
        assertEquals(booksCheckedOut1.size(), 2);
        assertTrue(booksCheckedOut1.contains(new Book(9780330351690L, "Jon Krakauer", "Into the Wild")));
        assertTrue(booksCheckedOut1.contains(new Book(9780374292799L, "Thomas L. Friedman", "The World is Flat")));
        assertEquals(booksCheckedOut1.get(0).getHolder(), patron1);
        assertEquals(booksCheckedOut1.get(0).getDueDate(), new GregorianCalendar(2008, 1, 1));
        assertEquals(booksCheckedOut1.get(1).getHolder(),patron1);
        assertEquals(booksCheckedOut1.get(1).getDueDate(),new GregorianCalendar(2008, 1, 1));

        assertTrue(lib.checkin(patron1));

    }

    @Test
    public void phoneNumberTest(){
        // test a library that uses phone numbers (PhoneNumber) to id patrons
        var lib = new LibraryGeneric<PhoneNumber>();
        lib.add(9780374292799L, "Thomas L. Friedman", "The World is Flat");
        lib.add(9780330351690L, "Jon Krakauer", "Into the Wild");
        lib.add(9780446580342L, "David Baldacci", "Simple Genius");

        PhoneNumber patron2 = new PhoneNumber("801.555.1234");

        assertTrue(lib.checkout(9780330351690L, patron2, 1, 1, 2008));
        assertTrue(lib.checkout(9780374292799L, patron2, 1, 1, 2008));

        ArrayList<LibraryBookGeneric<PhoneNumber>> booksCheckedOut2 = lib.lookup(patron2);

        assertEquals(booksCheckedOut2.size(), 2);
        assertTrue(booksCheckedOut2.contains(new Book(9780330351690L, "Jon Krakauer", "Into the Wild")));
        assertTrue(booksCheckedOut2.contains(new Book(9780374292799L, "Thomas L. Friedman", "The World is Flat")));
        assertEquals(booksCheckedOut2.get(0).getHolder(),patron2);
        assertEquals(booksCheckedOut2.get(0).getDueDate(),new GregorianCalendar(2008, 1, 1));
        assertEquals(booksCheckedOut2.get(1).getHolder(), patron2);
        assertEquals(booksCheckedOut2.get(1).getDueDate(), new GregorianCalendar(2008, 1, 1));

        assertTrue(lib.checkin(patron2));

    }

    @Test
    public void phoneNumberBookFromFileTest(){
        // test a medium library
        var lib = new LibraryGeneric<PhoneNumber>();
        lib.addAll("Mushroom_Publishing.txt");

        // test with another phone number format
        PhoneNumber patron3 = new PhoneNumber("(801)555-1234");

        assertTrue(lib.checkout(9781843190004L, patron3, 1, 1, 2008));
        assertTrue(lib.checkout(9781843193319L, patron3, 2, 28, 2008));

        ArrayList<LibraryBookGeneric<PhoneNumber>> booksCheckedOut3 = lib.lookup(patron3);
        assertEquals(booksCheckedOut3.get(0).getHolder(),patron3);
        assertEquals(booksCheckedOut3.get(0).getDueDate(),new GregorianCalendar(2008, 1, 1));
        assertEquals(booksCheckedOut3.get(1).getHolder(), patron3);
        assertEquals(booksCheckedOut3.get(1).getDueDate(), new GregorianCalendar(2008, 2, 28));

        assertTrue(lib.checkin(patron3));

    }

    @Test
    public void getInventoryListTest() {
        // test a small library
        LibraryGeneric<String> lib = new LibraryGeneric<>();
        lib.add(9780374292799L, "Thomas L. Friedman", "The World is Flat");
        lib.add(9780330351690L, "Jon Krakauer", "Into the Wild");
        lib.add(9780446580342L, "David Baldacci", "Simple Genius");

        // should be sorted by ISBN
        assertEquals( lib.getInventoryList().get(0).getIsbn(), 9780330351690L );
        assertEquals( lib.getInventoryList().get(1).getIsbn(), 9780374292799L );
        assertEquals( lib.getInventoryList().get(2).getIsbn(), 9780446580342L );
    }

    @Test
    public void getOrderedByAuthorTest(){
        // test a small library ( includes different books with the same author)
        LibraryGeneric<String> lib = new LibraryGeneric<>();
        lib.add(9780374292799L, "Thomas L. Friedman", "The World is Flat");
        lib.add(9780330351690L, "Jon Krakauer", "Into the Wild");
        lib.add(9780446580342L, "David Baldacci", "Simple Genius");
        lib.add(9780246580358L, "David Baldacci", "A for Apple");

        // should be sorted by author, and title as a tie-breaker
        assertEquals( lib.getOrderedByAuthor().get(0).getTitle(), "A for Apple" );
        assertEquals( lib.getOrderedByAuthor().get(1).getTitle(), "Simple Genius" );
        assertEquals( lib.getOrderedByAuthor().get(2).getAuthor(), "Jon Krakauer" );
        assertEquals( lib.getOrderedByAuthor().get(3).getAuthor(), "Thomas L. Friedman" );
    }

    @Test
    public void getOverdueListTest(){
        // test a small library
        LibraryGeneric<String> lib = new LibraryGeneric<>();
        lib.add(9780374292799L, "Thomas L. Friedman", "The World is Flat");
        lib.add(9780330351690L, "Jon Krakauer", "Into the Wild");
        lib.add(9780446580342L, "David Baldacci", "Simple Genius");
        lib.add(9780246580358L, "David Baldacci", "A for Apple");
        lib.add(9780546580358L, "David Baldacci", "Z for Zebra");

        // set due date
        assertTrue(lib.checkout(9780374292799L, "Jinny Jeng", 5,28,2020) );
        assertTrue(lib.checkout(9780330351690L, "Jinny Jeng", 4,10,2020) );
        assertTrue(lib.checkout(9780446580342L, "Jinny Jeng", 1,1,2030) );
        assertTrue(lib.checkout(9780246580358L, "Jinny Jeng", 1,1,2019) );

        // should only conclude books whose due date is older than the input, and be sorted by due date
        assertEquals( lib.lookup("Jinny Jeng").size(), 4);
        assertEquals( lib.getOverdueList(5,30,2022).size(), 3 );
        assertEquals( lib.getOverdueList(5,30,2022).get(0).getDueDate(), new GregorianCalendar(2019,1,1));
        assertEquals( lib.getOverdueList(5,30,2022).get(1).getDueDate(), new GregorianCalendar(2020,4,10));
        assertEquals( lib.getOverdueList(5,30,2022).get(2).getDueDate(), new GregorianCalendar(2020,5,28));
    }

}


