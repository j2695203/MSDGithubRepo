package assignment02;

import java.util.GregorianCalendar;

public class LibraryBook extends Book{
    private String holder;
    private GregorianCalendar dueDate;
    public Boolean isCheckedIn = true;
    // constructor
    public LibraryBook(long isbn, String author, String title) {
        super(isbn, author, title);
    }
    public String getHolder(){
        return holder;
    }
    public GregorianCalendar getDueDate(){
        return dueDate;
    }
    /**
     * Change the status when the book checked in
     *
     * If the current status of the book is not checked in, then update to check in, remove holder and due date.
     *
     */
    public void checkIn(){
        if( !isCheckedIn ){
            isCheckedIn = true;
            this.holder = null;
            this.dueDate = null;
        }
    }
    /**
     * Change the status when the book checked out
     *
     * If the current status of the book is checked in, then update to check out, add holder and due date.
     *
     * @param holder
     *          -- holder's name who checked out the books
     * @param dueDate
     *          -- due date includes year, month, and day in GregorianCalendar type
     */
    public void checkOut( String holder, GregorianCalendar dueDate ){
        if( isCheckedIn ){
            isCheckedIn = false;
            this.holder = holder;
            this.dueDate = dueDate;
        }
    }
}

