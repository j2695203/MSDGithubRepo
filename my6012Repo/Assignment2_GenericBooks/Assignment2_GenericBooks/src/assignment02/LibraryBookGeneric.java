package assignment02;

import java.util.GregorianCalendar;

public class LibraryBookGeneric <Type> extends Book{
    private Type holder = null;
    private GregorianCalendar dueDate;
    public Boolean isCheckedIn = true;
    // constructor
    public LibraryBookGeneric(long isbn, String author, String title) {
        super(isbn, author, title);
    }
    /**
     * Return the holder of this book ( name or phone number)
     */
    public Type getHolder(){
        return holder;
    }
    /**
     * Return the due date of this book
     */
    public GregorianCalendar getDueDate(){
        return dueDate;
    }
    /**
     * Change the status when the book checked in
     *
     * Update the status to check in, and remove holder and due date.
     *
     */
    public void checkIn(){
        isCheckedIn = true;
        this.holder = null;
        this.dueDate = null;
    }
    /**
     * Change the status when the book checked out
     *
     * Update the status to check out, and add holder and due date.
     *
     * @param holder
     *          -- holder's name or phone number who checked out the books
     * @param dueDate
     *          -- due date includes year, month, and day in GregorianCalendar type
     */
    public void checkOut( Type holder, GregorianCalendar dueDate ){
        isCheckedIn = false;
        this.holder = holder;
        this.dueDate = dueDate;
    }
}
