package assignment02;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Junit class for testing of the LibraryGeneric class.
 * Bulk of testing is done in the generic class since if 
 * it works generically it should work here. 
 * 
 * @author Miriah Meyer & Matthew Farnsworth
 * @version January 26, 2018
 */
public class LibraryTestJUnit {
	
	Library emptyLib, lib, medLib, booksCheckedOut;
	
	@Before
	public void setUp() {
		
		//Empty library to test on
		emptyLib = new Library();
		
		//Small library to test
		lib = new Library();
		lib.add(9780374292799L, "Thomas L. Friedman", "The World is Flat");
		lib.add(9780330351690L, "Jon Krakauer", "Into the Wild");
		lib.add(9780446580342L, "David Baldacci", "Simple Genius");
		
		//Medium library for testing
		medLib = new Library();
		medLib.addAll("Mushroom_Publishing.txt");

	}

	@Test
	public void emptyLibraryLookupIsbn() {
		Assert.assertNull(emptyLib.lookup(978037429279L));
	}

	@Test
	public void emptyLibraryLookupHolder() {
		ArrayList<LibraryBook> booksCheckedOut = emptyLib.lookup("Jane Doe");
		Assert.assertNotNull(booksCheckedOut);
		Assert.assertEquals(0, booksCheckedOut.size());
	}
	
	@Test
	public void emptyLibraryCheckout() {
		Assert.assertFalse(emptyLib.checkout(978037429279L, "Jane Doe", 1, 1, 2008));
	}
	
	@Test
	public void emptyLibraryCheckinByIsbn() {
		Assert.assertFalse(emptyLib.checkin(978037429279L));
	}
	
	@Test
	public void emptyLibraryCheckinByHolder() {
		Assert.assertFalse(emptyLib.checkin("Jane Doe"));
	}
	
	@Test
	public void smallLibraryLookupIsbnNullOrEmpty() {
		Assert.assertNull(lib.lookup(9780330351690L));
	}
	
	@Test
	public void smallLibraryLookupIsbnReturnHolder() {
		lib.checkout(9780330351690L, "Jane Doe", 1, 1, 2008);
		Assert.assertEquals("Jane Doe", lib.lookup(9780330351690L));
	}
	
	
}
