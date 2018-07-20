package assignment02;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Junit class for testing of the LibraryGeneric class.
 * Testing done in conjunction with LibraryGenericTest class.
 * 
 * @author Miriah Meyer & Matthew Farnsworth
 * @version January 26, 2018
 */
public class LibraryGenericJunitTest {
	LibraryGeneric<String> emptyLib, lib1, medLib, booksCheckedOut;
	LibraryGeneric<PhoneNumber> lib2;
	String patron1;
	PhoneNumber patron2;
	
	@Before
	public void setUp() throws Exception {
		
		patron1 = "susan";
		patron2 = new PhoneNumber("801.555.1234");
		
		emptyLib = new LibraryGeneric<String>();
		
		lib1 = new LibraryGeneric<String>();
	    lib1.add(9780374292799L, "Thomas L. Friedman", "The World is Flat");
	    lib1.add(9780330351690L, "Jon Krakauer", "Into the Wild");
	    lib1.add(9780446580342L, "David Baldacci", "Simple Genius");
	
	    lib2 = new LibraryGeneric<PhoneNumber>();
	    lib2.add(9780374292799L, "Thomas L. Friedman", "The World is Flat");
	    lib2.add(9780330351690L, "Jon Krakauer", "Into the Wild");
	    lib2.add(9780446580342L, "David Baldacci", "Simple Genius");

	    
	    //Medium library for testing
  		medLib = new LibraryGeneric<String>();
  		medLib.addAll("Mushroom_Publishing.txt");
	
	}
	
	@Test
	public void emptyLibraryLookupIsbn() {
		Assert.assertNull(emptyLib.lookup(978037429279L));
	}
	
	@Test
	public void emptyLibraryLookupHolder() {
		ArrayList<LibraryBookGeneric<String>> booksCheckedOut = emptyLib.lookup("Jane Doe");
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
		Assert.assertNull(lib1.lookup(9780330351690L));
	}
	
	@Test
	public void smallLibraryLookupIsbnReturnHolder() {
		lib1.checkout(9780330351690L, "Jane Doe", 1, 1, 2008);
		Assert.assertEquals("Jane Doe", lib1.lookup(9780330351690L));
	}
	
	@Test
	public void smallLibraryLookupIsbnReturnPhoneNumber() {
		lib2.checkout(9780330351690L, patron2, 1, 1, 2008);
		Assert.assertEquals(patron2, lib2.lookup(9780330351690L));
	}
	
	@Test
	public void checkoutBook() {
		Assert.assertTrue(lib1.checkout(9780330351690L, patron1, 1, 1, 2008));
		Assert.assertTrue(lib2.checkout(9780330351690L, patron2, 1, 1, 2008));
	}

	@Test
	public void checkinByIsbn() {
		lib1.checkout(9780330351690L, patron1, 1, 1, 2008);
		lib2.checkout(9780330351690L, patron2, 1, 1, 2008);
		Assert.assertTrue(lib1.checkin(9780330351690L));
		Assert.assertTrue(lib2.checkin(9780330351690L));
	}
	
	@Test
	public void checkinByHolder() {
		lib1.checkout(9780330351690L, patron1, 1, 1, 2008);
	    lib1.checkout(9780374292799L, patron1, 1, 1, 2008);
	    lib2.checkout(9780330351690L, patron2, 1, 1, 2008);
	    lib2.checkout(9780374292799L, patron2, 1, 1, 2008);
		Assert.assertTrue(lib1.checkin(patron1));
		Assert.assertTrue(lib2.checkin(patron2));
	}
	
	@Test
	public void getInventoryListLib1() {
		Assert.assertNotNull(lib1.getInventoryList());
	}
	
	@Test
	public void getOrderedByAuthorLib1() {
		Assert.assertNotNull(lib1.getOrderedByAuthor());
	}
	
	@Test
	public void getOverDueListLib1() {
		Assert.assertNotNull(lib1.getOverdueList(1, 1, 2000));
	}
	
}
