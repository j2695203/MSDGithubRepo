package assignment02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    @Test
    public void testEmpty() {
        Library lib = new Library();
        assertNull(lib.lookup(978037429279L));
        // before checkout
        ArrayList<LibraryBook> booksCheckedOut = lib.lookup("Jane Doe");
        assertEquals(booksCheckedOut.size(), 0);

        assertFalse(lib.checkout(978037429279L, "Jane Doe", 1, 1, 2008));
        assertFalse(lib.checkin(978037429279L));
        assertFalse(lib.checkin("Jane Doe"));
    }

    @Test
    public void testNonEmpty() {

        var lib = new Library();
        // test a small library
        lib.add(9780374292799L, "Thomas L. Friedman", "The World is Flat");
        lib.add(9780330351690L, "Jon Krakauer", "Into the Wild");
        lib.add(9780446580342L, "David Baldacci", "Simple Genius");

        assertNull(lib.lookup(9780330351690L)); //not checked out

        // after check out
        var res = lib.checkout(9780330351690L, "Jane Doe", 1, 1, 2008);
        assertTrue(res); // success check out
        var booksCheckedOut = lib.lookup("Jane Doe");
        assertEquals(booksCheckedOut.size(), 1);
        assertEquals(booksCheckedOut.get(0),new Book(9780330351690L, "Jon Krakauer", "Into the Wild"));
        assertEquals(booksCheckedOut.get(0).getHolder(), "Jane Doe");
        assertEquals(booksCheckedOut.get(0).getDueDate(),new GregorianCalendar(2008, 1, 1));
        // after check in
        res = lib.checkin(9780330351690L);
        assertTrue(res); // success check in
        res = lib.checkin("Jane Doe");
        assertFalse(res); // fail to check in again cause already check in
    }

    @Test
    public void testLargeLibrary(){
        // test a medium library
        var lib = new Library();
        lib.addAll("Mushroom_Publishing.txt");

        assertNull(lib.lookup(9781843193319L)); //not checked out
        var res = lib.checkout(9781843193319L, "Jinny", 1, 1, 2008);
        assertTrue(res);
        var booksCheckedOut = lib.lookup("Jinny");
        assertEquals(booksCheckedOut.size(), 1);
        assertEquals(booksCheckedOut.get(0),new Book(9781843193319L, "Alan Burt Akers", "Transit to Scorpio"));
        assertEquals(booksCheckedOut.get(0).getHolder(), "Jinny");
        assertEquals(booksCheckedOut.get(0).getDueDate(),new GregorianCalendar(2008, 1, 1));
        res = lib.checkin(9781843193319L);
        assertTrue(res);
        res = lib.checkin("Jinny");
        assertFalse(res);
    }

}