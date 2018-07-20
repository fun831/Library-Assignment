package assignment02;

/**
 * Class representation of a book. The ISBN, author, and title can never change
 * once the book is created.
 * 
 * Note that ISBNs are unique.
 *
 * @author Miriah Meyer & Matthew Farnsworth
 * @version January 26, 2018
 */
public class Book {

	private long isbn;

	private String author;

	private String title;

	/**
	 * Constructor of a Book object. Sets the isbn, the author, and
	 * the title of the book.
	 * 
	 * @param isbn -- ISBN number of the book
	 * @param author -- Name of the book's author
	 * @param title -- Title of the Book
	 */
	public Book(long isbn, String author, String title) {
		this.isbn = isbn;
		this.author = author;
		this.title = title;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return this.author;
	}

	/**
	 * @return the ISBN
	 */
	public long getIsbn() {
		return this.isbn;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return this.title;
	}

	/**
	 * Two books are considered equal if they have the same ISBN, author, and
	 * title.
	 * 
	 * @param other
	 *            -- the object begin compared with "this"
	 * @return true if "other" is a Book and is equal to "this", false otherwise
	 */
	public boolean equals(Object other) {
		if(!(other instanceof Book)) { 
			return false;
		}
		Book book = (Book)other;
		if(this.isbn != book.isbn || this.author != book.author || this.title != book.title) {
			return false;
		}
		return true;
	}

	/**
	 * Returns a string representation of the book.
	 */
	public String toString() {
		return isbn + ", " + author + ", \"" + title + "\"";
	}

	@Override
	public int hashCode() {
		return (int) isbn + author.hashCode() + title.hashCode();
	}
}
