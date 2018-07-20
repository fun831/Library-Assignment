package assignment02;

import java.util.GregorianCalendar;

/**
 * Class representation of a Library Book Generic class. The ISBN, 
 * author, and title can never change once the book is created. Book 
 * is the base class of the library book class. Includes a method for
 * checking in and out a book, sets a due date, and sets a holder of 
 * the book, the holder can be generic. 
 * 
 * @author Miriah Meyer & Matthew Farnsworth
 * @version January 26, 2018
 */
public class LibraryBookGeneric<Type> extends Book {

	private Type holder = null;
	
	private GregorianCalendar dueDate;
	
	/**
	 * Constructor of a LibraryBookGeneric object. Sets the isbn, the author, and
	 * the title of the book.
	 * 
	 * @param isbn -- ISBN number of the book
	 * @param author -- Name of the book's author
	 * @param title -- Title of the Book
	 */
	public LibraryBookGeneric(long isbn, String author, String title) {
		super(isbn, author, title);
		
	}
	
	/**
	 * @return Holder
	 */
	public Type getHolder() {
		if(dueDate == null) {
			return null;
		}
		return holder;
	}

	/**
	 * @return due date of the book
	 */
	public GregorianCalendar getDueDate() {
		return dueDate;
	}
	
	/**
	 * Checks in a library book setting the holder and due date to null.
	 */
	public void checkIn() {
		holder = null;
		dueDate = null;
	}
	
	/**
	 * Checks out a library book setting a due date and setting 
	 * the book to the holder checking it out.
	 * 
	 * @param _holder -- The holder checking out the book
	 * @param month -- The month of the due date 
	 * @param day -- the day of the due date
	 * @param year -- the year of the due date
	 */
	public void checkOut(Type _holder, int month, int day, int year) {
		holder = _holder;
		dueDate = new GregorianCalendar(year, month, day);
	}
}
